package fr.eni.clinique.ihm.client;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class EcranClient extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public EcranClient() {
		setBounds(0,-28,1200, 800);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(106, 81, 1001, 88);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(EcranClient.class.getResource("/fr/eni/clinique/ihm/img/magnifying_glass.png")));
		button.setBounds(10, 26, 38, 37);
		panel.add(button);
		
		JLabel lblGestionDesClients = new JLabel("Gestion des clients");
		lblGestionDesClients.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblGestionDesClients.setBounds(24, 11, 241, 43);
		getContentPane().add(lblGestionDesClients);

	}
}
