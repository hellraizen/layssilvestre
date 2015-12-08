package com.layssilvestre.clientes;

import java.sql.SQLException;
import java.util.ArrayList;

import com.layssilvestre.clienteException.ClienteJaCadastradoException;
import com.layssilvestre.clienteException.ClienteNaoEncontradoException;

public interface IRepositorioCliente {

	public void cadastrar(Cliente cliente) throws SQLException, ClienteJaCadastradoException;

	public void atualizar(Cliente cliente) throws SQLException, ClienteNaoEncontradoException;

	public void remover(String cpf) throws SQLException, ClienteNaoEncontradoException;

	public Cliente procurar(String cpf) throws SQLException, ClienteNaoEncontradoException;

	public boolean existe(String cpf) throws SQLException;

	public ArrayList<Cliente> listar() throws SQLException;

}
