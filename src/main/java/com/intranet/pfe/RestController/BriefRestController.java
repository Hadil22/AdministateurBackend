package com.intranet.pfe.RestController;

import com.intranet.pfe.Entity.Brief;
import com.intranet.pfe.Repository.BriefRepository;
import com.intranet.pfe.Service.BriefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/brief")
public class BriefRestController {
    @Autowired
    BriefService briefService;
    @Autowired
    BriefRepository briefRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Brief AjouterBrief(@RequestBody Brief brief){
        return briefService.ajouterBrief(brief);

    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Brief ModifierBrief(@PathVariable("id")Long id, @RequestBody Brief brief){
        return briefService.modifierBrief(brief);
    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Brief> afficherBrief(){
        return briefService.GetBrief();}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void SupprimerBrief(@PathVariable("id") Long id){
        briefService.supprimerBrief(id);

    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Brief> getBriefById(@PathVariable("id") Long id){
        Optional<Brief> brief = briefService.GetBriefById(id);
        return brief;
    }
}