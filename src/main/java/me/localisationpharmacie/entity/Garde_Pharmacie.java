package me.localisationpharmacie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Garde_Pharmacie {

    @EmbeddedId
    private Garde_pharmaciePG pg;
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "pharmacie", insertable = false, updatable = false)
    @JsonIgnore
    private Pharmacie pharmacie;

    @ManyToOne
    @JoinColumn(name = "garde", insertable = false, updatable = false)
    @JsonIgnore
    private Garde garde;
}
