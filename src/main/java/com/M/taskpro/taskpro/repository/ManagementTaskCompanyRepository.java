package com.M.taskpro.taskpro.repository;

import com.M.taskpro.taskpro.Entity.EntityTaskCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagementTaskCompanyRepository extends JpaRepository<EntityTaskCompany, Long> {
}
