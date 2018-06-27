package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Animal;

public interface AnimalDAO extends DAO<Animal> {

	public List<Animal> selectAll() throws DALException;

}
