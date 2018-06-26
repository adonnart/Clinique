package fr.eni.clinique.dal;

import fr.eni.clinique.dal.jdbc.ClientDAO;
import fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.PersonnelDAO;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;

public class DAOFactory {

	private static ClientDAO clientDAO;
	private static PersonnelDAO personnelDAO;
	
	public static ClientDAO getClientDAO() {
		if(clientDAO == null) {
			return new ClientDAOJdbcImpl();
		}
		return clientDAO;
	}
	
	public static PersonnelDAO getPersonnelDAO() {
		if(personnelDAO == null) {
			return new PersonnelDAOJdbcImpl();
		}
		return personnelDAO;
	}

}