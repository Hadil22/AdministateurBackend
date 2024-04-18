package com.intranet.pfe.Service;



import com.intranet.pfe.Entity.Permission;
import com.intranet.pfe.Repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public Permission AjouterPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission ModifierPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> GetPermission() {
        return permissionRepository.findAll();
    }

    @Override
    public void SupprimerPermission(Long id) {
        permissionRepository.deleteById(id);

    }

    @Override
    public Optional<Permission> GetPermissionById(Long id) {
        return permissionRepository.findById(id);
    }
}
