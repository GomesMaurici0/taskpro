package com.M.taskpro.taskpro.service;

import com.M.taskpro.taskpro.DTO.UserDTO;
import com.M.taskpro.taskpro.Entity.EntityEnterprise;
import com.M.taskpro.taskpro.Entity.EntityUser;
import com.M.taskpro.taskpro.repository.ManagementEnterpriseRepository;
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
	ManagementEnterpriseRepository enterpriseRepository;

	public EntityUser postUser(UserDTO userDTO){
		if (userRepository.existsByUsername(userDTO.getUsername())){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario ja existente");
		}
		EntityUser entity = new EntityUser();
		BeanUtils.copyProperties(userDTO,entity);
		return userRepository.save(entity);
	}

	public void assignUsertoEnterprise (UUID userId, Long enterpriseId){
		EntityUser user = userRepository.findById(userId).
				orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));

		EntityEnterprise enterprise = enterpriseRepository.findById(enterpriseId).
				orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Empresa não encontrada."));

		user.setEmpresa(enterprise);
		userRepository.save(user);
	}
}
