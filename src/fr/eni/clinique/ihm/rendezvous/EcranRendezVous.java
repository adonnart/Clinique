package fr.eni.clinique.ihm.rendezvous;


import javax.swing.JInternalFrame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

public class EcranRendezVous extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4668576527947146408L;
	private JTable table;


	public EcranRendezVous() {
		setTitle("Prise de rendez-vous");
		setResizable(false);
		setBorder(null);
		setBounds(0,-22,850, 550);
		getContentPane().setLayout(null);
		
		JPanel PAN_Pour = new JPanel();
		PAN_Pour.setToolTipText("");
		PAN_Pour.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		PAN_Pour.setBounds(25, 25, 250, 150);
		getContentPane().add(PAN_Pour);
		PAN_Pour.setLayout(null);
		
		JPanel PAN_Client = new JPanel();
		PAN_Client.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PAN_Client.setBounds(19, 34, 210, 50);
		PAN_Pour.add(PAN_Client);
		PAN_Client.setLayout(null);
		
		JComboBox CMB_Client = new JComboBox();
		CMB_Client.setBounds(6, 16, 150, 25);
		PAN_Client.add(CMB_Client);
		
		JButton BTN_Client = new JButton("+");
		BTN_Client.setBounds(175, 16, 25, 25);
		PAN_Client.add(BTN_Client);
		BTN_Client.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblPour = new JLabel("Pour");
		lblPour.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPour.setBounds(10, 10, 50, 15);
		PAN_Pour.add(lblPour);
		
		JPanel PAN_Animal = new JPanel();
		PAN_Animal.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PAN_Animal.setBounds(19, 84, 210, 50);
		PAN_Pour.add(PAN_Animal);
		PAN_Animal.setLayout(null);
		
		JComboBox CMB_Animal = new JComboBox();
		CMB_Animal.setBounds(6, 16, 150, 25);
		PAN_Animal.add(CMB_Animal);
		
		JButton BTN_Animal = new JButton("+");
		BTN_Animal.setBounds(175, 16, 25, 25);
		PAN_Animal.add(BTN_Animal);
		BTN_Animal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel PAN_Par = new JPanel();
		PAN_Par.setToolTipText("");
		PAN_Par.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		PAN_Par.setBounds(300, 25, 250, 150);
		getContentPane().add(PAN_Par);
		PAN_Par.setLayout(null);
		
		JLabel lblPar = new JLabel("Par");
		lblPar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPar.setBounds(10, 10, 50, 15);
		PAN_Par.add(lblPar);
		
		JPanel PAN_Veto = new JPanel();
		PAN_Veto.setLayout(null);
		PAN_Veto.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PAN_Veto.setBounds(19, 34, 210, 50);
		PAN_Par.add(PAN_Veto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(6, 16, 150, 25);
		PAN_Veto.add(comboBox);
		
		JPanel PAN_Quand = new JPanel();
		PAN_Quand.setToolTipText("");
		PAN_Quand.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		PAN_Quand.setBounds(575, 25, 250, 150);
		getContentPane().add(PAN_Quand);
		PAN_Quand.setLayout(null);
		
		JLabel lblQuand = new JLabel("Quand");
		lblQuand.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuand.setBounds(10, 10, 50, 15);
		PAN_Quand.add(lblQuand);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(25, 200, 800, 250);
		getContentPane().add(table);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(600, 470, 100, 30);
		getContentPane().add(btnSupprimer);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(725, 470, 100, 30);
		getContentPane().add(btnValider);
	}		
}
