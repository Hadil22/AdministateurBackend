package com.intranet.pfe.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Emargement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String endroit;
    private Date date;
    private String objet;
    private String listedesgroupes;
    private String listedesagents;
    private Long debutefin;
    private String commentaires;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndroit() {
        return endroit;
    }

    public void setEndroit(String endroit) {
        this.endroit = endroit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getListedesgroupes() {
        return listedesgroupes;
    }

    public void setListedesgroupes(String listedesgroupes) {
        this.listedesgroupes = listedesgroupes;
    }

    public String getListedesagents() {
        return listedesagents;
    }

    public void setListedesagents(String listedesagents) {
        this.listedesagents = listedesagents;
    }

    public Long getDebutefin() {
        return debutefin;
    }

    public void setDebutefin(Long debutefin) {
        this.debutefin = debutefin;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }
}