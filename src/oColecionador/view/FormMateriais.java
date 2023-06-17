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
import oColecionador.service.BordasService;
import oColecionador.service.MaterialService;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormMateriais extends JFrame {

	private JPanel contentPane;
	private JTextField txtMateriais;
	private JTable tblMateriais;
	private MaterialEntity materialEntity = new MaterialEntity();
	private MaterialService materialService = new MaterialService();
	private JComboBox cbMaterialEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMateriais frame = new FormMateriais();
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
	public FormMateriais() {
		setBounds(100, 100, 705, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOColecionador = new JLabel("                    O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(68, -14, 523, 58);
		contentPane.add(lblOColecionador);

		JLabel lblControleMateriais = new JLabel("Controle Materiais");
		lblControleMateriais.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblControleMateriais.setBounds(173, 27, 523, 58);
		contentPane.add(lblControleMateriais);

		JLabel lblNewLabel_1 = new JLabel(
				"Escolha o Material para ser Editada, usar o campo Materiais (1) para editar o material !!");
		lblNewLabel_1.setBounds(10, 95, 558, 13);
		contentPane.add(lblNewLabel_1);

		cbMaterialEdit = new JComboBox();
		cbMaterialEdit.setBounds(10, 118, 139, 21);
		contentPane.add(cbMaterialEdit);

		JLabel lblMateriais = new JLabel("Materiais (1)");
		lblMateriais.setBounds(10, 180, 99, 24);
		contentPane.add(lblMateriais);

		txtMateriais = new JTextField();
		txtMateriais.setBounds(10, 205, 139, 19);
		contentPane.add(txtMateriais);
		txtMateriais.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(229, 185, 413, 217);
		contentPane.add(scrollPane);

		tblMateriais = new JTable();
		scrollPane.setViewportView(tblMateriais);
		tblMateriais.setModel(new DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, { null, null }, },
				new String[] { "ID DO MATERIAL", "NOME" }));

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaMaterial();
				preencheLIstaMateriais();
				carregaMateriais();

			}
		});
		btnSalvar.setBounds(10, 271, 85, 21);
		contentPane.add(btnSalvar);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarMaterial();
				preencheLIstaMateriais();
				carregaMateriais();
			}
		});
		btnEditar.setBounds(10, 315, 85, 21);
		contentPane.add(btnEditar);
		preencheLIstaMateriais();
		carregaMateriais();

	}

	public void adicionaMaterial() {
		String nomeBorda = txtMateriais.getText().trim();
		// Verifica se o campo está vazio
		if (nomeBorda.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'Materiais (1)' não pode estar vazio.");
			return;
		}

		// Verifica se contém apenas letras
		if (!nomeBorda.matches("[a-zA-Z]+")) {
			JOptionPane.showMessageDialog(null, "O campo 'Materiais (1)' deve conter apenas letras.");
			return;
		}

		if (nomeBorda.isEmpty() || nomeBorda.isBlank() || nomeBorda.matches("\\s+\\w+")) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Materiais (1)' não pode estar vazio ou conter apenas espaços em branco.");
			return;
		}

		// Verifica se o campo está vazio, contém apenas espaços em branco ou consiste
		// em espaços em branco seguidos de uma letra
		String nomeSemEspacos = nomeBorda.trim();
		if (nomeSemEspacos.isEmpty() || nomeSemEspacos.length() == 1) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Materiais (1)' não pode estar vazio ou conter apenas espaços em branco.");
			return;
		}
		// Verifica o tamanho mínimo do nome
		if (nomeSemEspacos.length() < 4) {
			JOptionPane.showMessageDialog(null, "O campo 'Bordas (1)' deve ter no mínimo 5 caracteres.");
			return;
		}

		// Verifica o tamanho máximo do nome
		if (nomeSemEspacos.length() > 20) {
			JOptionPane.showMessageDialog(null, "O campo 'Materiais (1)' deve ter no máximo 20 caracteres.");
			return;
		}

		MaterialEntity materialEntity = new MaterialEntity();
		materialEntity.setNome(nomeBorda);
		materialService.salvar(materialEntity);
		txtMateriais.setText("");
		

	}

	public void editarMaterial() {
		String nomeBorda = txtMateriais.getText().trim();
		// Verifica se o campo está vazio
		if (nomeBorda.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'Materiais (1)' não pode estar vazio.");
			return;
		}

		// Verifica se contém apenas letras
		if (!nomeBorda.matches("[a-zA-Z]+")) {
			JOptionPane.showMessageDialog(null, "O campo 'Materiais (1)' deve conter apenas letras.");
			return;
		}

		if (nomeBorda.isEmpty() || nomeBorda.isBlank() || nomeBorda.matches("\\s+\\w+")) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Materiais (1)' não pode estar vazio ou conter apenas espaços em branco.");
			return;
		}

		// Verifica se o campo está vazio, contém apenas espaços em branco ou consiste
		// em espaços em branco seguidos de uma letra
		String nomeSemEspacos = nomeBorda.trim();
		if (nomeSemEspacos.isEmpty() || nomeSemEspacos.length() == 1) {
			JOptionPane.showMessageDialog(null,
					"O campo 'Materiais (1)' não pode estar vazio ou conter apenas espaços em branco.");
			return;
		}
		// Verifica o tamanho mínimo do nome
		if (nomeSemEspacos.length() < 4) {
			JOptionPane.showMessageDialog(null, "O campo 'Materiais (1)' deve ter no mínimo 4 caracteres.");
			return;
		}

		// Verifica o tamanho máximo do nome
		if (nomeSemEspacos.length() > 20) {
			JOptionPane.showMessageDialog(null, "O campo 'Materiais (1)' deve ter no máximo 20 caracteres.");
			return;
		}

		MaterialEntity materialEntity = (MaterialEntity) cbMaterialEdit.getSelectedItem();

		materialEntity.setIdMaterial(materialEntity.getIdMaterial());
		materialEntity.setNome(txtMateriais.getText());
		materialService.salvar(materialEntity);
		txtMateriais.setText("");
		
	}

	public void carregaMateriais() {

		cbMaterialEdit.removeAllItems();
		for (MaterialEntity materialEntity : materialService.listar()) {

			cbMaterialEdit.addItem(materialEntity);

		}
	}

	public void preencheLIstaMateriais() {

		try {
			List<MaterialEntity> lista = materialService.listar();
			DefaultTableModel modeloTabela = (DefaultTableModel) tblMateriais.getModel();
			modeloTabela.setRowCount(0);
			for (MaterialEntity materialEntity : lista) {
				modeloTabela.addRow(new Object[] { materialEntity.getIdMaterial(), materialEntity.getNome() });

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
