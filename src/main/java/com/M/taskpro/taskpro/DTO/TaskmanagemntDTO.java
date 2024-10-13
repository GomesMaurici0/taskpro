package com.M.taskpro.taskpro.DTO;

import com.M.taskpro.taskpro.Enums.Status;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;


public record TaskmanagemntDTO(@NotBlank String titulo, @NotBlank String descricao,Status status) {

	@JsonCreator
	public TaskmanagemntDTO(@JsonProperty("titulo") String titulo, @JsonProperty("descricao") String descricao, @JsonProperty("status") Status status){
		this.descricao = descricao;
		this.titulo = titulo;
		this.status = (status != null) ? status : Status.PENDENTE;
	}

}
