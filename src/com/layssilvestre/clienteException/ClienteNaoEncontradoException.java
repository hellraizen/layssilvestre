package com.layssilvestre.clienteException;

public class ClienteNaoEncontradoException extends Exception{
	
	public ClienteNaoEncontradoException(){
		super("Cliente não encontrado");
	}

}
