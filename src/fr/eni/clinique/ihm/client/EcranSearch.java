package fr.eni.clinique.ihm.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;

public class EcranSearch extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtSearch;
	private TableClient modele ;

	/**
	 * Create the dialog.
	 */
	public EcranSearch() {
		setModal(true);
		setTitle("Resultat de la recherche");
		setBounds(100, 100, 467, 325);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel.setBounds(28, 95, 381, 155);
			contentPanel.add(panel);
			{
			JScrollPane scrollPane = new JScrollPane(getTableAnimal());
			scrollPane.setPreferredSize(new Dimension(519, 260));
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane);
			}
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel_1.setBounds(28, 12, 382, 64);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
				txtSearch = new JTextField();
				txtSearch.setBounds(10, 22, 275, 20);
				panel_1.add(txtSearch);
				txtSearch.setText("Nom du client");
				txtSearch.setColumns(10);
			}
			{
				JButton button = new JButton("");
				button.setBounds(328, 10, 33, 35);
				panel_1.add(button);
				button.setBorderPainted(false);
				button.setIcon(new ImageIcon(EcranSearch.class.getResource("/fr/eni/clinique/ihm/img/magnifying_glass.png")));
			}
			{
				JLabel lblRechercher = new JLabel("Rechercher");
				lblRechercher.setBounds(316, 46, 55, 14);
				panel_1.add(lblRechercher);
			}

		}
	}
	public TableAnimal getTableClient() {
		if(modele == null) {
			modele= new TableClient(EcranSearchController.get().getListClient());
		}
		return modele;
	}

}
