package com.intranet.pfe.Repository;


import com.intranet.pfe.Entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent,Long> {
    boolean existsByEmail(String email);

    Agent findAgentByEmail(String email);
}
