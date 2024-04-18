package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.RP;
import com.intranet.pfe.Repository.RPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RPServiceImpl implements RPService{
    @Autowired
    RPRepository rpRepository;

    @Override
    public RP AjouterRP(RP rp) {
        return rpRepository.save(rp);
    }

    @Override
    public RP ModifierRP(RP rp) {
        return rpRepository.save(rp);
    }

    @Override
    public List<RP> GetRP() {
        return rpRepository.findAll();
    }

    @Override
    public void SupprimerRP(Long id) {
        rpRepository.deleteById(id);

    }

    @Override
    public Optional<RP> GetRPById(Long id) {
        return rpRepository.findById(id);
    }
}
