package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.Avance;

import java.util.List;
import java.util.Optional;

public interface AvanceService {
    Avance AjouterAvance(Avance avance);
    Avance ModifierAvance(Avance avance);
    List<Avance> AfficherAvance();
    void SupprimerAvance(Long id);
    Optional<Avance> GetAvanceById(Long id);
}
