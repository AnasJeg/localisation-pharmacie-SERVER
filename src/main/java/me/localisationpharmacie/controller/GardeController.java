package me.localisationpharmacies.controller;

import me.localisationpharmacies.entity.Garde;
import me.localisationpharmacies.repository.GardeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("garde")
@CrossOrigin
public class GardeController {

    @Autowired
    private GardeRep gardeRep;

    @PostMapping("/save")
    public void save(@RequestBody Garde garde){
        gardeRep.save(garde);
    }

    @GetMapping("/all")
    public List<Garde> findAll(){
        return gardeRep.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        Garde g=gardeRep.findById(Integer.parseInt(id));
        gardeRep.delete(g);
    }

}
