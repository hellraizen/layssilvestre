package com.layssilvestre.caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.ConectaBd;

public class RepositorioCaixaJdbc implements IRepositorioCaixa {

	
	private Connection conn;

	public RepositorioCaixaJdbc() throws ClassNotFoundException {
		conn = ConectaBd.conectabd();
	

	}
	
	
	public ArrayList<Caixa> pesquisaBet (String inicio) throws SQLException{
		
		ArrayList<Caixa> array = new ArrayList<Caixa>();
		
		String sql = "select *from caixa where mes = ?";
		
		
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, inicio);
		
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
		double entrada = rs.getDouble(2);
		double saida = rs.getDouble(3);
		int idFuncionario = rs.getInt(4);
		String mes = rs.getString(5);
		String data  = rs.getString(6);
		String descricao= rs.getString(7);
		
		Caixa caixa = new Caixa(entrada, saida, idFuncionario,mes, data,descricao);
		array.add(caixa);
		}
		
		return array;
		
		
	}



	@Override
	public void entradaCaixa(Caixa entradaCaixa) throws SQLException {
		
		String sql = "insert into caixa( entrada,saida,idfuncionario,mes,data,descricao)values(?,?,?,?,?,?)";

		PreparedStatement pst = conn.prepareStatement(sql);
		System.out.println(entradaCaixa.getData());
		pst.setDouble(1, entradaCaixa.getEntrada());
		pst.setDouble(2, entradaCaixa.getSaida());
		pst.setInt(3, entradaCaixa.getIdFuncionario());
		pst.setString(4, entradaCaixa.getMes());
		pst.setString(5, entradaCaixa.getData());
		pst.setString(6, entradaCaixa.getDescricao());

		pst.execute();
		
	}

	@Override
	public void saidaCaixa(Caixa saidaCaixa) throws SQLException {
	
		String sql = "insert into caixa(entrada,saida,idfuncionario,mes,data,descricao)values(?,?,?,?,?,?)";

		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setDouble(1, saidaCaixa.getEntrada());
		pst.setDouble(2, saidaCaixa.getSaida());
		pst.setInt(3, saidaCaixa.getIdFuncionario());
		pst.setString(4, saidaCaixa.getMes());
		pst.setString(5, saidaCaixa.getData());
		pst.setString(6, saidaCaixa.getDescricao());

		pst.execute();
		
	}

	@Override
	public ArrayList<Caixa> movimentoDiario() throws SQLException {
		ArrayList<Caixa> array = new ArrayList<Caixa>();
		String sql = "select *from caixa";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
		int id= rs.getInt(1);	
		double entrada = rs.getDouble(2);
		double saida = rs.getDouble(3);
		int idFuncionario = rs.getInt(4);
		String mes = rs.getString(5);
		String data  = rs.getString(6);
		String descricao= rs.getString(7);
		
		Caixa caixa = new Caixa(entrada, saida,id, idFuncionario,mes, data,descricao);
		array.add(caixa);
		}
		
		return array;
	}

}
