package com.M.taskpro.taskpro.DTO;

import jakarta.validation.constraints.NotBlank;

public class UserNewDTO {

	@NotBlank
	private String name;

	@NotBlank
	private String username;

	@NotBlank
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public @NotBlank String getUsername() {
		return username;
	}

	public void setUsername(@NotBlank String username) {
		this.username = username;
	}

	public @NotBlank String getPassword() {
		return password;
	}

	public void setPassword(@NotBlank String password) {
		this.password = password;
	}
}



