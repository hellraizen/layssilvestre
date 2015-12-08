package com.layssilvestre.clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.ConectaBd;

public class RepositorioClienteJdbc implements IRepositorioCliente {

	Connection conn;

	public RepositorioClienteJdbc() throws ClassNotFoundException {
		this.conn = ConectaBd.conectabd();
	}

	@Override
	public void cadastrar(Cliente cliente) throws SQLException {
		
		// Criando a String SQL
		String sql = "insert into cliente(nome,cpf,dataNascimento,sexo,email,telefone,peso,altura,status,rua,bairro,numero,cidade,cep,complemento)values ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		// Atualizando o primeiro parametro
		preStatement.setString(1, cliente.getNome());
		preStatement.setString(2, cliente.getCpf());
		preStatement.setString(3, cliente.getDataNascimento());
		preStatement.setString(4, cliente.getSexo());
		preStatement.setString(5, cliente.getEmail());
		preStatement.setString(6, cliente.getTelefone());
		preStatement.setDouble(7, cliente.getPeso());
		preStatement.setDouble(8,cliente.getAltura());
		preStatement.setString(9, cliente.getStatus());
		preStatement.setString(10,cliente.getRua());
		preStatement.setString(11,cliente.getBairro());
		preStatement.setString(12,cliente.getNumero());
		preStatement.setString(13, cliente.getCidade());
		preStatement.setString(14,cliente.getCep());
		preStatement.setString(15,cliente.getComplemento());

		preStatement.execute();
		
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}

	@Override
	public void atualizar(Cliente cliente) throws SQLException {

		// Criando a String SQL
		String sql = "update cliente set  nome =?,cpf=? ,dataNascimento=?,sexo=?,email=?,telefone=?,peso=?,altura=?,status=?,rua=?,bairro=?,numero=?,cidade=?,cep=?,complemento=? where cpf = ?";
		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement;
		
		
		preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, cliente.getNome());
		preStatement.setString(2, cliente.getCpf());
		preStatement.setString(3, cliente.getDataNascimento());
		preStatement.setString(4, cliente.getSexo());
		preStatement.setString(5, cliente.getEmail());
		preStatement.setString(6, cliente.getTelefone());
		preStatement.setDouble(7, cliente.getPeso());
		preStatement.setDouble(8,cliente.getAltura());
		preStatement.setString(9, cliente.getStatus());
		preStatement.setString(10,cliente.getRua());
		preStatement.setString(11,cliente.getBairro());
		preStatement.setString(12,cliente.getNumero());
		preStatement.setString(13, cliente.getCidade());
		preStatement.setString(14,cliente.getCep());
		preStatement.setString(15,cliente.getComplemento());
		preStatement.setString(16, cliente.getCpf());

		// Executando o select
		preStatement.executeUpdate();
		
		System.out.println("Atualizado Com Sucesso");
		JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso");
	}

	@Override
	public void remover(String cpf) throws SQLException {

		// Criando a String SQL
		String sql = "delete from cliente where CPF = ?";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, cpf);

		// Executando o select
		preStatement.executeUpdate();
		
		
		JOptionPane.showMessageDialog(null, "REMOVIDO COM SUCESSO");
		
	}

	@Override
	public Cliente procurar(String cpf) throws SQLException {

		String sql = "select * from cliente where cpf= ?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, cpf);
		ResultSet resultSet = preStatement.executeQuery();
		while (resultSet.next()) {
		int codigo = resultSet.getInt(1);
		String nome = resultSet.getString(2);
		String cpf1 = resultSet.getString(3);
		String dataN = resultSet.getString(4);
		String sexo = resultSet.getString(5);
		String email = resultSet.getString(6);
		String telefone = resultSet.getString(7);
		double altura = resultSet.getDouble(8);
		double peso = resultSet.getDouble(9);
		String status =resultSet.getString(10);

		// Entrada de Endereço
		String rua = resultSet.getString(11);
		String bairro = resultSet.getString(12);
		String cep =resultSet.getString(13);
		String numero =resultSet.getString(14);
		String cidade =resultSet.getString(15);
		String complemento = resultSet.getString(16);

		Cliente cliente = new Cliente(nome, cpf, dataN, sexo, email, telefone, peso, altura, status, rua, bairro,
				numero,cidade, cep, complemento);
		cliente.setCodigo(codigo);
		
		return cliente;
		
		}
		
		return null;
		
	}

	@Override
	public boolean existe(String cpf) throws SQLException {
		
		String sql = "select * from cliente where cpf= ?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, cpf);
		ResultSet resultSet = preStatement.executeQuery();
		return true;
	}

	@Override
	public ArrayList<Cliente> listar() throws SQLException {

		ArrayList<Cliente> arrayListCliente = new ArrayList<Cliente>();

		// Criando a String SQL
		String sql = "select * from cliente";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conn.prepareStatement(sql);

		ResultSet resultSet = preStatement.executeQuery();

		// Verifica se retornou dados na consulta
		while (resultSet.next()) {
			// Pegando as colunas do registro
			int codigo = resultSet.getInt(1);
			String nome = resultSet.getString(2);
			String cpf1 = resultSet.getString(3);
			String dataN = resultSet.getString(4);
			String sexo = resultSet.getString(5);
			String email = resultSet.getString(6);
			String telefone = resultSet.getString(7);
			double altura = resultSet.getDouble(8);
			double peso = resultSet.getDouble(9);
			String status =resultSet.getString(10);

			// Entrada de Endereço
			String rua = resultSet.getString(11);
			String bairro = resultSet.getString(12);
			String cep =resultSet.getString(13);
			String numero =resultSet.getString(14);
			String cidade =resultSet.getString(15);
			String complemento = resultSet.getString(16);

			Cliente cliente = new Cliente(nome, cpf1, dataN, sexo, email, telefone, peso, altura, status, rua, bairro,
					numero,cidade, cep, complemento);
			cliente.setCodigo(codigo);
			
		
			arrayListCliente.add(cliente);
		}

		return arrayListCliente;
	}

}
