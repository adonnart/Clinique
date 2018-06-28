package fr.eni.clinique.ihm.accueil;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;


public class Accueil extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2588312367978048710L;

	/**
	 * Create the frame.
	 */
	public Accueil() {
		setMaximizable(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBorder(null);
		setBounds(100, 100, 500, 500);
		getContentPane().setLayout(null);

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(182, 151, 170, 170);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrateur\\Desktop\\Ressource\\Images\\fond_frame.jpg"));
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Clinique v\u00E9t\u00E9rinaire");
		label.setVerticalTextPosition(SwingConstants.TOP);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalTextPosition(SwingConstants.LEFT);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(170, 27, 182, 24);
		getContentPane().add(label);

	}

}
