package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.PersonnelDAO;

public class PersonnelManager {
	private PersonnelDAO personnelDao = DAOFactory.getPersonnelDAO();
	private static PersonnelManager personnelManager;

	public PersonnelManager() {
	}

	public static synchronized PersonnelManager getInstance() throws BLLException {
		if (personnelManager == null) {
			personnelManager = new PersonnelManager();
		}
		return personnelManager;
	}

	public void addClient(Personnel personnel) throws BLLException {
		try {
			personnelDao.insert(personnel);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}

	public void updateClient(Personnel personnel) throws BLLException {
		try {
			personnelDao.update(personnel);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}

	public void selectClient(int codeclient) throws BLLException {
		try {
			personnelDao.selectById(codeclient);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}

	public void removeClient(Personnel personnel, int index) throws BLLException {
		try {
			if (index < 0) {
				throw new BLLException("'id' ne doit pas être à 0");
			}
			personnelDao.delete(personnel);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}
	public List<Personnel> getAllPersonnel() throws BLLException{

		try {
			return personnelDao.selectAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

}