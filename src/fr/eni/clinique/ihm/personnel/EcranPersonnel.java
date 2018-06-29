package fr.eni.clinique.ihm.personnel;


import javax.swing.JInternalFrame;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.border.MatteBorder;

import com.sun.xml.internal.ws.wsdl.OperationDispatcher;

import fr.eni.clinique.ihm.login.EcranLoginController;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EcranPersonnel extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4668576527947146408L;
	
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
		
		JButton btnAjouter = new JButton("");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				  JPanel p = new JPanel(new BorderLayout(5,5));
//			        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
//			        labels.add(new JLabel("User Name", SwingConstants.RIGHT));
//			        labels.add(new JLabel("Password", SwingConstants.RIGHT));
//			        p.add(labels, BorderLayout.WEST);
//			        JPanel controls = new JPanel(new GridLayout(0,1,2,2));
//			        JTextField username = new JTextField("");
//			       controls.add(username);
//			        JTextField password = new JTextField("");
//			       controls.add(password);
//			        p.add(controls, BorderLayout.CENTER);
//			        JOptionPane.showInputDialog(p);
				EcranPersonnelController.get().ajouter();
			        
			        
			}
		});
      
        
		btnAjouter.setIcon(new ImageIcon("C:\\Users\\Administrateur\\Desktop\\Ressource\\Images\\plus.png"));
		btnAjouter.setBounds(40, 11, 38, 37);
		panel.add(btnAjouter);
		
		JButton btnSurpprimer = new JButton("");
		btnSurpprimer.setIcon(new ImageIcon("C:\\Users\\Administrateur\\Desktop\\Ressource\\Images\\minus.png"));
		btnSurpprimer.setBounds(140, 11, 38, 37);
		panel.add(btnSurpprimer);
		
		JButton btnReinitialiser = new JButton("");
		btnReinitialiser.setIcon(new ImageIcon("C:\\Users\\Administrateur\\Desktop\\Ressource\\Images\\lock_open.png"));
		btnReinitialiser.setBounds(240, 11, 38, 37);
		panel.add(btnReinitialiser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(300, 235, 532, 271);
		getContentPane().add(panel_2);
		TablePersonnel modele = new TablePersonnel(EcranPersonnelController.get().getListPersonnel());
		JScrollPane scrollPane = new JScrollPane(modele);
		scrollPane.setPreferredSize(new Dimension(519, 260));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_2.add(scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("Gestion du personnel");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setBounds(28, 11, 241, 43);
		getContentPane().add(lblNewLabel_3);
	}		
}
