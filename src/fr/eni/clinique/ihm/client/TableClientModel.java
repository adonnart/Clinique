package fr.eni.clinique.ihm.client;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;

public class TableClientModel extends AbstractTableModel {

	String[] entetes = {"Nom", "Prenom", "Code postal","Ville"};
	private List<Client> listClient;
	private static final long serialVersionUID = 1L;

	
	public TableClientModel(List<Client> listClient) {
			this.listClient = listClient;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entetes.length;
	}
	
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listClient.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Object val = null;
		switch (columnIndex) {
		case TableClient.COL_NOM:
			val = listClient.get(rowIndex).getNomClient();
			break;
		case TableClient.COL_PRENOM:
			val = listClient.get(rowIndex).getPrenomClient();
			break;
		case TableClient.COL_CODE_POSTAL:
			val = listClient.get(rowIndex).getCodePostal();
			break;	
		case TableClient.COL_VILLE:
			val = listClient.get(rowIndex).getVille();
			break;
		}
		return val;
	}
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0:
				return String.class;
			case 1:
				return String.class;
			case 2:
				return String.class;
			case 3:
				return String.class;			
			default:
				return Object.class;
		}
	}
	
}
