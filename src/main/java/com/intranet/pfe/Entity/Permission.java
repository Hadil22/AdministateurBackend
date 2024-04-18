package com.intranet.pfe.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jourpermission;
    private String heureete;
    private String permissionpour;
    private String raisons;
    private String responsabledirecte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJourpermission() {
        return jourpermission;
    }

    public void setJourpermission(String jourpermission) {
        this.jourpermission = jourpermission;
    }

    public String getHeureete() {
        return heureete;
    }

    public void setHeureete(String heureete) {
        this.heureete = heureete;
    }

    public String getPermissionpour() {
        return permissionpour;
    }

    public void setPermissionpour(String permissionpour) {
        this.permissionpour = permissionpour;
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
