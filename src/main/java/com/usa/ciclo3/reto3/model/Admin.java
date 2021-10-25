package com.usa.ciclo3.reto3.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Historia de usuario 7 -Creación de usuarios administrativos.
 */

@Entity
@Table(name = "admins")
public class Admin implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 250)
	private String name;

	@Column(length = 45)
	private String email;

	@Column(length = 45)
	private String password;


	// --- Getters y Setters ---
	
	public int getId() {
		return id;
	}

	public void setId(int newId) {
		id = newId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Constructores

	public Admin(){

	}

	public Admin(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	
}

