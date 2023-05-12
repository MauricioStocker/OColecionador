package oColecionador.view;

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
import javax.swing.text.MaskFormatter;

import oColecionador.entity.Colecao;
import oColecionador.entity.Moeda;
import oColecionador.entity.NotaProduto;
import oColecionador.entity.NotaTransacao;
import oColecionador.entity.TipoTransacao;
import oColecionador.entity.Usuario;
import oColecionador.repository.ColecaoRepository;
import oColecionador.repository.MoedaRepository;
import oColecionador.repository.NotaProdutoRepository;
import oColecionador.repository.NotaTransacaoRepository;
import oColecionador.repository.TipoRepository;
import oColecionador.repository.UsuarioRepository;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TelaNotaTransacao extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblUser;
	private JTextField txtValorTRans;
	private JTextField txtDataTrans;
	private JTextField txtNfe;

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
					TelaNotaTransacao frame = new TelaNotaTransacao();
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
	public TelaNotaTransacao() throws ParseException {

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
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID TRANSA\u00C7\u00C3O", "DADOS DO PRODUTO", "COMPRADOR", "VALOR", "DATA"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(568);
		table.getColumnModel().getColumn(3).setPreferredWidth(59);
		table.getColumnModel().getColumn(4).setPreferredWidth(62);

		JLabel lblMoedas = new JLabel("                    NOTAS GERADAS TRANSAÇÃO");
		lblMoedas.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblMoedas.setBounds(113, 208, 670, 97);
		contentPane.add(lblMoedas);

		JComboBox cbUserLog = new JComboBox();
		cbUserLog.setEnabled(false);
		cbUserLog.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				// responsavel para mostrar o usuário logado usando o lbl para pesquisar o
				// usuário
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
				// responsavel para buscar o usuário para ser usando no metodo de retorno do
				// usuario logado das coleções moeda
				/*
				 * UsuarioRepository repository1 = new UsuarioRepository(); Usuario userLog =
				 * repository1.pesquisaPeloUser(lblUser.getText());
				 */
				NotaProdutoRepository repository = new NotaProdutoRepository();
				List<NotaProduto> notasProdutoVenda = repository.obterNotasProdutoVenda();
				for (NotaProduto notaProduto : notasProdutoVenda) {
					cbMoeda.addItem(notaProduto);
				}

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbMoeda.setBounds(10, 82, 827, 21);
		contentPane.add(cbMoeda);
		Colecao colecao = (Colecao) cbMoeda.getSelectedItem();
		JLabel lblNewLabel = new JLabel("Valor da transação");
		lblNewLabel.setBounds(10, 125, 112, 13);
		contentPane.add(lblNewLabel);

		txtValorTRans = new JFormattedTextField(new MaskFormatter(" ###.###"));
		txtValorTRans.setBounds(10, 147, 96, 19);
		contentPane.add(txtValorTRans);
		txtValorTRans.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Data da transação");
		lblNewLabel_3.setBounds(193, 125, 112, 13);
		contentPane.add(lblNewLabel_3);

		txtDataTrans = new JFormattedTextField(new MaskFormatter(" ##/##/####"));
		txtDataTrans.setBounds(190, 147, 96, 19);
		contentPane.add(txtDataTrans);
		txtDataTrans.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel(" NF-e");
		lblNewLabel_5.setBounds(362, 125, 45, 13);
		contentPane.add(lblNewLabel_5);

		txtNfe = new JFormattedTextField(new MaskFormatter(" ###.###.###"));
		txtNfe.setBounds(362, 147, 119, 19);
		contentPane.add(txtNfe);
		txtNfe.setColumns(10);
		JButton btnCriarColec = new JButton("Salvar Venda");
		btnCriarColec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColecaoRepository colecaoRepository = new ColecaoRepository();
				NotaTransacao notaTransacao = new NotaTransacao();
				NotaTransacaoRepository notaTransacaoRepository = new NotaTransacaoRepository();
				NotaProduto notaProduto = (NotaProduto) cbMoeda.getSelectedItem();
				Usuario usuario = (Usuario) cbUserLog.getSelectedItem();
				notaTransacao.setData(txtDataTrans.getText());
				notaTransacao.setNotaProduto(notaProduto);
				notaTransacao.setValor(txtValorTRans.getText());
				notaTransacao.setNumNota(txtNfe.getText());
				notaTransacao.setUsuario(usuario);
				notaTransacaoRepository.inserir(notaTransacao);
				JOptionPane.showMessageDialog(null,"NOTA DA VENDA GERADA COM SUCESSO"+"\nCOMPRADOR: " +notaTransacao.getUsuario()+"\nVENDEDOR: "
				+ notaTransacao.getNotaProduto().getColecao().getUsuario());
				preencheLIstaColecaoProd();

				Colecao alterStatus = colecaoRepository.pesquisaPeloId(notaProduto.getColecao().getIdColecao());

				JOptionPane.showMessageDialog(null, alterStatus);
				
				
			}
		});
		btnCriarColec.setBounds(572, 146, 164, 21);
		contentPane.add(btnCriarColec);

		JLabel lblNewLabel_2 = new JLabel("NOTAS DOS PRODUTOS A VENDA");
		lblNewLabel_2.setBounds(10, 65, 276, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("COMPRADOR  :");
		lblNewLabel_4.setBounds(10, 197, 186, 13);
		contentPane.add(lblNewLabel_4);

		preencheLIstaColecaoProd();

	}

	public void preencheLIstaColecao() {
		NotaProdutoRepository colecaoRepository = new NotaProdutoRepository();
		List<NotaProduto> lista = colecaoRepository.obterNotasProdutoVenda();
		DefaultTableModel modeloTabela = (DefaultTableModel) table.getModel();
		modeloTabela.setRowCount(0);
		for (NotaProduto colecao : lista) {
			modeloTabela
					.addRow(new Object[] { colecao.getIdNotaProduto(), colecao.getColecao(), colecao.getValorUni() });
		}
	}

	public void preencheLIstaColecaoProd() {
		NotaTransacaoRepository notaTransacaoRepository = new NotaTransacaoRepository();
		List<NotaTransacao> lista = notaTransacaoRepository.listar();
		DefaultTableModel modeloTabela = (DefaultTableModel) table.getModel();
		modeloTabela.setRowCount(0);
		for (NotaTransacao transacao : lista) {
			modeloTabela
					.addRow(new Object[] {transacao.getIdTransacao(), transacao.getNotaProduto(), transacao.getUsuario(), transacao.getValor(), transacao.getData()  });
		}
	}

}