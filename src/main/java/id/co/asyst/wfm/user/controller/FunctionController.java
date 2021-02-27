package id.co.asyst.wfm.user.controller;

import id.co.asyst.wfm.user.model.Function;
import id.co.asyst.wfm.user.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/identity/function")
public class FunctionController
{

    @Autowired
    FunctionService functionService;

    @GetMapping("/list")
    public List<Function> getAllFunction() {
        return (List<Function>) functionService.findAll();
    }

    @PostMapping("/create")
    public Function createFunction(@Valid @RequestBody Function function) {
        return (Function) functionService.saveOrUpdate(function);
    }

    @GetMapping("/find/{id}")
    public Function getFunctionById(@PathVariable(value = "id") Long functionId) {
        return (Function) functionService.findById(functionId);
    }

    @PutMapping("/update/{id}")
    public Function updateFunction(@PathVariable(value = "id") Long functionId,
                           @Valid @RequestBody Function functionDetails) {

        Function function = (Function) functionService.findById(functionId);

        function.setDescription(functionDetails.getDescription());
        function.setActive(functionDetails.getActive());

        return (Function) functionService.saveOrUpdate(function);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFunction(@PathVariable(value = "id") Long functionId) {
        functionService.deleteById(functionId);

        return ResponseEntity.ok().build();
    }
}
