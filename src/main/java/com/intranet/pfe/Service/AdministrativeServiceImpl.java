package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.Administrative;
import com.intranet.pfe.Repository.AdministrativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativeServiceImpl implements AdministrativeService {
    @Autowired
    AdministrativeRepository administrativeRepository;

    @Override
    public Administrative AjouterAdministrative(Administrative administrative) {
        return administrativeRepository.save(administrative);
    }

    @Override
    public List<Administrative> GetAdministrative() {
        return administrativeRepository.findAll();
    }

    @Override
    public void SupprimerAdministrative(Long id) {
        administrativeRepository.deleteById(id);
    }

    @Override
    public Optional<Administrative> GetAdministrativeById(Long id) {
        return administrativeRepository.findById(id);
    }
}
