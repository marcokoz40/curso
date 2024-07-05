package com.exemplo.curso.configuracoes;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.exemplo.curso.entidades.Pedido;
import com.exemplo.curso.entidades.Usuario;
import com.exemplo.curso.entidades.enumeracoes.StatusPedido;
import com.exemplo.curso.repositorios.PedidoRepositorio;
import com.exemplo.curso.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfiguracao implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private PedidoRepositorio pedidoRepositorio;

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "98888-8888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "99999-9999", "123456");
		Usuario u3 = new Usuario(null, "Marco Antonio", "marco@gmail.com", "91911-2345", "456789");

		Pedido p1 = new Pedido(null, LocalDateTime.parse("2024-07-02T10:15:00"), StatusPedido.PAGO, u1);
		Pedido p2 = new Pedido(null, LocalDateTime.parse("2024-07-02T20:45:00"), StatusPedido.ENVIADO, u2);
		Pedido p3 = new Pedido(null, LocalDateTime.parse("2024-07-03T15:30:20"), StatusPedido.ENTREGUE, u3);
		Pedido p4 = new Pedido(null, LocalDateTime.parse("2024-07-04T06:00:00"), StatusPedido.AGUARDANDOPAGAMENTO, u2);

		usuarioRepositorio.saveAll(Arrays.asList(u1, u2, u3));
		pedidoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4));
	}

}
