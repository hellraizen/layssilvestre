package com.layssilvestre.caixa;



public class Caixa {
	private Double entrada;
	private Double saida;
	private Integer id;
	private Integer idFuncionario;
	private String mes;
	private String data;
	private String descricao;

	public Caixa(Double entrada, Double saida, Integer id, Integer idFuncionario,String mes, String data,String descricao) {

		this.entrada = entrada;
		this.saida = saida;
		this.id = id;
		this.idFuncionario = idFuncionario;
		this.mes=mes;
		this.data = data;
		this.descricao= descricao;
	}

	public Caixa(Double entrada, Double saida, Integer idFuncionario,String mes, String data,String descricao) {

		this.entrada = entrada;
		this.saida = saida;
		this.idFuncionario = idFuncionario;
		this.mes=mes;
		this.data = data;
		this.descricao=descricao;
	}

	public Double getEntrada() {
		return entrada;
	}

	public void setEntrada(Double entrada) {
		this.entrada = entrada;
	}

	public Double getSaida() {
		return saida;
	}

	public void setSaida(Double saida) {
		this.saida = saida;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
