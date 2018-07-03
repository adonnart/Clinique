package fr.eni.clinique.ihm.client;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.clinique.bo.Animal;

public class TableAnimalModel extends AbstractTableModel {

	String[] entetes = {"Numero", "Nom", "Sexe","Couleur","Race","Espece","Tatouage"};
	private List<Animal> listAnimal;
	private static final long serialVersionUID = 1L;

	
	public TableAnimalModel(List<Animal> listAnimal) {
			this.listAnimal = listAnimal;
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
		return listAnimal.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Object val = null;
		switch (columnIndex) {
		case TableAnimal.COL_NUMERO:
			val = listAnimal.get(rowIndex).getCodeAnimal();
			break;
		case TableAnimal.COL_NOM:
			val = listAnimal.get(rowIndex).getNomAnimal();
			break;
		case TableAnimal.COL_SEXE:
			val = listAnimal.get(rowIndex).getSexe();
			break;	
		case TableAnimal.COL_COULEUR:
			val = listAnimal.get(rowIndex).getCouleur();
			break;
		case TableAnimal.COL_RACE:
			val = listAnimal.get(rowIndex).getRace();
			break;
		case TableAnimal.COL_ESPECE:
			val = listAnimal.get(rowIndex).getEspece();
			break;
		case TableAnimal.COL_TATOUAGE:
			val = listAnimal.get(rowIndex).getTatouage();
			break;
		}
		return val;
	}
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0:
				return Integer.class;
			case 1:
				return String.class;
			case 2:
				return String.class;
			case 3:
				return String.class;
			case 4:
				return String.class;
			case 5:
				return String.class;
			case 6:
				return String.class;
				
			default:
				return Object.class;
		}
	}
	
}
