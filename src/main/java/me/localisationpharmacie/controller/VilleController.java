package me.localisationpharmacie.controller;


import me.localisationpharmacie.entity.Ville;
import me.localisationpharmacie.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/controller/villes")
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

    @PutMapping("/update/{id}")
    public Ville updateCity(@PathVariable int id, @RequestBody Ville Ville) {
        Ville existingCity = villeService.findById(id);
        if (existingCity != null) {
            existingCity.setNom(Ville.getNom());
            villeService.update(existingCity);
        }
        return null;
    }
    @GetMapping("/{id}")
    public Ville findById(@PathVariable int id) {
        return villeService.findById(id);
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
