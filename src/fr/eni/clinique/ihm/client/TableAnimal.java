package fr.eni.clinique.ihm.client;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import fr.eni.clinique.bo.Animal;

public class TableAnimal extends JTable  {

	/**
	 * 
	 */	
	public static final int COL_NUMERO= 0;
	public static final int COL_NOM= 1;
	public static final int COL_SEXE = 2;
	public static final int COL_COULEUR = 3;
	public static final int COL_RACE = 4;
	public static final int COL_ESPECE = 5;
	public static final int COL_TATOUAGE = 6;
	private static final long serialVersionUID = 1L;

	
public TableAnimal(List<Animal> listAnimal) {
		
		super(new TableAnimalModel(listAnimal));	
        setPreferredScrollableViewportSize(new Dimension(500, 70));
        setFillsViewportHeight(true);
        this.getColumnModel().getColumn(COL_NUMERO ).setPreferredWidth(10);
		this.getColumnModel().getColumn(COL_NOM).setPreferredWidth(50);
		this.getColumnModel().getColumn(COL_SEXE).setPreferredWidth(10);
		this.getColumnModel().getColumn(COL_COULEUR).setPreferredWidth(10);
		this.getColumnModel().getColumn(COL_RACE).setPreferredWidth(10);
		this.getColumnModel().getColumn(COL_ESPECE).setPreferredWidth(10);
		this.getColumnModel().getColumn(COL_TATOUAGE).setPreferredWidth(10);
		
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		this.setRowHeight(30);
		
	}
}
