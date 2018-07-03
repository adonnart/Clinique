package fr.eni.clinique.ihm.client;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ScrollPaneConstants;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EcranSearch extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private TableClient modele ;
	private JPanel panel;

	/**
	 * Create the dialog.
	 */
	public EcranSearch() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EcranSearch.class.getResource("/fr/eni/clinique/ihm/img/ico_veto.png")));
		setModal(true);
		setTitle("Resultat de la recherche");
		setBounds(100, 100, 462, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			panel = new JPanel();
			panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel.setBounds(28, 21, 392, 180);
			contentPanel.add(panel);
			{
			JScrollPane scrollPane = new JScrollPane(getTableClient());
			scrollPane.setPreferredSize(new Dimension(392, 168));
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane);
			}
		}
	}
	public TableClient getTableClient() {
		if(modele == null) {
			modele= new TableClient(EcranSearchController.get().getListClient());
			modele.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					EcranSearchController.get().selectClient();
				}
			});
		}
		return modele;
	}
	
	public JPanel getPanel(){
		return panel;
	}

}
