package oColecionador.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
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
import oColecionador.entity.NotaProdutoColecaoEntity;
import oColecionador.entity.NotaProdutoColecaoId;
import oColecionador.entity.NotaProdutoEntity;
import oColecionador.entity.PaisEntity;
import oColecionador.entity.TipoTransacaoEntity;
import oColecionador.entity.UsuarioEntity;
import oColecionador.repository.ColecaoRepository;
import oColecionador.repository.MoedaRepository;
import oColecionador.repository.NotaProdutoRepository;
import oColecionador.repository.PaisRepository;
import oColecionador.repository.TipoRepository;
import oColecionador.repository.UsuarioRepository;
import oColecionador.service.ColecaoService;
import oColecionador.service.UsuarioService;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TelaNotaProduto extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblUser;
	private JTextField txtQuantidade;
	private JTextField txtQuant;
	private JComboBox<MoedaEntity> cbMoeda;
	private JComboBox cbUserLog;
	private DefaultComboBoxModel<MoedaEntity> cbAdicionaProdutoModel;

	// método para definir o usuário do usuário logado e armazená-lo no JLabel
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
					TelaNotaProduto frame = new TelaNotaProduto();
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
	public TelaNotaProduto() throws ParseException {
		cbAdicionaProdutoModel = new DefaultComboBoxModel<>();
		cbAdicionaProdutoModel.getSelectedItem();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1016, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOColecionador = new JLabel("                    O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(234, 17, 523, 47);
		contentPane.add(lblOColecionador);

		lblUser = new JLabel("...");
		lblUser.setBounds(80, 17, 263, 25);
		getContentPane().add(lblUser);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));

		// mostrando o usuário
		JLabel lblNewLabel_1 = new JLabel("Usuário  :");
		lblNewLabel_1.setBounds(10, 25, 76, 13);
		getContentPane().add(lblNewLabel_1);

		JButton btnAjuda = new JButton("Ajuda");
		btnAjuda.setBounds(862, 82, 85, 21);
		contentPane.add(btnAjuda);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 267, 949, 239);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "ID NOTA", "DADOS DA MOEDA PRA VENDA", "VALOR DA MOEDA" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(17);
		table.getColumnModel().getColumn(1).setPreferredWidth(851);
		table.getColumnModel().getColumn(2).setPreferredWidth(35);

		JLabel lblMoedas = new JLabel("                    NOTAS GERADAS DE PRODUTOS");
		lblMoedas.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblMoedas.setBounds(144, -12, 670, 37);
		contentPane.add(lblMoedas);

		cbUserLog = new JComboBox<>();
		cbUserLog.setEnabled(false);
		cbUserLog.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				// responsável por mostrar o usuário logado usando o lbl para pesquisar o
				// usuário
				UsuarioRepository repository = new UsuarioRepository();
				UsuarioEntity userLog = repository.pesquisaPeloUser(lblUser.getText());
				cbUserLog.addItem(userLog);

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbUserLog.setBounds(125, 236, 252, 21);
		contentPane.add(cbUserLog);

		cbMoeda = new JComboBox<>();
		cbMoeda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MoedaEntity moedaSelecionada = (MoedaEntity) cbMoeda.getSelectedItem();

		        // Limpar o modelo do cbAdicionaProduto antes de adicionar a moeda selecionada
		        cbAdicionaProdutoModel.removeAllElements();

		        // Adicionar a moeda selecionada ao modelo do cbAdicionaProduto
		        cbAdicionaProdutoModel.addElement(moedaSelecionada);
		    }
			
		});

		cbMoeda.addAncestorListener(new AncestorListener() {

			public void ancestorAdded(AncestorEvent event) {
				carregaMoedasUsuario();
				cbAdicionaProdutoModel.removeAllElements();
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbMoeda.setBounds(10, 97, 829, 21);
		contentPane.add(cbMoeda);

		JLabel lblNewLabel = new JLabel("QUANTIDADE");
		lblNewLabel.setBounds(10, 128, 156, 13);
		contentPane.add(lblNewLabel);

		txtQuantidade = new JFormattedTextField(new MaskFormatter(" ###"));
		txtQuantidade.setBounds(10, 151, 96, 19);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);

		JButton btnCriarColec = new JButton("Salvar Nota do produto");
		btnCriarColec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarNotasProduto();
			}
		});
		btnCriarColec.setBounds(354, 191, 164, 21);
		contentPane.add(btnCriarColec);

		JLabel lblNewLabel_2 = new JLabel("PRODUTOS PARA VENDA");
		lblNewLabel_2.setBounds(10, 74, 263, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("VENDEDOR  :");
		lblNewLabel_4.setBounds(10, 240, 186, 13);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_3 = new JLabel("VALOR MOEDA");
		lblNewLabel_3.setBounds(144, 128, 96, 13);
		contentPane.add(lblNewLabel_3);

		txtQuant = new JFormattedTextField(new MaskFormatter(" ###.###"));
		txtQuant.setBounds(144, 151, 96, 19);
		contentPane.add(txtQuant);
		txtQuant.setColumns(10);

		JComboBox<MoedaEntity> cbAdicionaProduto = new JComboBox<>(cbAdicionaProdutoModel);
		cbAdicionaProduto.setBounds(250, 150, 589, 21);
		contentPane.add(cbAdicionaProduto);

		JLabel lblNewLabel_5 = new JLabel("ADICIONA PRODUTOS DE VENDA PARA NOTA");
		lblNewLabel_5.setBounds(251, 128, 228, 13);
		contentPane.add(lblNewLabel_5);

	}

	public void carregaMoedasUsuario() {
		UsuarioEntity usuarioLogado = (UsuarioEntity) cbUserLog.getSelectedItem(); // Obtenha o usuário logado

		ColecaoRepository colecaoRepository = new ColecaoRepository();
		List<ColecaoMoedaEntity> moedas = colecaoRepository.obterMoedasVenderDoUsuario(usuarioLogado);

		// Limpar o JComboBox antes de adicionar as moedas
		cbMoeda.removeAllItems();

		// Adicionar as moedas no JComboBox
		for (ColecaoMoedaEntity colecaoMoedaEntity : moedas) {
			cbMoeda.addItem(colecaoMoedaEntity.getColecaoMoedaID().getMoedaEntity());
		}
	}

	public void salvarNotasProduto() {
		UsuarioEntity usuarioLogado = (UsuarioEntity) cbUserLog.getSelectedItem(); // Obtenha o usuário logado

		ColecaoRepository colecaoRepository = new ColecaoRepository();
		List<ColecaoMoedaEntity> moedas = colecaoRepository.obterMoedasVenderDoUsuario(usuarioLogado);

		// Verificar se uma moeda foi selecionada
		if (cbMoeda.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Selecione uma moeda antes de salvar.");
			return;
		}

		// Criar uma instância de NotaProdutoEntity
		NotaProdutoEntity notaProdutoEntity = new NotaProdutoEntity();
		List<NotaProdutoColecaoEntity> notaProdutoColecaoEntities = new ArrayList<>();

		for (ColecaoMoedaEntity colecaoMoedaEntity : moedas) {
			// Verificar se a moeda atual é a selecionada no cbMoeda
			if (colecaoMoedaEntity.getColecaoMoedaID().getMoedaEntity().equals(cbMoeda.getSelectedItem())) {
				NotaProdutoColecaoEntity notaProdutoColecaoEntity = new NotaProdutoColecaoEntity();

				// Criar uma instância de NotaProdutoColecaoId
				NotaProdutoColecaoId notaProdutoColecaoId = new NotaProdutoColecaoId();

				// Definir a notaProdutoEntity no notaProdutoColecaoId
				notaProdutoColecaoId.setNotaProdutoEntity(notaProdutoEntity);

				// Definir a moedaEntity no notaProdutoColecaoId
				notaProdutoColecaoId.setMoedaEntity(colecaoMoedaEntity.getColecaoMoedaID().getMoedaEntity());

				// Definir o notaProdutoColecaoId na notaProdutoColecaoEntity
				notaProdutoColecaoEntity.setNotaProdutoColecaoID(notaProdutoColecaoId);
				notaProdutoColecaoEntity.setUsuarioEntity(usuarioLogado);
				notaProdutoColecaoEntity.setValorUni(txtQuant.getText());
				notaProdutoColecaoEntity.setQuantidade(txtQuantidade.getText());
				// Definir os valores dos outros atributos, se necessário
				// ...

				// Adicionar a NotaProdutoColecaoEntity à lista
				notaProdutoColecaoEntities.add(notaProdutoColecaoEntity);

				break; // Interrompe o loop após salvar a moeda selecionada
			}
		}

		// Verificar se nenhuma moeda foi salva
		if (notaProdutoColecaoEntities.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhuma moeda foi selecionada para salvar.");
			return;
		}

		// Definir a lista de NotaProdutoColecaoEntity na NotaProdutoEntity
		notaProdutoEntity.setNotaProdutoColecaoEntities(notaProdutoColecaoEntities);

		// Definir outros atributos da NotaProdutoEntity, se necessário
		// ...

		NotaProdutoRepository notaProdutoRepository = new NotaProdutoRepository();

		// Inserir a NotaProdutoEntity no banco de dados ou realizar outras operações
		// necessárias
		notaProdutoRepository.inserir(notaProdutoEntity);

		JOptionPane.showMessageDialog(null, "MOEDA SALVA NA NOTA COM SUCESSO");
	}

}
