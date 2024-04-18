package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.Agent;
import com.intranet.pfe.Repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService{
    @Autowired
    AgentRepository agentRepository;

    @Override
    public Agent ajouterAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Agent modifierAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public List<Agent> GetAgent() {
        return agentRepository.findAll();
    }

    @Override
    public void supprimerAgent(Long id) {
        agentRepository.deleteById(id);

    }

    @Override
    public Optional<Agent> GetAgentById(Long id) {
        return agentRepository.findById(id);
    }
}
