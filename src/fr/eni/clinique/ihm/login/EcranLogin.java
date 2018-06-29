package fr.eni.clinique.ihm.login;

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
import javax.swing.SwingConstants;

public class EcranLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public EcranLogin() {
		
		setResizable(false);
		setTitle("Connexion");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EcranLogin.class.getResource("/fr/eni/clinique/ihm/img/ico_veto.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtNom = new JTextField();
		txtNom.setBounds(193, 102, 168, 20);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 158, 168, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(59, 102, 57, 17);
		panel.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMotDePasse.setBounds(58, 158, 94, 17);
		panel.add(lblMotDePasse);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
			EcranLoginController.get().valider();
			}
		});
		btnValider.setBounds(272, 204, 89, 23);
		panel.add(btnValider);
		
		JLabel lblCliniqueVtrinaire = new JLabel("Clinique v\u00E9t\u00E9rinaire");
		lblCliniqueVtrinaire.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCliniqueVtrinaire.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliniqueVtrinaire.setBounds(59, 35, 302, 27);
		panel.add(lblCliniqueVtrinaire);
		
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
