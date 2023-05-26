package me.localisationpharmacie.repository;


import me.localisationpharmacie.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VilleRep extends JpaRepository<Ville, Integer> {
    Ville findById(int id);

    Ville findByNom(String nom);
}
