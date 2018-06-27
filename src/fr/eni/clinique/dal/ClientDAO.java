package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Client;

public interface ClientDAO extends DAO<Client> {

	public List<Client> selectAll() throws DALException;

}
