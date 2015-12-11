package com.layssilvestre.telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.layssilvestre.caixa.Caixa;
import com.layssilvestre.fachada.Fachada;
import com.layssilvestre.util.TrataDataBr;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JFCaixa extends JFrame {

	private JPanel contentPane;
	private JTable tableCaixa;
	private DefaultTableModel defautTableModelCaixa;
	private JTextField txtFuncionario;
	private JTextField txtEntrada;
	private DecimalFormat decimalFormat;
	private JTextField txtSaida;
	private JTextField txtTotalCaixa;
	private JComboBox cBMes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCaixa frame = new JFCaixa();
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
	public JFCaixa() {
		setTitle("Caixa\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1139, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Op\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel panel_1 = new JPanel();

		txtFuncionario = new JTextField();
		txtFuncionario.setEditable(false);
		txtFuncionario.setBackground(Color.WHITE);
		txtFuncionario.setEnabled(false);
		txtFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		txtFuncionario.setText("02");
		txtFuncionario.setColumns(10);

		JLabel lblTotalEmCaixa = new JLabel("Total Entrada");
		lblTotalEmCaixa.setFont(new Font("Tahoma", Font.BOLD, 18));

		txtEntrada = new JTextField();
		txtEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		txtEntrada.setText("0.00");
		txtEntrada.setBackground(new Color(0, 0, 102));
		txtEntrada.setEnabled(false);
		txtEntrada.setForeground(Color.WHITE);
		txtEntrada.setFont(new Font("Tahoma", Font.PLAIN, 39));
		txtEntrada.setColumns(10);

		JLabel lblTotalSaida = new JLabel("Total Saida");
		lblTotalSaida.setFont(new Font("Tahoma", Font.BOLD, 18));

		txtSaida = new JTextField();
		txtSaida.setHorizontalAlignment(SwingConstants.CENTER);
		txtSaida.setText("0.00");
		txtSaida.setForeground(Color.WHITE);
		txtSaida.setFont(new Font("Tahoma", Font.PLAIN, 39));
		txtSaida.setEnabled(false);
		txtSaida.setColumns(10);
		txtSaida.setBackground(new Color(0, 0, 102));

		txtTotalCaixa = new JTextField();
		txtTotalCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalCaixa.setText("0.00");
		txtTotalCaixa.setForeground(Color.WHITE);
		txtTotalCaixa.setFont(new Font("Tahoma", Font.PLAIN, 39));
		txtTotalCaixa.setEnabled(false);
		txtTotalCaixa.setColumns(10);
		txtTotalCaixa.setBackground(new Color(0, 0, 102));

		JLabel label_1 = new JLabel("Total Caixa");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(35)
									.addComponent(lblTotalEmCaixa))
								.addComponent(txtEntrada, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addComponent(txtSaida, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(98)
									.addComponent(lblTotalSaida, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(36)
									.addComponent(txtTotalCaixa, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 147, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(75)))
							.addGap(72)
							.addComponent(txtFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(43))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 905, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTotalEmCaixa)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtEntrada, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSaida, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTotalSaida, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(txtTotalCaixa, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtEntrada, txtSaida, txtTotalCaixa});

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(13)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
					.addContainerGap())
		);

		tableCaixa = new JTable();
		String coluna[] = new String[] { "nº", "Entrada", "Saida", "Funcionario","Mes", "Data","Descrição" };
		defautTableModelCaixa = new DefaultTableModel(new Object[][] {}, coluna) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableCaixa.setModel(defautTableModelCaixa);
		scrollPane.setViewportView(tableCaixa);

		panel_1.setLayout(gl_panel_1);

		JButton btnEntrada = new JButton("Entrada");
		btnEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					entrada();
					listarCaixa(Fachada.getInstance().movimentoDiarioCaixa());
					somaEntrada();
					somaSaida();
					somaTotal();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton btnSaida = new JButton("Saida");
		btnSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					saida();
					listarCaixa(Fachada.getInstance().movimentoDiarioCaixa());
					somaEntrada();
					somaSaida();
					somaTotal();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});

		JPanel panel_2 = new JPanel();
		
		JButton btnAnual = new JButton("Lista Todos");
		btnAnual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listarCaixa(Fachada.getInstance().movimentoDiarioCaixa());
					somaEntrada();
					somaSaida();
					somaTotal();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(btnEntrada, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSaida, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAnual)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(16)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnAnual)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEntrada, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSaida, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panel.linkSize(SwingConstants.VERTICAL, new Component[] {btnEntrada, btnSaida, btnAnual});
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnEntrada, btnSaida, btnAnual});

		JButton btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pesquisar();
					somaEntrada();
					somaSaida();
					somaTotal();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		 cBMes = new JComboBox();
		cBMes.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(cBMes, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(213))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(25)
					.addComponent(btnPesquisa, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(231, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(cBMes, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPesquisa)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	private void listarCaixa(ArrayList<Caixa> array) throws ClassNotFoundException, SQLException, IOException {
		this.limparTabelaCaixa();
		ArrayList<Caixa> caixas = array;
		for (Caixa caixa : caixas) {

			Vector vector = new Vector();
			vector.add(caixa.getId());
			vector.add(caixa.getEntrada());
			vector.add(caixa.getSaida());
			vector.add(caixa.getIdFuncionario());
			vector.add(caixa.getMes());
			vector.add(caixa.getData());
			vector.add(caixa.getDescricao());

			defautTableModelCaixa.addRow(vector);
		}

	}

	private void limparTabelaCaixa() {
		defautTableModelCaixa.setNumRows(0);
		;
	}
	private void pesquisar() throws ClassNotFoundException, SQLException, IOException{
		String mes = cBMes.getSelectedItem().toString();
		
		
		listarCaixa(Fachada.getInstance().pesquisaBet(mes));
	}

	private void entrada()  {

		double valorRetirada = Double.parseDouble(JOptionPane.showInputDialog("Digite o  Valor (R$ 0.00) da Entrada"));
		String descricao = JOptionPane.showInputDialog("Digite a Descrição ");
		double entrada = valorRetirada;
		double saida = 0;
		Date date = new Date();
		String data = TrataDataBr.trataData(date);
		String mes = TrataDataBr.tranformarDataMes(date);
		int idFuncionario = Integer.parseInt(txtFuncionario.getText());

		Caixa caixa = new Caixa(entrada, saida, idFuncionario,mes, data,descricao);

		try {
			Fachada.getInstance().entradaCaixa(caixa);

		} catch (ClassNotFoundException | IOException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void saida() {

		double valorRetirada = Double.parseDouble(JOptionPane.showInputDialog("Digite o  Valor (R$ 0.00) da Retirada"));
		String descricao = JOptionPane.showInputDialog("Digite a Descrição ");
		double entrada = 0;
		double saida = valorRetirada;
		Date date = new Date();
		String data =TrataDataBr.trataData(date);
		String mes = TrataDataBr.tranformarDataMes(date);
		int idFuncionario = Integer.parseInt(txtFuncionario.getText());

		Caixa caixa = new Caixa(entrada, saida, idFuncionario,mes, data,descricao);

		try {
			Fachada.getInstance().saidaCaixa(caixa);

		} catch (ClassNotFoundException | IOException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void somaEntrada() {
		decimalFormat = new DecimalFormat("0.00");
		double totalPositivo = 0;

		for (int i = 0; i < tableCaixa.getRowCount(); i++) {

			totalPositivo += Double.parseDouble(defautTableModelCaixa.getValueAt(i, 1).toString());

		}

		txtEntrada.setText(decimalFormat.format(totalPositivo).replace(',', '.'));

	}

	public void somaSaida() {
		decimalFormat = new DecimalFormat("0.00");
		double totalNegativo = 0;

		for (int i = 0; i < tableCaixa.getRowCount(); i++) {

			totalNegativo += Double.parseDouble(defautTableModelCaixa.getValueAt(i, 2).toString());

		}

		txtSaida.setText(decimalFormat.format(totalNegativo).replace(',', '.'));

	}

	public void somaTotal() {
		double entrada = Double.parseDouble(txtEntrada.getText());
		double saida = Double.parseDouble(txtSaida.getText());
		double total = entrada - saida;

		txtTotalCaixa.setText(decimalFormat.format(total).replace(',', '.'));
	}
}
