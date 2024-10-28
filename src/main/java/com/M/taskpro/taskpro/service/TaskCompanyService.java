package com.M.taskpro.taskpro.service;

import com.M.taskpro.taskpro.Entity.EntityCompany;
import com.M.taskpro.taskpro.Entity.EntityUser;
import com.M.taskpro.taskpro.repository.ManagementCompanyRepository;
import com.M.taskpro.taskpro.repository.ManagementUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class TaskCompanyService {

	@Autowired
	ManagementCompanyRepository companyRepository;

	@Autowired
	ManagementUserRepository userRepository;

	public void assignUserToEnterprise(UUID userId, Long enterpriseId){
		EntityUser user = userRepository.findById(userId).
				orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));

		EntityCompany enterprise = companyRepository.findById(enterpriseId).
				orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Empresa não encontrada."));

		user.setEmpresa(enterprise);
		userRepository.save(user);
	}
}
