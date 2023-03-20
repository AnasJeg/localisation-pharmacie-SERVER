package me.localisationpharmacie.service;

import me.localisationpharmacie.DAO.Dao;
import me.localisationpharmacie.entity.Pharmacie;
import me.localisationpharmacie.repository.PharmacieRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Pharmacie> findAllByVilleAndZone(String ville,String zone){
        return pharmacieRep.findAllByVilleAndZone(ville,zone);
    }

    public List<Pharmacie> findAllPharmacies(String ville, String zone,String periode){
        return  pharmacieRep.findAllPh(ville,zone,periode);
    }
}
