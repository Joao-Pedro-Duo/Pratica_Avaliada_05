package com.generation.infostore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_clientes") // CREATE TABLE tb_clientes();
public class Cliente {
	
	@Id // PRYMARY KEY 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(max = 255, message = "O atributo nome deve ter no máximo 255 caracteres!")
	@Column(length = 255)
	private String nome;
	
	@NotBlank(message = "O atributo email é obrigatório!")
	@Size(max = 255, message = "O atributo email deve ter no máximo 255 caracteres!")
	@Column(length = 255)
	@Email(message = "E-mail incorreto tente novamente!")
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "cliente", allowSetters = true)
	private List<Pedido> pedido;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	
	
	
}
