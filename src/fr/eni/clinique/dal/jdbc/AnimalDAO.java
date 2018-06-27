package fr.eni.clinique.dal.jdbc;

import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.dal.DALException;

public interface AnimalDAO extends DAO<Animal> {

	public List<Animal> selectAll() throws DALException;

}
