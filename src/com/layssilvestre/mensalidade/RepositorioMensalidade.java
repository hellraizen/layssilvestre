package com.layssilvestre.mensalidade;

import java.util.ArrayList;
import java.util.Calendar;
import com.layssilvestre.util.TrataDataBr;;

public class RepositorioMensalidade implements IRepositorioMensalidade{

	private ArrayList<Mensalidade> arrayMensalidade;
	private int index;


	public RepositorioMensalidade() {
		arrayMensalidade = new ArrayList<>();
		index = 1;
	}
	
	
	public void gerarMensalide (Mensalidade mensalidade){
		int parcela = mensalidade.getParcela();
	
		for (int i = 0; i < parcela; i++) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH,i );
			
			String dataCorrente = TrataDataBr.trataData(c.getTime());
			
			Mensalidade m1 = new Mensalidade(mensalidade.getTipo(),mensalidade.getQuantidade(),i+1,mensalidade.getStatus(),mensalidade.getNomeAluno(),mensalidade.getValor());
			m1.setCodigo(index++);
			m1.setData(dataCorrente);
			
			arrayMensalidade.add(m1);
			
		}	
	}
	
	public ArrayList<Mensalidade> listarMensalidade(){
		
		
		return arrayMensalidade;
	}
}
