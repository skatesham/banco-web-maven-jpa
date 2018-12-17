package br.sham.web.banco.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
public @Data class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String usuario;
	private String email;
	private String endereco;
	private String password;
	
	@JoinColumn(unique = true)
	@OneToOne
	private Conta conta;
	
	
}
