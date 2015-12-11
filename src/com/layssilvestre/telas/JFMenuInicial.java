package com.layssilvestre.telas;

import java.awt.EventQueue;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;



public class JFMenuInicial extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFMenuInicial frame = new JFMenuInicial();

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
	public JFMenuInicial() {
	
		setTitle("Lays Silvestre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);

		setBounds(100, 100, 1378, 757);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Cadastro");
		menuBar.add(mnArquivo);

		JMenuItem nenuCliente = new JMenuItem("Cliente\r\n");
		nenuCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFClienteListar clienteLista = new JFClienteListar();
				clienteLista.setVisible(true);
			}
		});
		mnArquivo.add(nenuCliente);

		JMenuItem menuFuncionrio = new JMenuItem("Funcion\u00E1rio");
		menuFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFFuncionario teleFuncionario = new JFFuncionario();
				teleFuncionario.setVisible(true);
			}
		});
		mnArquivo.add(menuFuncionrio);

		JMenuItem menuSair = new JMenuItem("Sair");
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		
		JMenuItem menuAtendimento = new JMenuItem("Atendimento");
		menuAtendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFAtendimento atendimentoTela = new JFAtendimento();
				atendimentoTela.setVisible(true);
			}
		});
		mnArquivo.add(menuAtendimento);
		mnArquivo.add(menuSair);

		JMenu mnHelp = new JMenu("Caixa");
		menuBar.add(mnHelp);

		JMenuItem menuCaixa = new JMenuItem("Caixa");
		menuCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCaixa telaCaixa = new JFCaixa();
				telaCaixa.setVisible(true);
			}
		});
		mnHelp.add(menuCaixa);

		JMenuItem menuPagamento = new JMenuItem("Pagamento");
		mnHelp.add(menuPagamento);
		
		JMenu menu_1 = new JMenu("Atendimento");
		menuBar.add(menu_1);
		
		JMenuItem mntmGerarFicha = new JMenuItem("Gerar Ficha");
		mntmGerarFicha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFAtendimentoCliente atendimentoCliente= new JFAtendimentoCliente();
				atendimentoCliente.setVisible(true);
			}
		});
		menu_1.add(mntmGerarFicha);

		JMenu menu = new JMenu("Help");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("Vers\u00E3o");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Entre em Contado com \n ADMINISTRADOR \n 081 98863 0020 \n Te amo Moreca =***");
			}
		});
		menu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 228, 196));
		lblNewLabel.setIcon(new ImageIcon(JFMenuInicial.class.getResource("/com/layssilvestre/imagens/logLays.png")));
		lblNewLabel.setBounds(10, -45, 1322, 1018);
		contentPane.add(lblNewLabel);

	
	}
}
