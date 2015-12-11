package com.layssilvestre.fachada;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.layssilvestre.atendimento.Atendimento;
import com.layssilvestre.atendimento.ControleAtendimento;
import com.layssilvestre.caixa.Caixa;
import com.layssilvestre.caixa.ControladorCaixa;
import com.layssilvestre.clienteException.ClienteCpfInvalidoException;
import com.layssilvestre.clienteException.ClienteJaCadastradoException;
import com.layssilvestre.clienteException.ClienteNaoEncontradoException;
import com.layssilvestre.clientes.Cliente;
import com.layssilvestre.clientes.ControladorCliente;
import com.layssilvestre.funcionario.ControladorFuncionario;
import com.layssilvestre.funcionario.Funcionario;
import com.layssilvestre.mensalidade.ControleMensalidade;
import com.layssilvestre.mensalidade.Mensalidade;



public class Fachada {
	private static Fachada instance;
	private ControladorCliente controladorCliente;
	private ControladorFuncionario controladorFuncionario;
	private ControladorCaixa controladorCaixa;
	private ControleAtendimento controladorAtendimento;
	private ControleMensalidade controladorMensalidade;

	private Fachada() throws ClassNotFoundException, IOException {
		this.controladorCliente = new ControladorCliente();
		this.controladorAtendimento = new ControleAtendimento();
		this.controladorFuncionario = new ControladorFuncionario();
		this.controladorMensalidade = new ControleMensalidade();
		this.controladorCaixa = new ControladorCaixa();
	}

	public static Fachada getInstance() throws ClassNotFoundException, IOException {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	// -------------------------------------------------------------------CLIENTE------------------------------------------------------------------

	public void cadastrarCliente(Cliente cliente) throws SQLException, ClienteJaCadastradoException, ClienteCpfInvalidoException {
		controladorCliente.cadastrar(cliente);

	}

	public void atualizarCliente(Cliente cliente) throws SQLException, ClienteNaoEncontradoException {
		controladorCliente.atualizar(cliente);

	}

	public void removerCliente(String cpf) throws SQLException, ClienteNaoEncontradoException{
		controladorCliente.remover(cpf);

	}

	public Cliente procurarCliente(String cpf) throws SQLException, ClienteNaoEncontradoException {

		return controladorCliente.procurar(cpf);
	}

	public boolean existeCliente(String cpf) throws SQLException {

		return controladorCliente.existe(cpf);
	}

	public ArrayList<Cliente> listarCliente() throws SQLException {

		return controladorCliente.listar();
	}

	


//------------------------------------------FUNCIONARIO-------------------------------------------------------------------------


	public void cadastrarFuncionario(Funcionario funcionario) throws SQLException, IOException, ClienteCpfInvalidoException
	{
		controladorFuncionario.cadastrar(funcionario);
	} 

	
	
	public void atualizarFuncionario(Funcionario funcionario) throws SQLException, IOException
	{
		controladorFuncionario.atualizar(funcionario);
	}


	
	
	public void removerFuncionario(String cpf) throws SQLException, IOException
	{
		
		controladorFuncionario.remover(cpf);
	}

	
	
	public Funcionario procurarFuncionario(String cpf) throws SQLException, IOException
	{
		return controladorFuncionario.procurar(cpf);
	}

	
	
	public boolean existirFuncionario(String cpf) throws SQLException, IOException
	{
		return controladorFuncionario.existir(cpf);
	}

	
	
	public ArrayList<Funcionario> listarFuncionario() throws SQLException, IOException
	{
		 return controladorFuncionario.listar();
	}
	

	//------------------------------------------Caixa-------------------------------------------------------------------------

	public ArrayList<Caixa> pesquisaBet (String inicio) throws SQLException{
		return controladorCaixa.pesquisaBet(inicio);
	}
	
	public void entradaCaixa(Caixa entradaCaixa) throws SQLException, IOException , ParseException {
		controladorCaixa.entradaCaixa(entradaCaixa);
	}

	public void saidaCaixa(Caixa saidaCaixa) throws SQLException, IOException, ParseException  {
		controladorCaixa.saidaCaixa(saidaCaixa);
	}

	public ArrayList<Caixa> movimentoDiarioCaixa() throws SQLException, IOException {
		return controladorCaixa.movimentoDiario();
	}
	//-------------------------------------------------------Atendimento-----------------------------------------------
	
	public void inserirAtendimento(Atendimento atendimento) throws SQLException {
		controladorAtendimento.inserirAtendimento(atendimento);
	}

	public void alterarAtendimento(Atendimento atendimento) throws SQLException {
		controladorAtendimento.alterarAtendimento(atendimento);
	}
	public void excluirAtendimento(int codigo) throws SQLException{
		controladorAtendimento.excluirAtendimento(codigo);
		
	}
	public Atendimento procurarAtendimento(int codigo) throws SQLException{
		return controladorAtendimento.procurar(codigo);
	}
	public ArrayList<Atendimento> listarAtendimento() throws SQLException{
		
		return controladorAtendimento.listar();
	}
	
	//----------------------------------------------------------------Mensalidade--------------------------------------
	
	public String pesquisarAtividade(String atividade) throws SQLException{
		return controladorMensalidade.pesquisarAtividade(atividade);
	}
	
	public void gerarMensalide (Mensalidade mensalidade){
		controladorMensalidade.gerarMensalide(mensalidade);
	}
	public ArrayList<Mensalidade> listarMensalidade(){
		return controladorMensalidade.listarMensalidade();
	}
	public void salvarMensalidade(ArrayList<Mensalidade> array) throws SQLException{
		controladorMensalidade.salvarMensalidade(array);
	}
	public void limpararray(){
		controladorMensalidade.limpararray();
	}
	public ArrayList<Mensalidade> listarBd() throws SQLException{
		return controladorMensalidade.listarBd();
	}
	public void deletarMensalidade(int codigo) throws SQLException{
		controladorMensalidade.deletarMensalidade(codigo);
	}
	public void pagamento(int codigo)throws SQLException, IOException{
		controladorMensalidade.pagamento(codigo);
	}
	public ArrayList<Mensalidade> pesquisarAluno(String nome) throws SQLException{
		return controladorMensalidade.pesquisarAluno(nome);
	}
	
	
}	