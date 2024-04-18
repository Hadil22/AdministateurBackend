package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.RP;

import java.util.List;
import java.util.Optional;

public interface RPService {
    RP AjouterRP(RP rp);
    RP ModifierRP(RP rp);
    List<RP> GetRP();
    void SupprimerRP(Long id);
    Optional<RP> GetRPById(Long id);

}
