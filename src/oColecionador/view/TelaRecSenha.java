package oColecionador.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oColecionador.entity.Usuario;
import oColecionador.repository.UsuarioRepository;
import oColecionador.service.UsuarioService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRecSenha extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRecSenha frame = new TelaRecSenha();
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
	public TelaRecSenha() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOColecionador = new JLabel("                    O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(-65, -15, 523, 97);
		contentPane.add(lblOColecionador);

		JLabel lblRecuperaoDeSenha = new JLabel("                     Recuperação de senha");
		lblRecuperaoDeSenha.setFont(new Font("Goudy Stout", Font.ITALIC, 10));
		lblRecuperaoDeSenha.setBounds(0, 29, 523, 97);
		contentPane.add(lblRecuperaoDeSenha);

		JLabel lblNewLabel = new JLabel("EMAIL DE RECUPEÇÃO");
		lblNewLabel.setBounds(10, 110, 179, 13);
		contentPane.add(lblNewLabel);

		txtEmail = new JTextField();
		txtEmail.setBounds(10, 131, 327, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnNewButton = new JButton("BUSCAR SENHA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuarioRepository repository = new UsuarioRepository();
				
				Usuario Recupera = repository.pesquisaPeloEmail(txtEmail.getText());
				if(Recupera == null) {
					
				}else {
					JOptionPane.showMessageDialog(null,"Olá "+Recupera.getNome()+ "\nSUA SENHA É: "+Recupera.getSenha());
				}
				

			}
		});
		btnNewButton.setBounds(148, 214, 189, 21);
		contentPane.add(btnNewButton);
	}
}
