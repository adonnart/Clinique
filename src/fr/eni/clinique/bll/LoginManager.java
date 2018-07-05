package fr.eni.clinique.bll;

import java.util.List;
import fr.eni.clinique.bo.Personnel;

public class LoginManager {
	private static LoginManager loginManager;

	public static synchronized LoginManager getInstance() throws BLLException {
		if (loginManager == null) {
			loginManager = new LoginManager();
		}
		return loginManager;
	}

	public Personnel checkConnexion(Personnel p) throws BLLException  {
			PersonnelManager mger = new PersonnelManager();
			List<Personnel>personnelList =mger .getAllPersonnel();
			for (Personnel pers : personnelList) {
				if (p.getNom().equalsIgnoreCase(pers.getNom()) && p.getMotPasse().equals(pers.getMotPasse())){
					return pers;
				}
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
		return null;
	}

}
