package com.intranet.pfe.Service;


import com.intranet.pfe.Entity.Contact;

import java.util.List;

public interface ContactService {
    Contact ajouterContact(Contact contact);
    Contact modifierContact(Contact contact);
    List<Contact> GetContact();
}
