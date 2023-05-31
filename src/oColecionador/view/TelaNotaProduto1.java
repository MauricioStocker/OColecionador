package oColecionador.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.event.AncestorListener;

import oColecionador.entity.ColecaoEntity;
import oColecionador.entity.UsuarioEntity;
import oColecionador.repository.ColecaoRepository;
import oColecionador.repository.UsuarioRepository;
import oColecionador.service.ColecaoService;
import oColecionador.service.UsuarioService;

import javax.swing.event.AncestorEvent;

public class TelaNotaProduto1 extends JFrame {

	private JPanel contentPane;
	private JLabel lblUser;
	private JComboBox cbUserLog;
	private JComboBox cbColecao;
	private UsuarioService usuarioService = new UsuarioService();
	private ColecaoService colecaoService = new ColecaoService();

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
					TelaNotaProduto1 frame = new TelaNotaProduto1();
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
	public TelaNotaProduto1() {
		setBounds(100, 100, 1161, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Usuário  :");
		lblNewLabel_1.setBounds(10, 23, 76, 13);
		contentPane.add(lblNewLabel_1);

		lblUser = new JLabel("...");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(69, 15, 263, 25);
		contentPane.add(lblUser);

		JLabel lblNewLabel_4 = new JLabel("COLEÇÃO DE :");
		lblNewLabel_4.setBounds(10, 47, 186, 13);
		contentPane.add(lblNewLabel_4);

		cbUserLog = new JComboBox();
		cbUserLog.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {

				userLogado();
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbUserLog.setEnabled(false);
		cbUserLog.setBounds(102, 42, 275, 22);
		contentPane.add(cbUserLog);

		JLabel lblNewLabel_2 = new JLabel("PRODUTOS PARA VENDA");
		lblNewLabel_2.setBounds(10, 105, 263, 13);
		contentPane.add(lblNewLabel_2);

		cbColecao = new JComboBox();
		cbColecao.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				carregaCbColecao();
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		cbColecao.setBounds(10, 118, 1113, 22);
		contentPane.add(cbColecao);

	}

	public void userLogado() {

		UsuarioEntity userLog = usuarioService.pesquisaUser(lblUser.getText());
		cbUserLog.addItem(userLog);
	}

	public void carregaCbColecao() {
		UsuarioEntity userLog = usuarioService.pesquisaUser(lblUser.getText());
		for (ColecaoEntity p : colecaoService.listarColecaoUserLogado(userLog)) {

			cbColecao.addItem(p);

		}

	}
}
