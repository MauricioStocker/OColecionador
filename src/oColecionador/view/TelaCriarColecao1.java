package oColecionador.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oColecionador.entity.ColecaoEntity;
import oColecionador.entity.MoedaEntity;
import oColecionador.entity.TipoTransacaoEntity;
import oColecionador.entity.UsuarioEntity;
import oColecionador.repository.ColecaoRepository;
import oColecionador.repository.MoedaRepository;
import oColecionador.repository.TipoRepository;
import oColecionador.repository.UsuarioRepository;
import oColecionador.service.ColecaoService;
import oColecionador.service.MoedaService;
import oColecionador.service.TipoService;
import oColecionador.service.UsuarioService;

import javax.swing.JScrollPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaCriarColecao1 extends JFrame {

	private JPanel contentPane;
	private JLabel lblUser;
	private JLabel lblOColecionador;
	private JLabel lblNewLabel_1;
	private JTextField txtQuantidade;
	private JComboBox cbUserLog;
	private JTable tbColecao;
	private JComboBox cbMoedasRegistradas;
	private JComboBox cbStatus;
	private ColecaoService colecaoService = new ColecaoService();
	private MoedaService moedaService = new MoedaService();
	private UsuarioService usuarioService = new UsuarioService();
	private TipoService tipoService = new TipoService();

	/**
	 * Launch the application.
	 */

	public void setUser(String user) {
		lblUser.setText(user);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriarColecao1 frame = new TelaCriarColecao1();
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
	public TelaCriarColecao1() {
		
		setBounds(100, 100, 1054, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuário :");
		lblNewLabel.setBounds(10, 44, 64, 13);
		contentPane.add(lblNewLabel);

		lblUser = new JLabel("...");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(104, 36, 263, 25);
		getContentPane().add(lblUser);

		lblOColecionador = new JLabel("                    O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(264, -23, 523, 67);
		contentPane.add(lblOColecionador);

		lblNewLabel_1 = new JLabel("MOEDAS");
		lblNewLabel_1.setBounds(10, 84, 96, 13);
		contentPane.add(lblNewLabel_1);

		cbMoedasRegistradas = new JComboBox();
		cbMoedasRegistradas.setBounds(10, 107, 942, 21);
		contentPane.add(cbMoedasRegistradas);

		JLabel lblNewLabel_3 = new JLabel("STATUS");
		lblNewLabel_3.setBounds(10, 158, 111, 13);
		contentPane.add(lblNewLabel_3);

		cbStatus = new JComboBox();
		cbStatus.setBounds(10, 187, 178, 21);
		contentPane.add(cbStatus);

		JLabel lblNewLabel_2 = new JLabel("QUANTIDADE");
		lblNewLabel_2.setBounds(333, 158, 76, 13);
		contentPane.add(lblNewLabel_2);

		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(333, 188, 96, 19);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("COLEÇÃO DE :");
		lblNewLabel_4.setBounds(481, 158, 186, 13);
		contentPane.add(lblNewLabel_4);

		cbUserLog = new JComboBox();
		cbUserLog.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				carregaUserLog();
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbUserLog.setEnabled(false);
		cbUserLog.setBounds(481, 187, 471, 21);
		contentPane.add(cbUserLog);

		
		JButton btnCadastrarColecao = new JButton("Cadastrar");
		btnCadastrarColecao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvaColecao();
				preencheTabela();

			}
		});
		btnCadastrarColecao.setBounds(10, 237, 85, 21);
		contentPane.add(btnCadastrarColecao);

		JLabel lblOleo = new JLabel("COLEÇÃO");
		lblOleo.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOleo.setBounds(321, 282, 226, 56);
		contentPane.add(lblOleo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 383, 923, 302);
		contentPane.add(scrollPane);

		tbColecao = new JTable();
		scrollPane.setViewportView(tbColecao);
		tbColecao.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "ID COLE\u00C7\u00C3O", "MOEDA", "USU\u00C1RIO", "STATUS" }));

		tbColecao.getColumnModel().getColumn(0).setPreferredWidth(38);
		tbColecao.getColumnModel().getColumn(1).setPreferredWidth(644);
		tbColecao.getColumnModel().getColumn(2).setPreferredWidth(50);
		tbColecao.getColumnModel().getColumn(3).setPreferredWidth(50);

		
		preencheTabela();
		carregaStatus();
		carregaMoedas();
		
	}

	public void carregaMoedas() {

		cbMoedasRegistradas.removeAllItems();
		for (MoedaEntity m : moedaService.listar()) {
			cbMoedasRegistradas.addItem(m);

		}
	}

	public void carregaStatus() {
		cbStatus.removeAllItems();
		for (TipoTransacaoEntity t : tipoService.listar()) {

			cbStatus.addItem(t);

		}
	}

	public void carregaUserLog() {
		UsuarioEntity userLog = usuarioService.pesquisaUser(lblUser.getText());
		cbUserLog.addItem(userLog);
	}

	public void salvaColecao() {
		ColecaoEntity colecaoEntity = new ColecaoEntity();
		TipoTransacaoEntity tipo = (TipoTransacaoEntity) cbStatus.getSelectedItem();
		UsuarioEntity usuarioEntity = (UsuarioEntity) cbUserLog.getSelectedItem();
		MoedaEntity moedaEntity = (MoedaEntity) cbMoedasRegistradas.getSelectedItem();
		colecaoEntity.setQuantidade(txtQuantidade.getText());
		colecaoEntity.setMoedaEntity(moedaEntity);
		colecaoEntity.setUsuarioEntity(usuarioEntity);
		colecaoEntity.setTipoTransacaoEntity(tipo);
		colecaoService.salvar(colecaoEntity);
		JOptionPane.showMessageDialog(null,
				"MOEDA SALVA NA COLEÇÃO DE " + colecaoEntity.getUsuarioEntity() + " COM SUCESSO");
	}

	public void preencheTabela() {
		UsuarioEntity usuarioEntity = (UsuarioEntity) cbUserLog.getSelectedItem();
		List<ColecaoEntity> lista = colecaoService.listarColecaoLogado(usuarioEntity);
		DefaultTableModel modeloTabela = (DefaultTableModel) tbColecao.getModel();
		modeloTabela.setRowCount(0);
		for (ColecaoEntity colecao : lista) {
			modeloTabela.addRow(new Object[] { colecao.getIdColecao(), colecao.getMoedaEntity().getTitulo(),
					colecao.getUsuarioEntity(), colecao.getTipoTransacaoEntity() });
		}
	}

}
