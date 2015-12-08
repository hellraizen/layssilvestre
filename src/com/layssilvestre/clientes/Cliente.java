package com.layssilvestre.clientes;

public class Cliente {
	// dados pessoais
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String sexo;
	private Integer codigo;
	private String email;
	private String telefone;
	private double peso;
	private double altura;
	private String status;

	// endereco
	private String rua;
	private String bairro;
	private String numero;
	private String cidade;
	private String cep;
	private String complemento;


	public Cliente(String nome, String cpf, String dataNascimento, String sexo, String email,
			String telefone, double peso, double altura, String status, String rua, String bairro, String numero,String cidade,
			String cep, String complemento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefone;
		this.peso = peso;
		this.altura = altura;
		this.status = status;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade= cidade;
		this.cep = cep;
		this.complemento = complemento;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getAltura() {
		return altura;
	}


	public void setAltura(double altura) {
		this.altura = altura;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo
				+ ", codigo=" + codigo + ", email=" + email + ", telefone=" + telefone + ", peso=" + peso + ", altura="
				+ altura + ", status=" + status + ", rua=" + rua + ", bairro=" + bairro + ", numero=" + numero
				+ ", cep=" + cep + ", complemento=" + complemento + "]";
	}

}
