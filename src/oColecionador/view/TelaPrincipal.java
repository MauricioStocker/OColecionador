package oColecionador.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oColecionador.entity.BordasEntity;
import oColecionador.entity.MaterialEntity;
import oColecionador.entity.MoedaEntity;
import oColecionador.entity.UsuarioEntity;
import oColecionador.repository.MoedaRepository;
import oColecionador.service.MoedaService;
import oColecionador.util.FormataData;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblUser;
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
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		System.out.println();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1357, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOColecionador = new JLabel("                    O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(372, -19, 523, 68);
		contentPane.add(lblOColecionador);

		lblUser = new JLabel("...");
		lblUser.setBounds(80, 17, 99, 25);
		getContentPane().add(lblUser);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));

		// mostrando o usuário
		JLabel lblNewLabel_1 = new JLabel("Usuário  :");
		lblNewLabel_1.setBounds(10, 25, 76, 13);
		getContentPane().add(lblNewLabel_1);

		JButton btnCadastrarMoedas = new JButton("Cadastrar Moedas");
		btnCadastrarMoedas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormMoeda moeda = new FormMoeda();
				moeda.setVisible(true);
				moeda.setLocationRelativeTo(null);

			}
		});
		btnCadastrarMoedas.setBounds(10, 123, 169, 21);
		contentPane.add(btnCadastrarMoedas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 194, 1299, 312);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null }, },
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

		JLabel lblMoedas = new JLabel("                    MOEDAS");
		lblMoedas.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblMoedas.setBounds(436, 154, 523, 49);
		contentPane.add(lblMoedas);

		JButton btnCadastraBordas = new JButton("Cadastrar Bordas");
		btnCadastraBordas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormBordas formBordas = new FormBordas();
				formBordas.setVisible(true);
				formBordas.setLocationRelativeTo(null);
			}
		});
		btnCadastraBordas.setBounds(198, 123, 164, 21);
		contentPane.add(btnCadastraBordas);

		JButton btnCadastraMateriais = new JButton("Cadastrar Materiais");
		btnCadastraMateriais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormMateriais formMateriais = new FormMateriais();
				formMateriais.setVisible(true);
				formMateriais.setLocationRelativeTo(null);
			}
		});
		btnCadastraMateriais.setBounds(388, 123, 179, 21);
		contentPane.add(btnCadastraMateriais);

		JLabel lblPainelDeControle = new JLabel("Painel de controle");
		lblPainelDeControle.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblPainelDeControle.setBounds(436, 47, 523, 68);
		contentPane.add(lblPainelDeControle);

		JButton btnPais = new JButton("cadastrar Pais");
		btnPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormPais formPais = new FormPais();
				formPais.setVisible(true);
				formPais.setLocationRelativeTo(null);
			}
		});
		btnPais.setBounds(590, 123, 123, 21);
		contentPane.add(btnPais);
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
