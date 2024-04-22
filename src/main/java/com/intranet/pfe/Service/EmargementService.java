package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.Emargement;

import java.util.List;
import java.util.Optional;

public interface EmargementService {
    Emargement ajouterEmargement(Emargement emargement);
    Emargement modifierEmargement(Emargement emargement);
    List<Emargement> GetEmargement();
    void supprimerEmargement(Long id);
    Optional<Emargement> GetEmargementById(Long id);
}