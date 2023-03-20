package me.localisationpharmacie.controller;


import me.localisationpharmacie.entity.Ville;
import me.localisationpharmacie.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/villes")
@CrossOrigin
public class VilleController {

    @Autowired
    private VilleService villeService;

    @GetMapping("/")
    public List<Ville> findAll(){
        return villeService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Ville ville){
        villeService.save(ville);
    }

    @PutMapping("/update")
    public void update(@RequestBody Ville v){
        villeService.update(v);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        Ville v=villeService.findById(id);
        villeService.delete(v);
    }


}
