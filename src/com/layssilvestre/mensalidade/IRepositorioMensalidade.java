package com.layssilvestre.mensalidade;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioMensalidade {
	public String pesquisarAtividade(String atividade) throws SQLException;
	
	public void gerarMensalide(Mensalidade mensalidade);
	public ArrayList<Mensalidade> listarMensalidade();
	public void salvarMensalidade(ArrayList<Mensalidade> array) throws SQLException;
	public void limpararray();

}
