package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Agenda;

public interface AgendaDAO extends DAO<Agenda> {

	public List<Agenda> selectAll() throws DALException;

}
