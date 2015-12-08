package com.layssilvestre.atendimento;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioAtendimento {
	
	public void inserirAtendimento(Atendimento atendimento) throws SQLException;

	public void alterarAtendimento(Atendimento atendimento) throws SQLException;
	
	public Atendimento procurar(int codigo) throws SQLException;

	public void excluirAtendimento(int codigo) throws SQLException;

	public ArrayList<Atendimento> listaAtendimento() throws SQLException;

}
