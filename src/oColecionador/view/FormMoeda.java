package oColecionador.view;

import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import oColecionador.entity.Bordas;
import oColecionador.entity.Material;
import oColecionador.entity.Moeda;
import oColecionador.entity.Pais;
import oColecionador.repository.BordasRepository;
import oColecionador.repository.MaterialRepository;
import oColecionador.repository.MoedaRepository;
import oColecionador.repository.PaisRepository;
import oColecionador.service.BordasService;
import oColecionador.service.MaterialService;
import oColecionador.service.MoedaService;
import oColecionador.service.PaisService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class FormMoeda extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtData;
	private JTextField txtValor;
	private JTextField txtPeso;
	private JTextField txtEspessura;
	private JTextField txtDiametro;
	private JTextField txtCodigoCat;
	private JTextField txtPais;
	private JTextField txtMaterial;
	private JTextField txtBordas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMoeda frame = new FormMoeda();
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
	 * 
	 * @throws ParseException
	 */
	public FormMoeda() throws ParseException {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 940, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(9, 5, 5, 13));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Titulo (1)");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 114, 75, 23);
		contentPane.add(lblNewLabel_1);

		txtTitulo = new JTextField();

		txtTitulo.setBounds(10, 147, 319, 19);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Ano comemorativo (2)");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(447, 114, 165, 23);
		contentPane.add(lblNewLabel_2);

		txtData = new JFormattedTextField(new MaskFormatter(" ##/##/####"));
		txtData.setBounds(447, 147, 138, 19);
		contentPane.add(txtData);
		txtData.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Valor (3)");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 176, 75, 23);
		contentPane.add(lblNewLabel_1_1);

		txtValor = new JFormattedTextField(new MaskFormatter(" ###.##"));
		txtValor.setBounds(10, 213, 96, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Peso (4)");
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(178, 176, 75, 23);
		contentPane.add(lblNewLabel_1_1_1);

		txtPeso = new JFormattedTextField(new MaskFormatter(" ###,###g"));
		txtPeso.setBounds(178, 213, 96, 19);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);

		JLabel lblNewLabel_1_1_2 = new JLabel("Espessura (5)");
		lblNewLabel_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(347, 176, 116, 23);
		contentPane.add(lblNewLabel_1_1_2);

		txtEspessura = new JFormattedTextField(new MaskFormatter(" ###,###mm"));
		txtEspessura.setBounds(347, 213, 96, 19);
		contentPane.add(txtEspessura);
		txtEspessura.setColumns(10);

		JLabel lblNewLabel_1_1_3 = new JLabel("Diametro (6)");
		lblNewLabel_1_1_3.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_3.setBounds(532, 176, 96, 23);
		contentPane.add(lblNewLabel_1_1_3);

		txtDiametro = new JFormattedTextField(new MaskFormatter(" ###,###mm"));
		txtDiametro.setBounds(532, 213, 96, 19);
		contentPane.add(txtDiametro);
		txtDiametro.setColumns(10);

		JLabel lblNewLabel_1_1_4 = new JLabel("Codigo do catalogo (7)");
		lblNewLabel_1_1_4.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_4.setBounds(701, 176, 155, 23);
		contentPane.add(lblNewLabel_1_1_4);

		txtCodigoCat = new JTextField();
		txtCodigoCat.setBounds(701, 213, 155, 19);
		contentPane.add(txtCodigoCat);
		txtCodigoCat.setColumns(10);

		JLabel lblNewLabel_1_1_5 = new JLabel("Pais");
		lblNewLabel_1_1_5.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_5.setBounds(10, 277, 75, 23);
		contentPane.add(lblNewLabel_1_1_5);

		JComboBox cbPais = new JComboBox();
		cbPais.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {

				PaisRepository pdao = new PaisRepository();

				for (Pais p : pdao.listar()) {

					cbPais.addItem(p);

				}

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbPais.setBounds(10, 310, 439, 21);
		contentPane.add(cbPais);

		JLabel lblNewLabel_1_1_6 = new JLabel("Material");
		lblNewLabel_1_1_6.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_6.setBounds(10, 355, 75, 23);
		contentPane.add(lblNewLabel_1_1_6);

		JComboBox cbMaterial = new JComboBox();
		cbMaterial.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				MaterialRepository mdao = new MaterialRepository();

				for (Material m : mdao.listar()) {

					cbMaterial.addItem(m);

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbMaterial.setBounds(10, 397, 439, 21);
		contentPane.add(cbMaterial);

		JButton btnEditarMat = new JButton("Editar Materia");
		btnEditarMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterialService service = new MaterialService();
				Material material1 = (Material) cbMaterial.getSelectedItem();
				Material material = new Material();
				material.setIdMaterial(material1.getIdMaterial());
				material.setNome(txtMaterial.getText());
				service.salvar(material);
				txtMaterial.setText("");

				// atualizacbPais
				MaterialRepository mdao = new MaterialRepository();
				cbMaterial.removeAllItems();
				for (Material p : mdao.listar()) {

					cbMaterial.addItem(p);

				}

			}
		});
		btnEditarMat.setBounds(460, 358, 109, 21);
		contentPane.add(btnEditarMat);

		JLabel lblNewLabel_1_1_7 = new JLabel("Bordas");
		lblNewLabel_1_1_7.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_7.setBounds(10, 447, 75, 23);
		contentPane.add(lblNewLabel_1_1_7);

		JComboBox cbBordas = new JComboBox();
		cbBordas.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				BordasRepository bdao = new BordasRepository();

				for (Bordas b : bdao.listar()) {

					cbBordas.addItem(b);

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbBordas.setBounds(10, 492, 439, 21);
		contentPane.add(cbBordas);
		JButton btnEditarBordas = new JButton("Editar Borda");
		btnEditarBordas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BordasService service = new BordasService();
				Bordas bordas1 = (Bordas) cbBordas.getSelectedItem();
				Bordas bordas = new Bordas();
				bordas.setIdBordas(bordas1.getIdBordas());
				bordas.setNome(txtBordas.getText());
				service.salvar(bordas);
				txtBordas.setText("");

				// atualizacbPais
				BordasRepository bdao = new BordasRepository();
				cbBordas.removeAllItems();
				for (Bordas p : bdao.listar()) {

					cbBordas.addItem(p);

				}
			}
		});
		btnEditarBordas.setBounds(460, 450, 109, 21);
		contentPane.add(btnEditarBordas);
		JButton btmEditar = new JButton("Editar Pais");
		btmEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaisService service = new PaisService();
				Pais pais1 = (Pais) cbPais.getSelectedItem();
				Pais pais = new Pais();
				pais.setIdPais(pais1.getIdPais());
				pais.setNome(txtPais.getText());
				service.salvar(pais);
				txtPais.setText("");

				// atualizacbPais
				PaisRepository pdao = new PaisRepository();
				cbPais.removeAllItems();
				for (Pais p : pdao.listar()) {

					cbPais.addItem(p);

				}

			}
		});
		btmEditar.setBounds(460, 280, 109, 21);
		contentPane.add(btmEditar);

		JButton btnSalvar = new JButton("Cadastrar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moeda moeda = new Moeda();
				MoedaService service = new MoedaService();
				Bordas bordas = (Bordas) cbBordas.getSelectedItem();
				Material material = (Material) cbMaterial.getSelectedItem();
				Pais pais = (Pais) cbPais.getSelectedItem();
				String titulo = txtTitulo.getText();

				if (!titulo.matches("[a-zA-Z]+")) {
					txtTitulo.setText("");
					// Exibe uma mensagem de erro informando que o campo deve conter apenas letras
					JOptionPane.showMessageDialog(null, "O campo 'Título' deve conter apenas letras", "Erro",
							JOptionPane.ERROR_MESSAGE);
					return;

				}
				moeda.setTitulo(txtTitulo.getText());
				moeda.setAno(txtData.getText());
				moeda.setValor(txtValor.getText());
				moeda.setPeso(txtPeso.getText());
				moeda.setEspessura(txtEspessura.getText());
				moeda.setDiametro(txtDiametro.getText());
				moeda.setCodigoCatalogo(txtCodigoCat.getText());
				moeda.setBordas(bordas);
				moeda.setMaterial(material);
				moeda.setPais(pais);
				service.salvar(moeda);
				// limpeza dos campos
				txtData.setText("");
				txtCodigoCat.setText("");
				txtEspessura.setText("");
				txtDiametro.setText("");
				txtPeso.setText("");
				txtTitulo.setText("");
				txtValor.setText("");

			}
		});
		btnSalvar.setBounds(new Rectangle(7, 0, 7, 0));
		btnSalvar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnSalvar.setBounds(216, 547, 155, 29);
		contentPane.add(btnSalvar);

		txtPais = new JTextField();
		txtPais.setBounds(74, 281, 215, 19);
		contentPane.add(txtPais);
		txtPais.setColumns(10);

		JButton btnNewButton = new JButton("Incluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pais pais = new Pais();
				PaisService paisService = new PaisService();
				String pais1 = txtPais.getText();

				if (!pais1.matches("[a-zA-Z]+")) {
					txtPais.setText("");
					// Exibe uma mensagem de erro informando que o campo deve conter apenas letras
					JOptionPane.showMessageDialog(null, "O campo 'Pais' deve conter apenas letras", "Erro",
							JOptionPane.ERROR_MESSAGE);
					return;

				}
				pais.setNome(txtPais.getText());
				paisService.salvar(pais);
				txtPais.setText("");

				// atualizacbPais
				PaisRepository pdao = new PaisRepository();
				cbPais.removeAllItems();
				for (Pais p : pdao.listar()) {

					cbPais.addItem(p);

				}

			}
		});
		btnNewButton.setBounds(358, 280, 85, 21);
		contentPane.add(btnNewButton);

		txtMaterial = new JTextField();
		txtMaterial.setColumns(10);
		txtMaterial.setBounds(74, 359, 215, 19);
		contentPane.add(txtMaterial);

		txtBordas = new JTextField();
		txtBordas.setColumns(10);
		txtBordas.setBounds(74, 451, 215, 19);
		contentPane.add(txtBordas);

		JButton btnSalvar_1 = new JButton("Incluir");
		btnSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Material material = new Material();
				MaterialService materialService = new MaterialService();
				String material1 = txtMaterial.getText();

				if (!material1.matches("[a-zA-Z]+")) {
					txtMaterial.setText("");
					// Exibe uma mensagem de erro informando que o campo deve conter apenas letras
					JOptionPane.showMessageDialog(null, "O campo 'Material' deve conter apenas letras", "Erro",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

				material.setNome(txtMaterial.getText());
				materialService.salvar(material);
				txtMaterial.setText("");
				// Atualiza cbMaterias
				MaterialRepository mdao = new MaterialRepository();
				cbMaterial.removeAllItems();
				for (Material m : mdao.listar()) {

					cbMaterial.addItem(m);

				}

			}
		});
		btnSalvar_1.setBounds(358, 358, 85, 21);
		contentPane.add(btnSalvar_1);

		JButton btnSalvar_2 = new JButton("Incluir");
		btnSalvar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bordas bordas = new Bordas();
				BordasService bordasService = new BordasService();
				String borda = txtBordas.getText();

				if (!borda.matches("[a-zA-Z]+")) {
					txtBordas.setText("");
					// Exibe uma mensagem de erro informando que o campo deve conter apenas letras
					JOptionPane.showMessageDialog(null, "O campo 'Bordas' deve conter apenas letras", "Erro",
							JOptionPane.ERROR_MESSAGE);
					return;

				}
				bordas.setNome(txtBordas.getText());
				bordasService.salvar(bordas);
				txtBordas.setText("");
				// atualiza cbBox
				BordasRepository bdao = new BordasRepository();
				cbBordas.removeAllItems();
				for (Bordas b : bdao.listar()) {

					cbBordas.addItem(b);

				}
			}
		});
		btnSalvar_2.setBounds(358, 450, 85, 21);
		contentPane.add(btnSalvar_2);

		JLabel lblOColecionador = new JLabel("                    O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(162, -35, 523, 97);
		contentPane.add(lblOColecionador);

		JLabel lblCadastro = new JLabel("                    CADASTRO");
		lblCadastro.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblCadastro.setBounds(194, 0, 523, 97);
		contentPane.add(lblCadastro);

		JComboBox cbMoedasEdit = new JComboBox();
		cbMoedasEdit.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				MoedaRepository repository = new MoedaRepository();
				for (Moeda b : repository.listar()) {

					cbMoedasEdit.addItem(b);

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbMoedasEdit.setBounds(10, 83, 872, 21);
		contentPane.add(cbMoedasEdit);

		JLabel lblNewLabel = new JLabel("Moeda");
		lblNewLabel.setBounds(10, 60, 45, 13);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("Editar Moeda");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moeda moeda = new Moeda();
				MoedaService service = new MoedaService();
				Bordas bordas = (Bordas) cbBordas.getSelectedItem();
				Material material = (Material) cbMaterial.getSelectedItem();
				Pais pais = (Pais) cbPais.getSelectedItem();
				String titulo = txtTitulo.getText();
				Moeda moedas = (Moeda) cbMoedasEdit.getSelectedItem();
				if (!titulo.matches("[a-zA-Z]+")) {
					txtTitulo.setText("");
					// Exibe uma mensagem de erro informando que o campo deve conter apenas letras
					JOptionPane.showMessageDialog(null, "O campo 'Título' deve conter apenas letras", "Erro",
							JOptionPane.ERROR_MESSAGE);
					return;

				}
				moeda.setTitulo(txtTitulo.getText());
				moeda.setIdMoeda(moedas.getIdMoeda());
				moeda.setAno(txtData.getText());
			
				moeda.setValor(txtValor.getText());
				moeda.setPeso(txtPeso.getText());
				moeda.setEspessura(txtEspessura.getText());
				moeda.setDiametro(txtDiametro.getText());
				moeda.setCodigoCatalogo(txtCodigoCat.getText());
				moeda.setBordas(bordas);
				moeda.setMaterial(material);
				moeda.setPais(pais);
				service.salvar(moeda);
				
				cbMoedasEdit.removeAll();
				MoedaRepository repository = new MoedaRepository();
				for (Moeda b : repository.listar()) {

					cbMoedasEdit.addItem(b);

				}
				// limpeza dos campos
				txtData.setText("");
				txtCodigoCat.setText("");
				txtEspessura.setText("");
				txtDiametro.setText("");
				txtPeso.setText("");
				txtTitulo.setText("");
				txtValor.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnNewButton_1.setBounds(396, 547, 189, 28);
		contentPane.add(btnNewButton_1);

	}

	private MaskFormatter setMascara(String mascara) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(mascara);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return mask;
	}
}
