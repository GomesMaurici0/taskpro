package com.M.taskpro.taskpro.repository;

import com.M.taskpro.taskpro.Entity.EntityCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ManagementCompanyRepository extends JpaRepository<EntityCompany, Long> {
	Boolean existsByUsername(String username);
}
