package me.localisationpharmacie.controller;


import me.localisationpharmacie.entity.Garde;
import me.localisationpharmacie.service.GardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gardes")
@CrossOrigin
public class GardeController {

    @Autowired
    private GardeService gardeService;

    @GetMapping("/")
    public List<Garde> findAll(){
        return gardeService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Garde garde){
        gardeService.save(garde);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        Garde g=gardeService.findById(id);
        gardeService.delete(g);
    }

    @PutMapping("/update")
    public void update(@RequestBody Garde g){
        gardeService.update(g);
    }
}
