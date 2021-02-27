package id.co.asyst.wfm.user.controller;

import id.co.asyst.wfm.user.exception.ResourceNotFoundException;
import id.co.asyst.wfm.user.model.Role;
import id.co.asyst.wfm.user.repository.RoleRepository;
import id.co.asyst.wfm.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/identity/role")
public class RoleController
{

    @Autowired
    RoleService roleService;

    @GetMapping("/list")
    public List<Role> getAllRole() {
        return (List<Role>) roleService.findAll();
    }

    @PostMapping("/create")
    public Role createRole(@Valid @RequestBody Role role) {
        return (Role) roleService.saveOrUpdate(role);
    }

    @GetMapping("/find/{id}")
    public Role getRoleById(@PathVariable(value = "id") String roleId) {
        return (Role) roleService.findById(roleId);
    }

    @PutMapping("/update/{id}")
    public Role updateRole(@PathVariable(value = "id") String userId,
                           @Valid @RequestBody Role noteDetails) {

        Role role = (Role) roleService.findById(userId);

        role.setRoleDesc(noteDetails.getRoleDesc());
        role.setActive(noteDetails.getActive());

        return (Role) roleService.saveOrUpdate(role);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable(value = "id") String roleId) {
        roleService.deleteById(roleId);

        return ResponseEntity.ok().build();
    }
}