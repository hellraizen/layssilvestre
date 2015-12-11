package com.layssilvestre.mensalidade;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioMensalidade {
	public String pesquisarAtividade(String atividade) throws SQLException;
	
	public void gerarMensalide(Mensalidade mensalidade);
	public ArrayList<Mensalidade> listarMensalidade();
	public void salvarMensalidade(ArrayList<Mensalidade> array) throws SQLException;
	public void limpararray();
	public ArrayList<Mensalidade> listarBd() throws SQLException;
	public void deletarMensalidade(int codigo) throws SQLException;
	public void pagamento(int codigo)throws SQLException, IOException;
	public ArrayList<Mensalidade> pesquisarAluno(String nome) throws SQLException;


}
