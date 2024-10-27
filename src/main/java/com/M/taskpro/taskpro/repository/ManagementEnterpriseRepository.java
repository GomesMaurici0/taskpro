package com.M.taskpro.taskpro.repository;

import com.M.taskpro.taskpro.Entity.EntityEnterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ManagementEnterpriseRepository extends JpaRepository<EntityEnterprise, Long> {
	Boolean existsByUsername(String username);
}
