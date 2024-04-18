package com.intranet.pfe.RestController;

import com.intranet.pfe.Entity.Agent;
import com.intranet.pfe.Repository.AgentRepository;
import com.intranet.pfe.Service.AgentService;
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
@RequestMapping(value = "/agent")

public class AgentRestController {
    @Autowired
    AgentService agentService;
    @Autowired
    AgentRepository agentRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> AjouterAgent (@RequestBody Agent agent){
        HashMap<String, Object> response = new HashMap<>();
        if(agentRepository.existsByEmail(agent.getEmail())){
            response.put("message", "email exist deja !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else{
            agent.setMdp(this.bCryptPasswordEncoder.encode(agent.getMdp()));
            Agent savedUser = agentRepository.save(agent);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);}

    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Agent modifieragent(@PathVariable("id")Long id, @RequestBody Agent agent){
        agent.setMdp(this.bCryptPasswordEncoder.encode(agent.getMdp()));
        return agentService.modifierAgent(agent);
    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Agent> afficherAgent(){
        return agentService.GetAgent();}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void suppAgent(@PathVariable("id") Long id){
        agentService.supprimerAgent(id);

    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Agent> getAgentById(@PathVariable("id") Long id){

        Optional<Agent> agent = agentService.GetAgentById(id);
        return agent;
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginAgent(@RequestBody Agent agent) {
        System.out.println("in login-agent"+agent);
        HashMap<String, Object> response = new HashMap<>();

        Agent userFromDB = agentRepository.findAgentByEmail(agent.getEmail());
        System.out.println("userFromDB+agent"+userFromDB);
        if (userFromDB == null) {
            response.put("message", "Agent not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            boolean compare = this.bCryptPasswordEncoder.matches(agent.getMdp(), userFromDB.getMdp());
            System.out.println("compare"+compare);
            if (!compare) {
                response.put("message", "agent not found !");
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
