package br.com.resources;
import java.net.URI;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import com.google.gson.Gson;

import br.com.dao.ClienteDAO;
import br.com.entidades.Cliente;
@Path("clientes")
public class ClienteResources {
	
	private static final Logger log = Logger.getLogger(ClienteResources.class);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listar() {
		try{
		List<Cliente> listar = new ClienteDAO().listar();
		return new Gson().toJson(listar);
		}
		catch(Exception ex){
			log.error("Erro ao listar registros" + ex);
			return Response.serverError().build().toString();
		}
		}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String adicionar(String conteudo){
		try{
		Gson gson = new Gson();
		Cliente cliente =	(Cliente) gson.fromJson(conteudo, Cliente.class);
		String resul = new ClienteDAO().adicionar(cliente);
		URI uri = URI.create("/clientes/" + cliente.getId());
		return gson.toJson(resul);
	}
		catch(Exception ex){
			log.error("Erro ao adicionar registro" + ex);
			return Response.serverError().build().toString();
		}
	}
	@Path("{id}")
	@DELETE
	public Response removerCliente(@PathParam("id")long id){
	try{
	new ClienteDAO().excluir(id);
	return Response.ok().build();
	}
	catch(Exception ex){
		log.error("Erro ao excluir registro" + ex);
		return Response.serverError().build();
	}
	}

	@Path("{id}")
	@PUT
	public Response alterar(String conteudo,@PathParam("id") long id){
	try{
	Cliente cliente = new Gson().fromJson(conteudo,Cliente.class);
	new ClienteDAO().alterar(cliente);
	return Response.ok().build();
	}
	catch(Exception ex){
		log.error("Falha ao alterar registro" + ex);
		return Response.serverError().build();
	
	}
	}
}
	



