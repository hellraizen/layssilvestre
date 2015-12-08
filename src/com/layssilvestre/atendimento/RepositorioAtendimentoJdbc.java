package com.layssilvestre.atendimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import DAL.ConectaBd;

public class RepositorioAtendimentoJdbc implements IRepositorioAtendimento {

	private int index;
	private Connection conn;

	public RepositorioAtendimentoJdbc() throws ClassNotFoundException {
		index = 1;
		this.conn = ConectaBd.conectabd();
	}

	@Override
	public void inserirAtendimento(Atendimento atendimento) throws SQLException {
		String sql = "insert into atendimento (tipo,valor)values(?,?)";

		PreparedStatement pst = conn.prepareStatement(sql);

		pst.setString(1, atendimento.getTipo());
		pst.setDouble(2, atendimento.getValor());

		pst.execute();
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}

	@Override
	public void alterarAtendimento(Atendimento atendimento) throws SQLException {
		String sql = "update atendimento set  tipo= ?,valor=? where codigo=?";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
	
		pst.setString(1, atendimento.getTipo());
		pst.setDouble(2, atendimento.getValor());
		pst.setInt(3, atendimento.getCodigo());

		pst.executeUpdate();
		JOptionPane.showMessageDialog(null, "Alteração realizado com sucesso");

	}

	@Override
	public Atendimento procurar(int codigo) throws SQLException {

		String sql = "select * from atendimento where codigo=?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setInt(1, codigo);
		ResultSet resultSet = preStatement.executeQuery();
		
		while (resultSet.next()) {
			int codigo1 = resultSet.getInt(1);
			String tipo = resultSet.getString(2);
			double valor = resultSet.getDouble(3);
		
			Atendimento atendimento = new Atendimento(tipo, valor);
			atendimento.setCodigo(codigo1);
			
			return atendimento;
		}
		return null;
	}

	@Override
	public void excluirAtendimento(int codigo) throws SQLException {
		String sql = "delete from atendimento where codigo=?";
		
		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setInt(1, codigo);

		preStatement.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "REMOVIDO COM SUCESSO");
		
	}

	@Override
	public ArrayList<Atendimento> listaAtendimento() throws SQLException {
		ArrayList<Atendimento> array = new ArrayList<Atendimento>();
		
		String sql = "select * from atendimento";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		
		ResultSet resultSet = preStatement.executeQuery();
		
		while (resultSet.next()) {
			int codigo = resultSet.getInt(1);
			String tipo = resultSet.getString(2);
			double valor = resultSet.getDouble(3);
		
			Atendimento atendimento = new Atendimento(tipo, valor);
			atendimento.setCodigo(codigo);
			array.add(atendimento);
			
		}
		
		return array;
	}

}
