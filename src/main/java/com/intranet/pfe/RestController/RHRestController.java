package com.intranet.pfe.RestController;

import com.intranet.pfe.Entity.Admin;
import com.intranet.pfe.Entity.RH;
import com.intranet.pfe.Repository.RHRepository;
import com.intranet.pfe.Service.RHService;
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
@RequestMapping(value = "/rh")
public class RHRestController {
    @Autowired
    RHService rhService;
    @Autowired
    RHRepository rhRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> AjouterRH (@RequestBody RH rh){
        HashMap<String, Object> response = new HashMap<>();
        if(rhRepository.existsByEmail(rh.getEmail())){
            response.put("message", "email exist deja !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else{
            rh.setMdp(this.bCryptPasswordEncoder.encode(rh.getMdp()));
            RH savedUser = rhRepository.save(rh);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);}

    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public RH modifierRH(@PathVariable("id")Long id, @RequestBody RH rh){
        rh.setMdp(this.bCryptPasswordEncoder.encode(rh.getMdp()));
        return rhService.ModifierRH(rh);
    }
    @RequestMapping(method = RequestMethod.GET )
    public List<RH> afficherRH(){
        return rhService.GetRH();}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void suppRH(@PathVariable("id") Long id){
        rhService.SupprimerRH(id);

    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<RH> getRHById(@PathVariable("id") Long id){

        Optional<RH> rh = rhService.GetRHById(id);
        return rh;
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginRH(@RequestBody RH rh) {
        System.out.println("in login-rh"+rh);
        HashMap<String, Object> response = new HashMap<>();

        RH userFromDB = rhRepository.findRHByEmail(rh.getEmail());
        System.out.println("userFromDB+rh"+userFromDB);
        if (userFromDB == null) {
            response.put("message", "RH not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            boolean compare = this.bCryptPasswordEncoder.matches(rh.getMdp(), userFromDB.getMdp());
            System.out.println("compare"+compare);
            if (!compare) {
                response.put("message", "RH not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }else
            {
                String token = Jwts.builder()
                        .claim("data", userFromDB)
                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();
                response.put("token", token);
                System.out.println("hhh");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

        }
    }

}
