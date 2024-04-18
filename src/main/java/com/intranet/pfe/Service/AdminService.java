package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin ajouterAdmin(Admin admin);
    Admin modifierAdmin(Admin admin);
    List<Admin> GetAdmin();
    void supprimerAdmin(Long id);
    Optional<Admin> GetAdminById(Long id);


}
