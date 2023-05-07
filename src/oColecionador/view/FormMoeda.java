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
import oColecionador.repository.PaisRepository;
import oColecionador.service.BordasService;
import oColecionador.service.MaterialService;
import oColecionador.service.MoedaService;
import oColecionador.service.PaisService;

import javax.swing.JLabel;
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

		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 92, 75, 23);
		contentPane.add(lblNewLabel_1);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 125, 319, 19);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Ano comemorativo");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(494, 92, 165, 23);
		contentPane.add(lblNewLabel_2);

		txtData = new JFormattedTextField(new MaskFormatter(" ##/##/####"));
		txtData.setBounds(494, 125, 138, 19);
		contentPane.add(txtData);
		txtData.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Valor");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 176, 75, 23);
		contentPane.add(lblNewLabel_1_1);

		txtValor = new JTextField();
		txtValor.setBounds(10, 213, 96, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Peso");
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(178, 176, 75, 23);
		contentPane.add(lblNewLabel_1_1_1);

		txtPeso = new JTextField();
		txtPeso.setBounds(178, 213, 96, 19);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);

		JLabel lblNewLabel_1_1_2 = new JLabel("Espessura");
		lblNewLabel_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(347, 176, 75, 23);
		contentPane.add(lblNewLabel_1_1_2);

		txtEspessura = new JTextField();
		txtEspessura.setBounds(347, 213, 96, 19);
		contentPane.add(txtEspessura);
		txtEspessura.setColumns(10);

		JLabel lblNewLabel_1_1_3 = new JLabel("Diametro");
		lblNewLabel_1_1_3.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1_1_3.setBounds(532, 176, 75, 23);
		contentPane.add(lblNewLabel_1_1_3);

		txtDiametro = new JTextField();
		txtDiametro.setBounds(532, 213, 96, 19);
		contentPane.add(txtDiametro);
		txtDiametro.setColumns(10);

		JLabel lblNewLabel_1_1_4 = new JLabel("Codigo do catalogo");
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

		JButton btnSalvar = new JButton("Cadastrar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moeda moeda = new Moeda();
				MoedaService service = new MoedaService();
				Bordas bordas = (Bordas) cbBordas.getSelectedItem();
				Material material = (Material) cbMaterial.getSelectedItem();
				Pais pais = (Pais) cbPais.getSelectedItem();
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
		btnSalvar.setBounds(730, 485, 155, 29);
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
		lblOColecionador.setBounds(156, -29, 523, 97);
		contentPane.add(lblOColecionador);

		JLabel lblCadastro = new JLabel("                    CADASTRO");
		lblCadastro.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblCadastro.setBounds(193, 18, 523, 97);
		contentPane.add(lblCadastro);

	}
}
