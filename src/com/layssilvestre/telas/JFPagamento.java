package com.layssilvestre.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.layssilvestre.fachada.Fachada;
import com.layssilvestre.mensalidade.Mensalidade;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JFPagamento extends JFrame {

	private JPanel contentPane;
	private JTable tableBoleto;
	private JTextField txtPesquisaNome;
	private DefaultTableModel defaultTable;
	private int idControle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFPagamento frame = new JFPagamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public JFPagamento() throws ClassNotFoundException, SQLException, IOException {
		setTitle("Pagamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 578, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
					.addGap(5))
		);
		
		tableBoleto = new JTable();
		tableBoleto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int linhaSelecao = tableBoleto.getSelectedRow();
				idControle= Integer.parseInt(tableBoleto.getValueAt(linhaSelecao, 0).toString());
				
				
			}
		});
		String[] topo = new String[] {"Codigo", "Nome", "Atividade", "Parcela", "Valor","Vencimento","Status"};
		defaultTable =new DefaultTableModel(	new Object[][] {},topo){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableBoleto.setModel(defaultTable);
		scrollPane.setViewportView(tableBoleto);
		panel_1.setLayout(gl_panel_1);
		
		txtPesquisaNome = new JTextField();
		txtPesquisaNome.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
			
				try {
					String nome =txtPesquisaNome.getText();
					listar(Fachada.getInstance().pesquisarAluno(nome));
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		txtPesquisaNome.setColumns(10);
		
		JLabel lblNomeDoAluno = new JLabel("Nome do Aluno");
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.getInstance().deletarMensalidade(idControle);
					listar();
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(JFPagamento.class.getResource("/com/layssilvestre/imagens/image004.gif")));
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.getInstance().pagamento(idControle);
					listar();
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNomeDoAluno)
						.addComponent(txtPesquisaNome, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnPagar, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
							.addGap(26))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNomeDoAluno)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPesquisaNome, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPagar)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_panel.linkSize(SwingConstants.VERTICAL, new Component[] {btnNewButton, btnPagar});
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnNewButton, btnPagar});
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		listar();
	}
	private void listar() throws ClassNotFoundException, SQLException, IOException {
		
		this.limparTabelaProduto();
		limparTabelaProduto();
		ArrayList<Mensalidade> mensalidade = Fachada.getInstance().listarBd();
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
private void listar(ArrayList<Mensalidade> mensalidades1) throws ClassNotFoundException, SQLException, IOException {
		
		this.limparTabelaProduto();
		limparTabelaProduto();
		ArrayList<Mensalidade> mensalidade = mensalidades1;
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
