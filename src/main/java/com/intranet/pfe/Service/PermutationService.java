package com.intranet.pfe.Service;


import com.intranet.pfe.Entity.Permutation;

import java.util.List;
import java.util.Optional;

public interface PermutationService {
    Permutation AjouterPermutation(Permutation permutation);
    Permutation ModifierPermutation(Permutation permutation);
    List<Permutation> GetPermutation();
    void SupprimerPermutation(Long id);
    Optional<Permutation> GetPermutationById(Long id);
}
