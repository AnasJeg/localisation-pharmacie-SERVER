package me.localisationpharmacie.repository;


import me.localisationpharmacie.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ZoneRep extends JpaRepository<Zone, Integer> {
        Zone findById(int id);

        @Query("select z from Zone z where z.ville.nom= :nom order by z.nom")
        List<Zone> findZoneByVille(@Param("nom") String nom);

}
