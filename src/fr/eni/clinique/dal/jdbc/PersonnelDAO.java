package fr.eni.clinique.dal.jdbc;

import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.DALException;

public interface PersonnelDAO extends DAO<Personnel> {

	public List<Personnel> selectAll() throws DALException;

}
