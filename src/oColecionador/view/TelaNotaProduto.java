package oColecionador.view;

import java.awt.Component;
import java.awt.EventQueue;

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

import oColecionador.entity.Bordas;
import oColecionador.entity.Colecao;
import oColecionador.entity.Moeda;
import oColecionador.entity.NotaProduto;
import oColecionador.entity.Pais;
import oColecionador.entity.TipoTransacao;
import oColecionador.entity.Usuario;
import oColecionador.repository.ColecaoRepository;
import oColecionador.repository.MoedaRepository;
import oColecionador.repository.NotaProdutoRepository;
import oColecionador.repository.PaisRepository;
import oColecionador.repository.TipoRepository;
import oColecionador.repository.UsuarioRepository;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaNotaProduto extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblUser;
	private JTextField txtQuantidade;
	private JTextField txtQuant;

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
	 */
	public TelaNotaProduto() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1016, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOColecionador = new JLabel("                    O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(201, -25, 523, 97);
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
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID NOTA", "DADOS DA MOEDA PRA VENDA", "VALOR DA MOEDA"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(17);
		table.getColumnModel().getColumn(1).setPreferredWidth(591);
		table.getColumnModel().getColumn(2).setPreferredWidth(34);

		JLabel lblMoedas = new JLabel("                    NOTAS GERADAS DE PRODUTOS");
		lblMoedas.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblMoedas.setBounds(112, 195, 670, 97);
		contentPane.add(lblMoedas);

		JComboBox cbUserLog = new JComboBox();
		cbUserLog.setEnabled(false);
		cbUserLog.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				//responsavel para mostrar o usuário logado usando o lbl para pesquisar o usuário
				UsuarioRepository repository = new UsuarioRepository();
				Usuario userLog = repository.pesquisaPeloUser(lblUser.getText());
				cbUserLog.addItem(userLog);

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbUserLog.setBounds(131, 193, 252, 21);
		contentPane.add(cbUserLog);

		JComboBox cbMoeda = new JComboBox();
		cbMoeda.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				//responsavel para buscar o usuário para ser usando no metodo de retorno do usuario logado das coleções moeda
				UsuarioRepository repository1 = new UsuarioRepository();
				Usuario userLog = repository1.pesquisaPeloUser(lblUser.getText());
				ColecaoRepository repository = new ColecaoRepository();
				for (Colecao p : repository.listarColecaoPorTipoVenderDoUsuarioLogado(userLog)) {

					cbMoeda.addItem(p);

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbMoeda.setBounds(10, 82, 829, 21);
		contentPane.add(cbMoeda);
		Colecao colecao = (Colecao) cbMoeda.getSelectedItem();
		JLabel lblNewLabel = new JLabel("QUANTIDADE");
		lblNewLabel.setBounds(10, 125, 156, 13);
		contentPane.add(lblNewLabel);

		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(10, 148, 96, 19);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);

		JButton btnCriarColec = new JButton("Salvar Nota do produto");
		btnCriarColec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NotaProduto notaProduto = new NotaProduto();
				NotaProdutoRepository dao = new NotaProdutoRepository();
				Colecao colecao = (Colecao) cbMoeda.getSelectedItem();
				
				notaProduto.setColecao(colecao);
				notaProduto.setQuantidade(txtQuantidade.getText());
				notaProduto.setValorUni(txtQuant.getText());
				dao.inserir(notaProduto);
				JOptionPane.showMessageDialog(null,"NOTA DO PRODUTO GERADA COM SUCESSO"+
						"\nVENDEDOR: "+notaProduto.getColecao().getUsuario()+"\nVALOR: "+notaProduto.getValorUni());
				preencheLIstaColecaoProd();
				
				
				
			}
		});
		btnCriarColec.setBounds(368, 147, 164, 21);
		contentPane.add(btnCriarColec);

		JLabel lblNewLabel_2 = new JLabel("PRODUTOS PARA VENDA");
		lblNewLabel_2.setBounds(10, 65, 263, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("COLEÇÃO DE :");
		lblNewLabel_4.setBounds(10, 197, 186, 13);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_3 = new JLabel("VALOR MOEDA");
		lblNewLabel_3.setBounds(205, 125, 96, 13);
		contentPane.add(lblNewLabel_3);

		txtQuant = new JTextField();
		txtQuant.setBounds(205, 148, 96, 19);
		contentPane.add(txtQuant);
		txtQuant.setColumns(10);
		
		JButton btnNewButton = new JButton("att");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheLIstaColecaoProd();
			}
		});
		btnNewButton.setBounds(757, 211, 85, 21);
		contentPane.add(btnNewButton);
		preencheLIstaColecaoProd();
	
	}

	public void preencheLIsta() {
		MoedaRepository moedaRepository = new MoedaRepository();
		List<Moeda> lista = moedaRepository.listar();
		DefaultTableModel modeloTabela = (DefaultTableModel) table.getModel();
		modeloTabela.setRowCount(0);
		for (Moeda moeda : lista) {
			modeloTabela.addRow(new Object[] { moeda.getCodigoCatalogo(), moeda.getTitulo(), moeda.getPais(),
					moeda.getAno(), moeda.getValor(), moeda.getPeso(), moeda.getEspessura(), moeda.getDiametro(),
					moeda.getBordas(), moeda.getMaterial() });

		}

	}

	public void preencheLIstaColecaoProd() {
		NotaProdutoRepository colecaoRepository = new NotaProdutoRepository();
		List<NotaProduto> lista = colecaoRepository.listar();
		DefaultTableModel modeloTabela = (DefaultTableModel) table.getModel();
		modeloTabela.setRowCount(0);
		for (NotaProduto colecao : lista) {
			modeloTabela.addRow(new Object[] { colecao.getIdNotaProduto(), colecao.getColecao(), colecao.getValorUni() });
		}
	}
}