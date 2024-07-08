package com.exemplo.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.curso.entidades.Categoria;
import com.exemplo.curso.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico {

	@Autowired
	private CategoriaRepositorio repositorio;

	public List<Categoria> findAll() {
		return repositorio.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> op = repositorio.findById(id);
		return op.get();
	}

}
