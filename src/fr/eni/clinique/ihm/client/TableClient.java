package fr.eni.clinique.ihm.client;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import fr.eni.clinique.bo.Client;

public class TableClient extends JTable  {

	/**
	 * 
	 */	
	public static final int COL_NOM= 0;
	public static final int COL_PRENOM= 1;
	public static final int COL_CODE_POSTAL = 2;
	public static final int COL_VILLE = 3;
	private static final long serialVersionUID = 1L;

	
public TableClient(List<Client> listClient) {
		
		super(new TableClientModel(listClient));	
        setPreferredScrollableViewportSize(new Dimension(500, 70));
        setFillsViewportHeight(true);
        this.getColumnModel().getColumn(COL_NOM ).setPreferredWidth(10);
		this.getColumnModel().getColumn(COL_PRENOM).setPreferredWidth(50);
		this.getColumnModel().getColumn(COL_CODE_POSTAL).setPreferredWidth(10);
		this.getColumnModel().getColumn(COL_VILLE).setPreferredWidth(10);
	
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		this.setRowHeight(30);
		
	}
}
