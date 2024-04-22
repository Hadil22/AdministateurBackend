package com.intranet.pfe.Repository;

import com.intranet.pfe.Entity.Emargement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmargementRepository extends JpaRepository<Emargement,Long> {
}