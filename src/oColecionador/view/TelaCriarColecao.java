package oColecionador.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

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
import oColecionador.service.TipoService;
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
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCriarColecao extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblUser;
	private JTextField txtTitulo;
	private JComboBox cbUserLog;
	private JComboBox cbAdicionaMoedaColecao;
	private JTextField txtIdColecao;
	private JTextField txtIdMoeda;
	private JComboBox cbStatus;
	private JComboBox cbMoeda;

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
		setBounds(100, 100, 1666, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOColecionador = new JLabel("                    O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(270, -16, 523, 58);
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
		scrollPane.setBounds(819, 126, 711, 417);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resgataValorTabelaColecao();
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { "", null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "ID COLE\u00C7\u00C3O", "ID MOEDA", "TITULO DA COLE\u00C7\u00C3O", "MOEDA", "Status",
						"Usuario" }));
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(139);

		JLabel lblMoedas = new JLabel("COLEÇÃO");
		lblMoedas.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblMoedas.setBounds(488, 34, 204, 39);
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
		cbUserLog.setBounds(10, 442, 252, 21);
		contentPane.add(cbUserLog);

		JButton btnAtualizaTabela = new JButton("MOSTRAR MOEDAS DA COLEÇÃO");
		btnAtualizaTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				carregaColecaoUsuario();
			}

		});
		btnAtualizaTabela.setBounds(1293, 21, 237, 21);
		contentPane.add(btnAtualizaTabela);

		cbMoeda = new JComboBox();

		cbMoeda.setBounds(10, 197, 768, 21);
		contentPane.add(cbMoeda);

		cbStatus = new JComboBox();

		cbStatus.setBounds(10, 253, 170, 21);
		contentPane.add(cbStatus);

		JLabel lblNewLabel = new JLabel("Titulo da Coleção");
		lblNewLabel.setBounds(217, 228, 136, 13);
		contentPane.add(lblNewLabel);

		txtTitulo = new JTextField();
		;
		txtTitulo.setBounds(217, 254, 153, 19);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		JButton btnCriarColec = new JButton("CRIAR COLEÇÃO");
		btnCriarColec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				criarColecaoUsuario();

			}

		});
		btnCriarColec.setBounds(488, 253, 164, 21);
		contentPane.add(btnCriarColec);

		JLabel lblNewLabel_2 = new JLabel("MOEDAS CADASTRADAS");
		lblNewLabel_2.setBounds(10, 173, 198, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("STATUS");
		lblNewLabel_3.setBounds(10, 230, 111, 13);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("COLEÇÃO DE :");
		lblNewLabel_4.setBounds(22, 421, 186, 13);
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

		cbAdicionaMoedaColecao.setBounds(10, 512, 768, 21);
		contentPane.add(cbAdicionaMoedaColecao);

		JButton btnAdcMoedaColecao = new JButton("ADICIONAR MOEDAS A COLEÇÃO");
		btnAdcMoedaColecao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaMoedaColecao();

			}
		});
		btnAdcMoedaColecao.setBounds(306, 442, 229, 21);
		contentPane.add(btnAdcMoedaColecao);

		JLabel lblNewLabel_5 = new JLabel("QUER APRENDER A CADASTRAR UMA COLEÇÃO DE MOEDAS? CLIQUE AQUI!");
		lblNewLabel_5.setToolTipText("");
		lblNewLabel_5.setBounds(10, 82, 472, 14);
		contentPane.add(lblNewLabel_5);

		JButton btnAjuda = new JButton("AJUDA");
		btnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAjuda telaAjuda = new TelaAjuda();
				telaAjuda.setVisible(true);
				telaAjuda.setLocationRelativeTo(null);
			}
		});
		btnAjuda.setBounds(555, 78, 89, 23);
		contentPane.add(btnAjuda);

		JLabel lblNewLabel_4_1 = new JLabel("COLEÇÕES");
		lblNewLabel_4_1.setBounds(10, 489, 186, 13);
		contentPane.add(lblNewLabel_4_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 337, 799, 13);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(590, 83, 1, 82);
		contentPane.add(separator_1);

		JLabel lblNewLabel_6 = new JLabel("ESPAÇO DE CRIAR COLEÇÃO");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6.setBounds(306, 124, 186, 13);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_6_1 = new JLabel("ESPAÇO DE ADICIONAR MOEDA A COLEÇÃO");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6_1.setBounds(295, 360, 296, 13);
		contentPane.add(lblNewLabel_6_1);

		JLabel lblNewLabel_6_2 = new JLabel("VER MOEDAS DA COLEÇÃO");
		lblNewLabel_6_2.setBounds(1039, 25, 186, 13);
		contentPane.add(lblNewLabel_6_2);

		JLabel lblNewLabel_7 = new JLabel("ID MOEDA");
		lblNewLabel_7.setBounds(819, 78, 89, 13);
		contentPane.add(lblNewLabel_7);

		JButton btnRemoveMoeda = new JButton("Remover");
		btnRemoveMoeda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtém os valores dos campos de texto
				Long idMoeda = Long.parseLong(txtIdMoeda.getText());
				Long idColecao = Long.parseLong(txtIdColecao.getText());

				// Chama o método removerMoedaDaColecao com os valores dos campos de texto
				removerMoedaDaColecao(idColecao, idMoeda);
			}
		});
		btnRemoveMoeda.setBounds(947, 79, 117, 21);
		contentPane.add(btnRemoveMoeda);

		JLabel lblNewLabel_7_1 = new JLabel("ID COLEÇÃO");
		lblNewLabel_7_1.setBounds(819, 29, 89, 13);
		contentPane.add(lblNewLabel_7_1);

		txtIdColecao = new JTextField();
		txtIdColecao.setEnabled(false);
		txtIdColecao.setBounds(819, 46, 96, 19);
		contentPane.add(txtIdColecao);
		txtIdColecao.setColumns(10);

		txtIdMoeda = new JTextField();
		txtIdMoeda.setEnabled(false);
		txtIdMoeda.setText("");
		txtIdMoeda.setBounds(819, 97, 96, 19);
		contentPane.add(txtIdMoeda);
		txtIdMoeda.setColumns(10);

		carregaMoedas();
		carregaStatus();

	}

	public void resgataValorTabelaColecao() {

		// Recupera a linha selecionada
		int selectedRow = table.getSelectedRow();

		// Verifica se uma linha foi selecionada
		if (selectedRow != -1) {
			// Recupera os valores das colunas da linha selecionada
			String idColecao = table.getValueAt(selectedRow, 0).toString();
			String idMoeda = table.getValueAt(selectedRow, 1).toString();

			txtIdColecao.setText(idColecao);
			txtIdMoeda.setText(idMoeda);

		}
	}

	public void removerMoedaDaColecao(Long idColecao, Long idMoeda) {
		// Verificar se os campos de ID estão preenchidos corretamente
		idColecao = Long.parseLong(txtIdColecao.getText());
		idMoeda = Long.parseLong(txtIdMoeda.getText());
		if (idColecao == null || idMoeda == null) {
			JOptionPane.showMessageDialog(null, "Informe o ID da coleção e da moeda");
			return;
		}

		// Chamar o serviço para remover a moeda da coleção
		ColecaoService colecaoService = new ColecaoService();
		colecaoService.removerMoedaDaColecao(idColecao, idMoeda);

	}

	public void adicionaMoedaColecao() {

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

		ColecaoEntity colecaoEntity = colecaoService.presquisaId(colecaoId.getIdColecao());
		if (colecaoEntity != null) {
			List<ColecaoMoedaEntity> listaColecaoMoedas = colecaoEntity.getColecaoMoedaEntities();
			if (listaColecaoMoedas == null) {
				listaColecaoMoedas = new ArrayList<>();
				colecaoEntity.setColecaoMoedaEntities(listaColecaoMoedas);
			}

			listaColecaoMoedas.add(colecaoMoedaEntity);

			colecaoEntity.setUsuarioEntity(usuarioEntity);
			colecaoService.salvar(colecaoEntity);
			JOptionPane.showMessageDialog(null, "MOEDA Atualizada NA COLEÇÃO COM SUCESSO");
		}
	}

	public void criarColecaoUsuario() {

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

		List<ColecaoMoedaEntity> listaColecaoMoedas = colecaoEntity.getColecaoMoedaEntities();
		if (listaColecaoMoedas == null) {
			listaColecaoMoedas = new ArrayList<>();
			colecaoEntity.setColecaoMoedaEntities(listaColecaoMoedas);
		}

		listaColecaoMoedas.add(colecaoMoedaEntity);
		colecaoEntity.setTituloColecao(txtTitulo.getText());

		colecaoEntity.setUsuarioEntity(usuarioEntity);
		colecaoService.salvar(colecaoEntity);
		JOptionPane.showMessageDialog(null, "MOEDA SALVA NA COLEÇÃO COM SUCESSO");

		txtTitulo.setText("");
		UsuarioEntity usuarioEntity1 = (UsuarioEntity) cbUserLog.getSelectedItem();
		ColecaoService colecaoService1 = new ColecaoService();
		cbAdicionaMoedaColecao.removeAllItems();
		for (ColecaoEntity colecaoEntity1 : colecaoService1.listarColecaoLogado(usuarioEntity1)) {

			cbAdicionaMoedaColecao.addItem(colecaoEntity1);

		}
	}

	public void carregaMoedas() {

		MoedaService moedaService = new MoedaService();

		for (MoedaEntity moedaEntity : moedaService.listar()) {

			cbMoeda.addItem(moedaEntity);

		}
	}

	public void carregaStatus() {

		TipoService tipoService = new TipoService();

		for (TipoTransacaoEntity tipoTransacaoEntity : tipoService.listar()) {

			cbStatus.addItem(tipoTransacaoEntity);

		}
	}

	public void carregaColecaoUsuario() {

		ColecaoService colecaoService = new ColecaoService();
		ColecaoEntity colecao = (ColecaoEntity) cbAdicionaMoedaColecao.getSelectedItem();
		Long idColecao = colecao.getIdColecao(); // Obtém o ID da coleção selecionada

		// Chama o método pesquisaPeloId para obter a coleção correspondente
		ColecaoEntity colecaoSelecionada = colecaoService.presquisaIdColecao(idColecao);

		DefaultTableModel modeloTabela = (DefaultTableModel) table.getModel();
		modeloTabela.setRowCount(0);

		if (colecaoSelecionada != null) {
			List<ColecaoMoedaEntity> moedas = colecaoService.presquisaMoedasColeção(colecaoSelecionada.getIdColecao());

			for (ColecaoMoedaEntity moeda : moedas) {
				modeloTabela.addRow(new Object[] { colecaoSelecionada.getIdColecao(),
						moeda.getColecaoMoedaID().getMoedaEntity().getIdMoeda(), colecaoSelecionada.getTituloColecao(),
						moeda.getColecaoMoedaID().getMoedaEntity().getTitulo(),
						moeda.getTipoTransacaoEntity().getNome(), colecaoSelecionada.getUsuarioEntity().getNome() });
			}
		} else {

		}
	}

}