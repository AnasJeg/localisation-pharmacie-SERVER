package me.localisationpharmacie.controller;

import me.localisationpharmacie.entity.Role;
import me.localisationpharmacie.entity.User;
import me.localisationpharmacie.service.RoleService;
import me.localisationpharmacie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @PostMapping("/save")
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping("/")
    public List<User> findALL(){
       return userService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        userService.delete(userService.findById(id));
    }

    @PutMapping("/update")
    public void update(@RequestBody User u){
        userService.update(u);
    }

    @PostMapping("/affect/user/{idU}/role/{idR}")
    public void affectRoleToUser(@PathVariable String idU,@PathVariable String idR){
        User u=userService.findById(Integer.parseInt(idU));
        Role r=roleService.findById(Integer.parseInt(idR));
        u.getRole().add(r);
        userService.save(u);
    }
}
