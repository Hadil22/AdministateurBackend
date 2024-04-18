package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.Avance;
import com.intranet.pfe.Repository.AvanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvanceServiceImpl implements AvanceService{
    @Autowired
    AvanceRepository avanceRepository ;

    @Override
    public Avance AjouterAvance(Avance avance) {
        return avanceRepository.save(avance);
    }

    @Override
    public Avance ModifierAvance(Avance avance) {
        return avanceRepository.save(avance);
    }

    @Override
    public List<Avance> AfficherAvance() {
        return avanceRepository.findAll();
    }

    @Override
    public void SupprimerAvance(Long id) {
        avanceRepository.deleteById(id);

    }

    @Override
    public Optional<Avance> GetAvanceById(Long id) {
        return avanceRepository.findById(id);
    }
}
