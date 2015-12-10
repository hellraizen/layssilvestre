package com.layssilvestre.caixa;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public interface IRepositorioCaixa {
	
	public ArrayList<Caixa> pesquisaBet (String inicio) throws SQLException;

	public void entradaCaixa(Caixa entradaCaixa) throws SQLException, IOException;

	public void saidaCaixa(Caixa saidaCaixa) throws SQLException, IOException;

	public ArrayList<Caixa> movimentoDiario() throws SQLException, IOException;

}
