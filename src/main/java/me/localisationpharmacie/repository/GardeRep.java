package me.localisationpharmacies.repository;


import me.localisationpharmacies.entity.Garde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GardeRep extends JpaRepository<Garde , Integer> {

    Garde findById(int id);
}
