package me.localisationpharmacie.repository;


import me.localisationpharmacie.entity.Garde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GardeRep extends JpaRepository<Garde, Integer> {

    Garde findById(int id);

    Garde findByType(String type);
}
