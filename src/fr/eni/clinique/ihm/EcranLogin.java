package fr.eni.clinique.ihm;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class EcranLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JButton btnValider;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */

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
		
		txtNom = new JTextField();
		txtNom.setBounds(193, 53, 168, 20);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 119, 168, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(58, 53, 57, 17);
		panel.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMotDePasse.setBounds(58, 119, 94, 17);
		panel.add(lblMotDePasse);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
			EcranLoginController.get().valider();
			}
		});
		btnValider.setBounds(272, 204, 89, 23);
		panel.add(btnValider);
		
	}
	public JTextField getTxtNom() {
		if(txtNom == null) {
			txtNom = new JTextField(30);
		}
		return txtNom;
	}
	public JPasswordField getPassField() {
		if(passwordField == null) {
			passwordField= new JPasswordField(30);
		}
		return passwordField;
	}
	
	public void msgErreur(String msg) {
		JOptionPane.showMessageDialog(EcranLogin.this, msg, "", JOptionPane.ERROR_MESSAGE);
	}
}
