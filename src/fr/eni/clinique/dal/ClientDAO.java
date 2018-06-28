package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Client;

public interface ClientDAO extends DAO<Client> {

	public Client selectById(int id) throws DALException;

}