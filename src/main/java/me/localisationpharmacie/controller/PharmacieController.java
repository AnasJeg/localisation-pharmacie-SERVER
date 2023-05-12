package me.localisationpharmacie.controller;



import me.localisationpharmacie.entity.Pharmacie;
import me.localisationpharmacie.service.PharmacieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/controller/pharmacies")
@CrossOrigin(value = "http://localhost:3000",
        methods = {RequestMethod.GET, RequestMethod.POST,
                RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class PharmacieController {

    @Autowired
    private PharmacieService pharmacieService;


    @PostMapping("/save")
    public void save(@RequestBody Pharmacie pharmacie){
        pharmacieService.save(pharmacie);
    }

    @GetMapping("/")
    public List<Pharmacie> findAll(){
        return pharmacieService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        Pharmacie p=pharmacieService.findById(id);
        pharmacieService.delete(p);
    }

    @PutMapping("/update")
    public void update(@RequestBody Pharmacie p){
        pharmacieService.update(p);
    }


    @GetMapping("/ville/{ville}/zone/{zone}")
    public List<Pharmacie> getPharmacieByVZ(@PathVariable String ville,@PathVariable String zone){
        return pharmacieService.findAllByVilleAndZone(ville,zone);
    }

      @GetMapping("/ville/{ville}/zone/{zone}/pharmacies/{periode}")
    public List<Pharmacie> findAllPharmacies(@PathVariable String ville, @PathVariable String zone,@PathVariable String periode){
            return pharmacieService.findAllPharmacies(ville,zone,periode);
      }

      @GetMapping("/{id}")
      public Pharmacie findById(@PathVariable String id){
        return pharmacieService.findById(Integer.parseInt(id));
      }

    @GetMapping("/{id}/itineraire")
   public String getItinerary(@PathVariable int id, @RequestParam String depart) {
        try {
            return  pharmacieService.getItineraire(id,depart);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
