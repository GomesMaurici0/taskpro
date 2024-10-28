package com.M.taskpro.taskpro.service;

import com.M.taskpro.taskpro.DTO.UserNewDTO;
import com.M.taskpro.taskpro.Entity.EntityCompany;
import com.M.taskpro.taskpro.Entity.EntityUser;
import com.M.taskpro.taskpro.repository.ManagementCompanyRepository;
import com.M.taskpro.taskpro.repository.ManagementUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UserService {

	@Autowired
	ManagementUserRepository userRepository;

	@Autowired
	ManagementCompanyRepository enterpriseRepository;

	public EntityUser postUser(UserNewDTO userDTO){
		if (userRepository.existsByUsername(userDTO.getUsername())){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario ja existente");
		}
		EntityUser entity = new EntityUser();
		BeanUtils.copyProperties(userDTO,entity);
		return userRepository.save(entity);
	}


}
