package fr.eni.clinique.ihm.rendezvous;

import fr.eni.clinique.bo.Agenda;

import java.awt.Dimension;

import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TableRendezVous extends JTable  {

	private static final long serialVersionUID = 1L;
	
	public static final int COL_HEURE = 0;
	public static final int COL_NOMCLI = 1;
	public static final int COL_ANIMAL= 2;
	public static final int COL_RACE = 3;
	
	public TableRendezVous(List<Agenda> listAgenda) {
		
		super(new TableRendezVousModel(listAgenda));	
        setPreferredScrollableViewportSize(new Dimension(500, 70));
        setFillsViewportHeight(true);
        this.getColumnModel().getColumn(COL_HEURE ).setPreferredWidth(100);
        this.getColumnModel().getColumn(COL_NOMCLI ).setPreferredWidth(200);
		this.getColumnModel().getColumn(COL_ANIMAL).setPreferredWidth(200);
		this.getColumnModel().getColumn(COL_RACE).setPreferredWidth(100);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		this.setRowHeight(30);
		
	}

}