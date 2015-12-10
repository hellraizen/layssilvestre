package com.layssilvestre.mensalidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import com.layssilvestre.caixa.Caixa;
import com.layssilvestre.util.TrataDataBr;

import DAL.ConectaBd;;

public class RepositorioMensalidade implements IRepositorioMensalidade{

	private ArrayList<Mensalidade> arrayMensalidade;
	private int index;
	private Connection conn;


	public RepositorioMensalidade() throws ClassNotFoundException {
		arrayMensalidade = new ArrayList<>();
		index = 1;
		conn = ConectaBd.conectabd();
	}
	
	public String pesquisarAtividade(String atividade) throws SQLException{
		String sql = "select * from atendimento where tipo = ?";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setString(1, atividade);
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
			
			String valor = String.valueOf(rs.getDouble(3));
			return valor;
			}
		
		return "";
		
	}
	
	
	public void gerarMensalide (Mensalidade mensalidade){
		int parcela = mensalidade.getParcela();
	
		for (int i = 0; i < parcela; i++) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH,i );
			
			String dataCorrente = TrataDataBr.trataData(c.getTime());
			
			Mensalidade m1 = new Mensalidade(mensalidade.getTipo(),i+1,mensalidade.getStatus(),mensalidade.getNomeAluno(),mensalidade.getValor());
			m1.setCodigo(index++);
			m1.setData(dataCorrente);
			
			arrayMensalidade.add(m1);
			
		}	
	}
	
	public void salvarMensalidade(ArrayList<Mensalidade> array) throws SQLException{
		ArrayList<Mensalidade> arraylocal = array;
		
		String sql = "insert into mensalidade (nomeAluno,tipo,parcela,valor,status,data) values (?,?,?,?,?,?)";
		
		PreparedStatement pst= conn.prepareStatement(sql);
		
		for (Mensalidade mensalidade : arraylocal) {
		
			pst.setString(1, mensalidade.getNomeAluno());
			pst.setString(2, mensalidade.getTipo());
			pst.setInt(3, mensalidade.getParcela());
			pst.setDouble(4, mensalidade.getValor());
			pst.setString(5, mensalidade.getStatus());
			pst.setString(6,mensalidade.getData());
			pst.execute();
		
		}
		
		
		JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		
	}
	
	public ArrayList<Mensalidade> listarMensalidade(){
		
		return arrayMensalidade;
	}
	public void limpararray(){
		arrayMensalidade.clear();
	}
	
	
	
}
