package com.layssilvestre.mensalidade;

import java.util.ArrayList;

public interface IRepositorioMensalidade {
	
	public void gerarMensalide(Mensalidade mensalidade);
	public ArrayList<Mensalidade> listarMensalidade();

}
