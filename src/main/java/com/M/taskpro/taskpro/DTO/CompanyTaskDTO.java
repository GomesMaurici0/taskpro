package com.M.taskpro.taskpro.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class CompanyTaskDTO {

	@NotBlank private String description;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	@NotBlank private LocalDate dueDate;

	@NotBlank private String title;

	@NotNull private  UUID assignedUserId;

	public @NotNull UUID getAssignedUserId() {
		return assignedUserId;
	}

	public void setAssignedUserId(@NotNull UUID assignedUserId) {
		this.assignedUserId = assignedUserId;
	}

	public @NotBlank String getDescription() {
		return description;
	}

	public void setDescription(@NotBlank String description) {
		this.description = description;
	}

	public @NotBlank LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(@NotBlank LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public @NotBlank String getTitle() {
		return title;
	}

	public void setTitle(@NotBlank String title) {
		this.title = title;
	}
}
