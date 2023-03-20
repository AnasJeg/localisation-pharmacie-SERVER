package me.localisationpharmacies.repository;

import me.localisationpharmacies.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRep extends JpaRepository<Ville , Integer> {

    Ville findById(int id);

}
