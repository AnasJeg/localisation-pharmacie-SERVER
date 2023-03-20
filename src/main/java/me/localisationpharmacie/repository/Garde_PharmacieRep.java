package me.localisationpharmacie.repository;


import me.localisationpharmacie.entity.Garde_Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Garde_PharmacieRep extends JpaRepository<Garde_Pharmacie, Integer> {
    Garde_Pharmacie findById(int id);

    @Query("select gp from Garde_Pharmacie gp where CURRENT_DATE NOT BETWEEN gp.pg.dateDebut and gp.dateFin")
    List<Garde_Pharmacie> findAllPharmaciesDisponible();

    @Query("select gp from Garde_Pharmacie gp where CURRENT_DATE BETWEEN gp.pg.dateDebut and gp.dateFin ")
    List<Garde_Pharmacie> findAllPharmaciesEnGarde();
}
