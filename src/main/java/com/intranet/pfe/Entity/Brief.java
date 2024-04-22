package com.intranet.pfe.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Brief {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String employe;
    private String objet;
    private String analyse;
    private String pointsforts;
    private String axesdeprogres;
    private String moyens;
    private String attachement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmploye() {
        return employe;
    }

    public void setEmploye(String employe) {
        this.employe = employe;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getAnalyse() {
        return analyse;
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse;
    }

    public String getPointsforts() {
        return pointsforts;
    }

    public void setPointsforts(String pointsforts) {
        this.pointsforts = pointsforts;
    }

    public String getAxesdeprogres() {
        return axesdeprogres;
    }

    public void setAxesdeprogres(String axesdeprogres) {
        this.axesdeprogres = axesdeprogres;
    }

    public String getMoyens() {
        return moyens;
    }

    public void setMoyens(String moyens) {
        this.moyens = moyens;
    }

    public String getAttachement() {
        return attachement;
    }

    public void setAttachement(String attachement) {
        this.attachement = attachement;
    }
}