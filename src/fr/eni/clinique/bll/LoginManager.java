package fr.eni.clinique.bll;

import fr.eni.clinique.dal.ClientDAO;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.PersonnelDAO;

public class LoginManager {
	private PersonnelDAO personnelDao = DAOFactory.getPersonnelDAO();
	private static LoginManager personnelManager;
}
