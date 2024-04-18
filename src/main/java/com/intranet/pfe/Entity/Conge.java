package com.intranet.pfe.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String soldeconge;
    private Date dernierjourtravailler;
    private Date datereprise;
    private String nombredejourstotal;
    private String nombredejourretenu;
    private String raisons;
    private String responsabledirecte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoldeconge() {
        return soldeconge;
    }

    public void setSoldeconge(String soldeconge) {
        this.soldeconge = soldeconge;
    }

    public Date getDernierjourtravailler() {
        return dernierjourtravailler;
    }

    public void setDernierjourtravailler(Date dernierjourtravailler) {
        this.dernierjourtravailler = dernierjourtravailler;
    }

    public Date getDatereprise() {
        return datereprise;
    }

    public void setDatereprise(Date datereprise) {
        this.datereprise = datereprise;
    }

    public String getNombredejourstotal() {
        return nombredejourstotal;
    }

    public void setNombredejourstotal(String nombredejourstotal) {
        this.nombredejourstotal = nombredejourstotal;
    }

    public String getNombredejourretenu() {
        return nombredejourretenu;
    }

    public void setNombredejourretenu(String nombredejourretenu) {
        this.nombredejourretenu = nombredejourretenu;
    }

    public String getRaisons() {
        return raisons;
    }

    public void setRaisons(String raisons) {
        this.raisons = raisons;
    }

    public String getResponsabledirecte() {
        return responsabledirecte;
    }

    public void setResponsabledirecte(String responsabledirecte) {
        this.responsabledirecte = responsabledirecte;
    }
}
