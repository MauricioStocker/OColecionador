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

public class FormUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtTell;
	private JTextField txtUser;
	private JTextField txtSenha;

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
		setBounds(100, 100, 929, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOColecionador = new JLabel("                    CADASTRO");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(166, 31, 523, 97);
		contentPane.add(lblOColecionador);
		
		JLabel lblNewLabel_1 = new JLabel("NOME");
		lblNewLabel_1.setBounds(26, 103, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(26, 126, 172, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ENDEREÇO");
		lblNewLabel_2.setBounds(395, 103, 98, 13);
		contentPane.add(lblNewLabel_2);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(397, 126, 228, 19);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("E-MAIL");
		lblNewLabel_3.setBounds(26, 187, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(26, 210, 172, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("TELEFONE");
		lblNewLabel_4.setBounds(395, 187, 98, 13);
		contentPane.add(lblNewLabel_4);
		
		txtTell = new JFormattedTextField(new MaskFormatter(" (##)#####-####"));
		txtTell.setBounds(395, 210, 228, 19);
		contentPane.add(txtTell);
		txtTell.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("USUÁRIO DE LOGIN");
		lblNewLabel_5.setBounds(26, 344, 123, 13);
		contentPane.add(lblNewLabel_5);
		
		txtUser = new JTextField();
		txtUser.setBounds(26, 367, 199, 19);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("SENHA");
		lblNewLabel_6.setBounds(395, 344, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(395, 367, 230, 19);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnSalvar = new JButton("CADASTRAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioEntity usuarioEntity = new UsuarioEntity();
				UsuarioService usuarioService = new UsuarioService();
				
				usuarioEntity.setNome(txtNome.getText());
				usuarioEntity.setEndereco(txtEndereco.getText());
				usuarioEntity.setTelefone(txtTell.getText());
				usuarioEntity.setUser(txtUser.getText());
				usuarioEntity.setSenha(txtSenha.getText());
				usuarioEntity.setEmail(txtEmail.getText());
				usuarioService.salvar(usuarioEntity);
				if(usuarioService.salvar(usuarioEntity) == null) {
					
					TelaLogin login = new TelaLogin();
					login.setVisible(true);
				}
				txtNome.setText("");
				txtEndereco.setText("");
				txtTell.setText("");
				txtEmail.setText("");
				txtUser.setText("");
				txtSenha.setText("");
				
				
				
				
			}
		});
		btnSalvar.setBounds(655, 429, 145, 21);
		contentPane.add(btnSalvar);
		
		JLabel lblOColecionador_1 = new JLabel("                    O COLECIONADOR");
		lblOColecionador_1.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador_1.setBounds(155, -32, 523, 97);
		contentPane.add(lblOColecionador_1);
	}
}
