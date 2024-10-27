package com.M.taskpro.taskpro.controller;

import com.M.taskpro.taskpro.service.EnterpriseService;
import com.M.taskpro.taskpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class AssosiationController {

	@Autowired
	EnterpriseService enterprise;

	@Autowired
	UserService user;


	@PostMapping("/assignUserToCompany")
	public ResponseEntity<String> assign(@RequestParam UUID idUser, @RequestParam Long idEnterprise){
		user.assignUsertoEnterprise(idUser,idEnterprise);
		return ResponseEntity.ok("Usuário associado a empresa com sucesso. ");
	}
}
