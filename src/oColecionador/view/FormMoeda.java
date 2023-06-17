package oColecionador.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.ToolTipManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import oColecionador.entity.BordasEntity;

import oColecionador.entity.MaterialEntity;

import oColecionador.entity.MoedaEntity;

import oColecionador.entity.PaisEntity;
import oColecionador.repository.BordasRepository;
import oColecionador.repository.MaterialRepository;
import oColecionador.repository.MoedaRepository;
import oColecionador.repository.PaisRepository;
import oColecionador.service.BordasService;
import oColecionador.service.MaterialService;
import oColecionador.service.MoedaService;
import oColecionador.service.PaisService;
import oColecionador.util.FormataData;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class FormMoeda extends JFrame {

	private JPanel cbMoedasCadastro;
	private JTextField txtTitulo;
	private JTextField txtAnoCom;
	private JTextField txtValorMoneta;
	private JTextField txtEspessura;
	private JTextField txtPeso;
	private JTextField txtDiametro;
	private JTable table;
	private JComboBox cbMateriais;
	private JComboBox cbBordas;
	private JComboBox cbPais;
	private DefaultComboBoxModel<BordasEntity> cbRecebeBordasModel;
	private DefaultComboBoxModel<MaterialEntity> cbRecebemateriaisModel;
	private JTextField txtCodCatalogo;
	private JTextField txtIdmoeda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMoeda frame = new FormMoeda();
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
	public FormMoeda() {
		cbRecebeBordasModel = new DefaultComboBoxModel<>();
		cbRecebeBordasModel.getSelectedItem();

		cbRecebemateriaisModel = new DefaultComboBoxModel<>();
		cbRecebemateriaisModel.getSelectedItem();
		setBounds(100, 100, 1615, 792);
		cbMoedasCadastro = new JPanel();
		cbMoedasCadastro.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(cbMoedasCadastro);
		cbMoedasCadastro.setLayout(null);

		JLabel lblOColecionador_1 = new JLabel("    O COLECIONADOR");
		lblOColecionador_1.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador_1.setBounds(643, 0, 371, 48);
		cbMoedasCadastro.add(lblOColecionador_1);

		JLabel lblCadastroMoedas = new JLabel("       CADASTRO MOEDAS");
		lblCadastroMoedas.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblCadastroMoedas.setBounds(617, 39, 417, 48);
		cbMoedasCadastro.add(lblCadastroMoedas);

		JLabel lblNewLabel_1_1_6_2_6 = new JLabel("Moeda selecionada para Edição/Exlusão");
		lblNewLabel_1_1_6_2_6.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_6.setBounds(10, 97, 300, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_6);

		JLabel lblNewLabel_1_1_6_2 = new JLabel("Titulo (1)*");
		lblNewLabel_1_1_6_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2.setBounds(10, 181, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 216, 229, 19);
		cbMoedasCadastro.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblNewLabel_1_1_6_2_1 = new JLabel("Ano comemorativo (3)*");
		lblNewLabel_1_1_6_2_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_1.setBounds(10, 252, 177, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_1);

		// Crie um objeto MaskFormatter com o padrão desejado
		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_'); // Caractere para preenchimento opcional
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtAnoCom = new JFormattedTextField(mascaraData);
		txtAnoCom.setBounds(10, 285, 116, 19);
		cbMoedasCadastro.add(txtAnoCom);
		txtAnoCom.setColumns(10);

		JLabel lblNewLabel_1_1_6_2_2 = new JLabel("Valor monetario (4)");
		lblNewLabel_1_1_6_2_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_2.setBounds(208, 252, 139, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_2);
		// Crie um objeto MaskFormatter com o padrão desejado
		MaskFormatter mascaravalor = null;
		try {
			mascaravalor = new MaskFormatter("#,##");

		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtValorMoneta = new JFormattedTextField(mascaravalor);
		txtValorMoneta.setBounds(206, 285, 104, 19);
		cbMoedasCadastro.add(txtValorMoneta);
		txtValorMoneta.setColumns(10);

		JLabel lblNewLabel_1_1_6_2_5 = new JLabel("Espessura (5)");
		lblNewLabel_1_1_6_2_5.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_5.setBounds(357, 252, 158, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_5);

		txtEspessura = new JFormattedTextField(mascaravalor);
		txtEspessura.setBounds(357, 285, 74, 19);
		cbMoedasCadastro.add(txtEspessura);
		txtEspessura.setColumns(10);

		JLabel lblNewLabel_1_1_6_2_3 = new JLabel("Peso (6)");
		lblNewLabel_1_1_6_2_3.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_3.setBounds(10, 335, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_3);

		txtPeso = new JFormattedTextField(mascaravalor);
		txtPeso.setBounds(10, 372, 74, 19);
		cbMoedasCadastro.add(txtPeso);
		txtPeso.setColumns(10);

		JLabel lblNewLabel_1_1_6_2_4 = new JLabel("Diametro (7)");
		lblNewLabel_1_1_6_2_4.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_4.setBounds(123, 335, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_4);

		txtDiametro = new JFormattedTextField(mascaravalor);
		txtDiametro.setBounds(123, 372, 74, 19);
		cbMoedasCadastro.add(txtDiametro);
		txtDiametro.setColumns(10);

		JLabel lblNewLabel_1_1_6_2_5_1 = new JLabel("Pais (8)");
		lblNewLabel_1_1_6_2_5_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_5_1.setBounds(242, 335, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_5_1);

		cbPais = new JComboBox();
		cbPais.setBounds(242, 371, 152, 21);
		cbMoedasCadastro.add(cbPais);

		JLabel lblNewLabel_1_1_6_2_5_2 = new JLabel("Bordas (9)");
		lblNewLabel_1_1_6_2_5_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_5_2.setBounds(10, 422, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_5_2);

		JComboBox<BordasEntity> cbRecebeBordas = new JComboBox<>(cbRecebeBordasModel);
		cbRecebeBordas.setBounds(171, 455, 104, 21);
		cbMoedasCadastro.add(cbRecebeBordas);

		JLabel lblNewLabel_1_1_6_2_5_3 = new JLabel("Materiais (10)");
		lblNewLabel_1_1_6_2_5_3.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_5_3.setBounds(10, 510, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_5_3);

		JComboBox<MaterialEntity> cbRecebemateriais = new JComboBox<>(cbRecebemateriaisModel);
		cbRecebemateriais.setBounds(171, 543, 104, 21);
		cbMoedasCadastro.add(cbRecebemateriais);

		JButton btnCadastrarMoeda = new JButton("Salvar");
		btnCadastrarMoeda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarMoeda();
					preencheLIstaMoedas();
					// carregaMoedas();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnCadastrarMoeda.setBounds(10, 634, 85, 21);
		cbMoedasCadastro.add(btnCadastrarMoeda);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(488, 203, 1012, 542);
		cbMoedasCadastro.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				resgataValorTabela();
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, "", null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "ID MOEDA", "Titulo", "Codigo", "Data Comemorativa", "Valor", "Espessura", "Peso",
						"Diametro", "Pais", "Borda", "Material" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(147);
		table.getColumnModel().getColumn(2).setPreferredWidth(57);
		table.getColumnModel().getColumn(4).setPreferredWidth(38);
		table.getColumnModel().getColumn(5).setPreferredWidth(47);
		table.getColumnModel().getColumn(6).setPreferredWidth(57);
		table.getColumnModel().getColumn(7).setPreferredWidth(52);
		table.getColumnModel().getColumn(9).setPreferredWidth(189);
		table.getColumnModel().getColumn(10).setPreferredWidth(156);

		JLabel lblNewLabel_1_1_6_2_7_1 = new JLabel(
				"MOEDAS CADASTRADAS QUE SÃO USADAS QUANDO PRECISAR EDIDAR, CLICANDO NA LINHA QUE PRECISA EDITAR RETORNANDO OS VALORES AO FORME");
		lblNewLabel_1_1_6_2_7_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_7_1.setBounds(488, 151, 1214, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_7_1);

		cbBordas = new JComboBox();
		cbBordas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BordasEntity bordas = (BordasEntity) cbBordas.getSelectedItem();

				boolean bordaRepetida = false;

				// Verifica se a borda já foi adicionada
				for (int i = 0; i < cbRecebeBordasModel.getSize(); i++) {
					if (cbRecebeBordasModel.getElementAt(i).equals(bordas)) {
						bordaRepetida = true;
						break;
					}
				}

				if (!bordaRepetida) {
					cbRecebeBordasModel.addElement(bordas);
				} else {
					// Exibe uma mensagem de erro ou toma alguma ação adequada
					JOptionPane.showMessageDialog(null, "Essa Borda já foi adicionada!");
				}
			}

		});
		cbBordas.setBounds(10, 455, 104, 21);
		cbMoedasCadastro.add(cbBordas);

		cbMateriais = new JComboBox();
		cbMateriais.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MaterialEntity material = (MaterialEntity) cbMateriais.getSelectedItem();
				boolean bordaRepetida = false;

				// Verifica se a borda já foi adicionada
				for (int i = 0; i < cbRecebemateriaisModel.getSize(); i++) {
					if (cbRecebemateriaisModel.getElementAt(i).equals(material)) {
						bordaRepetida = true;
						break;
					}
				}

				if (!bordaRepetida) {
					cbRecebemateriaisModel.addElement(material);
				} else {
					// Exibe uma mensagem de erro ou toma alguma ação adequada
					JOptionPane.showMessageDialog(null, "Esse Material já foi adicionada!");
				}
			}

		});
		cbMateriais.setBounds(10, 543, 104, 21);
		cbMoedasCadastro.add(cbMateriais);

		JButton btnRemoveBordas = new JButton("Remover");
		btnRemoveBordas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				BordasEntity bordas = (BordasEntity) cbRecebeBordasModel.getSelectedItem();
				cbRecebeBordasModel.removeElement(bordas);
			}
		});
		btnRemoveBordas.setBounds(327, 455, 85, 21);
		cbMoedasCadastro.add(btnRemoveBordas);

		JButton btnRemoverMate = new JButton("Remover");
		btnRemoverMate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterialEntity material = (MaterialEntity) cbRecebemateriaisModel.getSelectedItem();
				cbRecebemateriaisModel.removeElement(material);
			}
		});
		btnRemoverMate.setBounds(327, 543, 85, 21);
		cbMoedasCadastro.add(btnRemoverMate);

		JButton btnEditarMoeda = new JButton("Editar");
		btnEditarMoeda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					editarMoeda();
					preencheLIstaMoedas();
					// carregaMoedas();
					limpaCbRecebeBordas();
					limpaCbRecebeMateriais();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnEditarMoeda.setBounds(210, 634, 85, 21);
		cbMoedasCadastro.add(btnEditarMoeda);

		JLabel lblNewLabel_1_1_6_2_9 = new JLabel("Codigo de catalogo (2)*");
		lblNewLabel_1_1_6_2_9.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_9.setBounds(267, 181, 197, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_9);

		txtCodCatalogo = new JTextField();
		txtCodCatalogo.setBounds(262, 216, 132, 19);
		cbMoedasCadastro.add(txtCodCatalogo);
		txtCodCatalogo.setColumns(10);

		JButton btnDeletarMoeda = new JButton("Deletar");
		btnDeletarMoeda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarMoeda();
				preencheLIstaMoedas();
				// carregaMoedas();
			}
		});
		btnDeletarMoeda.setBounds(102, 634, 85, 21);
		cbMoedasCadastro.add(btnDeletarMoeda);

		JLabel lblNewLabel_1_1_6_2_5_2_2 = new JLabel("Recebe Bordas *");
		lblNewLabel_1_1_6_2_5_2_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_5_2_2.setBounds(171, 422, 187, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_5_2_2);

		JLabel lblNewLabel_1_1_6_2_5_2_2_1 = new JLabel("Recebe Material *");
		lblNewLabel_1_1_6_2_5_2_2_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_5_2_2_1.setBounds(171, 517, 187, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_5_2_2_1);

		JLabel lblNewLabel = new JLabel("-->");
		lblNewLabel.setBounds(131, 459, 45, 13);
		cbMoedasCadastro.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("-->");
		lblNewLabel_1.setBounds(123, 547, 45, 13);
		cbMoedasCadastro.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("*LEIA ME");

		lblNewLabel_2.setToolTipText(
				"*PARA ADICIONAR BORDAS OU MATERIAIS NO CAMPO RECEBE BORDAS E \r\nMATERIAIS BASTA ESCOLHER UMA OPÇÃO "
						+ "\r\nAO LADO ESQUERDO DO RECEBE BORDAS E CLICAR, ELA VAI PARA O CAMPO RECEBE O OBJETO ESCOLHIDO");

		lblNewLabel_2.setBounds(10, 401, 836, 13);
		cbMoedasCadastro.add(lblNewLabel_2);

		txtIdmoeda = new JTextField();
		txtIdmoeda.setEnabled(false);
		txtIdmoeda.setEditable(false);
		txtIdmoeda.setBounds(10, 130, 96, 19);
		cbMoedasCadastro.add(txtIdmoeda);
		txtIdmoeda.setColumns(10);

		JButton btnLimpaCampos = new JButton("Limpar Campos");
		btnLimpaCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaTodoscampos();
			}
		});
		btnLimpaCampos.setBounds(336, 634, 142, 21);
		cbMoedasCadastro.add(btnLimpaCampos);

		// carregaMoedas();
		preencheLIstaMoedas();
		carregaMaterial();
		carregaBordas();
		carregaPais();
		limpaCbRecebeBordas();
		limpaCbRecebeMateriais();
	}

	public void preencheLIstaMoedas() {

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

	/*
	 * public void carregaMoedas() {
	 * 
	 * MoedaService moedaService = new MoedaService(); for (MoedaEntity moedaEntity
	 * : moedaService.listar()) {
	 * 
	 * cbMoedasCad.addItem(moedaEntity);
	 * 
	 * } }
	 */

	public void cadastrarMoeda() throws ParseException {
		MoedaEntity moeda = new MoedaEntity();
		MoedaService moedaService = new MoedaService();

		List<MaterialEntity> materiais = new ArrayList<>();
		for (int i = 0; i < cbRecebemateriaisModel.getSize(); i++) {
			MaterialEntity material = cbRecebemateriaisModel.getElementAt(i);
			materiais.add(material);
		}

		List<BordasEntity> bordas = new ArrayList<>();
		for (int i = 0; i < cbRecebeBordasModel.getSize(); i++) {
			BordasEntity borda = cbRecebeBordasModel.getElementAt(i);
			bordas.add(borda);
		}

		PaisEntity pais = (PaisEntity) cbPais.getSelectedItem();

		String nomeTitulo = txtTitulo.getText().trim();
		// Verifica Titulo se o campo está vazio
		if (nomeTitulo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'Titulo (1)' não pode estar vazio.");
			return;
		}

		if (nomeTitulo.isEmpty() || nomeTitulo.isBlank() || nomeTitulo.matches("\\s+\\w+")) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Titulo (1)' não pode estar vazio ou conter apenas espaços em branco.");
			return;
		}

		// Verifica se o campo Titulo está vazio, contém apenas espaços em branco ou
		// consiste
		// em espaços em branco seguidos de uma letra
		String nomeSemEspacos = nomeTitulo.trim();
		if (nomeSemEspacos.isEmpty() || nomeSemEspacos.length() == 1) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Titulo (1)' não pode estar vazio ou conter apenas espaços em branco.");
			return;
		}
		// Verifica o tamanho mínimo do Titulo
		if (nomeSemEspacos.length() < 4) {
			JOptionPane.showMessageDialog(null, "O campo 'Titulo (1)' deve ter no mínimo 4 caracteres.");
			return;
		}

		// Verifica o tamanho máximo do Titulo
		if (nomeSemEspacos.length() >= 30) {
			JOptionPane.showMessageDialog(null, "O campo 'Titulo (1)' deve ter no máximo 30 caracteres.");
			return;
		}

		moeda.setTitulo(txtTitulo.getText());

		String nomeCodcatalogo = txtCodCatalogo.getText().trim();
		// Verifica se o campo Codigo está vazio
		if (nomeCodcatalogo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'Codigo de catalogo (2)' não pode estar vazio.");
			return;
		}

		// Verifica o tamanho máximo do Codigo
		if (nomeCodcatalogo.length() > 7) {
			JOptionPane.showMessageDialog(null, "O campo 'Codigo de catalogo (2)' deve ter no máximo 6 caracteres.");
			return;
		}
		moeda.setCodigoCatalogo(txtCodCatalogo.getText());
		String dataComemorativa = txtAnoCom.getText();

		// Verifica se a data comemorativa é válida
		if (!validarDataComemorativa(dataComemorativa)) {
			JOptionPane.showMessageDialog(null, "Data comemorativa inválida!");
			txtAnoCom.setText("");
			return; // Sai do método caso a data seja inválida
		}
		Date data = FormataData.parseStringToDate(txtAnoCom.getText());

		// Verifica se o campo está vazio
		if (data == null) {
			JOptionPane.showMessageDialog(null, "O campo 'Data Comemorativa (3)' não pode estar vazio.");
			return;
		}

		moeda.setAno(data);
		moeda.setValor(txtValorMoneta.getText());
		moeda.setDiametro(txtDiametro.getText());
		moeda.setEspessura(txtEspessura.getText());
		moeda.setPeso(txtPeso.getText());
		if (bordas.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Bordas (9)' Não pode estar vazio, escolha um Material na lista de bordas ao lado esquedo.");
			return;
		}
		moeda.setBordas(bordas);

		if (materiais.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Materiais (10)' Não pode estar vazio, escolha um Material na lista de materiais ao lado esquedo.");
			return;
		}
		moeda.setMateriais(materiais);

		moeda.setPaisEntity(pais);

		moedaService.salvar(moeda);

		preencheLIstaMoedas();

		// limpeza dos campos

		limpaTodoscampos();
	}

	public void carregaMaterial() {
		MaterialService materialService = new MaterialService();
		cbMateriais.removeAllItems();
		for (MaterialEntity m : materialService.listar()) {
			cbMateriais.addItem(m);
		}
	}

	public void carregaBordas() {
		BordasService bordasService = new BordasService();
		cbBordas.removeAllItems();
		for (BordasEntity m : bordasService.listar()) {

			cbBordas.addItem(m);

		}
	}

	public void carregaPais() {
		PaisService paisService = new PaisService();
		cbPais.removeAllItems();
		for (PaisEntity p : paisService.listar()) {

			cbPais.addItem(p);

		}
	}

	public void limpaCbRecebeBordas() {
		cbRecebeBordasModel.removeAllElements();

	}

	public void limpaCbRecebeMateriais() {
		cbRecebemateriaisModel.removeAllElements();

	}

	public void editarMoeda() throws ParseException {

		MoedaEntity moeda = new MoedaEntity();
		MoedaService moedaService = new MoedaService();
		List<MaterialEntity> materiais = new ArrayList<>();
		for (int i = 0; i < cbRecebemateriaisModel.getSize(); i++) {
			MaterialEntity material = cbRecebemateriaisModel.getElementAt(i);
			materiais.add(material);
		}

		List<BordasEntity> bordas = new ArrayList<>();
		for (int i = 0; i < cbRecebeBordasModel.getSize(); i++) {
			BordasEntity borda = cbRecebeBordasModel.getElementAt(i);
			bordas.add(borda);
		}

		PaisEntity pais = (PaisEntity) cbPais.getSelectedItem();
		// MoedaEntity moedaEntity = (MoedaEntity) cbMoedasCad.getSelectedItem();

		// moeda.setIdMoeda(moedaEntity.getIdMoeda());
		moeda.setIdMoeda(Long.parseLong(txtIdmoeda.getText()));
		String nomeTitulo = txtTitulo.getText().trim();
		// Verifica se o campo está vazio
		if (nomeTitulo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'Moeda (1)' não pode estar vazio.");
			return;
		}

		if (nomeTitulo.isEmpty() || nomeTitulo.isBlank() || nomeTitulo.matches("\\s+\\w+")) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Moeda (1)' não pode estar vazio ou conter apenas espaços em branco.");
			return;
		}

		// Verifica se o campo está vazio, contém apenas espaços em branco ou consiste
		// em espaços em branco seguidos de uma letra
		String nomeSemEspacos = nomeTitulo.trim();
		if (nomeSemEspacos.isEmpty() || nomeSemEspacos.length() == 1) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Moeda (1)' não pode estar vazio ou conter apenas espaços em branco.");
			return;
		}
		// Verifica o tamanho mínimo do nome
		if (nomeSemEspacos.length() < 4) {
			JOptionPane.showMessageDialog(null, "O campo 'Moeda (1)' deve ter no mínimo 4 caracteres.");
			return;
		}

		// Verifica o tamanho máximo do nome
		if (nomeSemEspacos.length() >= 30) {
			JOptionPane.showMessageDialog(null, "O campo 'Moeda (1)' deve ter no máximo 30 caracteres.");
			return;
		}

		moeda.setTitulo(txtTitulo.getText());

		String nomeCodcatalogo = txtCodCatalogo.getText().trim();
		// Verifica se o campo está vazio
		if (nomeCodcatalogo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'Codigo de catalogo (2)' não pode estar vazio.");
			return;
		}
		if (nomeCodcatalogo.length() < 4) {
			JOptionPane.showMessageDialog(null, "O campo 'Codigo de catalogo (2)' deve ter no maximo 6 caracteres.");
			return;
		}
		if (nomeCodcatalogo.length() > 7) {
			JOptionPane.showMessageDialog(null, "O campo 'Codigo de catalogo (2)' deve ter no mínimo 4 caracteres.");
			return;
		}

		moeda.setCodigoCatalogo(txtCodCatalogo.getText());
		Date data = FormataData.parseStringToDate(txtAnoCom.getText());

		// Verifica se o campo está vazio
		if (data == null) {
			JOptionPane.showMessageDialog(null, "O campo 'Data Comemorativa (3)' não pode estar vazio.");
			return;
		}

		moeda.setAno(data);
		moeda.setValor(txtValorMoneta.getText());
		moeda.setDiametro(txtDiametro.getText());
		moeda.setEspessura(txtEspessura.getText());
		moeda.setPeso(txtPeso.getText());
		if (bordas.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Bordas (9)' Não pode estar vazio, escolha um Material na lista de bordas ao lado esquedo.");
			return;
		}
		moeda.setBordas(bordas);

		if (materiais.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Materiais (10)' Não pode estar vazio, escolha um Material na lista de materiais ao lado esquedo.");
			return;
		}
		moeda.setMateriais(materiais);

		moeda.setPaisEntity(pais);

		moedaService.salvar(moeda);

		// cbMoedasCad.removeAll();

		/*
		 * for (MoedaEntity moedaEnti : moedaService.listar()) {
		 * 
		 * cbMoedasCad.addItem(moedaEnti);
		 * 
		 * }
		 */
		// limpeza dos campos
		limpaTodoscampos();
	}

	public void deletarMoeda() {
		MoedaService service = new MoedaService();
		// MoedaEntity moeda1 = (MoedaEntity) cbMoedasCad.getSelectedItem();
		MoedaEntity moeda = new MoedaEntity();

		if (txtIdmoeda.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "NÃO EXISTE MOEDA PARA DELETAR", "Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			int escolha = JOptionPane.showConfirmDialog(null,
					"Deseja realizar o delete da moeda de ID : " + txtIdmoeda.getText() + " que você escolheu !!", "  ",
					JOptionPane.YES_NO_OPTION);
			if (escolha == JOptionPane.YES_OPTION) {
				moeda.setIdMoeda(Long.parseLong(txtIdmoeda.getText()));
				service.remover(moeda.getIdMoeda());
				JOptionPane.showMessageDialog(null, "MOEDA DELATADA COM SUCESSO !!");

			}
		}
		limpaTodoscampos();
	}

	public void resgataValorTabela() {

		// Recupera a linha selecionada
		int selectedRow = table.getSelectedRow();

		// Verifica se uma linha foi selecionada
		if (selectedRow != -1) {
			// Recupera os valores das colunas da linha selecionada
			String idMoeda = table.getValueAt(selectedRow, 0).toString();
			String titulo = table.getValueAt(selectedRow, 1).toString();
			String codigo = table.getValueAt(selectedRow, 2).toString();
			String anoComemorativo = table.getValueAt(selectedRow, 3).toString();
			String valor = table.getValueAt(selectedRow, 4).toString();
			String espessura = table.getValueAt(selectedRow, 5).toString();
			String peso = table.getValueAt(selectedRow, 6).toString();
			String diametro = table.getValueAt(selectedRow, 7).toString();
			// Recupera os valores relacionados às listas

			String pais = table.getValueAt(selectedRow, 8).toString();
			String recebeborda = table.getValueAt(selectedRow, 9).toString();
			String material = table.getValueAt(selectedRow, 10).toString();
			// Preenche os campos de texto com os valores recuperados
			txtIdmoeda.setText(idMoeda);
			txtTitulo.setText(titulo);
			txtCodCatalogo.setText(codigo);
			txtAnoCom.setText(anoComemorativo);
			txtValorMoneta.setText(valor);
			txtEspessura.setText(espessura);
			txtPeso.setText(peso);
			txtDiametro.setText(diametro);
			// Define os valores selecionados nos JComboBox

			cbPais.setSelectedItem(pais);
			cbRecebeBordasModel.setSelectedItem(recebeborda);
			cbRecebemateriaisModel.setSelectedItem(material);

		}
	}

	private boolean camposVazios() {
		BordasEntity bordas = (BordasEntity) cbBordas.getSelectedItem();
		MaterialEntity material = (MaterialEntity) cbMateriais.getSelectedItem();

		return (bordas == null || material == null);
	}

	private boolean validarDataComemorativa(String dataComemorativa) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false); // Define que a formatação deve ser estrita

		try {
			Date data = sdf.parse(dataComemorativa);

			// Verifica se o dia é maior que 31 ou o mês é maior que 12
			if (data.getDate() > 31 || data.getMonth() >= 12 || data.getYear() + 1900 < 1500
					|| data.getYear() + 1900 > Calendar.getInstance().get(Calendar.YEAR)) {
				return false; // Data inválida
			}
		} catch (ParseException e) {
			return false; // Data inválida
		}

		return true; // Data válida
	}

	public void limpaTodoscampos() {
		txtIdmoeda.setText("");
		txtTitulo.setText("");
		txtAnoCom.setText("");
		txtDiametro.setText("");
		txtEspessura.setText("");
		txtPeso.setText("");
		txtValorMoneta.setText("");
		txtCodCatalogo.setText("");
		cbRecebeBordasModel.removeAllElements();
		cbRecebemateriaisModel.removeAllElements();
	}
}
