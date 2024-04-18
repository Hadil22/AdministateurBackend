package com.intranet.pfe.Service;


import com.intranet.pfe.Entity.Permutation;

import com.intranet.pfe.Repository.PermutationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermutationServiceImpl implements PermutationService{
    @Autowired
    PermutationRepository permutationRepository;

    @Override
    public Permutation AjouterPermutation(Permutation permutation) {
        return permutationRepository.save(permutation);
    }

    @Override
    public Permutation ModifierPermutation(Permutation permutation) {
        return permutationRepository.save(permutation);
    }

    @Override
    public List<Permutation> GetPermutation() {
        return permutationRepository.findAll();
    }

    @Override
    public void SupprimerPermutation(Long id) {
        permutationRepository.deleteById(id);

    }

    @Override
    public Optional<Permutation> GetPermutationById(Long id) {
        return permutationRepository.findById(id);
    }
}
