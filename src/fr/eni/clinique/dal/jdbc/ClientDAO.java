package fr.eni.clinique.dal.jdbc;

import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.DALException;

public interface ClientDAO extends DAO<Client>{
	public List<Client> selectAll() throws DALException;
	
	public List<Client> selectByKeyWord(String word) throws DALException;
	
	public List<Client> selectByMark(String mark) throws DALException;

}
