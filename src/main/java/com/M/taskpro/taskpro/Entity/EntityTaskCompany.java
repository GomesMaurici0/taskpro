package com.M.taskpro.taskpro.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Entity
@Table(name = "taskCompany_table")
public class EntityTaskCompany {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String description;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private LocalDate dueDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private EntityUser assgnedUser;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private EntityCompany assgnedCompany;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public EntityUser getAssgnedUser() {
		return assgnedUser;
	}

	public void setAssgnedUser(EntityUser assgnedUser) {
		this.assgnedUser = assgnedUser;
	}

	public EntityCompany getAssgnedCompany() {
		return assgnedCompany;
	}

	public void setAssgnedCompany(EntityCompany assgnedCompany) {
		this.assgnedCompany = assgnedCompany;
	}
}
