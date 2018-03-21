package br.com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import br.com.entidades.Campanha;
import br.com.entidades.Cliente;

public class ClienteDAO {
	
	private static  List<Cliente> clientes = new ArrayList<Cliente>();
	private static AtomicLong id = new AtomicLong(1);
	
	List<Campanha> campanhas = new CampanhaDAO().campanhasDisponiveis();
	

	public List<Cliente> listar(){
	return clientes;	
	}
	
	public String adicionar(Cliente clienteNovo){
	for (Cliente cliente : clientes) {
		if(clienteNovo.getEmail()!= null){
		if(cliente.getEmail().equals(clienteNovo.getEmail())){
			if(campanhas.isEmpty()){
				return "email ja cadastrado.";
			}
			else{
			return "email ja cadastrado." + "\n" +"Campanhas disponiveis" + campanhas.toString();
		}}
	}}
	clienteNovo.setId(id.getAndIncrement());
	clientes.add(clienteNovo);		
	return"cliente Cadastrado";	
	}
	public void excluir(long id) {
		Cliente cli = null ;
		for (Cliente cliente : clientes) {
			if(cliente.getId() == id)
				cli=cliente;
		}	
		clientes.remove(cli);
	}
	public void alterar(Cliente cliente) {
		Cliente alterar = null;
				for (Cliente cli : clientes) {
					if(cli.getId() == cliente.getId()){
						alterar = cli;
				}					
				}
				clientes.remove(alterar);
				clientes.add(cliente);
			}
}

