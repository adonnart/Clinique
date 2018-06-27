package fr.eni.clinique.dal.jdbc;

import java.util.List;

import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.dal.DALException;

public interface AgendaDAO extends DAO<Agenda> {

	public List<Agenda> selectAll() throws DALException;

}
