package com.exemplo.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.curso.entidades.Pedido;
import com.exemplo.curso.repositorios.PedidoRepositorio;

@Service
public class PedidoServico {

	@Autowired
	private PedidoRepositorio repositorio;

	public List<Pedido> findAll() {
		return repositorio.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> op = repositorio.findById(id);
		return op.get();
	}

}
