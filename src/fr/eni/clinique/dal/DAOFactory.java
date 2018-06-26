package fr.eni.clinique.dal;

import fr.eni.clinique.dal.jdbc.ClientDAO;
import fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl;

public class DAOFactory {

	private static ClientDAO clientDAO;
	
	public static ClientDAO getClientDAO() {
		if(clientDAO == null) {
			return new ClientDAOJdbcImpl();
		}
		return clientDAO;
	}
	
}
