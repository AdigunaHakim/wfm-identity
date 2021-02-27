package id.co.asyst.wfm.user.controller;

import id.co.asyst.wfm.user.exception.ResourceNotFoundException;
import id.co.asyst.wfm.user.model.RoleFunction;
import id.co.asyst.wfm.user.repository.RoleFunctionRepository;
import id.co.asyst.wfm.user.service.RoleFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/identity/role-function")
public class RoleFunctionController
{

    @Autowired
    RoleFunctionService roleFunctionService;

    @GetMapping("/list")
    public List<RoleFunction> getAllUserRole() {
        return (List<RoleFunction>) roleFunctionService.findAll();
    }

    @PostMapping("/create")
    public RoleFunction createRoleFunction(@Valid @RequestBody RoleFunction roleFunction) {
        return (RoleFunction) roleFunctionService.saveOrUpdate(roleFunction);
    }

    @GetMapping("/find/{id}")
    public RoleFunction getRoleFunctionById(@PathVariable(value = "id") Long roleFunctionId) {
        return (RoleFunction) roleFunctionService.findById(roleFunctionId);
    }

    @PutMapping("/update/{id}")
    public RoleFunction updateRoleFunction(@PathVariable(value = "id") Long roleFunctionId,
                               @Valid @RequestBody RoleFunction roleFunctionDetails) {

        RoleFunction roleFunction = (RoleFunction) roleFunctionService.findById(roleFunctionId);

        roleFunction.setRole(roleFunctionDetails.getRole());
        roleFunction.setFunction(roleFunctionDetails.getFunction());
        roleFunction.setActive(roleFunctionDetails.getActive());

        return (RoleFunction) roleFunctionService.saveOrUpdate(roleFunction);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable(value = "id") Long roleFunctionId) {
        roleFunctionService.delete(roleFunctionId);

        return ResponseEntity.ok().build();
    }
}


