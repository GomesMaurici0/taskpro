package com.M.taskpro.taskpro.repository;

import com.M.taskpro.taskpro.Entity.EntityTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ManagementTaskRepository extends JpaRepository<EntityTask, Long> {
	Boolean existsByTituloAndDescricao(String titulo, String descricao);

}
