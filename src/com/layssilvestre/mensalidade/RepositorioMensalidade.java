package com.layssilvestre.mensalidade;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import com.layssilvestre.caixa.Caixa;
import com.layssilvestre.caixa.ControladorCaixa;
import com.layssilvestre.util.TrataDataBr;

import DAL.ConectaBd;;

public class RepositorioMensalidade implements IRepositorioMensalidade{

	private ArrayList<Mensalidade> arrayMensalidade;
	private int index;
	private Connection conn;
	private ControladorCaixa controleCaixa;


	public RepositorioMensalidade() throws ClassNotFoundException, IOException {
		arrayMensalidade = new ArrayList<>();
		index = 1;
		conn = ConectaBd.conectabd();
		controleCaixa = new ControladorCaixa();
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
	
	public ArrayList<Mensalidade> listarBd() throws SQLException{
		
		ArrayList<Mensalidade> array = new ArrayList<Mensalidade>();
		
		String sql = "select * from mensalidade";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();
		
		while (rs.next()) {
			
			int codigo = rs.getInt(1);
			String nomeAluno = rs.getString(2);
			String tipo = rs.getString(3);
			int parcela = rs.getInt(4);
			double valor = rs.getDouble(5);
			String status = rs.getString(6);
			String data = rs.getString(7);
			
		Mensalidade mensalidade = new Mensalidade(codigo,tipo, parcela, status, nomeAluno, valor, data);
		
		array.add(mensalidade);
		
		}
		
		return array;
	}
	public void deletarMensalidade(int codigo) throws SQLException{
		
		
		String sql = "delete from mensalidade where id = ?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setInt(1, codigo);

		
		preStatement.executeUpdate();
		
		
		JOptionPane.showMessageDialog(null, "REMOVIDO COM SUCESSO");
	}
	public void pagamento(int codigo)throws SQLException, IOException{
		
		String sql= "update mensalidade set  status =? where id= ?";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, "PAGO");
		pst.setInt(2, codigo);
		
		pst.executeUpdate();
		
		//-------------------------------------------------------------------
		
		String sql1= "select * from mensalidade where id = ?";
		
		PreparedStatement pst1 = conn.prepareStatement(sql1);
		pst1.setInt(1, codigo);
		ResultSet rs = pst1.executeQuery();
		while (rs.next()) {
		double entrada = rs.getDouble(5);
		String nome= rs.getString(2);
		Date date = new Date();
		String data = TrataDataBr.trataData(date);
		String mes = TrataDataBr.tranformarDataMes(date);
		String descricao = "Pagamento de "+nome;
		
		Caixa caixa = new Caixa(entrada, 0.0, 2, mes, data, descricao);
		
		controleCaixa.entradaCaixa(caixa);
		}
		
		JOptionPane.showMessageDialog(null, "Pagamento da codigo : "+codigo);
	}
	
	public ArrayList<Mensalidade> pesquisarAluno(String nome) throws SQLException{
		ArrayList<Mensalidade> array = new ArrayList<Mensalidade>();
		
	
		String sql = "select * from mensalidade where nomealuno like ?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, nome+"%");
		ResultSet rs = preStatement.executeQuery();
		while (rs.next()) {
			
			int codigo = rs.getInt(1);
			String nomeAluno = rs.getString(2);
			String tipo = rs.getString(3);
			int parcela = rs.getInt(4);
			double valor = rs.getDouble(5);
			String status = rs.getString(6);
			String data = rs.getString(7);
			
		Mensalidade mensalidade = new Mensalidade(codigo,tipo, parcela, status, nomeAluno, valor, data);
		
		array.add(mensalidade);
		}
		
		return array;
	}
	
	
	
}
