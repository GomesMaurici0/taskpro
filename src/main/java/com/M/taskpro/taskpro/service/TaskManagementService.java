package com.M.taskpro.taskpro.service;

import com.M.taskpro.taskpro.DTO.TaskmanagemntDTO;
import com.M.taskpro.taskpro.Entity.EntityTask;
import com.M.taskpro.taskpro.controller.TaskManagementController;
import com.M.taskpro.taskpro.repository.ManagementTaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class TaskManagementService {

	@Autowired
	ManagementTaskRepository repository;


	public EntityTask validationId (Long id){
		Optional<EntityTask> entityId = repository.findById(id);
		if (entityId.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Task não encontrada");
		}
		return entityId.get();
	}

	public EntityTask managementPost(TaskmanagemntDTO DTO){
		if (repository.existsByTituloAndDescricao(DTO.titulo(), DTO.descricao())){
			throw new ResponseStatusException(HttpStatus.CONFLICT,"Titulo e/ou Descricao Já existe.",null);
		}

			EntityTask entity = EntityTask.builder().build();
			BeanUtils.copyProperties(DTO,entity);
			return repository.save(entity);
	}
	public PagedModel<EntityModel<EntityTask>> managementGetAll(Pageable pageable){
		Page<EntityTask> taskPage = repository.findAll(pageable);
		List<EntityModel<EntityTask>> entityList = new ArrayList<>();
		if (!taskPage.isEmpty()){
			for (EntityTask task : taskPage){
				EntityModel<EntityTask> resource = EntityModel.of(task);
				resource.add(linkTo(methodOn(TaskManagementController.class).getById(task.getId())).withSelfRel());
				entityList.add(resource);
			}
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Task não encontrada",null);
		}
		PagedModel<EntityModel<EntityTask>> pagedModel = PagedModel.of(entityList, new PagedModel.PageMetadata(
				taskPage.getSize(),
				taskPage.getNumber(),
				taskPage.getTotalElements()));
		return pagedModel;
	}

	public EntityModel<EntityTask> managementGetById(Long id){
		EntityTask validId = validationId(id);
		EntityModel<EntityTask> resource= EntityModel.of(validId);
		resource.add(linkTo(methodOn(TaskManagementController.class).getAll(Pageable.unpaged())).withSelfRel());
		return resource;
	}
	public void managementDelete (Long id){
		EntityTask entityIdValidation = validationId(id);
		 repository.delete(entityIdValidation);
	}
	public EntityTask managementnUpdate(Long id, TaskmanagemntDTO DTO) {
		Optional<EntityTask> taskExistente = repository.findById(id);

		if (taskExistente.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task não encontrada.");
		}

		if (repository.existsByTituloAndDescricao(DTO.titulo(), DTO.descricao())
				&& !taskExistente.get().getId().equals(id)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Título e/ou descrição já existentes.");
		}


		EntityTask validationEntity = validationId(id);

		BeanUtils.copyProperties(DTO, validationEntity);

		return repository.save(validationEntity);
	}
}
