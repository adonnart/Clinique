package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class EcranLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranLogin frame = new EcranLogin();
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
	public EcranLogin() {
		setTitle("Connexion");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrateur\\Desktop\\Ressource\\Images\\ico_veto.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(193, 53, 168, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(193, 119, 168, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(58, 53, 57, 17);
		panel.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMotDePasse.setBounds(58, 119, 94, 17);
		panel.add(lblMotDePasse);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(272, 204, 89, 23);
		panel.add(btnNewButton);
	}
}
