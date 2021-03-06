package br.com.resources;

import java.net.URI;
import java.util.Date;
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

import br.com.dao.CampanhaDAO;
import br.com.entidades.Campanha;

@Path("campanhas")
public class CampanhaResources {
	
	private static final Logger log = Logger.getLogger(CampanhaResources.class);
	
			
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listarCampanhas(){
	List<Campanha> campanhas = new CampanhaDAO().campanhasDisponiveis();
	return new Gson().toJson(campanhas);	
	}	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response adcionar(String conteudo){
	try{
	Gson gson = new Gson();
	Campanha campanha =	(Campanha) gson.fromJson(conteudo, Campanha.class);
	campanha.setDataInicio(new Date(campanha.getDataInicioEntrada()));
	campanha.setDataFim(new Date(campanha.getDataTerminoEntrada()));
	String resul = new CampanhaDAO().adicionar(campanha);
	URI uri = URI.create("/campanhas/" + campanha.getId());
	if(resul.equals("Campanha ja cadastrada"))
	{
		return Response.serverError().build();
	}
	return Response.created(uri).build();
	}
	catch(Exception ex){
		log.error("Erro ao adicionar novo registro :" + ex.getMessage());
		return Response.serverError().build();

	}
	}
	@Path("{id}")
	@PUT
	public Response alterar(String conteudo,@PathParam("id") long id){
	try{
	Gson gson = new Gson();
	Campanha campanha =	(Campanha) gson.fromJson(conteudo, Campanha.class);
	new CampanhaDAO().alterar(campanha);
	URI uri = URI.create("/campanhas/" + campanha.getId());
	return Response.created(uri).build();
	}
	catch(Exception ex){
		log.error("Erro ao alterar registro :"+ ex);
		return Response.serverError().build();
	}
	}
	
	@Path("{id}")
	@DELETE
	public Response removerCampanha(@PathParam("id")long id){
		try{
		new CampanhaDAO().excluir(id);
		return Response.ok().build();
		}
		catch(Exception ex){
		log.error("Erro ao excluir registro: " + ex);	
		return Response.serverError().build();
		}
	}
	

}
