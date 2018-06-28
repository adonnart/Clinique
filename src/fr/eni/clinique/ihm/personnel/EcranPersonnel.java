package fr.eni.clinique.ihm.personnel;


import javax.swing.JInternalFrame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class EcranPersonnel extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4668576527947146408L;
	private JTable table;


	public EcranPersonnel() {
		setResizable(false);
		setBorder(null);
		setBounds(0,-22,1200, 600);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(300, 103, 532, 84);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supprimer");
		lblNewLabel.setBounds(136, 59, 53, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("R\u00E9initialiser");
		lblNewLabel_1.setBounds(234, 59, 75, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ajouter");
		lblNewLabel_2.setBounds(41, 59, 46, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Administrateur\\Desktop\\Ressource\\Images\\plus.png"));
		btnNewButton.setBounds(40, 11, 38, 37);
		panel.add(btnNewButton);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Administrateur\\Desktop\\Ressource\\Images\\minus.png"));
		button.setBounds(140, 11, 38, 37);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Administrateur\\Desktop\\Ressource\\Images\\lock_open.png"));
		button_1.setBounds(240, 11, 38, 37);
		panel.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(300, 235, 532, 271);
		getContentPane().add(panel_2);
		
		table = new JTable();		
		panel_2.add(table);
		
		JLabel lblNewLabel_3 = new JLabel("Gestion du personnel");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setBounds(28, 11, 241, 43);
		getContentPane().add(lblNewLabel_3);
	}		
		
}
