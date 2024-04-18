package com.intranet.pfe.Service;

import com.intranet.pfe.Entity.Agent;

import java.util.List;
import java.util.Optional;

public interface AgentService {
    Agent ajouterAgent(Agent agent);
    Agent modifierAgent(Agent agent);
    List<Agent> GetAgent();
    void supprimerAgent(Long id);
    Optional<Agent> GetAgentById(Long id);
}
