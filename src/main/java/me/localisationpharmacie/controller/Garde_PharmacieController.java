package me.localisationpharmacie.controller;

import me.localisationpharmacie.entity.Garde_Pharmacie;
import me.localisationpharmacie.service.Garde_PharmacieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/GardePharmacie")
@CrossOrigin
public class Garde_PharmacieController {
    @Autowired
    private Garde_PharmacieService gardePharmacieService;

    @PostMapping("/save")
    public void save(@RequestBody Garde_Pharmacie gardePharmacie){
        gardePharmacieService.save(gardePharmacie);
    }

    @GetMapping("/")
    public List<Garde_Pharmacie> findAll(){
        return gardePharmacieService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        Garde_Pharmacie p=gardePharmacieService.findById(id);
        gardePharmacieService.delete(p);
    }

    @PutMapping("/update")
    public void update(@RequestBody Garde_Pharmacie p){
        gardePharmacieService.update(p);
    }



}
