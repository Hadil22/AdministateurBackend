package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.Administrative;

import java.util.List;
import java.util.Optional;

public interface AdministrativeService {
    Administrative AjouterAdministrative(Administrative administrative);
    List<Administrative> GetAdministrative();
    void SupprimerAdministrative(Long id);
    Optional<Administrative> GetAdministrativeById(Long id);

}
