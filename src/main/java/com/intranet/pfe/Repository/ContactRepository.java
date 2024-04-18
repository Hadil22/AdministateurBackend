package com.intranet.pfe.Repository;

import com.intranet.pfe.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
