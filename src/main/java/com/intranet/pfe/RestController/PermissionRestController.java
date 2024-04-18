package com.intranet.pfe.RestController;


import com.intranet.pfe.Entity.Permission;
import com.intranet.pfe.Repository.PermissionRepository;
import com.intranet.pfe.Service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/permission")
public class PermissionRestController {
    @Autowired
    PermissionRepository permissionRepository;
    @Autowired
    PermissionService permissionService;
    @RequestMapping(method = RequestMethod.POST)
    public Permission AjouterPermission(@RequestBody Permission permission){
        return permissionService.AjouterPermission(permission);

    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Permission ModifierPermission(@PathVariable("id")Long id, @RequestBody Permission permission){
        return permissionService.ModifierPermission(permission);
    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Permission> AfficherPermission(){
        return permissionService.GetPermission();}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void SupprimerPermission(@PathVariable("id") Long id){
        permissionService.SupprimerPermission(id);

    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Permission> getPermissionById(@PathVariable("id") Long id){
        Optional<Permission> permission = permissionService.GetPermissionById(id);
        return permission;
    }
}
