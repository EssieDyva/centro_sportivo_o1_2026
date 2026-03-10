package com.betacom.jpa.models;

import com.betacom.jpa.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "utente")
public class Utente {
	
	@Id
	private String userName;
	private String pwd;
	private String email;
	private Role role;
}
