package br.com.servidor;

import java.io.IOException;
import java.net.URI;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class Servidor {
	
	private static final Logger log = Logger.getLogger(Servidor.class);
	

	
	public static void main(String[] args) throws IOException{
		BasicConfigurator.configure();
		try{
		HttpServer server = iniciarServidor();
		System.out.println("Servidor iniciado");
		System.in.read();
		server.stop();
		}
		catch(IOException ex){
			log.error("Erro ao iniciar servidor :" + ex);		
		}
	}
	 public static HttpServer iniciarServidor() {
		ResourceConfig config = new ResourceConfig().packages("br.com.resources");
		URI uri = URI.create("http://localhost:8080/");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri,config);
		return server;
	}

}
