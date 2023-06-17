package oColecionador.view;

import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import oColecionador.entity.UsuarioEntity;
import oColecionador.service.UsuarioService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

public class FormUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtTell;
	private JTextField txtUser;
	private JPasswordField pswSenha;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormUsuario frame = new FormUsuario();
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
	public FormUsuario() throws ParseException {
		setBounds(100, 100, 688, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOColecionador = new JLabel("                    CADASTRO");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(180, 21, 523, 35);
		contentPane.add(lblOColecionador);

		JLabel lblNewLabel_1 = new JLabel("NOME");
		lblNewLabel_1.setBounds(10, 57, 45, 13);
		contentPane.add(lblNewLabel_1);

		txtNome = new JTextField();
		txtNome.setBounds(10, 76, 172, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("ENDEREÇO");
		lblNewLabel_2.setBounds(397, 57, 98, 13);
		contentPane.add(lblNewLabel_2);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(395, 76, 228, 19);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("E-MAIL");
		lblNewLabel_3.setBounds(10, 106, 45, 13);
		contentPane.add(lblNewLabel_3);

		txtEmail = new JTextField();
		txtEmail.setBounds(10, 126, 172, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("TELEFONE");
		lblNewLabel_4.setBounds(397, 106, 98, 13);
		contentPane.add(lblNewLabel_4);

		txtTell = new JFormattedTextField(new MaskFormatter(" (##)#####-####"));
		txtTell.setBounds(395, 126, 228, 19);
		contentPane.add(txtTell);
		txtTell.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("USUÁRIO DE LOGIN");
		lblNewLabel_5.setBounds(10, 208, 123, 13);
		contentPane.add(lblNewLabel_5);

		txtUser = new JTextField();
		txtUser.setBounds(10, 232, 172, 19);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("SENHA");
		lblNewLabel_6.setBounds(10, 158, 45, 13);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(397, 157, 46, 14);
		contentPane.add(lblNewLabel);

		JTextField txtCpf = new JFormattedTextField(new MaskFormatter(" ###-###-###.##"));
		txtCpf.setBounds(397, 177, 226, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		JButton btnSalvar = new JButton("CADASTRAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioEntity usuarioEntity = new UsuarioEntity();
				UsuarioService usuarioService = new UsuarioService();

				usuarioEntity.setNome(txtNome.getText());
				String nomeTitulo = txtNome.getText().trim();
				// Verifica se o campo está vazio
				if (nomeTitulo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo Nome não pode estar vazio.");
					return;
				}

				if (nomeTitulo.isEmpty() || nomeTitulo.isBlank() || nomeTitulo.matches("\\s+\\w+")) {
					JOptionPane.showMessageDialog(null,
							"O campo Nome não pode estar vazio ou conter apenas espaços em branco.");
					return;
				}

				// Verifica se o campo está vazio, contém apenas espaços em branco ou consiste
				// em espaços em branco seguidos de uma letra
				String nomeSemEspacos = nomeTitulo.trim();
				if (nomeSemEspacos.isEmpty() || nomeSemEspacos.length() == 1) {
					JOptionPane.showMessageDialog(null,
							"O campo Nome não pode estar vazio ou conter apenas espaços em branco.");
					return;
				}
				// Verifica o tamanho mínimo do nome
				if (nomeSemEspacos.length() < 4) {
					JOptionPane.showMessageDialog(null, "O campo Nome deve ter no mínimo 4 caracteres.");
					return;
				}

				// Verifica o tamanho máximo do nome
				if (nomeSemEspacos.length() >= 30) {
					JOptionPane.showMessageDialog(null, "O campo Nome deve ter no máximo 30 caracteres.");
					return;
				}
				usuarioEntity.setEndereco(txtEndereco.getText());
				usuarioEntity.setTelefone(txtTell.getText());
				usuarioEntity.setUser(txtUser.getText());
				usuarioEntity.setSenha(pswSenha.getText());
				String email = txtEmail.getText();
				if (email == null || email.isEmpty()) {
					JOptionPane.showMessageDialog(null, "preencha o campo email !!.");
					return; // E-mail inválido
				}

				// Verifica se o e-mail possui um formato válido
				String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
				if (!email.matches(regex)) {
					JOptionPane.showMessageDialog(null, "Email fora dos padrões de ex: nome@nome.com.br");
					return; // E-mail inválido
				}

				usuarioEntity.setEmail(txtEmail.getText());

				String cpf = txtCpf.getText();
				if (validarCPF(cpf)) {
					
					usuarioEntity.setCpf(cpf);
					usuarioService.salvar(usuarioEntity);
				} else {
					JOptionPane.showMessageDialog(null, "CPF INVÁLIDO !!!");
					txtCpf.setText("");
					return;
				}
				usuarioEntity.setCpf(txtCpf.getText());
				usuarioService.salvar(usuarioEntity);
				if (usuarioService.salvar(usuarioEntity) == null) {

					TelaLogin login = new TelaLogin();
					login.setVisible(true);
				}
				txtNome.setText("");
				txtEndereco.setText("");
				txtTell.setText("");
				txtEmail.setText("");
				txtUser.setText("");
				pswSenha.setText("");
				txtCpf.setText("");

			}
		});
		btnSalvar.setBounds(26, 450, 145, 21);
		contentPane.add(btnSalvar);

		JLabel lblOColecionador_1 = new JLabel("                    O COLECIONADOR");
		lblOColecionador_1.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador_1.setBounds(155, -32, 523, 97);
		contentPane.add(lblOColecionador_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 262, 588, 136);
		contentPane.add(scrollPane);

		JTextArea txtrALeiGeral = new JTextArea();
		txtrALeiGeral.setLineWrap(true);
		scrollPane.setViewportView(txtrALeiGeral);
		txtrALeiGeral.setText(
				"A Lei Geral de Proteção de Dados (LGPD) é uma legislação que\r\n tem como objetivo proteger os dados pessoais dos usuários. No sistema \r\n\"O Colecionador\", seguimos rigorosamente as diretrizes e normas estabelecidas pela LGPD.\r\nOs dados pessoais fornecidos pelos usuários, como nome e informações de contato, são armazenados de forma segura e utilizados apenas para os fins previstos no sistema, como o gerenciamento das coleções de moedas.\r\nGarantimos a confidencialidade e integridade dos dados pessoais, adotando medidas de segurança adequadas para protegê-los contra acessos não autorizados, perda ou alteração indevida.\r\n\r\nAlém disso, respeitamos os direitos dos usuários, como o acesso aos seus dados, a correção de informações incorretas e a exclusão dos dados quando solicitado.\r\n\r\nEstamos comprometidos em manter a privacidade e a segurança dos dados dos usuários, atendendo aos princípios e obrigações estabelecidos pela LGPD.");

		JCheckBox chckbxNewCheckBox = new JCheckBox("Aceito os termos.");
		chckbxNewCheckBox.setBounds(10, 401, 145, 23);
		contentPane.add(chckbxNewCheckBox);

		pswSenha = new JPasswordField();
		pswSenha.setBounds(10, 177, 172, 20);
		contentPane.add(pswSenha);

	}

	private boolean validarEmail(String email) {
		// Verifica se o e-mail está vazio ou é nulo
		if (email == null || email.isEmpty()) {
			return false; // E-mail inválido
		}

		// Verifica se o e-mail possui um formato válido
		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		if (!email.matches(regex)) {
			return false; // E-mail inválido
		}

		return true; // E-mail válido
	}

	public boolean validarCPF(String cpf) {
		// Remove caracteres não numéricos
		cpf = cpf.replaceAll("[^0-9]", "");

		// Verifica se possui 11 dígitos
		if (cpf.length() != 11) {
			return false;
		}

		// Verifica se todos os dígitos são iguais
		boolean digitosIguais = true;
		for (int i = 1; i < 11; i++) {
			if (cpf.charAt(i) != cpf.charAt(0)) {
				digitosIguais = false;
				break;
			}
		}
		if (digitosIguais) {
			return false;
		}

		// Calcula o primeiro dígito verificador
		int soma = 0;
		for (int i = 0; i < 9; i++) {
			soma += (cpf.charAt(i) - '0') * (10 - i);
		}
		int resto = soma % 11;
		int digito1 = (resto < 2) ? 0 : (11 - resto);

		// Verifica o primeiro dígito verificador
		if (digito1 != (cpf.charAt(9) - '0')) {
			return false;
		}

		// Calcula o segundo dígito verificador
		soma = 0;
		for (int i = 0; i < 10; i++) {
			soma += (cpf.charAt(i) - '0') * (11 - i);
		}
		resto = soma % 11;
		int digito2 = (resto < 2) ? 0 : (11 - resto);

		// Verifica o segundo dígito verificador
		if (digito2 != (cpf.charAt(10) - '0')) {
			return false;
		}

		// CPF válido
		return true;
	}
}
