package me.localisationpharmacies.repository;

import me.localisationpharmacies.entity.Garde_Pharmacie;
import me.localisationpharmacies.entity.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Garde_pharmacieRep extends JpaRepository<Garde_Pharmacie, Integer> {
   // Garde_Pharmacie findById(int id);

  //  List<Garde_Pharmacie> findAllByPharmacie(Pharmacie pharmacie);


}
