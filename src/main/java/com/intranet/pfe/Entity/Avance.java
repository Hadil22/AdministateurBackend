package com.intranet.pfe.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Avance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Long montantenchiffre;

    private String montant;

    private String numcin;
    private String delivree;
    private String gouvernorat;
    private String moisderemboursement;
    private String annee;
    private String responsable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Number getMontantenchiffre() {
        return montantenchiffre;
    }

    public void setMontantenchiffre(Long montantenchiffre) {
        this.montantenchiffre = montantenchiffre;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getNumcin() {
        return numcin;
    }

    public void setNumcin(String numcin) {
        this.numcin = numcin;
    }

    public String getDelivree() {
        return delivree;
    }

    public void setDelivree(String delivree) {
        this.delivree = delivree;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getMoisderemboursement() {
        return moisderemboursement;
    }

    public void setMoisderemboursement(String moisderemboursement) {
        this.moisderemboursement = moisderemboursement;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}


