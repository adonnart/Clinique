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
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.border.MatteBorder;

import com.sun.xml.internal.ws.wsdl.OperationDispatcher;

import fr.eni.clinique.ihm.form.FormulaireController;
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
	private TablePersonnel modele ;
	public EcranPersonnel() {
		setResizable(false);
		setBorder(null);
		setBounds(0,-25,1200, 800);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(300, 103, 532, 84);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supprimer");
		lblNewLabel.setBounds(136, 59, 62, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Reinitialiser");
		lblNewLabel_1.setBounds(234, 59, 75, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ajouter");
		lblNewLabel_2.setBounds(41, 59, 46, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnAjouter = new JButton("");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormulaireController.get().openFormulaire();	        		        
			}
		});
      
        
		btnAjouter.setIcon(new ImageIcon(EcranPersonnel.class.getResource("/fr/eni/clinique/ihm/img/plus.png")));
		btnAjouter.setBounds(40, 11, 38, 37);
		panel.add(btnAjouter);
		
		JButton btnSurpprimer = new JButton("");
		btnSurpprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(getTablePersonnel().getSelectedRow()>= 0){
					 int a=JOptionPane.showConfirmDialog(new Frame(),"Voulez vous vraiment supprimer ce personnel?","Supprimer", JOptionPane.YES_NO_OPTION);  
					 if(a==JOptionPane.YES_OPTION){  
						EcranPersonnelController.get().supprimer();	
					 }
				}
				else
					JOptionPane.showMessageDialog(new Frame(), "Il faut choisir un personnel pour le supprimer", "", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnSurpprimer.setIcon(new ImageIcon(EcranPersonnel.class.getResource("/fr/eni/clinique/ihm/img/minus.png")));
		btnSurpprimer.setBounds(140, 11, 38, 37);
		panel.add(btnSurpprimer);
		
		JButton btnReinitialiser = new JButton("");
		btnReinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(getTablePersonnel().getSelectedRow()>= 0)
					ChangerMDPController.get().openChangerMDP();
				else
					JOptionPane.showMessageDialog(new Frame(), "Il faut choisir un personnel pour changer son MDP", "", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnReinitialiser.setIcon(new ImageIcon(EcranPersonnel.class.getResource("/fr/eni/clinique/ihm/img/lock_open.png")));
		btnReinitialiser.setBounds(240, 11, 38, 37);
		panel.add(btnReinitialiser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(300, 235, 532, 271);
		getContentPane().add(panel_2);
		JScrollPane scrollPane = new JScrollPane(getTablePersonnel());
		scrollPane.setPreferredSize(new Dimension(519, 260));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_2.add(scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("Gestion du personnel");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setBounds(28, 11, 241, 43);
		getContentPane().add(lblNewLabel_3);
	}		
	public TablePersonnel getTablePersonnel() {
		if(modele == null) {
			modele= new TablePersonnel(EcranPersonnelController.get().getListPersonnel());
		}
		return modele;
	}

	
}
