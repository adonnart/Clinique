package fr.eni.clinique.dal;

import fr.eni.clinique.dal.jdbc.ClientDAO;
import fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl;

public class DAOFactory {

	private static ClientDAO articleDAO;
	
	public static ClientDAO getArticleDAO() {
		if(articleDAO == null) {
			return new ClientDAOJdbcImpl();
		}
		return articleDAO;
	}
	
}
