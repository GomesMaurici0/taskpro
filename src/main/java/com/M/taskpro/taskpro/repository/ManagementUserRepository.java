package com.M.taskpro.taskpro.repository;

import com.M.taskpro.taskpro.Entity.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ManagementUserRepository extends JpaRepository<EntityUser, UUID> {
	Boolean existsByUsername(String username);
}
