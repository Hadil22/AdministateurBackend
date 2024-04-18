package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.RH;

import java.util.List;
import java.util.Optional;

public interface RHService {
    RH AjouterRH(RH rh);
    RH ModifierRH(RH rh);
    List<RH> GetRH();
    void SupprimerRH(Long id);
    Optional<RH> GetRHById(Long id);
}
