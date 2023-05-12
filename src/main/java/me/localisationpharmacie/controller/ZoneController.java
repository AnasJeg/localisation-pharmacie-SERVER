package me.localisationpharmacie.controller;


import me.localisationpharmacie.entity.Ville;
import me.localisationpharmacie.entity.Zone;
import me.localisationpharmacie.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/controller/zones")
@CrossOrigin
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @GetMapping("/")
    public List<Zone> findAll(){
        return  zoneService.findAll();
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('admin:create')")
    public void save(@RequestBody Zone zone){
        zoneService.save(zone);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        Zone z=zoneService.findById(id);
        zoneService.delete(z);
    }

    @PutMapping("/update/{id}")
    public Zone updateCity(@PathVariable int id, @RequestBody Zone zone) {
        return  zoneService.updateZone(id,zone);
        }

    @PutMapping("/update")
    public void update(@RequestBody Zone z){
        zoneService.update(z);
    }

    @GetMapping("/ville/{nom}")
    public List<Zone> getAllZone(@PathVariable String nom){
        return zoneService.findAllByVille(nom);
    }



}
