package com.layssilvestre.clientes;


import java.sql.SQLException;
import java.util.ArrayList;

import com.layssilvestre.clienteException.ClienteCpfInvalidoException;
import com.layssilvestre.clienteException.ClienteJaCadastradoException;
import com.layssilvestre.clienteException.ClienteNaoEncontradoException;
import com.layssilvestre.util.ValidarCPF;


public class ControladorCliente {
	private IRepositorioCliente repositorioCliente;
	
	public ControladorCliente() throws ClassNotFoundException{

		repositorioCliente= new RepositorioClienteJdbc();
		
	}

	public void cadastrar(Cliente cliente) throws SQLException, ClienteJaCadastradoException, ClienteCpfInvalidoException {
			repositorioCliente.cadastrar(cliente);
		
		
	}

	public void atualizar(Cliente cliente) throws SQLException, ClienteNaoEncontradoException {
		repositorioCliente.atualizar(cliente);

	}

	public void remover(String cpf) throws SQLException, ClienteNaoEncontradoException {
		repositorioCliente.remover(cpf);

	}

	public Cliente procurar(String cpf) throws SQLException, ClienteNaoEncontradoException {
  
		return repositorioCliente.procurar(cpf);
	}

	public boolean existe(String cpf) throws SQLException{
		
		return repositorioCliente.existe(cpf);
	}

	public ArrayList<Cliente> listar() throws SQLException {
		
		return repositorioCliente.listar();
	}
	public Cliente procurarNomeCliente(String nome1) throws SQLException {
		return repositorioCliente.procurarNomeCliente(nome1);
	}
	

}
