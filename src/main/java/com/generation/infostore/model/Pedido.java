package com.generation.infostore.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_pedidos") // CREATE TABLE tb_pedidos();
public class Pedido {

	@Id // PRYMARY KEY 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Long id;
	
	@NotBlank(message = "O atributo produto é obrigatório!")
	@Size(min = 2, max = 100, message = "O atributo produto deve ter no mínimo 02 e no máximo 100 caracteres!")
	@Column(length = 100)
	private String produto;
	
	@NotBlank(message = "O atributo descricão é obrigatório!")
	@Size(min = 5, max = 500, message = "A descricão deve ter no mínimo 05 e no máximo 500 caracteres!")
	@Column(length = 500)
	private String descricao;
	
	@NotNull(message = "O atributo valor é obrigatório!")
	@PositiveOrZero(message = "O valor só pode ser positivo e maior do que zero!")
	@Digits(integer = 8, fraction = 2)
	private BigDecimal valor;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("pedido")
	private Cliente cliente;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	} 
	
	
}
