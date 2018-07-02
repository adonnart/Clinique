package fr.eni.clinique.bll;

import java.util.List;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAO;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.PersonnelDAO;

public class LoginManager {
	private PersonnelDAO personnelDao = DAOFactory.getPersonnelDAO();
	private static LoginManager loginManager;

	public static synchronized LoginManager getInstance() throws BLLException {
		if (loginManager == null) {
			loginManager = new LoginManager();
		}
		return loginManager;
	}

	public Personnel checkConnexion(Personnel p) throws BLLException {
		try {
			PersonnelManager mger = new PersonnelManager();
			List<Personnel>personnelList =mger .getAllPersonnel();
			for (Personnel pers : personnelList) {
				if (p.getNom().equalsIgnoreCase(pers.getNom()) && p.getMotPasse().equals(pers.getMotPasse())){
					return pers;
				}
			}
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
		return null;
	}
	public Personnel getPersonnel (Personnel p) throws BLLException{
		PersonnelManager mger = new PersonnelManager();
		List<Personnel> personnelList =mger .getAllPersonnel();
		for (Personnel pers : personnelList) {
		if ((p.getNom().equalsIgnoreCase(pers.getNom())) && (p.getMotPasse().equals(pers.getMotPasse())) ){ 
			return pers;
		}
}
		return p;
	}

}
