package me.localisationpharmacies.repository;

import me.localisationpharmacies.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRep extends JpaRepository<Zone, Integer> {
        Zone findById(int id);
}
