package com.exemplo.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.curso.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
