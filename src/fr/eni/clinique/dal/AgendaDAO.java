package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Agenda;

public interface AgendaDAO extends DAO<Agenda> {

	public Agenda selectByIds(int idV, int idA) throws DALException;

}