package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.Emargement;
import com.intranet.pfe.Repository.EmargementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmargementServiceImpl implements EmargementService {
    @Autowired
    EmargementRepository emargementRepository ;
    @Override
    public Emargement ajouterEmargement(Emargement emargement) {
        return emargementRepository.save(emargement);
    }

    @Override
    public Emargement modifierEmargement(Emargement emargement) {
        return emargementRepository.save(emargement);
    }

    @Override
    public List<Emargement> GetEmargement() {
        return emargementRepository.findAll();
    }

    @Override
    public void supprimerEmargement(Long id) {
        emargementRepository.deleteById(id);

    }

    @Override
    public Optional<Emargement> GetEmargementById(Long id) {
        return emargementRepository.findById(id);
    }
}