package fr.eni.clinique.ihm.rendezvous;

import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.UtilDateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;

public class EcranRendezVous extends JInternalFrame {

	private static final long serialVersionUID = -4668576527947146408L;
	
	private static JPanel PAN_Pour, PAN_Par, PAN_Quand, PAN_Client, PAN_Animal, PAN_Veto, PAN_Date, PAN_Heure;
	private static JButton BTN_AddClient, BTN_AddAnimal, BTN_Supprimer, BTN_Valider;
	private static JComboBox<String> CMB_Client, CMB_Animal, CMB_Veto;
	private static JComboBox<Integer> CMB_Heure, CMB_Minute;
	private static TitledBorder BOR_Empty, BOR_Line;
	private static JDatePickerImpl DAT_DatePicker;
	private static JDatePanelImpl DAT_DatePanel;
	private static Properties PRO_Perties;
	private static Font FON_ArialBold;
	private static Container CON_Main;
	private static JTable TAB_Agenda;
	private static JLabel LAB_Heure;
	
	public EcranRendezVous() {
		
		this.setTitle("Prise de rendez-vous");
		this.setResizable(true);
		this.setBorder(null);
		this.setBounds(0, 0, 850, 550);
		
		CON_Main = this.getContentPane();
		CON_Main.setLayout(null);
		
		FON_ArialBold = new Font("Arial", Font.BOLD, 12);
		
		BOR_Empty = new TitledBorder(BorderFactory.createEmptyBorder());
		BOR_Line = new TitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		PAN_Pour = new JPanel();
		PAN_Pour.setBorder(new TitledBorder(BOR_Line, "Pour", 0, 0, FON_ArialBold));
		PAN_Pour.setBounds(25, 25, 250, 150);
		PAN_Pour.setLayout(null);
		
		PAN_Par = new JPanel();
		PAN_Par.setBorder(new TitledBorder(BOR_Line, "Par", 0, 0, FON_ArialBold));
		PAN_Par.setBounds(300, 25, 250, 150);
		PAN_Par.setLayout(null);
		
		PAN_Quand = new JPanel();
		PAN_Quand.setBorder(new TitledBorder(BOR_Line, "Quand", 0, 0, FON_ArialBold));
		PAN_Quand.setBounds(575, 25, 250, 150);
		PAN_Quand.setLayout(null);
		
		PAN_Client = new JPanel();
		PAN_Client.setBorder(new TitledBorder(BOR_Empty, "Client", 0, 0));
		PAN_Client.setBounds(20, 30, 210, 50);
		PAN_Client.setLayout(null);
		
		PAN_Animal = new JPanel();
		PAN_Animal.setBorder(new TitledBorder(BOR_Empty, "Animal", 0, 0));
		PAN_Animal.setBounds(20, 80, 210, 50);
		PAN_Animal.setLayout(null);
		
		PAN_Veto = new JPanel();
		PAN_Veto.setBorder(new TitledBorder(BOR_Empty, "Vétérinaire", 0, 0));
		PAN_Veto.setBounds(20, 30, 210, 50);
		PAN_Veto.setLayout(null);
		
		PAN_Date = new JPanel();
		PAN_Date.setBorder(new TitledBorder(BOR_Empty, "Date", 0, 0));
		PAN_Date.setBounds(20, 30, 210, 50);
		PAN_Date.setLayout(null);
		
		PAN_Heure = new JPanel();
		PAN_Heure.setBorder(new TitledBorder(BOR_Empty, "Heure", 0, 0));
		PAN_Heure.setBounds(20, 80, 210, 50);
		PAN_Heure.setLayout(null);
		
		CMB_Client = new JComboBox<String>();
		CMB_Client.setBounds(5, 15, 150, 25);
		
		BTN_AddClient = new JButton("+");
		BTN_AddClient.setBounds(175, 15, 25, 25);
		//BTN_AddClient.setFont(FON_ArialBold);
		
		CMB_Animal = new JComboBox<String>();
		CMB_Animal.setBounds(5, 15, 150, 25);
		
		BTN_AddAnimal = new JButton("+");
		BTN_AddAnimal.setBounds(175, 15, 25, 25);
		//BTN_AddAnimal.setFont(FON_ArialBold);
		
		CMB_Veto = new JComboBox<String>();
		CMB_Veto.setBounds(5, 15, 150, 25);
		
		PRO_Perties = new Properties();
		PRO_Perties.put("text.today", "Today");
		PRO_Perties.put("text.month", "Month");
		PRO_Perties.put("text.year", "Year");
		
		DAT_DatePanel = new JDatePanelImpl(new UtilDateModel(), PRO_Perties);
		
		DAT_DatePicker = new JDatePickerImpl(DAT_DatePanel, new DateLabelFormatter());
		DAT_DatePicker.getJFormattedTextField().setPreferredSize(new Dimension(175, 25));
		DAT_DatePicker.getJFormattedTextField().setBackground(Color.WHITE);
		DAT_DatePicker.setBorder(null);
		DAT_DatePicker.setSize(200, 25);
		DAT_DatePicker.setLocation(5, 15);
		
		CMB_Heure = new JComboBox<Integer>();
		CMB_Heure.setBounds(5, 15, 80, 25);
		
		LAB_Heure = new JLabel("h");
		LAB_Heure.setBounds(90, 15, 10, 25);
		
		CMB_Minute = new JComboBox<Integer>();
		CMB_Minute.setBounds(100, 15, 80, 25);
		
		TAB_Agenda = new JTable();
		TAB_Agenda.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		TAB_Agenda.setBounds(25, 200, 800, 250);
		
		BTN_Supprimer = new JButton("Supprimer");
		BTN_Supprimer.setBounds(600, 470, 100, 30);
		
		BTN_Valider = new JButton("Valider");
		BTN_Valider.setBounds(725, 470, 100, 30);
		
		PAN_Client.add(CMB_Client);
		PAN_Client.add(BTN_AddClient);
		PAN_Animal.add(CMB_Animal);
		PAN_Animal.add(BTN_AddAnimal);
		PAN_Veto.add(CMB_Veto);
		PAN_Date.add(DAT_DatePicker);
		PAN_Heure.add(CMB_Heure);
		PAN_Heure.add(LAB_Heure);
		PAN_Heure.add(CMB_Minute);
		
		PAN_Pour.add(PAN_Client);
		PAN_Pour.add(PAN_Animal);
		PAN_Par.add(PAN_Veto);
		PAN_Quand.add(PAN_Date);
		PAN_Quand.add(PAN_Heure);
		
		CON_Main.add(PAN_Pour);
		CON_Main.add(PAN_Par);
		CON_Main.add(PAN_Quand);
		CON_Main.add(TAB_Agenda);
		CON_Main.add(BTN_Supprimer);
		CON_Main.add(BTN_Valider);
		
	}

}