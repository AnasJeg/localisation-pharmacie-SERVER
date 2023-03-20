package me.localisationpharmacie.service;

import me.localisationpharmacie.DAO.Dao;
import me.localisationpharmacie.entity.Garde;
import me.localisationpharmacie.repository.GardeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GardeService implements Dao<Garde> {
    @Autowired
    private GardeRep gardeRep;

    @Override
    public Garde save(Garde c) {
        return gardeRep.save(c);
    }

    @Override
    public Garde findById(int id) {
        return gardeRep.findById(id);
    }

    @Override
    public List<Garde> findAll() {
        return gardeRep.findAll();
    }

    @Override
    public void delete(Garde c) {
                gardeRep.delete(c);
    }

    @Override
    public void update(Garde c) {
            gardeRep.save(c);
    }
}
