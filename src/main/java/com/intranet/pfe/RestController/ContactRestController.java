package com.intranet.pfe.RestController;

import com.intranet.pfe.Entity.Avance;
import com.intranet.pfe.Entity.Contact;
import com.intranet.pfe.Repository.ContactRepository;
import com.intranet.pfe.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/contact")
public class ContactRestController {
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ContactService contactService;
    @RequestMapping(method = RequestMethod.POST)
    public Contact AjouterContact(@RequestBody Contact contact){
       return contactService.ajouterContact(contact);
    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Contact ModifierContact(@PathVariable("id")Long id, @RequestBody Contact contact){
        return contactService.modifierContact(contact);
    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Contact> AfficherContact(){
        return contactService.GetContact();
    }
}
