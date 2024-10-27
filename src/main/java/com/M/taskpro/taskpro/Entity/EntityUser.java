package com.M.taskpro.taskpro.Entity;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "userTable")
public class EntityUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user")
	private UUID id;

	@Column(nullable = false)
	private String name;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password",nullable = false)
	private String password;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empresa_id")
	private EntityEnterprise empresa;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EntityEnterprise getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EntityEnterprise empresa) {
		this.empresa = empresa;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}