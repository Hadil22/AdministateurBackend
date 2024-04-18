package com.intranet.pfe.Repository;

import com.intranet.pfe.Entity.RP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RPRepository extends JpaRepository<RP,Long> {
    boolean existsByEmail(String email);

    RP findRHByEmail(String email);
}
