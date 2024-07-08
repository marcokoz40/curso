package com.exemplo.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.curso.entidades.Produto;
import com.exemplo.curso.servicos.ProdutoServico;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRecurso {

	@Autowired
	private ProdutoServico servico;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
