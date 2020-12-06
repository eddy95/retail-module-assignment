package com.assignment.retail.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user")
public class UserEntity {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "role")
	private String role;

	@Column(name = "user_registered_date")
	private LocalDateTime userRegisteredDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getUserRegisteredDate() {
		return userRegisteredDate;
	}

	public void setUserRegisteredDate(LocalDateTime userRegisteredDate) {
		this.userRegisteredDate = userRegisteredDate;
	}

}
