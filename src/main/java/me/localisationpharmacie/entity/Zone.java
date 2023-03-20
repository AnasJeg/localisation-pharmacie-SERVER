package me.localisationpharmacie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @OneToMany(mappedBy = "zone",fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<Pharmacie> pharmacie;

    @ManyToOne(fetch = FetchType.EAGER)
    private Ville ville;
}
