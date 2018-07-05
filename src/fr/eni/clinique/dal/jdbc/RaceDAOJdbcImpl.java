package fr.eni.clinique.dal.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.eni.clinique.bo.Race;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.JdbcTools;
import fr.eni.clinique.dal.Queries;
import fr.eni.clinique.dal.RaceDAO;

public class RaceDAOJdbcImpl implements RaceDAO{
	private static ResultSet rs = null;
	@Override
	public List<Race> selectAll() throws DALException {
		List<Race> raceList = new ArrayList<>();
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			rs = stm.executeQuery(Queries.getQuerySelectAll("Race"));
			while (rs.next()) {
				raceList.add(new Race(
						rs.getString("Race"),
						rs.getString("Espece")
				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return raceList;
	}

	@Override
	public boolean update(Race data) throws DALException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(Race data) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(Race data) throws DALException {
		// TODO Auto-generated method stub
		return false;
	}

}
