package com.exemplo.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.curso.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

}
