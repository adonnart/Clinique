package fr.eni.clinique.dal.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Agenda;

import fr.eni.clinique.dal.AgendaDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.JdbcTools;
import fr.eni.clinique.dal.Queries;

public class AgendaDAOJdbcImpl implements AgendaDAO {

	private static ResultSet rs = null;
	
	public Agenda selectByIds(int idV, int idA) throws DALException {
		Agenda agenda = null;
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			rs = stm.executeQuery(Queries.getAgendaQuerySelectByIds(idV, idA));
			while (rs.next()) {
				agenda = new Agenda(
						rs.getInt("CodeVeto"),
						rs.getInt("CodeAnimal"),
						rs.getTimestamp("DateRdv")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return agenda;
	}
	
	public List<Agenda> selectAll() throws DALException {
		List<Agenda> agendaList = new ArrayList<>();
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			rs = stm.executeQuery(Queries.getQuerySelectAll("Agendas"));
			while (rs.next()) {
				agendaList.add(new Agenda(
						rs.getInt("CodeVeto"),
						rs.getInt("CodeAnimal"),
						rs.getTimestamp("DateRdv")
				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return agendaList;
	}
	
	public void insert(Agenda agenda) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			System.out.println(Queries.getAgendaQueryInsert(agenda));
			stm.executeUpdate(Queries.getAgendaQueryInsert(agenda));
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}
	
	public boolean update(Agenda agenda) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			System.out.println(Queries.getAgendaQueryUpdate(agenda));
			stm.executeUpdate(Queries.getAgendaQueryUpdate(agenda));
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}
	
	public boolean delete(Agenda agenda) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			System.out.println(Queries.getAgendaQueryDelete(agenda));
			stm.executeUpdate(Queries.getAgendaQueryDelete(agenda));
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}

}