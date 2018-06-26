package fr.eni.clinique.dal.jdbc;

import fr.eni.clinique.dal.DALException;

public interface DAO<T> {

	public T selectById(int id) throws DALException;

	public boolean update(T data) throws DALException;

	public void insert(T data) throws DALException;

	public boolean delete(T data) throws DALException;

}
