package fr.eni.clinique.bll;

import java.util.List;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DAO;
import fr.eni.clinique.dal.DAOFactory;

public class LoginManager {
	private DAO<Personnel> personnelDao = DAOFactory.getPersonnelDAO();
	private static LoginManager loginManager;

	public static synchronized LoginManager getInstance() throws BLLException {
		if (loginManager == null) {
			loginManager = new LoginManager();
		}
		return loginManager;
	}

	public String checkConnexion(Personnel p) throws BLLException {
		try {
			List<Personnel> personnelList = personnelDao.selectAll();
			System.out.println(p.getNom()+" - "+p.getMotPasse());
			for (Personnel pers : personnelList) {
				if (p.getNom().equalsIgnoreCase(pers.getNom()) && p.getMotPasse().equals(pers.getMotPasse())){ 
					System.out.println(pers.getNom()+" - "+pers.getMotPasse());
					return pers.getRole();
				}
			}
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
		return "False";
	}

}
