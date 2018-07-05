package fr.eni.clinique.dal;

import fr.eni.clinique.dal.jdbc.AgendaDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.AnimalDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.RaceDAOJdbcImpl;

public class DAOFactory {

	private static AgendaDAO agendaDAO;
	private static AnimalDAO animalDAO;
	private static ClientDAO clientDAO;
	private static PersonnelDAO personnelDAO;
	private static RaceDAO raceDAO;
	
	public static AgendaDAO getAgendaDAO() {
		return (agendaDAO != null) ? agendaDAO : new AgendaDAOJdbcImpl();
	}
	
	public static AnimalDAO getAnimalDAO() {
		return (animalDAO != null) ? animalDAO : new AnimalDAOJdbcImpl();
	}
	
	public static ClientDAO getClientDAO() {
		return (clientDAO != null) ? clientDAO : new ClientDAOJdbcImpl();
	}
	
	public static PersonnelDAO getPersonnelDAO() {
		return (personnelDAO != null) ? personnelDAO : new PersonnelDAOJdbcImpl();
	}
	
	public static RaceDAO getRaceDAO(){
		return (raceDAO != null) ? raceDAO : new RaceDAOJdbcImpl();
	}

}