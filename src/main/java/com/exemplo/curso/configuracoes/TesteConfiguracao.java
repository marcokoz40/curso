package com.exemplo.curso.configuracoes;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.exemplo.curso.entidades.Categoria;
import com.exemplo.curso.entidades.ItemPedido;
import com.exemplo.curso.entidades.Pagamento;
import com.exemplo.curso.entidades.Pedido;
import com.exemplo.curso.entidades.Produto;
import com.exemplo.curso.entidades.Usuario;
import com.exemplo.curso.entidades.enumeracoes.StatusPedido;
import com.exemplo.curso.repositorios.CategoriaRepositorio;
import com.exemplo.curso.repositorios.ItemPedidoRepositorio;
import com.exemplo.curso.repositorios.PedidoRepositorio;
import com.exemplo.curso.repositorios.ProdutoRepositorio;
import com.exemplo.curso.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfiguracao implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private PedidoRepositorio pedidoRepositorio;

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	@Autowired
	private ItemPedidoRepositorio itemPedidoRepositorio;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");

		Produto prod1 = new Produto(null, "Atari", "Video-game antigo", 50.00, " ");
		Produto prod2 = new Produto(null, "PC", "Computador de última geração", 1500.00, " ");
		Produto prod3 = new Produto(null, "O Alquimista", "Autor Paulo Coelho", 33.00, " ");
		Produto prod4 = new Produto(null, "Geladeira", "Frost Free", 5000.00, " ");

		categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepositorio.saveAll(Arrays.asList(prod1, prod2, prod3));

		prod1.getConjuntoCategoria().add(cat3);
		prod2.getConjuntoCategoria().add(cat1);
		prod3.getConjuntoCategoria().add(cat2);
		prod4.getConjuntoCategoria().add(cat1);

		produtoRepositorio.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "98888-8888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "99999-9999", "123456");
		Usuario u3 = new Usuario(null, "Marco Antonio", "marco@gmail.com", "91911-2345", "456789");

		Pedido p1 = new Pedido(null, LocalDateTime.parse("2024-07-02T10:15:00"), StatusPedido.PAGO, u1);
		Pedido p2 = new Pedido(null, LocalDateTime.parse("2024-07-02T20:45:00"), StatusPedido.ENVIADO, u2);
		Pedido p3 = new Pedido(null, LocalDateTime.parse("2024-07-03T15:30:20"), StatusPedido.ENTREGUE, u3);
		Pedido p4 = new Pedido(null, LocalDateTime.parse("2024-07-04T06:00:00"), StatusPedido.AGUARDANDOPAGAMENTO, u2);

		usuarioRepositorio.saveAll(Arrays.asList(u1, u2, u3));
		pedidoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4));

		ItemPedido it1 = new ItemPedido(p1, prod4, 2, prod4.getPreco());
		ItemPedido it2 = new ItemPedido(p1, prod3, 4, prod3.getPreco());
		ItemPedido it3 = new ItemPedido(p3, prod2, 3, prod2.getPreco());
		ItemPedido it4 = new ItemPedido(p4, prod1, 1, prod1.getPreco());

		itemPedidoRepositorio.saveAll(Arrays.asList(it1, it2, it3, it4));
		
		Pagamento pag1 = new Pagamento(null, LocalDateTime.parse("2024-07-02T12:15:00"), p1);
		p1.setPagamento(pag1);
		pedidoRepositorio.save(p1);

	}

}
