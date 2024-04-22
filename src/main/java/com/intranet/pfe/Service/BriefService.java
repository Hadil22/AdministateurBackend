package com.intranet.pfe.Service;


import com.intranet.pfe.Entity.Brief;

import java.util.List;
import java.util.Optional;

public interface BriefService {

    Brief ajouterBrief(Brief brief);
    Brief modifierBrief(Brief brief);
    List<Brief> GetBrief();
    void supprimerBrief(Long id);
    Optional<Brief> GetBriefById(Long id);
}