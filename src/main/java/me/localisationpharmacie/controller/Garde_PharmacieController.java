package me.localisationpharmacie.controller;

import me.localisationpharmacie.entity.Garde_Pharmacie;
import me.localisationpharmacie.entity.Garde_pharmaciePG;
import me.localisationpharmacie.entity.Zone;
import me.localisationpharmacie.service.Garde_PharmacieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/controller/GardePharmacie")
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
    @DeleteMapping("/deleteGP/{dateD}/{idF}/{idG}")
    public void deleteGP(@PathVariable("dateD") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateD,
                         @PathVariable("idF") String idF,@PathVariable("idG") String idG){
       gardePharmacieService.deleteGp(dateD,idF,idG);
    }

    @PutMapping("/update")
    public void update(@RequestBody Garde_Pharmacie p){
        gardePharmacieService.update(p);
    }

    @PutMapping("/update/{dateD}/{idF}/{idG}")
    public void updateCity(@PathVariable("dateD") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateD,
                           @PathVariable("idF") String idF,@PathVariable("idG") String idG,
                           @RequestBody Garde_Pharmacie gp) {
            gardePharmacieService.updateGarde_Pharmacie(dateD, idF ,idG, gp);
    }
   /*
    @PutMapping("/update/{dateDebut}")
    public void  updateGarde_Pharmacie(@PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
                                                                 @RequestBody Garde_pharmaciePG pgToUpdate) {
        Garde_Pharmacie existingGarde_Pharmacie = gardePharmacieService.findByPg_DateDebut(dateDebut);

        if (existingGarde_Pharmacie != null) {
            existingGarde_Pharmacie.setPg(pgToUpdate);
           gardePharmacieService.save(existingGarde_Pharmacie);
        } else {
            System.out.println("not found");
        }
    }
*/

}
