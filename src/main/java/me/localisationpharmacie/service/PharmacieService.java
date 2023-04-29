package me.localisationpharmacie.service;

import me.localisationpharmacie.DAO.Dao;
import me.localisationpharmacie.entity.Pharmacie;
import me.localisationpharmacie.repository.PharmacieRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacieService implements Dao<Pharmacie> {

    @Autowired
    private PharmacieRep pharmacieRep;

    @Override
    public Pharmacie save(Pharmacie c) {
        return pharmacieRep.save(c);
    }

    @Override
    public Pharmacie findById(int id) {
        return pharmacieRep.findById(id);
    }

    @Override
    public List<Pharmacie> findAll() {
        return pharmacieRep.findAll();
    }

    @Override
    public void delete(Pharmacie c) {
        pharmacieRep.delete(c);
    }

    @Override
    public void update(Pharmacie c) {
        pharmacieRep.save(c);
    }

    public List<Pharmacie> findAllByVilleAndZone(String ville, String zone) {
        return pharmacieRep.findAllByVilleAndZone(ville, zone);
    }

    public List<Pharmacie> findAllPharmacies(String ville, String zone, String periode) {
        return pharmacieRep.findAllPh(ville, zone, periode);
    }


    public String getItineraire(int id, String depart) throws Exception {
        String apikey="AIzaSyDzmu1dHaje4yWHlQkP4cGC6lwWBRuwaUA";
        Optional<Pharmacie> optionalPharmacie = Optional.ofNullable(pharmacieRep.findById(id));
        Pharmacie pharmacie = optionalPharmacie.orElseThrow(() -> new Exception("Pharmacie not found !!!"));
        String destination = pharmacie.getLatitude() + "," + pharmacie.getLongitude();
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + depart + "&destination=" + destination + "&key="+apikey;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }

}
