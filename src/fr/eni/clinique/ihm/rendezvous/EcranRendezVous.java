package fr.eni.clinique.ihm.rendezvous;

import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JInternalFrame;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

//import javafx.scene.control.DatePicker;

public class EcranRendezVous extends JInternalFrame {

	private static final long serialVersionUID = -4668576527947146408L;
	
	private static Container CON_Main;
	private static JPanel PAN_Pour, PAN_Par, PAN_Quand, PAN_Client, PAN_Animal, PAN_Veto, PAN_Calendar;
	private static JButton BTN_AddClient, BTN_AddAnimal, BTN_Supprimer, BTN_Valider;
	private static JComboBox<String> CMB_Client, CMB_Animal, CMB_Veto;
	private static TitledBorder BOR_TitledEmpty, BOR_TitledLine;
	private static Font FON_ArialBold;
	private static JTable TAB_Agenda;
	
	//private final DatePicker datePicker = new DatePicker();
	
	public EcranRendezVous() {
		
		this.setTitle("Prise de rendez-vous");
		this.setResizable(true);
		this.setBorder(null);
		this.setBounds(0, 0, 850, 550);
		this.getContentPane().setLayout(null);
		
		CON_Main = this.getContentPane();
		
		FON_ArialBold = new Font("Arial", Font.BOLD, 12);
		
		BOR_TitledEmpty = new TitledBorder(BorderFactory.createEmptyBorder());
		BOR_TitledLine = new TitledBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		PAN_Pour = new JPanel();
		PAN_Pour.setBorder(new TitledBorder(BOR_TitledLine, "Pour", 0, 0, FON_ArialBold));
		PAN_Pour.setBounds(25, 25, 250, 150);
		PAN_Pour.setLayout(null);
		
		PAN_Par = new JPanel();
		PAN_Par.setBorder(new TitledBorder(BOR_TitledLine, "Par", 0, 0, FON_ArialBold));
		PAN_Par.setBounds(300, 25, 250, 150);
		PAN_Par.setLayout(null);
		
		PAN_Quand = new JPanel();
		PAN_Quand.setBorder(new TitledBorder(BOR_TitledLine, "Quand", 0, 0, FON_ArialBold));
		PAN_Quand.setBounds(575, 25, 250, 150);
		PAN_Quand.setLayout(null);
		
		PAN_Client = new JPanel();
		PAN_Client.setBorder(new TitledBorder(BOR_TitledEmpty, "Client", 0, 0));
		PAN_Client.setBounds(20, 30, 210, 50);
		PAN_Client.setLayout(null);
		
		PAN_Animal = new JPanel();
		PAN_Animal.setBorder(new TitledBorder(BOR_TitledEmpty, "Animal", 0, 0));
		PAN_Animal.setBounds(20, 80, 210, 50);
		PAN_Animal.setLayout(null);
		
		PAN_Veto = new JPanel();
		PAN_Veto.setBorder(new TitledBorder(BOR_TitledEmpty, "Vétérinaire", 0, 0));
		PAN_Veto.setBounds(20, 30, 210, 50);
		PAN_Veto.setLayout(null);
		
		PAN_Calendar = new JPanel();
		PAN_Calendar.setBorder(new TitledBorder(BOR_TitledEmpty, "Date / Heure", 0, 0));
		PAN_Calendar.setBounds(20, 30, 210, 100);
		PAN_Calendar.setLayout(null);
		
		CMB_Client = new JComboBox<String>();
		CMB_Client.setBounds(6, 16, 150, 25);
		
		BTN_AddClient = new JButton("+");
		BTN_AddClient.setBounds(175, 16, 25, 25);
		BTN_AddClient.setFont(FON_ArialBold);
		
		CMB_Animal = new JComboBox<String>();
		CMB_Animal.setBounds(6, 16, 150, 25);
		
		BTN_AddAnimal = new JButton("+");
		BTN_AddAnimal.setBounds(175, 16, 25, 25);
		BTN_AddClient.setFont(FON_ArialBold);
		
		CMB_Veto = new JComboBox<String>();
		CMB_Veto.setBounds(6, 16, 150, 25);
		
		TAB_Agenda = new JTable();
		TAB_Agenda.setBorder(new LineBorder(new Color(0, 0, 0), 2));
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
		
		PAN_Pour.add(PAN_Client);
		PAN_Pour.add(PAN_Animal);
		PAN_Par.add(PAN_Veto);
		PAN_Quand.add(PAN_Calendar);
		
		CON_Main.add(PAN_Pour);
		CON_Main.add(PAN_Par);
		CON_Main.add(PAN_Quand);
		CON_Main.add(TAB_Agenda);
		CON_Main.add(BTN_Supprimer);
		CON_Main.add(BTN_Valider);
		
	}

}