package com.f1rst.ada.gerenciadoremprestimo.model;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Perfil implements GrantedAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public String getAuthority() {
		return nome;
	}
}
