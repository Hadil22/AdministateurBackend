package com.intranet.pfe.RestController;

import com.intranet.pfe.Entity.Avance;
import com.intranet.pfe.Entity.Conge;
import com.intranet.pfe.Repository.CongeRepository;
import com.intranet.pfe.Service.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/conge")
public class CongeRestController {
    @Autowired
    CongeService congeService;
    @Autowired
    CongeRepository congeRepository;
    @RequestMapping(method = RequestMethod.POST)
    public Conge AjouterConge(@RequestBody Conge conge){
        return congeService.AjouterConge(conge);
    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Conge ModifierConge(@PathVariable("id")Long id, @RequestBody Conge conge){
        return congeService.ModifierConge(conge);
    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Conge> AfficherConge(){
        return congeService.GetConge();}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void SupprimerConge(@PathVariable("id") Long id){
        congeService.SupprimerConge(id);

    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Conge> getCongeById(@PathVariable("id") Long id){
        Optional<Conge> conge = congeService.GetCongeById(id);
        return conge;
    }
}
