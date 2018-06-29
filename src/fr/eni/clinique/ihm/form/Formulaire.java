package fr.eni.clinique.ihm.form;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulaire extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNom;
	private JTextField textRole;
	private JTextField textPassword;


	/**
	 * Create the dialog.
	 */
	public Formulaire() {
		setTitle("Ajouter personnel");
		setBounds(100, 100, 361, 299);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nom :");
			lblNewLabel.setBounds(23, 49, 78, 24);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblRole = new JLabel("Role :");
			lblRole.setBounds(23, 114, 78, 24);
			contentPanel.add(lblRole);
		}
		{
			JLabel lblPassword = new JLabel("Password :");
			lblPassword.setBounds(23, 176, 78, 24);
			contentPanel.add(lblPassword);
		}
		{
			textNom = new JTextField();
			textNom.setBounds(133, 51, 154, 20);
			contentPanel.add(textNom);
			textNom.setColumns(10);
		}
		{
			textRole = new JTextField();
			textRole.setBounds(133, 116, 154, 20);
			contentPanel.add(textRole);
			textRole.setColumns(10);
		}
		
		textPassword = new JTextField();
		textPassword.setBounds(133, 178, 154, 20);
		contentPanel.add(textPassword);
		textPassword.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						FormulaireController.get().ajouter();
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public JTextField getTxtNom() {
		if(textNom == null) {
			textNom = new JTextField(30);
		}
		return textNom;
	}
	public JTextField getTxtRole() {
		if(textRole == null) {
			textRole= new JTextField(30);
		}
		return textRole;
	}
	public JTextField getTxtPassword() {
		if(textPassword == null) {
			textPassword = new JTextField(30);
		}
		return textPassword;
	}
}
