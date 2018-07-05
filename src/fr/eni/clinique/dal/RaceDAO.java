package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Race;

public interface RaceDAO  extends DAO<Race>{

	List<Race>selectAllRace(String espece) throws DALException;

}
