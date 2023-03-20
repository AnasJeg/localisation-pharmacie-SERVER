package me.localisationpharmacies.controller;

import me.localisationpharmacies.entity.Ville;
import me.localisationpharmacies.repository.VilleRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ville")
@CrossOrigin
public class VilleController {

    @Autowired
    private VilleRep villeRep;

    @PostMapping("/save")
    public void save(@RequestBody Ville ville){
        villeRep.save(ville);
    }

    @GetMapping("/all")
    public List<Ville> findAll(){
        return villeRep.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        Ville v=villeRep.findById(Integer.parseInt(id));
        villeRep.delete(v);
    }


}
