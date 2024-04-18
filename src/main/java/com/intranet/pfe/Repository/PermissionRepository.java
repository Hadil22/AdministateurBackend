package com.intranet.pfe.Repository;

import com.intranet.pfe.Entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
