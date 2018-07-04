package fr.eni.clinique.ihm.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterClient extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textCode;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textAdresse;
	private JTextField textAdresse2;
	private JTextField textCP;
	private JTextField textVille;


	/**
	 * Create the dialog.
	 */
	public AjouterClient() {
		setTitle("Ajouter Client");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AjouterClient.class.getResource("/fr/eni/clinique/ihm/img/ico_veto.png")));
		setModal(true);
		setBounds(100, 100, 352, 304);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblNewLabel = new JLabel("Code");
			lblNewLabel.setBounds(10, 11, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNom = new JLabel("Nom");
			lblNom.setBounds(10, 38, 46, 14);
			contentPanel.add(lblNom);
		}
		{
			JLabel lblPrenom = new JLabel("Prenom");
			lblPrenom.setBounds(10, 63, 46, 14);
			contentPanel.add(lblPrenom);
		}
		{
			JLabel lblAdresse = new JLabel("Adresse");
			lblAdresse.setBounds(10, 92, 46, 14);
			contentPanel.add(lblAdresse);
		}
		{
			JLabel lblCodePostal = new JLabel("Code Postal");
			lblCodePostal.setBounds(10, 161, 60, 14);
			contentPanel.add(lblCodePostal);
		}
		{
			JLabel lblAd = new JLabel("Adresse 2");
			lblAd.setBounds(10, 122, 60, 14);
			contentPanel.add(lblAd);
		}
		{
			JLabel lblVille = new JLabel("Ville");
			lblVille.setBounds(10, 189, 46, 14);
			contentPanel.add(lblVille);
		}
		{
			textCode = new JTextField();
			textCode.setBounds(85, 8, 235, 20);
			contentPanel.add(textCode);
			textCode.setColumns(10);
		}
		{
			textNom = new JTextField();
			textNom.setColumns(10);
			textNom.setBounds(85, 35, 235, 20);
			contentPanel.add(textNom);
		}
		{
			textPrenom = new JTextField();
			textPrenom.setColumns(10);
			textPrenom.setBounds(85, 60, 235, 20);
			contentPanel.add(textPrenom);
		}
		{
			textAdresse = new JTextField();
			textAdresse.setColumns(10);
			textAdresse.setBounds(85, 89, 235, 20);
			contentPanel.add(textAdresse);
		}
		{
			textAdresse2 = new JTextField();
			textAdresse2.setColumns(10);
			textAdresse2.setBounds(85, 119, 235, 20);
			contentPanel.add(textAdresse2);
		}
		{
			textCP = new JTextField();
			textCP.setColumns(10);
			textCP.setBounds(85, 158, 235, 20);
			contentPanel.add(textCP);
		}
		{
			textVille = new JTextField();
			textVille.setColumns(10);
			textVille.setBounds(85, 186, 235, 20);
			contentPanel.add(textVille);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Valider");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AjouterClientController.get().valider();
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
	public JTextField getTextCode(){
		return textCode;
	}
	public JTextField getTextNom(){
		return textNom;
	}
	public JTextField getTextPrenom(){
		return textPrenom;
		
	}
	public JTextField getTextAdresse(){
		return textAdresse;
	}
	public JTextField getTextAdresse2(){
		return textAdresse2;
	}
	public JTextField getTextCP(){
		return textCP;
	}
	public JTextField getTextVille(){
		return textVille;
	}

}
