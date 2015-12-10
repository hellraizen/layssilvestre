package com.layssilvestre.caixa;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;


public class ControladorCaixa {

	private IRepositorioCaixa repositorioCaixa;

	public ControladorCaixa() throws IOException, ClassNotFoundException {
	
		repositorioCaixa = new RepositorioCaixaJdbc();
	}
	
	public ArrayList<Caixa> pesquisaBet (String inicio) throws SQLException{
		return repositorioCaixa.pesquisaBet(inicio);
	}
	

	public void entradaCaixa(Caixa entradaCaixa) throws SQLException, IOException {
		repositorioCaixa.entradaCaixa(entradaCaixa);
	}

	public void saidaCaixa(Caixa saidaCaixa) throws SQLException, IOException  {
		repositorioCaixa.saidaCaixa(saidaCaixa);
	}

	public ArrayList<Caixa> movimentoDiario() throws SQLException, IOException {
		return repositorioCaixa.movimentoDiario();
	}
	
}
