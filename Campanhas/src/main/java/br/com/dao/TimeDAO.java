package br.com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.core.Response;

import br.com.entidades.Time;

public class TimeDAO{

	static List<Time> times = new ArrayList<Time>();
	private static AtomicLong id = new AtomicLong(1);
	
	
	public Response adicionar(Time time) {
		time.setId(id.getAndIncrement());
		times.add(time);
		return null;
	}

	
	public void alterar(Time novo) {
		Time remover = null;
		for (Time time : times) {
			if(time.equals(novo));
			remover = time;
		}
		times.remove(remover);
		times.add(novo);		
	}

	public void excluir(long id) {
		Time remover = null;
		for (Time time : times) {
			if(time.getId() == id)
				remover = time;				
		}
		times.remove(remover);		
	}

	public List<Time> listar() {
		return times;
	}


	public Time buscar(long id) {
		for (Time time : times) {
		if(time.getId() == id)
		return time;
		}
		return null;
	}
	

}
