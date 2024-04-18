package com.intranet.pfe.RestController;

import com.intranet.pfe.Entity.RH;
import com.intranet.pfe.Entity.RP;
import com.intranet.pfe.Repository.RHRepository;
import com.intranet.pfe.Repository.RPRepository;
import com.intranet.pfe.Service.RHService;
import com.intranet.pfe.Service.RPService;
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
@RequestMapping(value = "/rp")
public class RPRestController {
    @Autowired
    RPService rpService;
    @Autowired
    RPRepository rpRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> AjouterRP (@RequestBody RP rp){
        HashMap<String, Object> response = new HashMap<>();
        if(rpRepository.existsByEmail(rp.getEmail())){
            response.put("message", "email exist deja !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else{
            rp.setMdp(this.bCryptPasswordEncoder.encode(rp.getMdp()));
            RP savedUser = rpRepository.save(rp);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);}

    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public RP modifierRP(@PathVariable("id")Long id, @RequestBody RP rp){
        rp.setMdp(this.bCryptPasswordEncoder.encode(rp.getMdp()));
        return rpService.ModifierRP(rp);
    }
    @RequestMapping(method = RequestMethod.GET )
    public List<RP> afficherRP(){
        return rpService.GetRP();}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void suppRP(@PathVariable("id") Long id){
        rpService.SupprimerRP(id);

    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<RP> getRPById(@PathVariable("id") Long id){

        Optional<RP> rp = rpService.GetRPById(id);
        return rp;
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginRP(@RequestBody RP rp) {
        System.out.println("in login-rp"+rp);
        HashMap<String, Object> response = new HashMap<>();

        RP userFromDB = rpRepository.findRHByEmail(rp.getEmail());
        System.out.println("userFromDB+rp"+userFromDB);
        if (userFromDB == null) {
            response.put("message", "RH not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            boolean compare = this.bCryptPasswordEncoder.matches(rp.getMdp(), userFromDB.getMdp());
            System.out.println("compare"+compare);
            if (!compare) {
                response.put("message", "RP not found !");
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
