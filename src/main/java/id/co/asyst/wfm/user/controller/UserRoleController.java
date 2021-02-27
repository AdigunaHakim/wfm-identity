package id.co.asyst.wfm.user.controller;

import id.co.asyst.wfm.user.exception.ResourceNotFoundException;
import id.co.asyst.wfm.user.model.Role;
import id.co.asyst.wfm.user.model.User;
import id.co.asyst.wfm.user.model.UserRole;
import id.co.asyst.wfm.user.repository.RoleRepository;
import id.co.asyst.wfm.user.repository.UserRepository;
import id.co.asyst.wfm.user.repository.UserRoleRepository;
import id.co.asyst.wfm.user.service.RoleService;
import id.co.asyst.wfm.user.service.UserRoleService;
import id.co.asyst.wfm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/identity/user-role")
public class UserRoleController
{

    @Autowired
    UserService userService;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    RoleService roleService;

    @GetMapping("/list")
    public List<UserRole> getAllUserRole() {
        return (List<UserRole>) userRoleService.findAll();
    }

    @PostMapping("/create/{user_id}/{role_id}")
    public UserRole createUserRole(@PathVariable(value = "user_id") String userId,
                                   @PathVariable(value = "role_id") String roleId,
                                   @Valid @RequestBody UserRole userRole) {
        User user = (User) userService.findById(userId);
        Role role = (Role) roleService.findById(roleId);
        userRole.setUser(user);
        userRole.setRole(role);

        return (UserRole) userRoleService.saveOrUpdate(userRole);
    }

    @GetMapping("/find/{id}")
    public UserRole getUserRoleById(@PathVariable(value = "id") Long userRoleId) {
        return (UserRole) userRoleService.findById(userRoleId);
    }

    @PutMapping("/update/{id}")
    public UserRole updateMenu(@PathVariable(value = "id") Long userRoleId,
                           @Valid @RequestBody UserRole userRoleDetails) {

        UserRole userRole = (UserRole) userRoleService.findById(userRoleId);

        return (UserRole) userRoleService.saveOrUpdate(userRole);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable(value = "id") Long userRoleId) {

        userRoleService.deleteById(userRoleId);

        return ResponseEntity.ok().build();
    }
}

