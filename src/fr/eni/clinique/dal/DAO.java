package fr.eni.clinique.dal;

import java.util.List;

public interface DAO<T> {
	
	public List<T> selectAll() throws DALException;
	
	public boolean update(T data) throws DALException;
	
	public void insert(T data) throws DALException;
	
	public boolean delete(T data) throws DALException;

}