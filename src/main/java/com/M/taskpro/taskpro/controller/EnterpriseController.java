package com.M.taskpro.taskpro.controller;

import com.M.taskpro.taskpro.DTO.EnterpriseDTO;
import com.M.taskpro.taskpro.Entity.EntityEnterprise;
import com.M.taskpro.taskpro.service.EnterpriseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EnterpriseController {

	@Autowired
	EnterpriseService enterpriseService;

	@PostMapping("/enterprise")
	public ResponseEntity<EntityEnterprise> postEnterprise (@RequestBody @Valid EnterpriseDTO DTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(enterpriseService.managementPost(DTO));
	}
}
