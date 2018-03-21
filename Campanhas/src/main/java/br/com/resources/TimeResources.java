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

import br.com.dao.TimeDAO;
import br.com.entidades.Time;

@Path("times")
public class TimeResources {
		private static final Logger logger = Logger.getLogger(TimeResources.class);
	

		@POST
		@Produces(MediaType.APPLICATION_JSON)
		public Response adicionar(String conteudo){
		try{
		Gson gson = new Gson();
		Time time =	(Time) gson.fromJson(conteudo, Time.class);
		new TimeDAO().adicionar(time);
		URI uri = URI.create("/campanhas/" + time.getId());
		return Response.created(uri).build();		
		}
		catch(Exception ex){
			logger.error("Erro ao adicionar registro" + ex);
			return Response.serverError().build();
		}
		}
		@Path("{id}")
		@PUT
		public Response alterar(String conteudo,@PathParam("id") long id){
		try{
		Time novo = new Gson().fromJson(conteudo,Time.class);
		new TimeDAO().alterar(novo);
		return Response.ok().build();
		}
		catch(Exception ex){
			logger.error("Erro ao alterar registro" + ex);
			return Response.serverError().build();
		}
		}
		@Path("{id}")
		@DELETE
		public Response removerTime(@PathParam("id")long id){
		try{
		new TimeDAO().excluir(id);
		return Response.ok().build();
		}
		catch(Exception ex){
			logger.error("Erro ao fazer remoção" + ex);
			return Response.serverError().build();
		}
		}

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public String listar() {
		try{
			List<Time> listar = new TimeDAO().listar();
			return new Gson().toJson(listar);
	
		}
		catch(Exception ex){
			logger.error("Erro ao retornar registros" + ex);
			return Response.serverError().build().toString();
		}

	}
}