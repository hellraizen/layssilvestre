package com.layssilvestre.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.layssilvestre.clienteException.ClienteCpfInvalidoException;
import com.layssilvestre.clienteException.ClienteJaCadastradoException;
import com.layssilvestre.clienteException.ClienteNaoEncontradoException;
import com.layssilvestre.clientes.Cliente;
import com.layssilvestre.fachada.Fachada;

public class JFCliente extends JFrame {

	private JPanel contentPane;
	public JTextField txtNomeCliente;
	public JTextField txtCpfCliente;
	public JTextField txtDataCliente;
	public JTextField txtTelefoneCliente;
	public JTextField txtEmailCliente;
	public JTextField txtRua;
	public JTextField txtCep;
	public JTextField txtBairro;
	public JTextField txtNumero;
	public JTextField txtCidade;
	private JRadioButton rdbtFeminino;
	private JRadioButton rdbtnMasculino;
	private ButtonGroup bg = new ButtonGroup();
	public JTextField txtCodigo;
	public JButton btnAtualizar;
	public JButton btnCadastrar;
	public JTextField txtAltura;
	public JTextField txtPeso;
	public JTextField txtComplemento;
	public JComboBox txtStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCliente frame = new JFCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public JFCliente() {
		setTitle("Cadastro Cliente");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		panel.setToolTipText("");
		panel.setBackground(new Color(240, 240, 240));

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		panel_1.setBackground(SystemColor.menu);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
				
				limpar();

			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 17));

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setEnabled(false);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
				limpar();

			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblCodigo = new JLabel("C\u00F3digo ");

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);

		txtStatus = new JComboBox();
		txtStatus.setModel(new DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));

		JLabel lblStatus = new JLabel("Status");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStatus)
						.addComponent(txtStatus, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
					.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(559, Short.MAX_VALUE)
					.addComponent(lblCodigo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(25))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblStatus)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(13)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(23))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
							.addContainerGap())))
		);
		panel_1.setLayout(null);

		txtRua = new JTextField();
		txtRua.setBounds(10, 47, 234, 20);
		txtRua.setColumns(10);
		panel_1.add(txtRua);

		JLabel rua = new JLabel("Rua");
		rua.setBounds(10, 22, 81, 14);
		panel_1.add(rua);

		txtCep = new JTextField();
		txtCep.setBounds(10, 97, 172, 20);
		txtCep.setColumns(10);
		panel_1.add(txtCep);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(10, 78, 49, 14);
		panel_1.add(lblCep);

		txtBairro = new JTextField();
		txtBairro.setBounds(218, 97, 170, 20);
		txtBairro.setColumns(10);
		panel_1.add(txtBairro);

		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(424, 78, 42, 14);
		panel_1.add(lblN);

		txtNumero = new JTextField();
		txtNumero.setBounds(424, 97, 181, 20);
		txtNumero.setColumns(10);
		panel_1.add(txtNumero);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(218, 78, 81, 14);
		panel_1.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(318, 22, 81, 14);
		panel_1.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(318, 47, 287, 20);
		panel_1.add(txtCidade);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(10, 147, 595, 20);
		panel_1.add(txtComplemento);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(10, 128, 115, 14);
		panel_1.add(lblComplemento);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 26, 71, 14);
		panel.add(lblNome);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(10, 45, 463, 20);
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 76, 71, 14);
		panel.add(lblCpf);

		txtCpfCliente = new JTextField();
		txtCpfCliente.setColumns(10);
		txtCpfCliente.setBounds(10, 91, 154, 20);
		panel.add(txtCpfCliente);

		JLabel labe2 = new JLabel("Data Nascimento");
		labe2.setBounds(489, 26, 136, 14);
		panel.add(labe2);

		txtDataCliente = new JTextField();
		txtDataCliente.setColumns(10);
		txtDataCliente.setBounds(489, 45, 118, 20);
		panel.add(txtDataCliente);

		JLabel labe1 = new JLabel("Telefone");
		labe1.setBounds(189, 76, 118, 14);
		panel.add(labe1);

		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setColumns(10);
		txtTelefoneCliente.setBounds(189, 91, 118, 20);
		panel.add(txtTelefoneCliente);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 122, 71, 14);
		panel.add(lblEmail);

		txtEmailCliente = new JTextField();
		txtEmailCliente.setColumns(10);
		txtEmailCliente.setBounds(10, 137, 426, 20);
		panel.add(txtEmailCliente);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(522, 120, 46, 14);
		panel.add(lblSexo);

		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setSelected(true);
		rdbtnMasculino.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

			}
		});
		bg.add(rdbtnMasculino);
		rdbtnMasculino.setBounds(459, 134, 83, 23);
		panel.add(rdbtnMasculino);

		rdbtFeminino = new JRadioButton("Feminino");
		rdbtFeminino.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

			}
		});
		bg.add(rdbtFeminino);
		rdbtFeminino.setBounds(544, 134, 81, 23);
		panel.add(rdbtFeminino);

		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(332, 91, 118, 20);
		panel.add(txtAltura);

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(332, 76, 118, 14);
		panel.add(lblAltura);

		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(475, 91, 132, 20);
		panel.add(txtPeso);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(475, 76, 118, 14);
		panel.add(lblPeso);
		contentPane.setLayout(gl_contentPane);
	}

	private void cadastrar() {
		// Entrada de dados Pessoais
		String nome = txtNomeCliente.getText();
		String cpf = txtCpfCliente.getText();
		String dataN = txtDataCliente.getText();
		String sexo = selecaoSexo();
		String email = txtEmailCliente.getText();
		String telefone = txtTelefoneCliente.getText();
		double altura = Double.parseDouble(txtAltura.getText());
		double peso = Double.parseDouble(txtPeso.getText());
		String status = txtStatus.getSelectedItem().toString();

		// Entrada de Endereço
		String rua = txtRua.getText();
		String bairro = txtBairro.getText();
		String cep = txtCep.getText();
		String numero = txtNumero.getText();
		String cidade = txtCidade.getText();
		String complemento = txtComplemento.getText();

		Cliente cliente = new Cliente(nome, cpf, dataN, sexo, email, telefone, peso, altura, status, rua, bairro,
				numero,cidade, cep, complemento);
		try {
			Fachada.getInstance().cadastrarCliente(cliente);

		} catch (SQLException | ClassNotFoundException | ClienteJaCadastradoException | ClienteCpfInvalidoException
				| IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	private void limpar() {
		// campos dados cliente

		txtNomeCliente.setText(" ");
		txtCpfCliente.setText(" ");
		txtDataCliente.setText(" ");
		txtEmailCliente.setText(" ");
		txtTelefoneCliente.setText(" ");
		txtAltura.setText(" ");
		txtPeso.setText(" ");

		// campos endereco

		txtRua.setText("");
		txtBairro.setText("");
		txtCep.setText("");
		txtNumero.setText("");
		txtCidade.setText("");
		txtComplemento.setText("");

	}

	private String selecaoSexo() {
		String sexo = "";
		if (rdbtFeminino.isSelected())
			sexo = "Feminino";
		if (rdbtnMasculino.isSelected())
			sexo = "Masculino";

		return sexo;
	}

	private void atualizar() {
		// Entrada de dados Pessoais
		String nome = txtNomeCliente.getText();
		String cpf = txtCpfCliente.getText();
		String dataN = txtDataCliente.getText();
		String sexo = selecaoSexo();
		String email = txtEmailCliente.getText();
		String telefone = txtTelefoneCliente.getText();
		double altura = Double.parseDouble(txtAltura.getText());
		double peso = Double.parseDouble(txtPeso.getText());
		String status = txtStatus.getSelectedItem().toString();

		// Entrada de Endereço
		String rua = txtRua.getText();
		String bairro = txtBairro.getText();
		String cep = txtCep.getText();
		String numero = txtNumero.getText();
		String cidade = txtCidade.getText();
		String complemento = txtComplemento.getText();

		Cliente cliente = new Cliente(nome, cpf, dataN, sexo, email, telefone, peso, altura, status, rua, bairro,
				numero,cidade, cep, complemento);

		try {
			Fachada.getInstance().atualizarCliente(cliente);

		} catch (ClassNotFoundException | SQLException | ClienteNaoEncontradoException | IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
}
