package fr.eni.clinique.ihm.client;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import fr.eni.clinique.ihm.personnel.EcranPersonnelController;
import fr.eni.clinique.ihm.personnel.TablePersonnel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class EcranClient extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TableAnimal modele ;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(EcranClient.class.getResource("/fr/eni/clinique/ihm/img/plus.png")));
		button_1.setBounds(390, 26, 38, 37);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(EcranClient.class.getResource("/fr/eni/clinique/ihm/img/minus.png")));
		button_2.setBounds(477, 26, 38, 37);
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(EcranClient.class.getResource("/fr/eni/clinique/ihm/img/check.png")));
		button_3.setBounds(771, 26, 38, 37);
		panel.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(EcranClient.class.getResource("/fr/eni/clinique/ihm/img/arrow_circle.png")));
		button_4.setBounds(866, 26, 38, 37);
		panel.add(button_4);
		
		JLabel lblGestionDesClients = new JLabel("Gestion des clients");
		lblGestionDesClients.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblGestionDesClients.setBounds(24, 11, 241, 43);
		getContentPane().add(lblGestionDesClients);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(106, 209, 417, 534);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(165, 39, 223, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 183, 223, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 105, 223, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(165, 256, 223, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(165, 298, 223, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(165, 378, 223, 20);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(165, 447, 223, 20);
		panel_1.add(textField_6);
		
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
		
		JScrollPane scrollPane = new JScrollPane(getTableAnimal());
		scrollPane.setPreferredSize(new Dimension(519, 260));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_2.add(scrollPane);

	}
	public TableAnimal getTableAnimal() {
		if(modele == null) {
			modele= new TableAnimal(EcranClientController.get().getListAnimal());
		}
		return modele;
	}
}
