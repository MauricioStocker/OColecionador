package oColecionador.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;

public class TelaAjuda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAjuda frame = new TelaAjuda();
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
	public TelaAjuda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 549, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 102, 478, 395);
		contentPane.add(scrollPane);
		
		JTextPane txtpnAquiEstaO = new JTextPane();
		scrollPane.setViewportView(txtpnAquiEstaO);
		txtpnAquiEstaO.setText("            Aqui está o passo a passo para gerenciar sua coleção de moedas: O Colecionador!\r\n1) Primeiro você escolhe sua moeda para iniciar a coleção, lembrando que em nosso sistema podemos adicionar somente uma moeda por vez, para ser mais divertido e para que você possa escolher realmente a moeda que você quer. A moeda é escolhida no campo MOEDAS CADASTRADAS.\r\n\r\n2) Escolha um nome para sua coleção, esse campo é importante para quando for acessar suas coleções, pois será pelo nome. O nome é preenchido no campo TITULO DA COLEÇÃO.\r\n\r\n3) Após escolher a moeda e criar o nome para sus coleção, clique em CRIAR COLEÇÃO, e pronto a sua coleção esta criada. Você pode visualizar no campo COLEÇÕES, logo abaixo onde se encontra o ESPAÇO DE ADICIONAR MOEDA A COLEÇÃO, esse campo será muito importante, pois é por ele que você adiciona a moeda a coleção, nele que você seleciona a coleção a qual quer adicionar uma moeda.\r\n\r\n4) Adicionar uma moeda na coleção é simples, você só precisa escolher a coleção no ESPAÇO DE ADICIONAR MOEDA A COLEÇÃO, e escolher uma nova moeda no ESPAÇO DE CRIAR COLEÇÃO, pois será lá que vão estar todas as moedas do sistema, não precisa preencher mais o campo TITULO, pois só é preenchido quando for criar uma nova coleção. Escolhido a moeda e a coleção, clique no botão ADICIONAR MOEDAS A COLEÇÃO, e pronto, ela estará vinculada a sua coleção.\r\n\r\n5) Após vincular a moeda a sua coleção, você pode pesquisar através do campo COLEÇÕES, selecione a coleção que deseja visualizar, e na tabela ao lado clique no botão MOSTRAR MOEDAS DA COLEÇÃO, será mostrado todas as moedas que você adicionou a sua coleção, legal né?! \r\n\r\nEspero que esse tutorial te ajudou, faça bom uso de nosso sistema.\r\n");
		
		JLabel lblOColecionador = new JLabel("                    O COLECIONADOR");
		lblOColecionador.setFont(new Font("Goudy Stout", Font.ITALIC, 16));
		lblOColecionador.setBounds(-17, -9, 523, 42);
		contentPane.add(lblOColecionador);
		
		JLabel lblTutorialDeUso = new JLabel("Tutorial de uso de tela criação de coleção");
		lblTutorialDeUso.setFont(new Font("Goudy Stout", Font.ITALIC, 9));
		lblTutorialDeUso.setBounds(31, 24, 523, 58);
		contentPane.add(lblTutorialDeUso);
	}
}
