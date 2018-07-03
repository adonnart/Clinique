package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Client;

public interface ClientDAO extends DAO<Client> {

	public Client selectById(int id) throws DALException;
	public List<Client> selectByName(String name) throws DALException;
}