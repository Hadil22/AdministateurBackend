package com.intranet.pfe.Repository;

import com.intranet.pfe.Entity.Admin;
import com.intranet.pfe.Entity.RH;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RHRepository extends JpaRepository<RH,Long> {
    boolean existsByEmail(String email);


    RH findRHByEmail(String email);
}
