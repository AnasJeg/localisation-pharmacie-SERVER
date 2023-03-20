package me.localisationpharmacie.repository;

import me.localisationpharmacie.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRep extends JpaRepository<Role, Integer> {
    Role findById(int id);

    Role findByNom(String nom);
}
