package me.localisationpharmacies.controller;

import me.localisationpharmacies.entity.Zone;
import me.localisationpharmacies.repository.ZoneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("zone")
@CrossOrigin
public class ZoneController {

    @Autowired
    private ZoneRep zoneRep;

    @PostMapping("/save")
    public void save(@RequestBody Zone zone){
        zoneRep.save(zone);
    }

    @GetMapping("/all")
    public List<Zone> findAll(){
      return  zoneRep.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        Zone z=zoneRep.findById(Integer.parseInt(id));
        zoneRep.delete(z);
    }


}
