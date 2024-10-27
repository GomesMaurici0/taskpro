package com.M.taskpro.taskpro.service;

import com.M.taskpro.taskpro.DTO.EnterpriseDTO;
import com.M.taskpro.taskpro.Entity.EntityEnterprise;
import com.M.taskpro.taskpro.repository.ManagementEnterpriseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EnterpriseService {

	@Autowired
	ManagementEnterpriseRepository repository;

	public EntityEnterprise managementPost (EnterpriseDTO DTO){
		if (repository.existsByUsername(DTO.getUsername())){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário ja existente.");
		}
		EntityEnterprise entity = new EntityEnterprise();
		BeanUtils.copyProperties(DTO, entity);
		return repository.save(entity);
	}
}