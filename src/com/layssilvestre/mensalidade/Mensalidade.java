package com.layssilvestre.mensalidade;

public class Mensalidade {

	private int codigo;
	private String nomeAluno;
	private String tipo;
	private int parcela;
	private double valor;
	private String status;
	private String data;

	public Mensalidade(String tipo, int parcela, String status, String nomeAluno,double valor) {
		this.valor=valor;
		this.nomeAluno = nomeAluno;
		this.tipo = tipo;
		this.parcela = parcela;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Mensalidade [codigo=" + codigo + ", nomeAluno=" + nomeAluno + ", tipo=" + tipo + ", quantidade="
			 + ", parcela=" + parcela + ", valor=" + valor + ", status=" + status + ", data=" + data
				+ "]\n";
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getParcela() {
		return parcela;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
