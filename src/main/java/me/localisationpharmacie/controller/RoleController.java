package me.localisationpharmacie.controller;

import me.localisationpharmacie.entity.Role;
import me.localisationpharmacie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/roles")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public void save(@RequestBody Role role){
        roleService.save(role);
    }

    @GetMapping("/")
    public List<Role> findALL(){
        return roleService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        Role r=roleService.findById(id);
        roleService.delete(r);
    }

    @PutMapping("/update")
    public void update(@RequestBody Role r){
        roleService.update(r);
    }

}
