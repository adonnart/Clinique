package fr.eni.clinique.ihm.personnel;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import fr.eni.clinique.bo.Personnel;

public class TablePersonnel extends JTable  {

	/**
	 * 
	 */	
	public static final int COL_NOM = 0;
	public static final int COL_ROLE= 1;
	public static final int COL_PASSWORD = 2;
	private static final long serialVersionUID = 1L;

	
public TablePersonnel(List<Personnel> listPersonnel) {
		
		super(new TablePersonnelModel(listPersonnel));	
        setPreferredScrollableViewportSize(new Dimension(500, 70));
        setFillsViewportHeight(true);
        this.getColumnModel().getColumn(COL_NOM ).setPreferredWidth(100);
		this.getColumnModel().getColumn(COL_ROLE).setPreferredWidth(100);
		this.getColumnModel().getColumn(COL_PASSWORD).setPreferredWidth(100);	
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		this.setRowHeight(30);
		
	}
}
