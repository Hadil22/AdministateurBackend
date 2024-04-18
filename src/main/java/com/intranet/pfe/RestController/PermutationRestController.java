package com.intranet.pfe.RestController;

import com.intranet.pfe.Entity.Permutation;
import com.intranet.pfe.Repository.PermutationRepository;
import com.intranet.pfe.Service.PermutationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/permutation")
public class PermutationRestController {
    @Autowired
    PermutationService permutationService;
    @Autowired
    PermutationRepository permutationRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Permutation AjouterPermutation(@RequestBody Permutation permutation){
        return permutationService.AjouterPermutation(permutation);

    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Permutation ModifierPermutation(@PathVariable("id")Long id, @RequestBody Permutation permutation){
        return permutationService.ModifierPermutation(permutation);
    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Permutation> AfficherPermutation(){
        return permutationService.GetPermutation();}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void SupprimerPermutation(@PathVariable("id") Long id){
        permutationService.SupprimerPermutation(id);

    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Permutation> getPermutationById(@PathVariable("id") Long id){
        Optional<Permutation> permutation = permutationService.GetPermutationById(id);
        return permutation;
    }
}
