package oColecionador.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oColecionador.entity.UsuarioEntity;

import oColecionador.service.UsuarioService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField pswSenha;
	private UsuarioService usuarioService = new UsuarioService();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setBounds(100, 100, 426, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblNewLabel.setBounds(128, 31, 188, 53);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setBounds(10, 84, 45, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setBounds(228, 84, 45, 13);
		contentPane.add(lblNewLabel_1_1);

		txtUser = new JTextField();
		txtUser.setBounds(10, 107, 119, 19);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		pswSenha = new JPasswordField();
		pswSenha.setBounds(228, 107, 119, 19);
		contentPane.add(pswSenha);

		JButton btnCadastro = new JButton("CADASTRAR USUÁRIO");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormUsuario formUsuario;
				try {
					formUsuario = new FormUsuario();
					formUsuario.setVisible(true);
				} catch (ParseException e1) {
					// TODO Bloco catch gerado automaticamente
					e1.printStackTrace();
				}

			}
		});
		btnCadastro.setBounds(10, 270, 183, 30);
		contentPane.add(btnCadastro);

		JButton btnEntrar = new JButton("LOGIN");
		btnEntrar.setMnemonic(KeyEvent.VK_ENTER);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioEntity usuarioEntity = new UsuarioEntity();

				TelaPrincipal principal = new TelaPrincipal();
				TelaPrincipalUser principalUser = new TelaPrincipalUser();
				String userLog = null;

				TelaCriarColecao criarColecao = new TelaCriarColecao();
				usuarioEntity.setUser(txtUser.getText());
				usuarioEntity.setSenha(pswSenha.getText());
				usuarioService.login(usuarioEntity);
				if (usuarioService.login(usuarioEntity).booleanValue()) {
					if (usuarioEntity.getSenha().equals("admin") && usuarioEntity.getUser().equals("admin")) {
						userLog = usuarioEntity.getUser();

						principal = new TelaPrincipal();
						principal.setUser(userLog);

						principal.setVisible(true);
						principal.setLocationRelativeTo(null);
						//setVisible(false);

					} else {
						userLog = usuarioEntity.getUser();
						System.out.println(userLog);
						UsuarioEntity sessaoUser = usuarioService.pesquisaUser(userLog);
						System.out.println(sessaoUser);

						principalUser = new TelaPrincipalUser();
						principalUser.setUser(userLog);
						principalUser.setVisible(true);
						criarColecao.setUser(userLog);
					//	setVisible(false);
						principalUser.setLocationRelativeTo(null);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Erro ao logar!!", "Erro", JOptionPane.ERROR_MESSAGE);

				}

				txtUser.setText("");
				pswSenha.setText("");

			}
		});
		btnEntrar.setBounds(124, 163, 119, 30);
		contentPane.add(btnEntrar);

		JLabel lblOColecionador = new JLabel("O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(81, 0, 254, 61);
		contentPane.add(lblOColecionador);

		JButton btnNewButton = new JButton("RECUPERAR SENHA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRecSenha recSenha = new TelaRecSenha();
				recSenha.setVisible(true);
				recSenha.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(217, 270, 183, 30);
		contentPane.add(btnNewButton);
	}

}
