package com.M.taskpro.taskpro.controller;

import com.M.taskpro.taskpro.DTO.CompanyNewDTO;
import com.M.taskpro.taskpro.Entity.EntityCompany;
import com.M.taskpro.taskpro.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CompanyController {

	@Autowired
	CompanyService enterpriseService;

	@PostMapping("/compaines")
	public ResponseEntity<EntityCompany> postEnterprise (@RequestBody @Valid CompanyNewDTO DTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(enterpriseService.managementPost(DTO));
	}

}
