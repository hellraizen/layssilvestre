package com.layssilvestre.mensalidade;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControleMensalidade {

	IRepositorioMensalidade repositorioMensalidade;
	
	public ControleMensalidade() throws ClassNotFoundException, IOException {
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
	public ArrayList<Mensalidade> listarBd() throws SQLException{
		return repositorioMensalidade.listarBd();
	}
	public void deletarMensalidade(int codigo) throws SQLException{
		repositorioMensalidade.deletarMensalidade(codigo);
	}
	public void pagamento(int codigo)throws SQLException, IOException{
		repositorioMensalidade.pagamento(codigo);
	}
	public ArrayList<Mensalidade> pesquisarAluno(String nome) throws SQLException{
		return repositorioMensalidade.pesquisarAluno(nome);
	}
}
