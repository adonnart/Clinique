package fr.eni.clinique.ihm.rendezvous;

import fr.eni.clinique.bo.Agenda;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableRendezVousModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private List<Agenda> listAgenda;
	String[] entetes = {"Heure", "Nom Client", "Animal", "Race"};
	
	public TableRendezVousModel(List<Agenda> listAgenda) {
		this.listAgenda = listAgenda;
	}
	
	@Override
	public int getColumnCount() {
		return entetes.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		return listAgenda.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case TableRendezVous.COL_HEURE : return listAgenda.get(rowIndex).getDateRdv();
			case TableRendezVous.COL_NOMCLI : return listAgenda.get(rowIndex).getAnimal().getCodeClient();
			case TableRendezVous.COL_ANIMAL: return listAgenda.get(rowIndex).getAnimal().getNomAnimal();
			case TableRendezVous.COL_RACE: return listAgenda.get(rowIndex).getAnimal().getRace();
			default: return null;
		}
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0 : return String.class;
			case 1 : return String.class;
			case 2 : return String.class;
			case 3 : return String.class;
			default: return Object.class;
		}
	}

}