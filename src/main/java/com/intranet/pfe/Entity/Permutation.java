package com.intranet.pfe.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Permutation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String permuteravec;

    private Date dateDebut;

    private Date dateFin;
    private String raisons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermuteravec() {
        return permuteravec;
    }

    public void setPermuteravec(String permuteravec) {
        this.permuteravec = permuteravec;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getRaisons() {
        return raisons;
    }

    public void setRaisons(String raisons) {
        this.raisons = raisons;
    }
}
