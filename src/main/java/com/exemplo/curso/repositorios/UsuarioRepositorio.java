package com.exemplo.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.curso.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
