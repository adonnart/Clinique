package fr.eni.clinique.ihm.personnel;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import fr.eni.clinique.bo.Personnel;

public class TablePersonnelModel extends AbstractTableModel {

	String[] entetes = {"Nom", "Role", "Password"};
	private List<Personnel> listPersonnel;
	private static final long serialVersionUID = 1L;

	
	public TablePersonnelModel(List<Personnel> listPersonnel) {
			this.listPersonnel = listPersonnel;
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
		return listPersonnel.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Object val = null;
		switch (columnIndex) {
		case TablePersonnel.COL_NOM:
			val = listPersonnel.get(rowIndex).getNom();
			break;
		case TablePersonnel.COL_ROLE:
			val = listPersonnel.get(rowIndex).getRole();
			break;
		case TablePersonnel.COL_PASSWORD:
			val = listPersonnel.get(rowIndex).getMotPasse();
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

			default:
				return Object.class;
		}
	}
	
}
