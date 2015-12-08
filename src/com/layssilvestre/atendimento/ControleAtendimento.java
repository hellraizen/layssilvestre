package com.layssilvestre.atendimento;

import java.sql.SQLException;
import java.util.ArrayList;



public class ControleAtendimento {
		
	IRepositorioAtendimento repositorioAtendimento;
	
	public ControleAtendimento() throws ClassNotFoundException {
		//repositorioAtendimento = new RepositorioAtendimento();
		repositorioAtendimento = new RepositorioAtendimentoJdbc();
	}
	
	public void inserirAtendimento(Atendimento atendimento) throws SQLException {
		repositorioAtendimento.inserirAtendimento(atendimento);
	}

	public void alterarAtendimento(Atendimento atendimento) throws SQLException {
		repositorioAtendimento.alterarAtendimento(atendimento);
	}
	public void excluirAtendimento(int codigo) throws SQLException{
		repositorioAtendimento.excluirAtendimento(codigo);
		
	}
	public Atendimento procurar(int codigo) throws SQLException{
		return repositorioAtendimento.procurar(codigo);
	}
	public ArrayList<Atendimento> listar() throws SQLException{
		
		return repositorioAtendimento.listaAtendimento();
	}

}
