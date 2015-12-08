package com.layssilvestre.atendimento;

import java.util.ArrayList;



public class RepositorioAtendimento implements IRepositorioAtendimento {

	private int index;
	ArrayList<Atendimento> arrayAtendimento;


	public RepositorioAtendimento() {
		arrayAtendimento = new ArrayList<>();
		index=1;
	}

	public void inserirAtendimento(Atendimento atendimento) {
		atendimento.setCodigo(index++);
		arrayAtendimento.add(atendimento);
		System.out.println("cadastrado");

	}

	public void alterarAtendimento(Atendimento atendimento) {
		for (Atendimento atendimentos : arrayAtendimento) {
			if(atendimentos.getCodigo()== atendimento.getCodigo()){
				arrayAtendimento.remove(atendimentos.getCodigo());
				arrayAtendimento.add(atendimento);
				System.out.println("Alterado");
			}
		}
		
	}
	public Atendimento procurar(int codigo){
		for (Atendimento atendimentos : arrayAtendimento) {
			if(atendimentos.getCodigo()== codigo){
				System.out.println("Encontrado");
				return atendimentos;
				
			}
		}
		
		
		
		return null;
	}
	public void excluirAtendimento(int codigo){
		
		for (Atendimento atendimentos : arrayAtendimento) {
			if(atendimentos.getCodigo()== codigo){
				arrayAtendimento.remove(atendimentos.getCodigo());
				System.out.println("excluido");
			}
		}
		
	}

	public ArrayList<Atendimento> listaAtendimento(){
		
		return arrayAtendimento;
	}
}

