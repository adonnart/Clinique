package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Race;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.RaceDAO;

public class RaceManager {
	private RaceDAO raceDao = DAOFactory.getRaceDAO();
	private static RaceManager raceManager;

	public RaceManager() {
	}

	public static synchronized RaceManager getInstance() throws BLLException {
		if (raceManager == null) {
			raceManager = new RaceManager();
		}
		return raceManager;
	}
	public List<Race> getAllRace(){
		try {
			return raceDao.selectAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
