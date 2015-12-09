package com.layssilvestre.telas;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.layssilvestre.atendimento.Atendimento;
import com.layssilvestre.clientes.Cliente;
import com.layssilvestre.fachada.Fachada;
import com.layssilvestre.mensalidade.Mensalidade;

public class JFAtendimentoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
	private JTable table;
	private JComboBox<String> cBClienteList;
	private JComboBox<String> cBatividadeList;
	private DefaultTableModel defaultTable;
	private JComboBox cBparcela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtendimentoCliente frame = new JFAtendimentoCliente();
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
	public JFAtendimentoCliente() {
		
		setTitle("Atendimento Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 766, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 736, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JScrollPane cBatividadeListe = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(cBatividadeListe, GroupLayout.PREFERRED_SIZE, 738, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(cBatividadeListe, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		String[] topo = new String[] {"Codigo", "Nome", "Atividade", "Parcela", "Valor","Vencimento","Status"};
		defaultTable =new DefaultTableModel(new Object[][] { },topo){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		table.setModel(defaultTable);
		cBatividadeListe.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Nome");
		
		cBClienteList = new JComboBox();
		
		cBatividadeList = new JComboBox();
		
		JLabel lblAtividade = new JLabel("Atividade");
		
		 cBparcela = new JComboBox();
		cBparcela.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12"}));
		
		JLabel lblParcela = new JLabel("Parcela");
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Arial", Font.PLAIN, 41));
		txtValor.setColumns(10);
		
		JLabel lblValorr = new JLabel("Valor (R$)");
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addComponent(cBClienteList, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(29)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblValorr, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(cBparcela, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblParcela, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAtividade, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(cBatividadeList, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cBClienteList, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(lblAtividade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cBatividadeList, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(lblParcela)
									.addGap(6)
									.addComponent(cBparcela, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(9)
									.addComponent(lblValorr)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))))
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {cBClienteList, cBatividadeList});
		
		JButton btnGerar = new JButton("Gerar Parcelas");
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cadastrar();
					listar();
				} catch (ClassNotFoundException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnPagar = new JButton("Pagar");
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(JFAtendimentoCliente.class.getResource("/com/layssilvestre/imagens/image004.gif")));
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		btnSalvar.setIcon(new ImageIcon(JFAtendimentoCliente.class.getResource("/com/layssilvestre/imagens/image005.gif")));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnGerar, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
						.addComponent(btnPagar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(20)
					.addComponent(btnGerar, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnPagar, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(18)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		listarCbCliente();
		listarCbAtividade();
	}
	private void listarCbCliente(){
		cBClienteList.removeAllItems();
		cBClienteList.addItem("Selecione...");
		
		try {
			ArrayList<Cliente> listaCliente = Fachada.getInstance().listarCliente();
			
			Iterator<Cliente> it = listaCliente.iterator();  
		    while(it.hasNext()){  
		  
		        Cliente e = it.next();  
		        String cliente = e.getNome();  
		  
		        cBClienteList.addItem(cliente); 
			
		    }
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	private void listarCbAtividade(){
		cBatividadeList.removeAllItems();
		cBatividadeList.addItem("Selecione...");
		
		try {
			ArrayList<Atendimento> listaCliente = Fachada.getInstance().listarAtendimento();
			
			Iterator<Atendimento> it = listaCliente.iterator();  
		    while(it.hasNext()){  
		  
		        Atendimento e = it.next();  
		        String atendimento = e.getTipo();  
		  
		        cBatividadeList.addItem(atendimento); 
			
		    }
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	private void cadastrar() throws ClassNotFoundException, IOException{
		String tipo = cBatividadeList.getSelectedItem().toString();
		int quantidade = 0;
		int parcela = Integer.parseInt(cBparcela.getSelectedItem().toString());
		String nomeAluno = cBClienteList.getSelectedItem().toString();
		double valor = Double.parseDouble(txtValor.getText());
		String status= "aberto";
		
		Mensalidade mensalidade = new Mensalidade(tipo, quantidade, parcela, status, nomeAluno, valor);
		Fachada.getInstance().gerarMensalide(mensalidade);
		
	}
	private void listar() throws ClassNotFoundException, SQLException, IOException {
		this.limparTabelaProduto();
		ArrayList<Mensalidade> mensalidade = Fachada.getInstance().listarMensalidade();
		for (Mensalidade mensalidades : mensalidade) {
			Vector vector = new Vector();
			vector.add(mensalidades.getCodigo());
			vector.add(mensalidades.getNomeAluno());
			vector.add(mensalidades.getTipo());
			vector.add(mensalidades.getParcela());
			vector.add(mensalidades.getValor());
			vector.add(mensalidades.getData());
			vector.add(mensalidades.getStatus());
			defaultTable.addRow(vector);
		}
	}

	private void limparTabelaProduto() {
		defaultTable.setNumRows(0);
	}
}
