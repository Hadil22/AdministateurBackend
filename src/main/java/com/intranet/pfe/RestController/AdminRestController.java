package com.intranet.pfe.RestController;

import com.intranet.pfe.Entity.Admin;
import com.intranet.pfe.Repository.AdminRepository;
import com.intranet.pfe.Service.AdminService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/admin")
public class AdminRestController {
    @Autowired
    AdminService adminservice;
    @Autowired
    AdminRepository adminrepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> AjouterAdmin (@RequestBody Admin admin){
        HashMap<String, Object> response = new HashMap<>();
        if(adminrepository.existsByEmail(admin.getEmail())){
            response.put("message", "email exist deja !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else{
            admin.setMdp(this.bCryptPasswordEncoder.encode(admin.getMdp()));
            Admin savedUser = adminrepository.save(admin);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);}

    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Admin modifieradmin(@PathVariable("id")Long id, @RequestBody Admin admin){
        admin.setMdp(this.bCryptPasswordEncoder.encode(admin.getMdp()));
        return adminservice.modifierAdmin(admin);
    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Admin> afficherAdmin(){
        return adminservice.GetAdmin();}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void suppAdmin(@PathVariable("id") Long id){
        adminservice.supprimerAdmin(id);

    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Admin> getAdminById(@PathVariable("id") Long id){

        Optional<Admin> admin = adminservice.GetAdminById(id);
        return admin;
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginAdmin(@RequestBody Admin admin) {
        System.out.println("in login-admin"+admin);
        HashMap<String, Object> response = new HashMap<>();

        Admin userFromDB = adminrepository.findAdminByEmail(admin.getEmail());
        System.out.println("userFromDB+admin"+userFromDB);
        if (userFromDB == null) {
            response.put("message", "Admin not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            boolean compare = this.bCryptPasswordEncoder.matches(admin.getMdp(), userFromDB.getMdp());
            System.out.println("compare"+compare);
            if (!compare) {
                response.put("message", "admin not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }else
            {
                String token = Jwts.builder()
                        .claim("data", userFromDB)
                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();
                response.put("token", token);
                response.put("role",userFromDB.getRole());
                System.out.println("hhh");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

        }
    }
}
