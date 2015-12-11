package com.layssilvestre.telas;

import java.awt.Component;
import java.awt.EventQueue;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.layssilvestre.atendimento.Atendimento;
import com.layssilvestre.fachada.Fachada;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFAtendimento extends JFrame {

	private JPanel contentPane;
	private JTextField txtAtividade;
	private JTextField txtValor;
	private JTable table;
	private DefaultTableModel defaultabelaAtividade;
	private int controleTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtendimento frame = new JFAtendimento();
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
	public JFAtendimento() {
		setTitle("Cadastro de Atividades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 407, 340);
		contentPane = new JPanel();
		contentPane.setToolTipText("Adcionar");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAdicionar = new JButton("+");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrar();
					limparCampos();
					listar();
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdicionar.setToolTipText("Adicionar");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Atividades", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					editar();
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEditar.setToolTipText("Editar");
		
		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.getInstance().excluirAtendimento(controleTable);
					listar();
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setIcon(new ImageIcon(JFAtendimento.class.getResource("/com/layssilvestre/imagens/image004.gif")));
		
		JButton btnSalva = new JButton("Atualizar");
		btnSalva.setFont(new Font("Arial", Font.PLAIN, 9));
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atualizar();
					limparCampos();
					listar();
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalva.setToolTipText("Atualizar");
		
		JPanel panel_1 = new JPanel();
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					listar();
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnListar.setToolTipText("Listar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnExcluir)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnAdicionar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnEditar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSalva))))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnExcluir)
						.addComponent(btnAdicionar)
						.addComponent(btnListar)
						.addComponent(btnEditar)
						.addComponent(btnSalva, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(59))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnAdicionar, btnEditar, btnExcluir, btnSalva, btnListar});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnAdicionar, btnEditar, btnExcluir, btnListar});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = table.getSelectedRow();
				controleTable = Integer.parseInt(table.getValueAt(linha, 0).toString());
				
				
			}
		});
		String[] top= new String[] {"Codigo","Atividade", "Valor (R$)"}; 	
		defaultabelaAtividade = new DefaultTableModel(new Object[][] {},top){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		table.setModel(defaultabelaAtividade);
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Atividade");
		
		txtAtividade = new JTextField();
		txtAtividade.setColumns(10);
		
		JLabel lblValorR = new JLabel("Valor ( R$ )");
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(41)
							.addGap(96)
							.addComponent(lblValorR))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtAtividade, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblValorR)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtAtividade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	private void listar() throws ClassNotFoundException, SQLException, IOException {
		 this.limparTabelaCliente();
		ArrayList<Atendimento> atendimento = Fachada.getInstance().listarAtendimento();
		for (Atendimento atendimentos : atendimento) {
			Vector vector = new Vector();
			
			vector.add(atendimentos.getCodigo());
			vector.add(atendimentos.getTipo());
			vector.add(atendimentos.getValor());
		
			defaultabelaAtividade.addRow(vector);
		}
	}
	private void limparTabelaCliente() {
		defaultabelaAtividade.setNumRows(0);;
	}
	private void cadastrar() throws ClassNotFoundException, IOException, SQLException{
		String tipo = txtAtividade.getText();
		double valor = Double.parseDouble(txtValor.getText());
		
		Atendimento atendimento = new Atendimento(tipo, valor);
		Fachada.getInstance().inserirAtendimento(atendimento);
	}
	private void editar() throws ClassNotFoundException, IOException, SQLException{
		
		Atendimento atividade = Fachada.getInstance().procurarAtendimento(controleTable);
		
		txtAtividade.setText(atividade.getTipo());
		txtValor.setText(String.valueOf(atividade.getValor()));
		
	}
	private void atualizar() throws ClassNotFoundException, IOException, SQLException{
		
		String tipo = txtAtividade.getText();
		double valor = Double.parseDouble(txtValor.getText());
		
		Atendimento atendimento = new Atendimento(tipo, valor);
		atendimento.setCodigo(controleTable);
		Fachada.getInstance().alterarAtendimento(atendimento);
	}
	private void limparCampos(){
		txtAtividade.setText("");
		txtValor.setText("");
	}
			
}
