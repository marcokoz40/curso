package com.exemplo.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.curso.entidades.ItemPedido;
import com.exemplo.curso.entidades.auxiliares.ItemPedidoAuxiliar;


public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, ItemPedidoAuxiliar> {

}
