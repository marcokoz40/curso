package com.exemplo.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.curso.entidades.ItemPedido;


public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, Long> {

}
