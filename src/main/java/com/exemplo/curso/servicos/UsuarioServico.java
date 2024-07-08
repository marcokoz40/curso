package com.exemplo.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.exemplo.curso.entidades.Usuario;
import com.exemplo.curso.repositorios.UsuarioRepositorio;
import com.exemplo.curso.servicos.excecoes.DataBaseException;
import com.exemplo.curso.servicos.excecoes.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;

	public List<Usuario> findAll() {
		return repositorio.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> op = repositorio.findById(id);
		return op.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Usuario insert(Usuario obj) {
		return repositorio.save(obj);
	}

	public void delete(Long id) {
		try {
		repositorio.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Usuario update(Long id, Usuario obj) {
		try {
		Usuario entidade = repositorio.getReferenceById(id);
		updateData(entidade, obj);
		return repositorio.save(entidade);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setFone(obj.getFone());

	}

}
