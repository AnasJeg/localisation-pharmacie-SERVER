package me.localisationpharmacies.controller;

import me.localisationpharmacies.entity.Garde_Pharmacie;
import me.localisationpharmacies.entity.Pharmacie;
import me.localisationpharmacies.repository.GardeRep;
import me.localisationpharmacies.repository.Garde_pharmacieRep;
import me.localisationpharmacies.repository.PharmacieRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pharmacie")
@CrossOrigin
public class PharmacieController {

    @Autowired
    private PharmacieRep pharmacieRep;

    @Autowired
    private GardeRep gardeRep;

    @Autowired
    private Garde_pharmacieRep garde_pharmacieRep;

    @PostMapping("/save")
    public void save(@RequestBody Pharmacie pharmacie){
        pharmacieRep.save(pharmacie);
    }

    @GetMapping("/all")
    public List<Pharmacie> findAll(){
        return pharmacieRep.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        Pharmacie p=pharmacieRep.findById(Integer.parseInt(id));
        pharmacieRep.delete(p);
    }

/*
    @PostMapping("/garde/{idG}/pharmacie/{idP}")
    public void affectGardeToPharmacie(@PathVariable String idG,@PathVariable String idP){
        Pharmacie p=pharmacieRep.findById(Integer.parseInt(idP));
        Garde g=gardeRep.findById(Integer.parseInt(idG));
      //  Garde_Pharmacie gp=garde_pharmacieRep.findById(Integer.parseInt());
        g.getPharmacieGardes().add();

    }
    */

    @GetMapping("/allgp")
    public List<Garde_Pharmacie> findAllGP(){
        return garde_pharmacieRep.findAll();
    }


}
