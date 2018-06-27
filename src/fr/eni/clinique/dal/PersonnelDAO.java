package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Personnel;

public interface PersonnelDAO extends DAO<Personnel> {

	public List<Personnel> selectAll() throws DALException;

}
