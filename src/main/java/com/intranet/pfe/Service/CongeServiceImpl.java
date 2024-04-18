package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.Conge;
import com.intranet.pfe.Repository.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CongeServiceImpl implements CongeService{
    @Autowired
    CongeRepository congeRepository;

    @Override
    public Conge AjouterConge(Conge conge) {
        return congeRepository.save(conge);
    }

    @Override
    public Conge ModifierConge(Conge conge) {
        return congeRepository.save(conge);
    }

    @Override
    public List<Conge> GetConge() {
        return congeRepository.findAll();
    }

    @Override
    public void SupprimerConge(Long id) {
        congeRepository.deleteById(id);

    }

    @Override
    public Optional<Conge> GetCongeById(Long id) {
        return congeRepository.findById(id);
    }
}
