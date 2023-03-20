package me.localisationpharmacies.repository;

import me.localisationpharmacies.entity.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacieRep extends JpaRepository<Pharmacie, Integer> {

        Pharmacie findById(int id);
}
