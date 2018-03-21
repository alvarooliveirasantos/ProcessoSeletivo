package br.com.testes;

import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import br.com.dao.CampanhaDAO;
import br.com.dao.ClienteDAO;
import br.com.dao.TimeDAO;
import br.com.entidades.Campanha;
import br.com.entidades.Cliente;
import br.com.entidades.Time;
import br.com.servidor.Servidor;


public class CampanhaTest {

	static String url = "http://localhost:8080";

	private HttpServer server;

	@Before
	public void iniciarServer() {
		server = Servidor.iniciarServidor();
	}

	@After
	public void pararServer() {
		server.stop();
	}

	@Test
	public void consultarTime() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url);
		String conteudo = target.path("/times").request().get(String.class);
		List<Object> times = new Gson().fromJson(conteudo, List.class);
		Assert.assertTrue(times.isEmpty());
	}

	@Test
	public void consultarCampanha() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url);
		String conteudo = target.path("/campanhas").request().get(String.class);
		List<Object> campanha = new Gson().fromJson(conteudo, List.class);
		Assert.assertTrue(campanha.isEmpty());
	}

	@Test
	public void consultarCliente() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url);
		String conteudo = target.path("/clientes").request().get(String.class);
		List<Object> cliente = new Gson().fromJson(conteudo, List.class);
		Assert.assertTrue(cliente.isEmpty());
	}

	@Test
	public void testeDeletarTime() {
		Client client = ClientBuilder.newClient();
		Time time = new Time();
		time.setNome("santos");
		new TimeDAO().adicionar(time);
		WebTarget target = client.target(url);
		Response conteudo = (Response) target.path("/times/1").request().delete();
		Assert.assertEquals(conteudo.getStatus(), 200);
	}

	@Test
	public void TestDeletarCliente() {
		Client client = ClientBuilder.newClient();
		Cliente cli = new Cliente();
		cli.setNome("Alvaro");
		new ClienteDAO().adicionar(cli);
		WebTarget target = client.target(url);
		Response conteudo = (Response) target.path("/clientes/1").request().delete();
		Assert.assertEquals(conteudo.getStatus(), 200);
	}

	@Test
	public void testeDeletarCampanha() {
		Campanha campanha = new Campanha();
		campanha.setDataInicio(new Date());
		campanha.setDataFim(new Date());
		campanha.setNome("Teste");
		Client client = ClientBuilder.newClient();
		new CampanhaDAO().adicionar(campanha);
		WebTarget target = client.target(url);
		Response conteudo = (Response) target.path("/campanhas/2").request().delete();
		Assert.assertEquals(conteudo.getStatus(), 200);
	}
}

