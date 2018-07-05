package fr.eni.clinique.ihm.animaux;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EcranAnimaux extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textTatouage,textCouleur,textNom,textCodeAnimal,textNomClient;
	private JComboBox cbEspece,cbRace;

	/**
	 * Create the dialog.
	 */
	public EcranAnimaux() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EcranAnimaux.class.getResource("/fr/eni/clinique/ihm/img/ico_veto.png")));
		setModal(true);
		setTitle("Animaux");
		setBounds(100, 100, 450, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel.setBounds(10, 10, 414, 69);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblClient = new JLabel("Client :");
				lblClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblClient.setBounds(10, 11, 42, 14);
				panel.add(lblClient);
			}
			
			textNomClient = new JTextField();
			textNomClient.setEditable(false);
			textNomClient.setColumns(10);
			textNomClient.setBounds(10, 30, 394, 26);
			panel.add(textNomClient);
		}
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(20, 90, 46, 14);
		contentPanel.add(lblCode);
		
		JLabel lblCouleur = new JLabel("Couleur");
		lblCouleur.setBounds(20, 184, 85, 14);
		contentPanel.add(lblCouleur);
		
		JLabel lblEspece = new JLabel("Esp\u00E8ce");
		lblEspece.setBounds(20, 221, 85, 14);
		contentPanel.add(lblEspece);
		
		JLabel lblTatouage = new JLabel("Tatouage");
		lblTatouage.setBounds(20, 264, 85, 14);
		contentPanel.add(lblTatouage);
		
		textTatouage = new JTextField();
		textTatouage.setBounds(147, 261, 168, 20);
		contentPanel.add(textTatouage);
		textTatouage.setColumns(10);
		
		textCouleur = new JTextField();
		textCouleur.setBounds(147, 181, 168, 20);
		contentPanel.add(textCouleur);
		textCouleur.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(20, 148, 46, 14);
		contentPanel.add(lblNom);
		
		textNom = new JTextField();
		textNom.setColumns(10);
		textNom.setBounds(147, 150, 168, 20);
		contentPanel.add(textNom);
		
		textCodeAnimal = new JTextField();
		textCodeAnimal.setEditable(false);
		textCodeAnimal.setColumns(10);
		textCodeAnimal.setBounds(147, 87, 86, 20);
		contentPanel.add(textCodeAnimal);
		
		cbEspece = new JComboBox();
		cbEspece.setBounds(147, 218, 28, 20);
		contentPanel.add(cbEspece);
		
		cbRace = new JComboBox();
		cbRace.setBounds(312, 218, 28, 20);
		contentPanel.add(cbRace);
		
		JLabel lblRace = new JLabel("Race");
		lblRace.setBounds(256, 221, 46, 14);
		contentPanel.add(lblRace);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(361, 150, 28, 20);
		contentPanel.add(comboBox_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Valider");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EcranAnimauxController.get().validerModif();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public JTextField  getTextTatouage(){
		if(textTatouage == null) 
			textTatouage = new JTextField();
		return textTatouage;
	}
	public JTextField getTextCouleur(){
		if(textCouleur == null) 
			textCouleur = new JTextField();
		return textCouleur;
	}
	public JTextField getTextNom(){
		if(textNom == null) 
			textNom = new JTextField();
		return textNom;
	}
	public JTextField getTextCodeAnimal(){
		if(textCodeAnimal == null) 
			textCodeAnimal = new JTextField();
		return textCodeAnimal;
	}
	public JTextField getTextNomClient(){
		if(textNomClient == null) 
			textNomClient = new JTextField();
		return textNomClient;
	}
	public JComboBox getCbRace(){
		if(cbRace == null) 
			cbRace = new JComboBox();
		return cbRace;
	}
	public JComboBox getCbEspece(){
		if(cbEspece == null) 
			cbEspece = new JComboBox();
		return cbEspece;
	}
	
	
	
}
