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

import oColecionador.entity.Colecao;
import oColecionador.entity.Moeda;
import oColecionador.entity.Pais;
import oColecionador.entity.TipoTransacao;
import oColecionador.entity.Usuario;
import oColecionador.repository.ColecaoRepository;
import oColecionador.repository.MoedaRepository;
import oColecionador.repository.PaisRepository;
import oColecionador.repository.TipoRepository;
import oColecionador.repository.UsuarioRepository;
import revendaCarros.DAO.ColecaoDAO;
import revendaCarros.entity.Pessoa;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCriarColecao extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblUser;
	private JTextField txtQuantidade;

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
					TelaCriarColecao frame = new TelaCriarColecao();
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
	public TelaCriarColecao() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1016, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOColecionador = new JLabel("                    O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(201, -25, 523, 97);
		contentPane.add(lblOColecionador);

		lblUser = new JLabel("...");
		lblUser.setBounds(80, 17, 263, 25);
		getContentPane().add(lblUser);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));

		// mostrando o usuário
		JLabel lblNewLabel_1 = new JLabel("Usuário  :");
		lblNewLabel_1.setBounds(10, 25, 76, 13);
		getContentPane().add(lblNewLabel_1);

	

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 267, 949, 239);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, "", null }, { null, null, null, null }, { null, null, null, null }, },
				new String[] { "Usu\u00E1rio", "Moeda", "Status" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(139);
		table.getColumnModel().getColumn(1).setPreferredWidth(333);
		table.getColumnModel().getColumn(2).setPreferredWidth(38);

		JLabel lblMoedas = new JLabel("                    COLEÇÃO");
		lblMoedas.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblMoedas.setBounds(261, 179, 316, 97);
		contentPane.add(lblMoedas);

		
		JComboBox cbUserLog = new JComboBox();
		cbUserLog.setEnabled(false);
		cbUserLog.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				UsuarioRepository repository = new UsuarioRepository();
				Usuario userLog = repository.pesquisaPeloUser(lblUser.getText());
				cbUserLog.addItem(userLog);

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbUserLog.setBounds(131, 193, 252, 21);
		contentPane.add(cbUserLog);
		JButton btnAjuda = new JButton("ATUALIZA COLEÇÃO");
		btnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = (Usuario) cbUserLog.getSelectedItem();

				ColecaoRepository colecaoRepository = new ColecaoRepository();
				List<Colecao> lista = colecaoRepository.obterColecoesDoUsuarioLogado(usuario);
				DefaultTableModel modeloTabela = (DefaultTableModel) table.getModel();
				modeloTabela.setRowCount(0);
				for (Colecao colecao1 : lista) {
					modeloTabela.addRow(new Object[] { colecao1.getUsuario(), colecao1.getMoeda(),
							 colecao1.getTipoTransacao() });
				}
			}
		});
		btnAjuda.setBounds(663, 236, 170, 21);
		contentPane.add(btnAjuda);
		JComboBox cbMoeda = new JComboBox();
		cbMoeda.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				MoedaRepository mdao = new MoedaRepository();

				for (Moeda p : mdao.listar()) {

					cbMoeda.addItem(p);

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbMoeda.setBounds(10, 82, 486, 21);
		contentPane.add(cbMoeda);

		JComboBox cbStatus = new JComboBox();
		cbStatus.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				TipoRepository tdao = new TipoRepository();

				for (TipoTransacao p : tdao.listar()) {

					cbStatus.addItem(p);

				}

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbStatus.setBounds(10, 147, 170, 21);
		contentPane.add(cbStatus);

		JLabel lblNewLabel = new JLabel("QUANTIDADE");
		lblNewLabel.setBounds(247, 125, 76, 13);
		contentPane.add(lblNewLabel);

		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(247, 148, 96, 19);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);

		JButton btnCriarColec = new JButton("Salvar Coleção");
		btnCriarColec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Colecao colecao = new Colecao();
				ColecaoRepository dao = new ColecaoRepository();
				TipoTransacao tipo = (TipoTransacao) cbStatus.getSelectedItem();
				Usuario usuario = (Usuario) cbUserLog.getSelectedItem();
				Moeda moeda = (Moeda) cbMoeda.getSelectedItem();
				colecao.setQuantidade(txtQuantidade.getText());
				colecao.setMoeda(moeda);
				colecao.setUsuario(usuario);
				colecao.setTipoTransacao(tipo);
				dao.inserir(colecao);
				JOptionPane.showMessageDialog(null,"MOEDA SALVA NA COLEÇÃO DE "+colecao.getUsuario()+" COM SUCESSO");
				ColecaoRepository colecaoRepository = new ColecaoRepository();
				List<Colecao> lista = colecaoRepository.obterColecoesDoUsuarioLogado(usuario);
				DefaultTableModel modeloTabela = (DefaultTableModel) table.getModel();
				modeloTabela.setRowCount(0);
				for (Colecao colecao1 : lista) {
					modeloTabela.addRow(
							new Object[] { colecao1.getUsuario(), colecao1.getMoeda(), colecao1.getTipoTransacao() });
				}
			}
		});
		btnCriarColec.setBounds(368, 147, 164, 21);
		contentPane.add(btnCriarColec);

		JLabel lblNewLabel_2 = new JLabel("MOEDAS");
		lblNewLabel_2.setBounds(10, 65, 96, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("STATUS");
		lblNewLabel_3.setBounds(10, 124, 111, 13);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("COLEÇÃO DE :");
		lblNewLabel_4.setBounds(10, 197, 186, 13);
		contentPane.add(lblNewLabel_4);

	}
	
	public void preencheLIsta() {

		
	}

}