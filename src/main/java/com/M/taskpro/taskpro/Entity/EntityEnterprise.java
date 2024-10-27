package com.M.taskpro.taskpro.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "empresa_table")
public class EntityEnterprise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column( nullable = true)
	private String name;

	@Column(nullable = true, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	public Long getId() {
		return id;
	}

	@OneToMany(mappedBy = "empresa")
	private Set<EntityUser> users = new HashSet<>();

	public void setId(Long id) {
		this.id = id;
	}

	public Set<EntityUser> getUsers() {
		return users;
	}

	public void setUsers(Set<EntityUser> users) {
		this.users = users;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

