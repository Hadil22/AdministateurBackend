package com.intranet.pfe.Service;


import com.intranet.pfe.Entity.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionService {
    Permission AjouterPermission(Permission permission);
    Permission ModifierPermission(Permission permission);
    List<Permission> GetPermission();
    void SupprimerPermission(Long id);
    Optional<Permission> GetPermissionById(Long id);
}
