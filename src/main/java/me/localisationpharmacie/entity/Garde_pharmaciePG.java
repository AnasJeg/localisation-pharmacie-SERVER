package me.localisationpharmacie.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Garde_pharmaciePG implements Serializable {

    private int pharmacie;
    private int garde;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

}