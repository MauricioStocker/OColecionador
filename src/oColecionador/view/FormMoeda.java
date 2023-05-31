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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormMoeda extends JFrame {

	private JPanel cbMoedasCadastro;
	private JTextField txtTitulo;
	private JTextField txtAnoCom;
	private JTextField txtValorMoneta;
	private JTextField txtEspessura;
	private JTextField txtPeso;
	private JTextField txtDiametro;
	private JTable table;
	private JTextField txtBordas;
	private JTextField txtMateriais;
	private JTextField txtPais;
	private JComboBox cbMoedasCad;
	private JComboBox cbMateriais;
	private JComboBox cbBordas;
	private JComboBox cbPais;
	private DefaultComboBoxModel<BordasEntity> cbRecebeBordasModel;
	private DefaultComboBoxModel<MaterialEntity> cbRecebemateriaisModel;
	private JTextField txtCodCatalogo;

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

		JLabel lblNewLabel_1_1_6_2_6 = new JLabel("Moedas para edição");
		lblNewLabel_1_1_6_2_6.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_6.setBounds(10, 97, 197, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_6);

		cbMoedasCad = new JComboBox();
		cbMoedasCad.setBounds(10, 120, 1436, 21);
		cbMoedasCadastro.add(cbMoedasCad);

		JLabel lblNewLabel_1_1_6_2 = new JLabel("Titulo (1)");
		lblNewLabel_1_1_6_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2.setBounds(10, 181, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 216, 229, 19);
		cbMoedasCadastro.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblNewLabel_1_1_6_2_1 = new JLabel("Ano comemorativo (3)");
		lblNewLabel_1_1_6_2_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_1.setBounds(10, 252, 177, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_1);

		txtAnoCom = new JTextField();
		txtAnoCom.setBounds(10, 285, 116, 19);
		cbMoedasCadastro.add(txtAnoCom);
		txtAnoCom.setColumns(10);

		JLabel lblNewLabel_1_1_6_2_2 = new JLabel("Valor monetario (4)");
		lblNewLabel_1_1_6_2_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_2.setBounds(171, 252, 139, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_2);

		txtValorMoneta = new JTextField();
		txtValorMoneta.setBounds(171, 285, 104, 19);
		cbMoedasCadastro.add(txtValorMoneta);
		txtValorMoneta.setColumns(10);

		JLabel lblNewLabel_1_1_6_2_5 = new JLabel("Espessura (5)");
		lblNewLabel_1_1_6_2_5.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_5.setBounds(320, 252, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_5);

		txtEspessura = new JTextField();
		txtEspessura.setBounds(320, 285, 74, 19);
		cbMoedasCadastro.add(txtEspessura);
		txtEspessura.setColumns(10);

		JLabel lblNewLabel_1_1_6_2_3 = new JLabel("Peso (6)");
		lblNewLabel_1_1_6_2_3.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_3.setBounds(10, 335, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_3);

		txtPeso = new JTextField();
		txtPeso.setBounds(10, 372, 74, 19);
		cbMoedasCadastro.add(txtPeso);
		txtPeso.setColumns(10);

		JLabel lblNewLabel_1_1_6_2_4 = new JLabel("Diametro (7)");
		lblNewLabel_1_1_6_2_4.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_4.setBounds(123, 335, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_4);

		txtDiametro = new JTextField();
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
		lblNewLabel_1_1_6_2_5_2.setBounds(10, 428, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_5_2);

		JComboBox<BordasEntity> cbRecebeBordas = new JComboBox<>(cbRecebeBordasModel);
		cbRecebeBordas.setBounds(10, 454, 197, 21);
		cbMoedasCadastro.add(cbRecebeBordas);

		JLabel lblNewLabel_1_1_6_2_5_3 = new JLabel("Materiais (10)");
		lblNewLabel_1_1_6_2_5_3.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_5_3.setBounds(10, 517, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_5_3);

		JComboBox<MaterialEntity> cbRecebemateriais = new JComboBox<>(cbRecebemateriaisModel);
		cbRecebemateriais.setBounds(10, 543, 197, 21);
		cbMoedasCadastro.add(cbRecebemateriais);

		JButton btnCadastrarMoeda = new JButton("Cadastrar");
		btnCadastrarMoeda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarMoeda();
				preencheLIsta();
				carregaMoedas();
			}
		});
		btnCadastrarMoeda.setBounds(10, 634, 85, 21);
		cbMoedasCadastro.add(btnCadastrarMoeda);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(429, 203, 598, 542);
		cbMoedasCadastro.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, },
				new String[] { "New column", "New column" }));

		JLabel lblNewLabel_1_1_6_2_7_1 = new JLabel("RELAÇÃO DE MOEDAS");
		lblNewLabel_1_1_6_2_7_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_7_1.setBounds(617, 151, 218, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_7_1);

		JLabel lblNewLabel_1_1_6_2_7 = new JLabel("EDIÇÕES E CRIAÇÕES");
		lblNewLabel_1_1_6_2_7.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_7.setBounds(1191, 151, 218, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_7);

		JLabel lblNewLabel_1_1_6_2_5_2_1 = new JLabel("Bordas");
		lblNewLabel_1_1_6_2_5_2_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_5_2_1.setBounds(1073, 219, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_5_2_1);

		txtBordas = new JTextField();
		txtBordas.setBounds(1073, 256, 116, 19);
		cbMoedasCadastro.add(txtBordas);
		txtBordas.setColumns(10);

		cbBordas = new JComboBox();
		cbBordas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BordasEntity bordas = (BordasEntity) cbBordas.getSelectedItem();
				cbRecebeBordasModel.addElement(bordas);

			}
		});
		cbBordas.setBounds(1073, 284, 183, 21);
		cbMoedasCadastro.add(cbBordas);

		JButton btnCadastraBorda = new JButton("cadastra Bordas");
		btnCadastraBorda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaBorda();
				limpaCbRecebeBordas();
			}
		});
		btnCadastraBorda.setBounds(1212, 255, 116, 21);
		cbMoedasCadastro.add(btnCadastraBorda);

		JLabel lblNewLabel_1_1_6_2_8 = new JLabel("Materiais");
		lblNewLabel_1_1_6_2_8.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_8.setBounds(1073, 355, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_8);

		txtMateriais = new JTextField();
		txtMateriais.setBounds(1073, 388, 116, 19);
		cbMoedasCadastro.add(txtMateriais);
		txtMateriais.setColumns(10);

		cbMateriais = new JComboBox();
		cbMateriais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterialEntity material = (MaterialEntity) cbMateriais.getSelectedItem();
				cbRecebemateriaisModel.addElement(material);
			}
		});
		cbMateriais.setBounds(1073, 417, 183, 21);
		cbMoedasCadastro.add(cbMateriais);

		JButton btnCadastraMaterial = new JButton("Cadastra Material");
		btnCadastraMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaMateriais();
				limpaCbRecebeMateriais();
			}
		});
		btnCadastraMaterial.setBounds(1215, 387, 113, 21);
		cbMoedasCadastro.add(btnCadastraMaterial);

		JLabel lblNewLabel_1_1_6_2_5_1_1 = new JLabel("Pais");
		lblNewLabel_1_1_6_2_5_1_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_5_1_1.setBounds(1073, 501, 116, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_5_1_1);

		txtPais = new JTextField();
		txtPais.setBounds(1073, 544, 116, 19);
		cbMoedasCadastro.add(txtPais);
		txtPais.setColumns(10);

		JButton btnCadastraPais = new JButton("cadastra Pais");
		btnCadastraPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaPais();

			}
		});
		btnCadastraPais.setBounds(1212, 543, 116, 21);
		cbMoedasCadastro.add(btnCadastraPais);

		JButton btnRemoveBordas = new JButton("Remover");
		btnRemoveBordas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BordasEntity bordas = (BordasEntity) cbRecebeBordasModel.getSelectedItem();
				cbRecebeBordasModel.removeElement(bordas);
			}
		});
		btnRemoveBordas.setBounds(221, 454, 85, 21);
		cbMoedasCadastro.add(btnRemoveBordas);

		JButton btnRemoverMate = new JButton("Remover");
		btnRemoverMate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterialEntity material = (MaterialEntity) cbRecebemateriaisModel.getSelectedItem();
				cbRecebemateriaisModel.removeElement(material);
			}
		});
		btnRemoverMate.setBounds(221, 543, 85, 21);
		cbMoedasCadastro.add(btnRemoverMate);

		JButton btnEditarMoeda = new JButton("Editar");
		btnEditarMoeda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarMoeda();
				preencheLIsta();
				carregaMoedas();
			}
		});
		btnEditarMoeda.setBounds(122, 634, 85, 21);
		cbMoedasCadastro.add(btnEditarMoeda);

		JLabel lblNewLabel_1_1_6_2_9 = new JLabel("Codigo de catalogo (2)");
		lblNewLabel_1_1_6_2_9.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6_2_9.setBounds(267, 181, 152, 23);
		cbMoedasCadastro.add(lblNewLabel_1_1_6_2_9);

		txtCodCatalogo = new JTextField();
		txtCodCatalogo.setBounds(262, 216, 132, 19);
		cbMoedasCadastro.add(txtCodCatalogo);
		txtCodCatalogo.setColumns(10);

		JButton btnDeletarMoeda = new JButton("Deletar");
		btnDeletarMoeda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarMoeda();
				preencheLIsta();
				carregaMoedas();
			}
		});
		btnDeletarMoeda.setBounds(241, 634, 85, 21);
		cbMoedasCadastro.add(btnDeletarMoeda);

		JButton btnEditarPais = new JButton("Editar");
		btnEditarPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarPais();
				carregaPais();
				carregaMoedas();
			}
		});
		btnEditarPais.setBounds(1361, 543, 85, 21);
		cbMoedasCadastro.add(btnEditarPais);

		JButton btnEditarBordas = new JButton("Editar");
		btnEditarBordas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarBordas();
				carregaBordas();
				carregaMoedas();

			}
		});
		btnEditarBordas.setBounds(1361, 255, 85, 21);
		cbMoedasCadastro.add(btnEditarBordas);

		JButton btnEditarMaterial = new JButton("Editar");
		btnEditarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarMaterial();
				carregaMaterial();
			}
		});
		btnEditarMaterial.setBounds(1361, 387, 85, 21);
		cbMoedasCadastro.add(btnEditarMaterial);

		carregaMoedas();
		preencheLIsta();
		carregaMaterial();
		carregaBordas();
		carregaPais();
		limpaCbRecebeBordas();
		limpaCbRecebeMateriais();
	}

	public void preencheLIsta() {
		MoedaService moedaService = new MoedaService();
		try {
			List<MoedaEntity> lista = moedaService.listar();
			DefaultTableModel modeloTabela = (DefaultTableModel) table.getModel();
			modeloTabela.setRowCount(0);
			for (MoedaEntity moeda : lista) {
				modeloTabela.addRow(new Object[] { moeda.getIdMoeda(), moeda.getTitulo() });

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void carregaMoedas() {
		MoedaService moedaService = new MoedaService();
		cbMoedasCad.removeAllItems();
		for (MoedaEntity m : moedaService.listar()) {

			cbMoedasCad.addItem(m);

		}
	}

	public void cadastrarMoeda() {
		MoedaEntity moeda = new MoedaEntity();
		MoedaService service = new MoedaService();

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

		moeda.setCodigoCatalogo(txtCodCatalogo.getText());
		moeda.setAno(txtAnoCom.getText());
		moeda.setValor(txtValorMoneta.getText());
		moeda.setDiametro(txtDiametro.getText());
		moeda.setEspessura(txtEspessura.getText());
		moeda.setPeso(txtPeso.getText());
		moeda.setTitulo(txtTitulo.getText());
		moeda.setMateriais(materiais);
		moeda.setBordas(bordas);
		moeda.setPaisEntity(pais);

		service.salvar(moeda);

		preencheLIsta();

		cbRecebeBordasModel.removeAllElements();
		cbRecebemateriaisModel.removeAllElements();
		// limpeza dos campos

		txtTitulo.setText("");
		txtAnoCom.setText("");
		txtDiametro.setText("");
		txtEspessura.setText("");
		txtPeso.setText("");
		txtValorMoneta.setText("");
		txtCodCatalogo.setText("");

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

	public void adicionaBorda() {
		BordasEntity bordas = new BordasEntity();
		BordasService bordasService = new BordasService();

		bordas.setNome(txtBordas.getText());
		bordasService.salvar(bordas);
		txtBordas.setText("");
		// Atualiza cbMaterias

		cbBordas.removeAllItems();
		for (BordasEntity m : bordasService.listar()) {

			cbBordas.addItem(m);

		}
	}

	public void adicionaPais() {
		PaisEntity pais = new PaisEntity();
		PaisService paisService = new PaisService();

		pais.setNome(txtPais.getText());
		paisService.salvar(pais);
		txtPais.setText("");
		// Atualiza cbMaterias

		cbPais.removeAllItems();
		for (PaisEntity m : paisService.listar()) {

			cbPais.addItem(m);

		}

	}

	public void adicionaMateriais() {

		MaterialEntity material = new MaterialEntity();
		MaterialService materialService = new MaterialService();

		material.setNome(txtMateriais.getText());
		materialService.salvar(material);
		txtMateriais.setText("");
		// Atualiza cbMaterias
		MaterialRepository mdao = new MaterialRepository();
		cbMateriais.removeAllItems();
		for (MaterialEntity m : mdao.listar()) {

			cbMateriais.addItem(m);

		}
	}

	public void editarMoeda() {
		MoedaEntity moeda = new MoedaEntity();
		MoedaService service = new MoedaService();
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

		MoedaEntity moedas = (MoedaEntity) cbMoedasCad.getSelectedItem();

		moeda.setTitulo(txtTitulo.getText());
		moeda.setIdMoeda(moedas.getIdMoeda());
		moeda.setAno(txtAnoCom.getText());
		moeda.setCodigoCatalogo(txtCodCatalogo.getText());
		moeda.setValor(txtValorMoneta.getText());
		moeda.setPeso(txtPeso.getText());
		moeda.setEspessura(txtEspessura.getText());
		moeda.setDiametro(txtDiametro.getText());

		moeda.setBordas(bordas);
		moeda.setMateriais(materiais);
		moeda.setPaisEntity(pais);
		service.salvar(moeda);

		cbMoedasCad.removeAll();

		for (MoedaEntity b : service.listar()) {

			cbMoedasCad.addItem(b);

		}
		// limpeza dos campos
		txtTitulo.setText("");
		txtAnoCom.setText("");
		txtDiametro.setText("");
		txtEspessura.setText("");
		txtPeso.setText("");
		txtValorMoneta.setText("");
		txtCodCatalogo.setText("");

	}

	public void deletarMoeda() {
		MoedaService service = new MoedaService();
		MoedaEntity moeda1 = (MoedaEntity) cbMoedasCad.getSelectedItem();
		MoedaEntity moeda = new MoedaEntity();

		if (moeda1 == null) {
			JOptionPane.showMessageDialog(null, "NÃO EXISTE MOEDA PARA DELETAR", "Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			int escolha = JOptionPane.showConfirmDialog(null, "Deseja realizar o delete de " + moeda.getTitulo(), " : ",
					JOptionPane.YES_NO_OPTION);
			if (escolha == JOptionPane.YES_OPTION) {
				moeda.setIdMoeda(moeda1.getIdMoeda());
				service.remover(moeda.getIdMoeda());
				JOptionPane.showMessageDialog(null, "MOEDA DELATADA COM SUCESSO !!");

			}
		}

	}

	public void editarPais() {
		PaisService service = new PaisService();
		PaisEntity pais1 = (PaisEntity) cbPais.getSelectedItem();
		PaisEntity pais = new PaisEntity();
		pais.setIdPais(pais1.getIdPais());
		pais.setNome(txtPais.getText());
		service.salvar(pais);
		txtPais.setText("");

	}

	public void editarBordas() {
		BordasService service = new BordasService();
		BordasEntity bordas1 = (BordasEntity) cbBordas.getSelectedItem();
		BordasEntity bordas = new BordasEntity();
		bordas.setIdBordas(bordas1.getIdBordas());
		bordas.setNome(txtBordas.getText());
		service.salvar(bordas);
		txtBordas.setText("");
	}

	public void editarMaterial() {
		MaterialService service = new MaterialService();
		MaterialEntity material1 = (MaterialEntity) cbMateriais.getSelectedItem();
		MaterialEntity material = new MaterialEntity();
		material.setIdMaterial(material1.getIdMaterial());
		material.setNome(txtMateriais.getText());
		service.salvar(material);
		txtMateriais.setText("");
	}
}
