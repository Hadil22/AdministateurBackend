package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.Conge;

import java.util.List;
import java.util.Optional;

public interface CongeService {
    Conge AjouterConge(Conge conge);
    Conge ModifierConge(Conge conge);
    List<Conge> GetConge();
    void SupprimerConge(Long id);
    Optional<Conge> GetCongeById(Long id);
}
