package fr.eni.clinique.ihm.client;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import fr.eni.clinique.ihm.animaux.EcranAnimauxController;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class EcranClient extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TableAnimal modele ;
	private JTextField textCode;
	private JTextField textPrenom;
	private JTextField textNom;
	private JTextField textAdresse;
	private JTextField textAdresse2;
	private JTextField textCP;
	private JTextField textVille;
	private JTextField textSearch;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public EcranClient() {
		setBorder(null);
		setBounds(0,-25,1200, 800);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(106, 81, 1003, 88);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EcranSearchController.get().openEcranSearch();
			}
		});
		button.setIcon(new ImageIcon(EcranClient.class.getResource("/fr/eni/clinique/ihm/img/magnifying_glass.png")));
		button.setBounds(10, 26, 38, 37);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EcranClientController.get().ajouter();
			}
		});
		button_1.setIcon(new ImageIcon(EcranClient.class.getResource("/fr/eni/clinique/ihm/img/plus.png")));
		button_1.setBounds(390, 26, 38, 37);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EcranClientController.get().getClient().getCodeClient() != null){
				 int a=JOptionPane.showConfirmDialog(new Frame(),"Voulez vous vraiment supprimer ce client?","Supprimer", JOptionPane.YES_NO_OPTION);  
				 if(a==JOptionPane.YES_OPTION){  
					 EcranClientController.get().supprimer();
				 }
			}}
		});
		button_2.setIcon(new ImageIcon(EcranClient.class.getResource("/fr/eni/clinique/ihm/img/minus.png")));
		button_2.setBounds(486, 26, 38, 37);
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EcranClientController.get().getClient().getCodeClient() != null){
				 int a=JOptionPane.showConfirmDialog(new Frame(),"Voulez vous vraiment valider les modifications?","Supprimer", JOptionPane.YES_NO_OPTION);  
				 if(a==JOptionPane.YES_OPTION){  
					 EcranClientController.get().validerclient();
				 }
				}
			}
		});
		button_3.setIcon(new ImageIcon(EcranClient.class.getResource("/fr/eni/clinique/ihm/img/check.png")));
		button_3.setBounds(771, 26, 38, 37);
		panel.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EcranClientController.get().loadClient(EcranClientController.get().getClient());
			}
		});
		button_4.setIcon(new ImageIcon(EcranClient.class.getResource("/fr/eni/clinique/ihm/img/arrow_circle.png")));
		button_4.setBounds(866, 26, 38, 37);
		panel.add(button_4);
		
		textSearch = new JTextField();
		textSearch.setBounds(56, 33, 258, 20);
		panel.add(textSearch);
		textSearch.setColumns(10);
		
		JLabel lblRechercher = new JLabel("Rechercher");
		lblRechercher.setBounds(10, 63, 70, 14);
		panel.add(lblRechercher);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setBounds(390, 63, 59, 14);
		panel.add(lblAjouter);
		
		JLabel lblSupprimer = new JLabel("Supprimer");
		lblSupprimer.setBounds(476, 63, 70, 14);
		panel.add(lblSupprimer);
		
		JLabel lblValider = new JLabel("Valider");
		lblValider.setBounds(771, 63, 46, 14);
		panel.add(lblValider);
		
		JLabel lblAnnuler = new JLabel("Annuler");
		lblAnnuler.setBounds(866, 63, 46, 14);
		panel.add(lblAnnuler);
		
		JLabel lblGestionDesClients = new JLabel("Gestion des clients");
		lblGestionDesClients.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblGestionDesClients.setBounds(24, 11, 241, 43);
		getContentPane().add(lblGestionDesClients);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(106, 209, 417, 534);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textCode = new JTextField();
		textCode.setEditable(false);
		textCode.setBounds(165, 39, 223, 20);
		panel_1.add(textCode);
		textCode.setColumns(10);
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		textPrenom.setBounds(165, 183, 223, 20);
		panel_1.add(textPrenom);
		
		textNom = new JTextField();
		textNom.setColumns(10);
		textNom.setBounds(165, 105, 223, 20);
		panel_1.add(textNom);
		
		textAdresse = new JTextField();
		textAdresse.setColumns(10);
		textAdresse.setBounds(165, 256, 223, 20);
		panel_1.add(textAdresse);
		
		textAdresse2 = new JTextField();
		textAdresse2.setColumns(10);
		textAdresse2.setBounds(165, 298, 223, 20);
		panel_1.add(textAdresse2);
		
		textCP = new JTextField();
		textCP.setColumns(10);
		textCP.setBounds(165, 378, 223, 20);
		panel_1.add(textCP);
		
		textVille = new JTextField();
		textVille.setColumns(10);
		textVille.setBounds(165, 447, 223, 20);
		panel_1.add(textVille);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(32, 42, 46, 14);
		panel_1.add(lblCode);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(32, 108, 46, 14);
		panel_1.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(32, 186, 46, 14);
		panel_1.add(lblPrnom);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(32, 259, 46, 14);
		panel_1.add(lblAdresse);
		
		JLabel lblCodePostal = new JLabel("Code postal");
		lblCodePostal.setBounds(32, 381, 68, 14);
		panel_1.add(lblCodePostal);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(32, 453, 46, 14);
		panel_1.add(lblVille);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(593, 209, 516, 380);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(getTableAnimal());
		scrollPane.setBounds(-1, 5, 519, 260);
		scrollPane.setPreferredSize(new Dimension(519, 260));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_2.add(scrollPane);
		
		JButton button_6 = new JButton("");
		button_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_6.setIcon(new ImageIcon(EcranClient.class.getResource("/fr/eni/clinique/ihm/img/minus.png")));
		button_6.setBounds(384, 276, 38, 37);
		panel_2.add(button_6);
		
		JButton button_5 = new JButton("");
		button_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EcranClientController.get().ajouterAnimal();
			}
		});
		button_5.setIcon(new ImageIcon(EcranClient.class.getResource("/fr/eni/clinique/ihm/img/plus.png")));
		button_5.setBounds(310, 276, 38, 37);
		panel_2.add(button_5);
		
		JButton button_7 = new JButton("");
		button_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EcranClientController.get().modifierAnimal();
			}
		});
		button_7.setIcon(new ImageIcon(EcranClient.class.getResource("/fr/eni/clinique/ihm/img/edit_text.png")));
		button_7.setBounds(450, 276, 38, 37);
		panel_2.add(button_7);
		
		JLabel lblNewLabel = new JLabel("Ajouter");
		lblNewLabel.setBounds(310, 324, 46, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Supprimer");
		lblNewLabel_1.setBounds(378, 324, 62, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Modifier");
		lblNewLabel_2.setBounds(450, 324, 46, 14);
		panel_2.add(lblNewLabel_2);

	}
	public TableAnimal getTableAnimal() {
		if(modele == null) {
			modele= new TableAnimal(EcranClientController.get().getListAnimal());
		}
		return modele;
	}
	public JTextField  getTextSearch(){
		return textSearch;
	}

	public JTextField  getTextCode(){
		return textCode;
	}
	public JTextField  getTextPrenom(){
		return textPrenom;
	}
	public JTextField  getTextnom(){
		return textNom;
	}
	public JTextField  getTextAdresse(){
		return textAdresse;
	}
	public JTextField  getTextAdresse2(){
		return textAdresse2;
	}
	public JTextField  getTextCP(){
		return textCP;
	}
	public JTextField  getTextVille(){
		return textVille;
	}
}
