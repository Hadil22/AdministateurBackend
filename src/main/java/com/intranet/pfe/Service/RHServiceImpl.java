package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.RH;
import com.intranet.pfe.Repository.RHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RHServiceImpl implements RHService{
    @Autowired
    RHRepository rhRepository;
    @Override
    public RH AjouterRH(RH rh) {
        return rhRepository.save(rh);
    }

    @Override
    public RH ModifierRH(RH rh) {
        return rhRepository.save(rh);
    }

    @Override
    public List<RH> GetRH() {
        return rhRepository.findAll();
    }

    @Override
    public void SupprimerRH(Long id) {
        rhRepository.deleteById(id);

    }

    @Override
    public Optional<RH> GetRHById(Long id) {
        return rhRepository.findById(id);
    }
}
