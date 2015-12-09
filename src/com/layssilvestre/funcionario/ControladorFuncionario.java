package com.layssilvestre.funcionario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.layssilvestre.clienteException.ClienteCpfInvalidoException;
import com.layssilvestre.util.ValidarCPF;

public class ControladorFuncionario {

	private IRepositorioFuncionario repositorioFuncionario;
	
	public ControladorFuncionario() throws ClassNotFoundException 
	{
		repositorioFuncionario = new RepositorioFuncionarioBd();
		
		
	}

	public void cadastrar(Funcionario funcionario) throws SQLException, IOException, ClienteCpfInvalidoException {
		if (!ValidarCPF.validaCPF(funcionario.getCpf())) {
			throw new ClienteCpfInvalidoException();
		} else {
		repositorioFuncionario.cadastrar(funcionario);
		}
	}

	
	public void atualizar(Funcionario funcionario) throws SQLException, IOException
	{
		repositorioFuncionario.atualizar(funcionario);
	}

	
	public void remover(String cpf) throws SQLException, IOException 
	{
		repositorioFuncionario.remover(cpf);
	}

	
	public Funcionario procurar(String cpf) throws SQLException, IOException 
	{
		return repositorioFuncionario.procurar(cpf);
	}

	
	public boolean existir(String cpf) throws SQLException, IOException 
	{
		return repositorioFuncionario.existir(cpf);
	}

	
	public ArrayList<Funcionario> listar() throws SQLException, IOException 
	{
		return repositorioFuncionario.listar();
	}

}
