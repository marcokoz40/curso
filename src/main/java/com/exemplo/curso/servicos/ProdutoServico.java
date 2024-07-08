package com.exemplo.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.curso.entidades.Produto;
import com.exemplo.curso.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio repositorio;

	public List<Produto> findAll() {
		return repositorio.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> op = repositorio.findById(id);
		return op.get();
	}

}
