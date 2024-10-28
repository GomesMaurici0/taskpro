package com.M.taskpro.taskpro.service;

import com.M.taskpro.taskpro.DTO.CompanyNewDTO;
import com.M.taskpro.taskpro.Entity.EntityCompany;
import com.M.taskpro.taskpro.repository.ManagementCompanyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CompanyService {

	@Autowired
	ManagementCompanyRepository repository;

	public EntityCompany managementPost (CompanyNewDTO DTO){
		if (repository.existsByUsername(DTO.getUsername())){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário ja existente.");
		}
		EntityCompany entity = new EntityCompany();
		BeanUtils.copyProperties(DTO, entity);
		return repository.save(entity);
	}
}