package com.intranet.pfe.RestController;

import com.intranet.pfe.Entity.Admin;
import com.intranet.pfe.Entity.Agent;
import com.intranet.pfe.Entity.Avance;
import com.intranet.pfe.Repository.AvanceRepository;
import com.intranet.pfe.Service.AvanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/avance")
public class AvanceRestController {
    @Autowired
    AvanceService avanceService;
    @Autowired
    AvanceRepository avanceRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Avance AjouterAvance(@RequestBody Avance avance){
        return avanceService.AjouterAvance(avance);

    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Avance ModifierAvance(@PathVariable("id")Long id, @RequestBody Avance avance){
        return avanceService.ModifierAvance(avance);
    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Avance> AfficherAvance(){
        return avanceService.AfficherAvance();}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void SupprimerAvance(@PathVariable("id") Long id){
        avanceService.SupprimerAvance(id);

    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Avance> getAvanceById(@PathVariable("id") Long id){
        Optional<Avance> avance = avanceService.GetAvanceById(id);
        return avance;
    }
}
