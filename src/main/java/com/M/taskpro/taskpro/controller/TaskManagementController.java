package com.M.taskpro.taskpro.controller;

import com.M.taskpro.taskpro.DTO.TaskmanagemntDTO;
import com.M.taskpro.taskpro.Entity.EntityTask;
import com.M.taskpro.taskpro.service.TaskManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TaskManagementController {

	@Autowired
	TaskManagementService service;

	@PostMapping("/task")
	public ResponseEntity<EntityTask> post(@RequestBody @Valid TaskmanagemntDTO DTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.managementPost(DTO));
	}

	@GetMapping("/task")
	public ResponseEntity<PagedModel<EntityModel<EntityTask>>> getAll(Pageable page){
		return ResponseEntity.status(HttpStatus.OK).body(service.managementGetAll(page));
	}

	@GetMapping("/task/{id}")
	public ResponseEntity<EntityModel<EntityTask>> getById(@PathVariable(name = "id")Long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.managementGetById(id));
	}
	@PutMapping("/task/{id}")
	public ResponseEntity<EntityTask> update(@PathVariable(name = "id" )Long id,@RequestBody @Valid TaskmanagemntDTO DTO ){
		return ResponseEntity.status(HttpStatus.OK).body(service.managementnUpdate(id,DTO));

	}

	@DeleteMapping("/task/{id}")
	public ResponseEntity delete (@PathVariable(name = "id") Long id){
		service.managementDelete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
