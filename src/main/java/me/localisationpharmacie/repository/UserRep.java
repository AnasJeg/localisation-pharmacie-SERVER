package me.localisationpharmacies.repository;

import me.localisationpharmacies.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRep extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}