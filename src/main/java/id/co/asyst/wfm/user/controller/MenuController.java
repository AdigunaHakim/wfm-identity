package id.co.asyst.wfm.user.controller;

import id.co.asyst.wfm.user.model.Menu;
import id.co.asyst.wfm.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/identity/menu")
public class MenuController
{

    @Autowired
    MenuService menuService;

    @GetMapping("/list")
    public List<Menu> getAllMenu() {
        return (List<Menu>) menuService.findAll();
    }

    @PostMapping("/create")
    public Menu createMenu(@Valid @RequestBody Menu menu) {
        return (Menu) menuService.saveOrUpdate(menu);
    }

    @GetMapping("/find/{id}")
    public Menu getMenuById(@PathVariable(value = "id") Long menuId) {
        return (Menu) menuService.findById(menuId);
    }

    @PutMapping("/update/{id}")
    public Menu updateMenu(@PathVariable(value = "id") Long menuId,
                           @Valid @RequestBody Menu menuDetails) {

        Menu menu = (Menu) menuService.findById(menuId);

        menu.setName(menuDetails.getName());
        menu.setUrl(menuDetails.getUrl());
        menu.setParent(menuDetails.getParent());
        menu.setOrderRole(menuDetails.getOrderRole());
        menu.setActive(menuDetails.getActive());

        return (Menu) menuService.saveOrUpdate(menu);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable(value = "id") Long menuId) {
        menuService.deleteById(menuId);

        return ResponseEntity.ok().build();
    }
}
