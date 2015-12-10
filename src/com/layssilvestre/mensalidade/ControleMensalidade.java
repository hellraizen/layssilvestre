package com.layssilvestre.mensalidade;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControleMensalidade {

	IRepositorioMensalidade repositorioMensalidade;
	
	public ControleMensalidade() throws ClassNotFoundException {
		repositorioMensalidade = new RepositorioMensalidade();
		
	}
	
	public String pesquisarAtividade(String atividade) throws SQLException{
		return repositorioMensalidade.pesquisarAtividade(atividade);
	}
	public void gerarMensalide (Mensalidade mensalidade){
		repositorioMensalidade.gerarMensalide(mensalidade);
	}
	public ArrayList<Mensalidade> listarMensalidade(){
		return repositorioMensalidade.listarMensalidade();
	}
	public void salvarMensalidade(ArrayList<Mensalidade> array) throws SQLException{
		repositorioMensalidade.salvarMensalidade(array);
	}
	public void limpararray(){
		repositorioMensalidade.limpararray();
	}
}
