package com.layssilvestre.caixa;

import java.util.Date;

public class Caixa {
	private Double entrada;
	private Double saida;
	private Integer id;
	private Double totalCaixa;
	private Integer idFuncionario;
	private Date data;

	public Caixa(Double entrada, Integer id, Integer idFuncionario) {
		setEntrada(entrada);
		setIdComanda(id);
		setIdFuncionario(idFuncionario);

	}

	public Caixa(Double entrada, Integer id, Integer idFuncionario, Date data) {
		setEntrada(entrada);
		setIdComanda(id);
		setIdFuncionario(idFuncionario);
		setData(data);

	}

	public Caixa(Double entrada, Integer idFuncionario, Date data) {
		setEntrada(entrada);
		setIdFuncionario(idFuncionario);
		setData(data);

	}

	public Double getEntrada() {
		return entrada;
	}

	public void setEntrada(double entrada) {
		this.entrada = entrada;
	}

	public Double getSaida() {
		return saida;
	}

	public void setSaida(Double saida) {
		this.saida = saida;
	}

	public Integer getIdComanda() {
		return id;
	}

	public void setIdComanda(Integer idComanda) {
		this.id = idComanda;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Double getTotalCaixa() {
		return totalCaixa;
	}

	public void setTotalCaixa(Double totalPago) {
		this.totalCaixa = totalPago;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Caixa [entrada=" + entrada + ", saida=" + saida + ", id=" + id + ", totalCaixa=" + totalCaixa
				+ ", idFuncionario=" + idFuncionario + ", data=" + data + "]";
	}

}
