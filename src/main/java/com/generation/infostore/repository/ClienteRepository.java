package com.generation.infostore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.infostore.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	// Faz uma Busca pelo Nome do cliente digitado
	public List<Cliente> findAllByNomeContainingIgnoreCase(String nome);
	
	
	// Faz uma Busca pelo Email do cliente digitado - Extra
	public List<Cliente> findAllByEmailContainingIgnoreCase(String email);

}
