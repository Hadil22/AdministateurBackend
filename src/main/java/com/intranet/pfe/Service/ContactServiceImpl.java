package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.Contact;
import com.intranet.pfe.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    ContactRepository contactRepository;

    @Override
    public Contact ajouterContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact modifierContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> GetContact() {
        return contactRepository.findAll();
    }
}
