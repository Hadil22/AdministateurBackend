package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.Brief;
import com.intranet.pfe.Repository.BriefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BriefServiceImpl implements BriefService{
    @Autowired
    BriefRepository briefRepository ;
    @Override
    public Brief ajouterBrief(Brief brief) {
        return briefRepository.save(brief);
    }

    @Override
    public Brief modifierBrief(Brief brief) {
        return briefRepository.save(brief);
    }

    @Override
    public List<Brief> GetBrief() {
        return briefRepository.findAll();
    }

    @Override
    public void supprimerBrief(Long id) {
        briefRepository.deleteById(id);

    }

    @Override
    public Optional<Brief> GetBriefById(Long id) {
        return briefRepository.findById(id);
    }
}