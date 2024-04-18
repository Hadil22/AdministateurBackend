package com.intranet.pfe.RestController;

import com.intranet.pfe.Entity.Administrative;
import com.intranet.pfe.Entity.Conge;
import com.intranet.pfe.Repository.AdministrativeRepository;
import com.intranet.pfe.Repository.CongeRepository;
import com.intranet.pfe.Service.AdministrativeService;
import com.intranet.pfe.Service.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/administrative")
public class AdministrativeRestController {
    @Autowired
    AdministrativeService administrativeService;
    @Autowired
    AdministrativeRepository administrativeRepository;
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> AjouterAdministrative(@RequestBody Administrative administrative){
        Administrative savedAdministrative = administrativeRepository.save(administrative);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdministrative);
    }

    @RequestMapping(method = RequestMethod.GET )
    public List<Administrative> AfficherAdministrative(){
        return administrativeService.GetAdministrative();}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void SupprimerConge(@PathVariable("id") Long id){
        administrativeService.SupprimerAdministrative(id);

    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Administrative> getAdministrativeById(@PathVariable("id") Long id){
        Optional<Administrative> administrative = administrativeService.GetAdministrativeById(id);
        return administrative;
    }
}
