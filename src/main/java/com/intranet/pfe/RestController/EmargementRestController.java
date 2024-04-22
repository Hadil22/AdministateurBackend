package com.intranet.pfe.RestController;

import com.intranet.pfe.Entity.Emargement;
import com.intranet.pfe.Repository.EmargementRepository;
import com.intranet.pfe.Service.EmargementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/emargement")
public class EmargementRestController {

    @Autowired
    EmargementService emargementService;
    @Autowired
    EmargementRepository emargementRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Emargement AjouterEmargement(@RequestBody Emargement emargement){
        return emargementService.ajouterEmargement(emargement);

    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Emargement ModifierEmargement(@PathVariable("id")Long id, @RequestBody Emargement emargement){
        return emargementService.modifierEmargement(emargement);
    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Emargement> afficherEmargement(){
        return emargementService.GetEmargement();}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void SupprimerEmargement(@PathVariable("id") Long id){
        emargementService.supprimerEmargement(id);

    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Emargement> getEmargementById(@PathVariable("id") Long id){
        Optional<Emargement> emargement = emargementService.GetEmargementById(id);
        return emargement;
    }

}
