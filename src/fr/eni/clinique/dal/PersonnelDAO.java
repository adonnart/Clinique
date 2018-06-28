package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Personnel;

public interface PersonnelDAO extends DAO<Personnel> {

	public Personnel selectById(int id) throws DALException;

}