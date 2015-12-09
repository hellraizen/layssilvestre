package com.layssilvestre.funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.ConectaBd;

public class RepositorioFuncionarioBd implements IRepositorioFuncionario {

	Connection conn;
	
	public RepositorioFuncionarioBd() throws ClassNotFoundException {
		this.conn = ConectaBd.conectabd();
	}
	
	@Override
	public void cadastrar(Funcionario funcionario) throws SQLException {
		// Criando a String SQL
		String sql = "insert into funcionario (nome, cpf,dataNascimento, sexo, telefone, email, cargo, login, senha) values (?,?,?,?,?,?,?,?,?)";
		
		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conn.prepareStatement(sql);
		
		// Atualizando o primeiro parametro
		
		preStatement.setString(1, funcionario.getNome());
		preStatement.setString(2, funcionario.getCpf());
		preStatement.setString(3, funcionario.getDataNascimento());
		preStatement.setString(4, funcionario.getSexo());
		preStatement.setString(5, funcionario.getTelefone());
		preStatement.setString(6, funcionario.getEmail());
		preStatement.setString(7, funcionario.getCargo());
		preStatement.setString(8, funcionario.getLogin());
		preStatement.setString(9, funcionario.getSenha());
		
		preStatement.execute();
		
	
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		
	}

	
	
	@Override
	public void atualizar(Funcionario funcionario) throws SQLException {
		// Criando a String SQL
		String sql = "update funcionario set id = ?, nome = ?, cpf = ?, dataNascimento = ?, sexo = ?, telefone = ?, email = ?, cargo = ?, login = ?, senha = ? where cpf=?" ;
		
		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement;
		
		preStatement = conn.prepareStatement(sql);
		
		preStatement.setInt(1, funcionario.getId());
		preStatement.setString(2, funcionario.getNome());
		preStatement.setString(3, funcionario.getCpf());
		preStatement.setString(4, funcionario.getDataNascimento());
		preStatement.setString(5, funcionario.getSexo());
		preStatement.setString(6, funcionario.getTelefone());
		preStatement.setString(7, funcionario.getEmail());
		preStatement.setString(8, funcionario.getCargo());
		preStatement.setString(9, funcionario.getLogin());
		preStatement.setString(10, funcionario.getSenha());
		preStatement.setString(11, funcionario.getCpf());
	
		// Executando a atualização para os valores setados
		preStatement.executeUpdate();
		
		System.out.println("Atualizado com sucesso!");
		JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso");
		
	}

	
	
	
	@Override
	public void remover(String cpf) throws SQLException {
		//Criando String SQL
		String sql = "delete from funcionario where cpf = ?";
		
		//Criando PreparedStatement
		PreparedStatement preStatement = conn.prepareStatement(sql);
		
		preStatement.setString(1, cpf);
		
		//Executando select
		preStatement.executeUpdate();
		
		System.out.println("REMOVIDO COM SUCESSO");
		JOptionPane.showMessageDialog(null, "REMOVIDO COM SUCESSO");
	}

	
	
	
	@Override
	public Funcionario procurar(String cpf) throws SQLException {
		String sql = "select * from funcionario where cpf = ?";
		
		PreparedStatement preStatement = conn.prepareStatement(sql);
		
		preStatement.setString(1, cpf);
		
		ResultSet resultSet = preStatement.executeQuery();
		
		while(resultSet.next()){
			Integer idFuncionario = resultSet.getInt(1);
			String nomeFuncionario = resultSet.getString(2);
			String cpfFuncionario = resultSet.getString(3);
			String dataNascimentoFuncionario = resultSet.getString(4);
			String sexoFuncionario = resultSet.getString(5);
			String telefoneFuncionario = resultSet.getString(6);
			String emailFuncionario = resultSet.getString(7);
			String tipoFuncionario = resultSet.getString(8);
			String login = resultSet.getString(9);
			String senha = resultSet.getString(10);
			
			Funcionario funcionario = new Funcionario(idFuncionario, nomeFuncionario, cpfFuncionario, dataNascimentoFuncionario, sexoFuncionario, telefoneFuncionario, emailFuncionario, tipoFuncionario, login, senha);
			return funcionario;
		}	
		
		return null;
	}

	
	
	
	@Override
	public boolean existir(String cpf) throws SQLException {
		
		String sql = "select * from funcionario where cpf = ?";
		
		PreparedStatement preStatement = conn.prepareStatement(sql);
		
		preStatement.setString(1,cpf);
		
		ResultSet resultSet = preStatement.executeQuery();
		
		if(resultSet.equals(cpf)){
			JOptionPane.showMessageDialog(null, "Funcionário Existe!");
			return true;
		}
		
		return false;
	}

	
	
	
	@Override
	public ArrayList<Funcionario> listar() throws SQLException {
		ArrayList<Funcionario> arrayFuncionario = new ArrayList<Funcionario>();
		
		String sql = "select * from funcionario";
		PreparedStatement preStatement = conn.prepareStatement(sql);
		
		ResultSet resultSet = preStatement.executeQuery();
		
		while(resultSet.next())
		{
			Integer idFuncionario = resultSet.getInt(1);
			String nomeFuncionario = resultSet.getString(2);
			String cpfFuncionario = resultSet.getString(3);
			String dataNascimentoFuncionario = resultSet.getString(4);
			String sexoFuncionario = resultSet.getString(5);
			String telefoneFuncionario = resultSet.getString(6);
			String emailFuncionario = resultSet.getString(7);
			String tipoFuncionario = resultSet.getString(8);
			String login = resultSet.getString(9);
			String senha = resultSet.getString(10);
			
			Funcionario funcionario = new Funcionario(idFuncionario, nomeFuncionario, cpfFuncionario, dataNascimentoFuncionario, sexoFuncionario, telefoneFuncionario, emailFuncionario, tipoFuncionario, login, senha);
			arrayFuncionario.add(funcionario);
		}
		
		return arrayFuncionario;
	}

}
