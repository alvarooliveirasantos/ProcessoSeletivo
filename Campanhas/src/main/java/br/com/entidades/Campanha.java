package br.com.entidades;

import java.util.Date;

public class Campanha {
	private String nome;
	private long idTimeCoracao;
	private long id;
	private Date dataInicio;
	private Date dataFim;
	
	private String dataInicioEntrada;	
	
	private String dataTerminoEntrada;
	private long idCliente;
	
	
	
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public long getIdTimeCoracao() {
		return idTimeCoracao;
	}
	public void setIdTimeCoracao(long idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public String getDataInicioEntrada() {
		return dataInicioEntrada;
	}
	public void setDataInicioEntrada(String dataInicioEntrada) {
		this.dataInicioEntrada = dataInicioEntrada;
	}
	public String getDataTerminoEntrada() {
		return dataTerminoEntrada;
	}
	public void setDataTerminoEntrada(String dataTerminoEntrada) {
		this.dataTerminoEntrada = dataTerminoEntrada;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	@Override
	public String toString() {
		return "Campanha :" + nome + "\nData de inicio: " + dataInicio + "Data Termino" + dataFim;
	}

}
