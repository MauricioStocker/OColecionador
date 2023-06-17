package oColecionador.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oColecionador.entity.BordasEntity;
import oColecionador.entity.MaterialEntity;
import oColecionador.entity.PaisEntity;
import oColecionador.service.PaisService;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPais extends JFrame {

	private JPanel contentPane;
	private JTextField txtPais;
	private JTable tblPais;
	private JComboBox cbPais;
	private PaisEntity paisEntity = new PaisEntity();
	private PaisService paisService = new PaisService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPais frame = new FormPais();
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
	public FormPais() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 706, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOColecionador = new JLabel("                    O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(70, -15, 523, 58);
		contentPane.add(lblOColecionador);

		JLabel lblControlePais = new JLabel("Controle Pais");
		lblControlePais.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblControlePais.setBounds(224, 21, 523, 58);
		contentPane.add(lblControlePais);

		JLabel lblNewLabel_1 = new JLabel(
				"Escolha o Pais para ser Editado, usar o campo Pais (1) para editar o pais !!");
		lblNewLabel_1.setBounds(10, 75, 439, 13);
		contentPane.add(lblNewLabel_1);

		cbPais = new JComboBox();
		cbPais.setBounds(10, 98, 144, 21);
		contentPane.add(cbPais);

		JLabel lblPais = new JLabel("Pais (1)");
		lblPais.setBounds(10, 166, 99, 24);
		contentPane.add(lblPais);

		txtPais = new JTextField();
		txtPais.setBounds(10, 190, 144, 19);
		contentPane.add(txtPais);
		txtPais.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(263, 171, 404, 225);
		contentPane.add(scrollPane);

		tblPais = new JTable();
		scrollPane.setViewportView(tblPais);
		tblPais.setModel(new DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, { null, null }, },
				new String[] { "ID DO PAIS", "NOME" }));

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaPais();
				preencheLIstaPais();
				carregaPais();
			}
		});
		btnSalvar.setBounds(10, 284, 85, 21);
		contentPane.add(btnSalvar);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarPais();
				carregaPais();
				preencheLIstaPais();
			}
		});
		btnEditar.setBounds(10, 326, 85, 21);
		contentPane.add(btnEditar);
		preencheLIstaPais();
		carregaPais();
	}

	public void adicionaPais() {
		String nomeBorda = txtPais.getText().trim();
		// Verifica se o campo está vazio
		if (nomeBorda.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'Bordas (1)' não pode estar vazio.");
			return;
		}

		// Verifica se contém apenas letras
		if (!nomeBorda.matches("[a-zA-Z]+")) {
			JOptionPane.showMessageDialog(null, "O campo 'Bordas (1)' deve conter apenas letras.");
			return;
		}

		if (nomeBorda.isEmpty() || nomeBorda.isBlank() || nomeBorda.matches("\\s+\\w+")) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Bordas (1)' não pode estar vazio ou conter apenas espaços em branco.");
			return;
		}

		// Verifica se o campo está vazio, contém apenas espaços em branco ou consiste
		// em espaços em branco seguidos de uma letra
		String nomeSemEspacos = nomeBorda.trim();
		if (nomeSemEspacos.isEmpty() || nomeSemEspacos.length() == 1) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Bordas (1)' não pode estar vazio ou conter apenas espaços em branco.");
			return;
		}
		// Verifica o tamanho mínimo do nome
		if (nomeSemEspacos.length() < 4) {
			JOptionPane.showMessageDialog(null, "O campo 'Bordas (1)' deve ter no mínimo 4 caracteres.");
			return;
		}

		// Verifica o tamanho máximo do nome
		if (nomeSemEspacos.length() > 20) {
			JOptionPane.showMessageDialog(null, "O campo 'Bordas (1)' deve ter no máximo 20 caracteres.");
			return;
		}
		PaisEntity entity = new PaisEntity();
		entity.setNome(txtPais.getText());
		paisService.salvar(entity);
		txtPais.setText("");
		// Atualiza cbMaterias

		cbPais.removeAllItems();
		for (PaisEntity paisEntity : paisService.listar()) {

			cbPais.addItem(paisEntity);

		}
	}

	public void editarPais() {

		String nomeBorda = txtPais.getText().trim();
		// Verifica se o campo está vazio
		if (nomeBorda.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'Pais (1)' não pode estar vazio.");
			return;
		}

		// Verifica se contém apenas letras
		if (!nomeBorda.matches("[a-zA-Z]+")) {
			JOptionPane.showMessageDialog(null, "O campo 'Pais (1)' deve conter apenas letras.");
			return;
		}

		if (nomeBorda.isEmpty() || nomeBorda.isBlank() || nomeBorda.matches("\\s+\\w+")) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Pais (1)' não pode estar vazio ou conter apenas espaços em branco.");
			return;
		}

		// Verifica se o campo está vazio, contém apenas espaços em branco ou consiste
		// em espaços em branco seguidos de uma letra
		String nomeSemEspacos = nomeBorda.trim();
		if (nomeSemEspacos.isEmpty() || nomeSemEspacos.length() == 1) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Pais (1)' não pode estar vazio ou conter apenas espaços em branco.");
			return;
		}
		// Verifica o tamanho mínimo do nome
		if (nomeSemEspacos.length() < 4) {
			JOptionPane.showMessageDialog(null, "O campo 'Pais (1)' deve ter no mínimo 4 caracteres.");
			return;
		}

		// Verifica o tamanho máximo do nome
		if (nomeSemEspacos.length() > 20) {
			JOptionPane.showMessageDialog(null, "O campo 'Pais (1)' deve ter no máximo 20 caracteres.");
			return;
		}
		PaisEntity pais = (PaisEntity) cbPais.getSelectedItem();
		paisEntity.setIdPais(pais.getIdPais());
		paisEntity.setNome(txtPais.getText());
		paisService.salvar(paisEntity);
		preencheLIstaPais();
		carregaPais();
		txtPais.setText("");
	}

	public void carregaPais() {

		cbPais.removeAllItems();
		for (PaisEntity paisEntity : paisService.listar()) {

			cbPais.addItem(paisEntity);

		}
	}

	public void preencheLIstaPais() {

		try {
			List<PaisEntity> lista = paisService.listar();
			DefaultTableModel modeloTabela = (DefaultTableModel) tblPais.getModel();
			modeloTabela.setRowCount(0);
			for (PaisEntity paisEntity : lista) {
				modeloTabela.addRow(new Object[] { paisEntity.getIdPais(), paisEntity.getNome() });

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
