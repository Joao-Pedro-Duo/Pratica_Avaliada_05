package com.generation.infostore.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.infostore.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	// Faz uma Busca pelo nome do Produto digitado
	public List<Pedido> findAllByProdutoContainingIgnoreCase(String produto);
	

	// Realiza uma busca por todos os Pedidos cujo o valor seja maior 
	// do que um valor digitado ordenado pelo valor em ordem crescente - Extra
	public List <Pedido> findAllByValorGreaterThanOrderByValor(BigDecimal valor);
	
	
	// Realiza uma busca por todos os Pedidos cujo o valor seja menor 
	// do que um valor digitado ordenado pelo valor em ordem decrescente - Extra
	public List <Pedido> findAllByValorLessThanOrderByValorDesc(BigDecimal valor);

}
