package oColecionador.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oColecionador.entity.BordasEntity;
import oColecionador.entity.ColecaoEntity;
import oColecionador.entity.MaterialEntity;
import oColecionador.entity.MoedaEntity;
import oColecionador.entity.PaisEntity;
import oColecionador.entity.TipoTransacaoEntity;
import oColecionador.entity.UsuarioEntity;
import oColecionador.repository.ColecaoRepository;
import oColecionador.repository.MoedaRepository;
import oColecionador.repository.PaisRepository;
import oColecionador.repository.TipoRepository;
import oColecionador.repository.UsuarioRepository;
import oColecionador.service.MoedaService;
import oColecionador.service.UsuarioService;
import oColecionador.util.FormataData;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TelaPrincipalUser extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblUser;
	private JComboBox cbUserLog;
	private UsuarioService usuarioService = new UsuarioService();
	private MoedaService moedaService = new MoedaService();

	// metodo de pegar o user do usuario logado, e guardado na jlabel
	public void setUser(String user) {
		lblUser.setText(user);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalUser frame = new TelaPrincipalUser();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipalUser() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1016, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOColecionador = new JLabel("                    O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(202, -19, 523, 97);
		contentPane.add(lblOColecionador);

		lblUser = new JLabel("...");
		lblUser.setBounds(80, 17, 263, 25);
		getContentPane().add(lblUser);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));

		// mostrando o usuário
		JLabel lblNewLabel_1 = new JLabel("Usuário  :");
		lblNewLabel_1.setBounds(10, 25, 76, 13);
		getContentPane().add(lblNewLabel_1);
		JButton btnColecao = new JButton("Criar Coleção");
		btnColecao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCriarColecao criarColecao = new TelaCriarColecao();
				criarColecao.setUser(lblUser.getText());
				criarColecao.setVisible(true);
			}
		});
		btnColecao.setBounds(10, 82, 145, 21);
		contentPane.add(btnColecao);

		JButton btnNotaProduto = new JButton("Gerar nota Produto");
		btnNotaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaNotaProduto notaProduto;
				try {
					notaProduto = new TelaNotaProduto();
					notaProduto.setUser(lblUser.getText());
					notaProduto.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			

			}
		});
		btnNotaProduto.setBounds(198, 82, 145, 21);
		contentPane.add(btnNotaProduto);

		JButton btnTransacao = new JButton("Venda");
		btnTransacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaNotaTransacao notaTransacao;
				try {
					notaTransacao = new TelaNotaTransacao();
					notaTransacao.setUser(lblUser.getText());
					notaTransacao.setVisible(true);
				} catch (ParseException e1) {
					// TODO Bloco catch gerado automaticamente
					e1.printStackTrace();
				}

			}
		});
		btnTransacao.setBounds(380, 82, 145, 21);
		contentPane.add(btnTransacao);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 267, 949, 239);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null }, },
				new String[] { "C\u00F3digo de catalogo", "Titulo da Moeda", "Pais", "Data Comemorativo",
						"Valor Monetario", "Peso", "Espessura", "Diametro", "Borda", "Material" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(65);
		table.getColumnModel().getColumn(4).setPreferredWidth(43);
		table.getColumnModel().getColumn(5).setPreferredWidth(44);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(59);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(85);

		JLabel lblMoedas = new JLabel("MOEDAS CADASTRADAS");
		lblMoedas.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblMoedas.setBounds(299, 164, 379, 57);
		contentPane.add(lblMoedas);

		cbUserLog = new JComboBox();
		cbUserLog.setVisible(true);
		cbUserLog.setFont(new Font("Arial Black", Font.PLAIN, 14));
		cbUserLog.setFocusTraversalKeysEnabled(false);
		cbUserLog.setEnabled(false);
		cbUserLog.setAutoscrolls(true);
		cbUserLog.setEditable(true);
		cbUserLog.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {

				UsuarioEntity userLog = usuarioService.pesquisaUser(lblUser.getText());
				cbUserLog.addItem(userLog);

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbUserLog.setBounds(10, 236, 252, 21);
		contentPane.add(cbUserLog);

		preencheLIsta();
	}

	public void preencheLIsta() {

		MoedaService moedaService = new MoedaService();
		try {
			List<MoedaEntity> lista = moedaService.listar();
			DefaultTableModel modeloTabela = (DefaultTableModel) table.getModel();
			modeloTabela.setRowCount(0);
			for (MoedaEntity moeda : lista) {
				String dataFormatada = FormataData.getDate(moeda.getAno());
				String bordas = "";
				for (BordasEntity borda : moeda.getBordas()) {
					if (!bordas.isEmpty()) {
						bordas += ", ";
					}
					bordas += borda;
				}
				String materiais = "";
				for (MaterialEntity material : moeda.getMateriais()) {
					if (!materiais.isEmpty()) {
						materiais += ", ";
					}
					materiais += material;
				}
				modeloTabela.addRow(new Object[] { moeda.getIdMoeda(), moeda.getTitulo(), moeda.getCodigoCatalogo(),
						dataFormatada, moeda.getValor(), moeda.getEspessura(), moeda.getPeso(), moeda.getDiametro(),
						moeda.getPaisEntity(), bordas, materiais });
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}