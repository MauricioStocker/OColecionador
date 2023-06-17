package oColecionador.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import oColecionador.entity.BordasEntity;
import oColecionador.entity.MoedaEntity;
import oColecionador.service.BordasService;
import oColecionador.service.MoedaService;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormBordas extends JFrame {

	private JPanel contentPane;
	private JTextField txtBordas;
	private JTable tblBordas;
	private JComboBox cbBordasEdit;
	private BordasService bordasService = new BordasService();
	private BordasEntity bordas = new BordasEntity();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBordas frame = new FormBordas();
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
	public FormBordas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 698, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOColecionador = new JLabel("                    O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(62, -18, 523, 58);
		contentPane.add(lblOColecionador);

		JLabel lblCadastrarBordas = new JLabel("Controle Bordas");
		lblCadastrarBordas.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblCadastrarBordas.setBounds(197, 23, 523, 58);
		contentPane.add(lblCadastrarBordas);

		JLabel lblNewLabel = new JLabel("Bordas (1)");
		lblNewLabel.setBounds(10, 166, 99, 24);
		contentPane.add(lblNewLabel);

		txtBordas = new JTextField();
		txtBordas.setBounds(10, 187, 96, 19);
		contentPane.add(txtBordas);
		txtBordas.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(228, 171, 416, 228);
		contentPane.add(scrollPane);

		tblBordas = new JTable();
		scrollPane.setViewportView(tblBordas);
		tblBordas.setModel(new DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, },
				new String[] { "ID DA BORDA", "NOME" }));

		cbBordasEdit = new JComboBox();
		cbBordasEdit.setBounds(10, 126, 96, 21);
		contentPane.add(cbBordasEdit);

		JLabel lblNewLabel_1 = new JLabel(
				"Escolha a borda para ser Editada, usar o campo Bordas (1) para editar a borda !!");
		lblNewLabel_1.setBounds(10, 103, 466, 13);
		contentPane.add(lblNewLabel_1);

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaBorda();
				preencheLIstaBordas();
				carregaBordas();

				txtBordas.setText("");

			}
		});
		btnSalvar.setBounds(10, 270, 85, 21);
		contentPane.add(btnSalvar);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarBordas();
				preencheLIstaBordas();
				carregaBordas();
			}
		});
		btnEditar.setBounds(10, 308, 85, 21);
		contentPane.add(btnEditar);
		carregaBordas();
		preencheLIstaBordas();

	}

	public void adicionaBorda() {
		String nomeBorda = txtBordas.getText().trim();
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
		BordasEntity bordas = new BordasEntity();
		bordas.setNome(nomeBorda);
		bordasService.salvar(bordas);
		txtBordas.setText("");

		// Atualiza cbMaterias
		cbBordasEdit.removeAllItems();
		for (BordasEntity m : bordasService.listar()) {
			cbBordasEdit.addItem(m);
		}
	}

	public void editarBordas() {
		String nomeBorda = txtBordas.getText().trim();
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
			JOptionPane.showMessageDialog(null, "O campo 'Bordas (1)' deve ter no mínimo 5 caracteres.");
			return;
		}

		// Verifica o tamanho máximo do nome
		if (nomeSemEspacos.length() > 20) {
			JOptionPane.showMessageDialog(null, "O campo 'Bordas (1)' deve ter no máximo 20 caracteres.");
			return;
		}
		BordasEntity bordas1 = (BordasEntity) cbBordasEdit.getSelectedItem();

		bordas.setIdBordas(bordas1.getIdBordas());
		bordas.setNome(txtBordas.getText());
		bordasService.salvar(bordas);
		txtBordas.setText("");
	}

	public void carregaBordas() {
		BordasService bordasService = new BordasService();
		cbBordasEdit.removeAllItems();
		for (BordasEntity m : bordasService.listar()) {

			cbBordasEdit.addItem(m);

		}
	}

	public void preencheLIstaBordas() {
		BordasService bordasService = new BordasService();
		try {
			List<BordasEntity> lista = bordasService.listar();
			DefaultTableModel modeloTabela = (DefaultTableModel) tblBordas.getModel();
			modeloTabela.setRowCount(0);
			for (BordasEntity bordasEntity : lista) {
				modeloTabela.addRow(new Object[] { bordasEntity.getIdBordas(), bordasEntity.getNome() });

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
