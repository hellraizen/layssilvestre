package com.layssilvestre.mensalidade;

import java.util.ArrayList;

public class ControleMensalidade {

	IRepositorioMensalidade repositorioMensalidade;
	
	public ControleMensalidade() {
		repositorioMensalidade = new RepositorioMensalidade();
		
	}
	
	public void gerarMensalide (Mensalidade mensalidade){
		repositorioMensalidade.gerarMensalide(mensalidade);
	}
	public ArrayList<Mensalidade> listarMensalidade(){
		return repositorioMensalidade.listarMensalidade();
	}
}
