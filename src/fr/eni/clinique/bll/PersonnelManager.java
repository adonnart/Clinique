package fr.eni.clinique.bll;

import java.util.ArrayList;
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

	public void addPersonnel(Personnel personnel) throws BLLException {
		try {
			personnelDao.insert(personnel);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}

	public void updatePersonnel(Personnel personnel) throws BLLException {
		try {
			personnelDao.update(personnel);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}

	public void selectPersonnel(int codepersonnel) throws BLLException {
		try {
			personnelDao.selectById(codepersonnel);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}

	public void removePersonnel(Personnel personnel, int index) throws BLLException {
		try {
			if (index < 0) {
				throw new BLLException("'id' ne doit pas être à 0");
			}
			personnelDao.delete(personnel);
		} catch (Exception e) {
			throw new BLLException(e.getMessage());
		}
	}
	public List<Personnel> getAll() throws BLLException{

		try {
			List<Personnel> listPersonnel = personnelDao.selectAll();
			for (Personnel p : listPersonnel){
				listPersonnel.add(p);
				}
			
			return listPersonnel;
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException(e.getMessage());
		}}
		
	public List<Personnel> getAllPersonnel() throws BLLException{

		try {
			List<Personnel> listPersonnel = personnelDao.selectAll();
			List<Personnel>	listNonArchive = new ArrayList<Personnel>();
			for (Personnel p : listPersonnel){
				if(p.isArchive() == false){
					listNonArchive.add(p);
				}
			}
			return listNonArchive;
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException(e.getMessage());
		}
		
	//	return null;	
	}

}