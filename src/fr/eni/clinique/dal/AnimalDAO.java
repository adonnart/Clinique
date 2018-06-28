package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Animal;

public interface AnimalDAO extends DAO<Animal> {

	public Animal selectById(int id) throws DALException;

}