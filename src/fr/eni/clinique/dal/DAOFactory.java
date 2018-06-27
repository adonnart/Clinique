package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;

import fr.eni.clinique.dal.jdbc.AgendaDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.AnimalDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;

public class DAOFactory {

	private static DAO<Client> clientDAO;
	private static DAO<Personnel> personnelDAO;
	private static DAO<Animal> animalDAO;
	private static DAO<Agenda> agendaDAO;
	
	public static DAO<Client> getClientDAO() {
		if(clientDAO == null) {
			return new ClientDAOJdbcImpl();
		}
		return clientDAO;
	}
	
	public static DAO<Personnel> getPersonnelDAO() {
		if(personnelDAO == null) {
			return new PersonnelDAOJdbcImpl();
		}
		return personnelDAO;
	}
	
	public static DAO<Animal> getAnimalDAO() {
		if(animalDAO == null) {
			return new AnimalDAOJdbcImpl();
		}
		return animalDAO;
	}
	
	public static DAO<Agenda> getAgendaDAO() {
		if(agendaDAO == null) {
			return new AgendaDAOJdbcImpl();
		}
		return agendaDAO;
	}

}