package br.com.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import br.com.entidades.Campanha;

public class CampanhaDAO {
	private static int contador = 1;
	private static List<Campanha> banco = new ArrayList<Campanha>();
	private static List<Campanha> campanhasDisponiveis = new ArrayList<Campanha>();
	List<Campanha> relacaoCampanhaCliente = new ArrayList<Campanha>();
	private static AtomicLong id = new AtomicLong(1);
	
	
	
	public String adicionar(Campanha novaCampanha) {
		List<Campanha> alterarDatas = new ArrayList<Campanha>();
		for (Campanha campanha : banco) {
			if(campanha.getDataFim().equals(novaCampanha.getDataFim())){
				alterarDatas.add(campanha);
								
			}
			if(campanha.getNome().equals(novaCampanha.getNome())){
				return("Campanha ja cadastrada");
			}
			}
		novaCampanha.setId(id.incrementAndGet());
		novaCampanha.setDataInicioEntrada(null);
		novaCampanha.setDataTerminoEntrada(null);
		banco.add(novaCampanha);
		atualizarDatas(alterarDatas);
		return "Camapnha cadastrada";
	}
	public void atualizarDatas(List<Campanha> campanhas){
		for (Campanha campanha2 : campanhas) {
		Date novaData = campanha2.getDataFim();
		novaData.setDate(novaData.getDate()+contador);				
		campanha2.setDataFim(novaData);
		contador++;
		}
		
	}
	public List<Campanha> listarTodos(){
		List<Campanha> campanhasAtivas = new ArrayList<Campanha>();
		Date atual = new Date();
		//if(banco.isEmpty()){
		//	popular();
		//}
		for (Campanha campanha : banco) {
			if(!campanha.getDataFim().before(atual))
			campanhasAtivas.add(campanha);
		}
		return campanhasAtivas;
	}
	public List<Campanha> listarRelacao(){
		for (Campanha campanha : banco) {
			if(campanha.getIdCliente() > 0)
			relacaoCampanhaCliente.add(campanha);
		}
		return relacaoCampanhaCliente;		
	}
	
	@Override
	public String toString() {
		return "CampanhaDAO [listarTodos()=" + listarTodos() + "]";
	}

	public void alterar(Campanha alterarCampanha) {
		Campanha alterar = null;
		for (Campanha campanha : banco) {
			if(campanha.getId() == alterarCampanha.getId()){
				alterar=campanha;		
			}
		}
		banco.remove(alterar);
		banco.add(alterarCampanha);		
	}
	public void excluir(long id) {
		Campanha removerCampanha = null;
		for (Campanha campanha : banco) {
			if(campanha.getId() == id)
			removerCampanha = campanha;
		}
		banco.remove(removerCampanha);
	}
	public List<Campanha> campanhasDisponiveis(){
		campanhasDisponiveis.clear();
		for (Campanha campanha : banco) {
			if(campanha.getIdCliente() == 0){
				campanhasDisponiveis.add(campanha);
		}
		}
		return campanhasDisponiveis;
	}
	
}
