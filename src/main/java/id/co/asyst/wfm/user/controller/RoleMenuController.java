package id.co.asyst.wfm.user.controller;

import id.co.asyst.wfm.user.exception.ResourceNotFoundException;
import id.co.asyst.wfm.user.model.RoleMenu;
import id.co.asyst.wfm.user.repository.RoleMenuRepository;
import id.co.asyst.wfm.user.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/identity/role-menu")
public class RoleMenuController
{

    @Autowired
    RoleMenuService roleMenuService;

    @GetMapping("/list")
    public List<RoleMenu> getAllRoleMenu() {
        return (List<RoleMenu>) roleMenuService.findAll();
    }

    @PostMapping("/create")
    public RoleMenu createRoleMenu(@Valid @RequestBody RoleMenu roleMenu) {
        return (RoleMenu) roleMenuService.saveOrUpdate(roleMenu);
    }

    @GetMapping("/find/{id}")
    public RoleMenu getUserRoleById(@PathVariable(value = "id") Long roleMenuId) {
        return (RoleMenu) roleMenuService.findById(roleMenuId);
    }

    @PutMapping("/update/{id}")
    public RoleMenu updateRoleMenu(@PathVariable(value = "id") Long roleMenuId,
                               @Valid @RequestBody RoleMenu userRoleDetails) {

        RoleMenu roleMenu = (RoleMenu) roleMenuService.findById(roleMenuId);

        roleMenu.setMenu(userRoleDetails.getMenu());
        roleMenu.setRole(userRoleDetails.getRole());
        roleMenu.setActive(userRoleDetails.getActive());

        return (RoleMenu) roleMenuService.saveOrUpdate(roleMenu);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable(value = "id") Long roleMenuId) {
        roleMenuService.deleteById(roleMenuId);

        return ResponseEntity.ok().build();
    }
}


