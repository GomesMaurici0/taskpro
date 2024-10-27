package com.M.taskpro.taskpro.controller;

import com.M.taskpro.taskpro.DTO.UserDTO;
import com.M.taskpro.taskpro.Entity.EntityUser;
import com.M.taskpro.taskpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@PostMapping("/user")
	public ResponseEntity<EntityUser> post (@RequestBody  UserDTO dto){
		EntityUser creatUser = service.postUser(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(creatUser);
	}

}
