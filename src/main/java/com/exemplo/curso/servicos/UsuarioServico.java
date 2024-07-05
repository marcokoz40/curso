package com.exemplo.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.curso.entidades.Usuario;
import com.exemplo.curso.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;

	public List<Usuario> findAll() {
		return repositorio.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> op = repositorio.findById(id);
		return op.get();
	}

}
