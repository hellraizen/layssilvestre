package com.layssilvestre.clienteException;

public class ClienteCpfInvalidoException extends Exception {
	public ClienteCpfInvalidoException(){
		super("Cliente com CPF invalido");
	}
	
}
