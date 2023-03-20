package me.localisationpharmacie.service;

import me.localisationpharmacie.DAO.Dao;
import me.localisationpharmacie.entity.Garde_Pharmacie;
import me.localisationpharmacie.repository.Garde_PharmacieRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Garde_PharmacieService implements Dao<Garde_Pharmacie> {

    @Autowired
    private Garde_PharmacieRep garde_pharmacieRep;

    @Override
    public Garde_Pharmacie save(Garde_Pharmacie c) {
        return garde_pharmacieRep.save(c);
    }

    @Override
    public Garde_Pharmacie findById(int id) {
        return garde_pharmacieRep.findById(id);
    }

    @Override
    public List<Garde_Pharmacie> findAll() {
        return garde_pharmacieRep.findAll();
    }

    @Override
    public void delete(Garde_Pharmacie c) {
        garde_pharmacieRep.delete(c);
    }

    @Override
    public void update(Garde_Pharmacie c) {
        garde_pharmacieRep.save(c);
    }
}
