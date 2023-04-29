package me.localisationpharmacie.service;

import me.localisationpharmacie.DAO.Dao;
import me.localisationpharmacie.entity.Zone;
import me.localisationpharmacie.repository.ZoneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService implements Dao<Zone> {

    @Autowired
    private ZoneRep zoneRep;
    @Override
    public Zone save(Zone c) {
        return zoneRep.save(c);
    }

    @Override
    public Zone findById(int id) {
        return zoneRep.findById(id);
    }

    @Override
    public List<Zone> findAll() {
        return zoneRep.findAll();
    }

    @Override
    public void delete(Zone c) {
        zoneRep.delete(c);
    }

    @Override
    public void update(Zone c) {
        zoneRep.save(c);
    }

    public Zone updateZone(int id ,Zone zoneDetails) {
        Zone zone = zoneRep.findById(id);
        zone.setNom(zoneDetails.getNom());
        zone.setVille(zoneDetails.getVille());
        return zoneRep.save(zone);
    }
    public List<Zone> findAllByVille(String nom){

        return zoneRep.findZoneByVille(nom);
    }
}
