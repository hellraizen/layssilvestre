package com.layssilvestre.telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.layssilvestre.clienteException.ClienteNaoEncontradoException;
import com.layssilvestre.clientes.Cliente;
import com.layssilvestre.fachada.Fachada;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JFClienteListar extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel defaultTableModelCliente;
	private JTable tableListaCliente;
	private JTextField txtProcurar;
	private String cpfControle;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFClienteListar frame = new JFClienteListar();
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
	public JFClienteListar() {
		setTitle("Lista de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 709, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
				
				
			}
		});

		JButton btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon(JFClienteListar.class.getResource("/com/layssilvestre/imagens/image004.gif")));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.getInstance().removerCliente(cpfControle);
					listar();
				} catch (ClassNotFoundException | SQLException | ClienteNaoEncontradoException | IOException  e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton Listar = new JButton("Listar");
		Listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					listar();
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		JPanel panel = new JPanel();
		
		txtProcurar = new JTextField();
		txtProcurar.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtProcurar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String nome =txtProcurar.getText();
				Cliente cliente;
				try {
					cliente = Fachada.getInstance().procurarNomeCliente(nome);
					listar(cliente);
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		txtProcurar.setColumns(10);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		
		JButton btnCadastrar = new JButton("+");
		btnCadastrar.setFont(new Font("TypoUpright BT", Font.PLAIN, 16));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFCliente telaCliente = new JFCliente();
				telaCliente.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPesquisar)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(btnRemover))
										.addComponent(txtProcurar, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
									.addGap(54)
									.addComponent(Listar)
									.addGap(5)
									.addComponent(btnEditar)))))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addComponent(lblPesquisar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(Listar)
								.addComponent(btnEditar))
							.addGap(26))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtProcurar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
					.addContainerGap())
		);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE));

		tableListaCliente = new JTable();
		tableListaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaSelecao = tableListaCliente.getSelectedRow();
			cpfControle= tableListaCliente.getValueAt(linhaSelecao, 2).toString();
			
			}
		});
		String colunaTabelaCliente[] = new String[] {"Codigo", "Nome", "CPF", "Data de Nascimanto", "Telefone", "Sexo", "Status"};
		defaultTableModelCliente = new DefaultTableModel(new Object[] []{ }, colunaTabelaCliente){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
	
		tableListaCliente.setModel(defaultTableModelCliente);
		scrollPane.setViewportView(tableListaCliente);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

	}

	private void listar() throws ClassNotFoundException, SQLException, IOException {
		 this.limparTabelaCliente();
		ArrayList<Cliente> clientes = Fachada.getInstance().listarCliente();
		for (Cliente cliente : clientes) {
			Vector vector = new Vector();
			vector.add(cliente.getCodigo());
			vector.add(cliente.getNome());
			vector.add(cliente.getCpf());
			vector.add(cliente.getDataNascimento());
			vector.add(cliente.getTelefone());
			vector.add(cliente.getSexo());
			vector.add(cliente.getStatus());

			defaultTableModelCliente.addRow(vector);
		}
	}
	private void listar(Cliente cliente) throws ClassNotFoundException, SQLException {
		 this.limparTabelaCliente();
		
		
			Vector vector = new Vector();
			vector.add(cliente.getCodigo());
			vector.add(cliente.getNome());
			vector.add(cliente.getCpf());
			vector.add(cliente.getDataNascimento());
			vector.add(cliente.getTelefone());
			vector.add(cliente.getSexo());
			vector.add(cliente.getStatus());

			defaultTableModelCliente.addRow(vector);
		
	}
	private void limparTabelaCliente() {
		defaultTableModelCliente.setNumRows(0);;
	}
	private void editar() {
		try {
			Cliente cliente = Fachada.getInstance().procurarCliente(cpfControle);
			
			JFCliente telaC = new JFCliente();
			telaC.btnAtualizar.setEnabled(true);
			telaC.btnCadastrar.setEnabled(false);
			telaC.setVisible(true);
			//dados cliente
			telaC.txtNomeCliente.setText(cliente.getNome());
			telaC.txtCpfCliente.setText(cliente.getCpf());
			telaC.txtDataCliente.setText(cliente.getDataNascimento());
			telaC.txtEmailCliente.setText(cliente.getEmail());
			telaC.txtTelefoneCliente.setText(cliente.getTelefone());
			telaC.txtCodigo.setText(cliente.getCodigo().toString());
			telaC.txtAltura.setText(String.valueOf(cliente.getAltura()));
			telaC.txtPeso.setText(String.valueOf(cliente.getPeso()));
			//endereco
			telaC.txtRua.setText(cliente.getRua());
			telaC.txtBairro.setText(cliente.getBairro());
			telaC.txtCep.setText(cliente.getCep());
			telaC.txtNumero.setText(cliente.getNumero());
			telaC.txtCidade.setText(cliente.getCidade());
			telaC.txtStatus.setSelectedItem(cliente.getStatus());
			telaC.txtComplemento.setText(cliente.getComplemento());
		
			
			
		} catch (ClassNotFoundException | SQLException | ClienteNaoEncontradoException | IOException e) {
			JOptionPane.showMessageDialog( null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
}
