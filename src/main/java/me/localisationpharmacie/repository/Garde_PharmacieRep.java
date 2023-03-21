package me.localisationpharmacie.repository;


import me.localisationpharmacie.entity.Garde_Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface Garde_PharmacieRep extends JpaRepository<Garde_Pharmacie, Integer> {
    Garde_Pharmacie findById(int id);

    @Query("select gp from Garde_Pharmacie gp where CURRENT_DATE NOT BETWEEN gp.pg.dateDebut and gp.dateFin")
    List<Garde_Pharmacie> findAllPharmaciesDisponible();

    @Query("select gp from Garde_Pharmacie gp where CURRENT_DATE BETWEEN gp.pg.dateDebut and gp.dateFin ")
    List<Garde_Pharmacie> findAllPharmaciesEnGarde();


    @Query(value="select gp.pharmacie, min(sqrt(power((gp.pharmacie.latitude-:lat),2)+power((gp.pharmacie.longitude-:long),2))) from Garde_Pharmacie gp where gp.pharmacie.zone.nom = :zone and gp.pharmacie.zone.ville.nom = :ville and gp.garde.type like 'jour'")
    List<ArrayList> findDistanceJour(@Param("lat") double lat, @Param("long") double lon, @Param("zone") String zone, @Param("ville") String ville);

    @Query(value="select gp.pharmacie, min(sqrt(power((gp.pharmacie.latitude-:lat),2)+power((gp.pharmacie.longitude-:long),2))) from Garde_Pharmacie gp where gp.pharmacie.zone.nom = :zone and gp.pharmacie.zone.ville.nom = :ville and gp.garde.type like 'nuit'")
    List<ArrayList> findDistanceNuit(@Param("lat") double lat, @Param("long") double lon, @Param("zone") String zone, @Param("ville") String ville);

}
