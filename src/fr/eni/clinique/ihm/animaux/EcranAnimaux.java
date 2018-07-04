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

public class EcranAnimaux extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EcranAnimaux dialog = new EcranAnimaux();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EcranAnimaux() {
		setTitle("Animaux");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel.setBounds(10, 10, 357, 69);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblClient = new JLabel("Client");
				lblClient.setBounds(10, 11, 27, 14);
				panel.add(lblClient);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel_1.setBounds(10, 30, 337, 28);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblClient = new JLabel("");
			lblClient.setBounds(10, 6, 317, 14);
			panel_1.add(lblClient);
		}
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(20, 90, 46, 14);
		contentPanel.add(lblCode);
		
		JLabel lblCouleur = new JLabel("Couleur");
		lblCouleur.setBounds(20, 153, 85, 14);
		contentPanel.add(lblCouleur);
		
		JLabel lblEspece = new JLabel("Esp\u00E8ce");
		lblEspece.setBounds(20, 178, 85, 14);
		contentPanel.add(lblEspece);
		
		JLabel lblTatouage = new JLabel("Tatouage");
		lblTatouage.setBounds(20, 203, 85, 14);
		contentPanel.add(lblTatouage);
		
		JLabel lblNewLabelCode = new JLabel("");
		lblNewLabelCode.setBounds(147, 90, 46, 14);
		contentPanel.add(lblNewLabelCode);
		
		textField = new JTextField();
		textField.setBounds(147, 200, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 150, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(20, 115, 46, 14);
		contentPanel.add(lblNom);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 115, 86, 20);
		contentPanel.add(textField_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Valider");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
