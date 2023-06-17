package oColecionador.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
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
import javax.swing.text.MaskFormatter;

import oColecionador.entity.BordasEntity;
import oColecionador.entity.ColecaoEntity;
import oColecionador.entity.ColecaoMoedaEntity;
import oColecionador.entity.ColecaoMoedaId;
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
import oColecionador.service.ColecaoService;
import oColecionador.service.MoedaService;
import oColecionador.util.FormataData;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TelaCriarColecao extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblUser;
	private JTextField txtTitulo;
	private JComboBox cbUserLog;
	private JComboBox cbAdicionaMoedaColecao;

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
		lblOColecionador.setBounds(217, -20, 523, 58);
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
		scrollPane.setBounds(10, 409, 949, 97);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "ID", "titulo", "moedas", "Status", "Usuario" }));
		table.getColumnModel().getColumn(4).setPreferredWidth(139);

		JLabel lblMoedas = new JLabel("COLEÇÃO");
		lblMoedas.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblMoedas.setBounds(398, 360, 204, 39);
		contentPane.add(lblMoedas);

		cbUserLog = new JComboBox();
		cbUserLog.setEnabled(false);
		cbUserLog.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				UsuarioRepository repository = new UsuarioRepository();
				UsuarioEntity userLog = repository.pesquisaPeloUser(lblUser.getText());
				cbUserLog.addItem(userLog);

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbUserLog.setBounds(10, 316, 252, 21);
		contentPane.add(cbUserLog);

		JButton btnAtualizaTabela = new JButton("ATUALIZA COLEÇÃO");
		btnAtualizaTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColecaoService colecaoService = new ColecaoService();
				ColecaoEntity colecao = (ColecaoEntity) cbAdicionaMoedaColecao.getSelectedItem();
				Long idColecao = colecao.getIdColecao(); // Obtém o ID da coleção selecionada

				// Chama o método pesquisaPeloId para obter a coleção correspondente
				ColecaoEntity colecaoSelecionada = colecaoService.presquisaIdColecao(idColecao);

				DefaultTableModel modeloTabela = (DefaultTableModel) table.getModel();
				modeloTabela.setRowCount(0);

				if (colecaoSelecionada != null) {
					List<ColecaoMoedaEntity> moedas = colecaoService
							.presquisaMoedasColeção(colecaoSelecionada.getIdColecao());

					for (ColecaoMoedaEntity moeda : moedas) {
						modeloTabela.addRow(
								new Object[] { colecaoSelecionada.getIdColecao(), colecaoSelecionada.getTituloColecao(),
										moeda.toString(), moeda.getTipoTransacaoEntity().getNome(),
										colecaoSelecionada.getUsuarioEntity().getNome() });
					}
				} else {
					// A coleção não foi encontrada pelo ID
				}

			}

		});
		btnAtualizaTabela.setBounds(789, 378, 170, 21);
		contentPane.add(btnAtualizaTabela);

		JComboBox cbMoeda = new JComboBox();
		cbMoeda.addAncestorListener(new AncestorListener() {

			public void ancestorAdded(AncestorEvent event) {
				MoedaRepository mdao = new MoedaRepository();

				for (MoedaEntity p : mdao.listar()) {

					cbMoeda.addItem(p);

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbMoeda.setBounds(10, 197, 845, 21);
		contentPane.add(cbMoeda);

		JComboBox cbStatus = new JComboBox();
		cbStatus.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				TipoRepository tdao = new TipoRepository();

				for (TipoTransacaoEntity p : tdao.listar()) {

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

		JLabel lblNewLabel = new JLabel("Titulo da Coleção");
		lblNewLabel.setBounds(190, 124, 136, 13);
		contentPane.add(lblNewLabel);

		txtTitulo = new JTextField();
		;
		txtTitulo.setBounds(190, 148, 153, 19);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		JButton btnCriarColec = new JButton("Criar Coleção");
		btnCriarColec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ColecaoService colecaoService = new ColecaoService();
				ColecaoEntity colecaoEntity = new ColecaoEntity();
				ColecaoMoedaId colecaoMoedaId = new ColecaoMoedaId();
				ColecaoMoedaEntity colecaoMoedaEntity = new ColecaoMoedaEntity();
				MoedaEntity moedaEntity = (MoedaEntity) cbMoeda.getSelectedItem();
				UsuarioEntity usuarioEntity = (UsuarioEntity) cbUserLog.getSelectedItem();
				TipoTransacaoEntity tipoTransacaoEntity = (TipoTransacaoEntity) cbStatus.getSelectedItem();
				colecaoMoedaId.setColecaoEntity(colecaoEntity);
				colecaoMoedaId.setMoedaEntity(moedaEntity);

				colecaoMoedaEntity.setColecaoMoedaID(colecaoMoedaId);
				colecaoMoedaEntity.setTipoTransacaoEntity(tipoTransacaoEntity);
				// colecaoMoedaEntity.setUsuarioEntity(usuarioEntity);;

				List<ColecaoMoedaEntity> listaColecaoMoedas = colecaoEntity.getColecaoMoedaEntities();
				if (listaColecaoMoedas == null) {
					listaColecaoMoedas = new ArrayList<>();
					colecaoEntity.setColecaoMoedaEntities(listaColecaoMoedas);
				}

				listaColecaoMoedas.add(colecaoMoedaEntity);
				colecaoEntity.setTituloColecao(txtTitulo.getText());
				// colecaoEntity.setTipoTransacaoEntity(tipoTransacaoEntity);

				colecaoEntity.setUsuarioEntity(usuarioEntity);
				colecaoService.salvar(colecaoEntity);
				JOptionPane.showMessageDialog(null, "MOEDA SALVA NA COLEÇÃO COM SUCESSO");
				// preencheLIstaColecao();
				txtTitulo.setText("");
				UsuarioEntity usuarioEntity1 = (UsuarioEntity) cbUserLog.getSelectedItem();
				ColecaoService colecaoService1 = new ColecaoService();

				for (ColecaoEntity colecaoEntity1 : colecaoService1.listarColecaoLogado(usuarioEntity1)) {

					cbAdicionaMoedaColecao.addItem(colecaoEntity1);

				}

			}

		});
		btnCriarColec.setBounds(379, 147, 164, 21);
		contentPane.add(btnCriarColec);

		JLabel lblNewLabel_2 = new JLabel("MOEDAS CADASTRADAS");
		lblNewLabel_2.setBounds(10, 173, 198, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("STATUS");
		lblNewLabel_3.setBounds(10, 124, 111, 13);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("COLEÇÃO DE :");
		lblNewLabel_4.setBounds(10, 292, 186, 13);
		contentPane.add(lblNewLabel_4);

		cbAdicionaMoedaColecao = new JComboBox();
		cbAdicionaMoedaColecao.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				UsuarioEntity usuarioEntity = (UsuarioEntity) cbUserLog.getSelectedItem();
				ColecaoService colecaoService = new ColecaoService();

				for (ColecaoEntity colecaoEntity : colecaoService.listarColecaoLogado(usuarioEntity)) {

					cbAdicionaMoedaColecao.addItem(colecaoEntity);

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbAdicionaMoedaColecao.setBounds(10, 262, 845, 21);
		contentPane.add(cbAdicionaMoedaColecao);

		JButton btnAdcMoedaColecao = new JButton("Adiciona Moeda Coleção");
		btnAdcMoedaColecao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColecaoService colecaoService = new ColecaoService();
				ColecaoMoedaId colecaoMoedaId = new ColecaoMoedaId();
				ColecaoMoedaEntity colecaoMoedaEntity = new ColecaoMoedaEntity();
				MoedaEntity moedaEntity = (MoedaEntity) cbMoeda.getSelectedItem();
				UsuarioEntity usuarioEntity = (UsuarioEntity) cbUserLog.getSelectedItem();
				ColecaoEntity colecaoId = (ColecaoEntity) cbAdicionaMoedaColecao.getSelectedItem();
				TipoTransacaoEntity tipoTransacaoEntity = (TipoTransacaoEntity) cbStatus.getSelectedItem();

				colecaoMoedaId.setColecaoEntity(colecaoId);
				colecaoMoedaId.setMoedaEntity(moedaEntity);

				colecaoMoedaEntity.setColecaoMoedaID(colecaoMoedaId);
				colecaoMoedaEntity.setTipoTransacaoEntity(tipoTransacaoEntity);
				// colecaoMoedaEntity.setUsuarioEntity(usuarioEntity);

				ColecaoEntity colecaoEntity = colecaoService.presquisaId(colecaoId.getIdColecao());
				if (colecaoEntity != null) {
					List<ColecaoMoedaEntity> listaColecaoMoedas = colecaoEntity.getColecaoMoedaEntities();
					if (listaColecaoMoedas == null) {
						listaColecaoMoedas = new ArrayList<>();
						colecaoEntity.setColecaoMoedaEntities(listaColecaoMoedas);
					}

					listaColecaoMoedas.add(colecaoMoedaEntity);

					// colecaoEntity.setTipoTransacaoEntity(tipoTransacaoEntity);
					colecaoEntity.setUsuarioEntity(usuarioEntity);
					colecaoService.salvar(colecaoEntity);
					JOptionPane.showMessageDialog(null, "MOEDA Atualizada NA COLEÇÃO COM SUCESSO");
				}

			}
		});
		btnAdcMoedaColecao.setBounds(10, 372, 229, 21);
		contentPane.add(btnAdcMoedaColecao);

		JLabel lblNewLabel_5 = new JLabel(
				"QUER APRENDER CADASTRA UMA COLEÇÃO E ADICIONAR MOEDAS NELA CLICK AQUI NO BOTÃO AJUDA !!!");
		lblNewLabel_5.setToolTipText("");
		lblNewLabel_5.setBounds(10, 68, 730, 14);
		contentPane.add(lblNewLabel_5);

		JButton btnAjuda = new JButton("AJUDA");
		btnAjuda.setBounds(766, 64, 89, 23);
		contentPane.add(btnAjuda);

		JLabel lblNewLabel_4_1 = new JLabel("COLEÇÕES");
		lblNewLabel_4_1.setBounds(10, 238, 186, 13);
		contentPane.add(lblNewLabel_4_1);

	}
}