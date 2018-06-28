package fr.eni.clinique.dal.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Personnel;

import fr.eni.clinique.dal.PersonnelDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.JdbcTools;
import fr.eni.clinique.dal.Queries;

public class PersonnelDAOJdbcImpl implements PersonnelDAO {

	private static ResultSet rs = null;
	
	public Personnel selectById(int id) throws DALException {
		Personnel pers = null;
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			rs = stm.executeQuery(Queries.getQuerySelectById("Personnels", "CodePers", id));
			while (rs.next()) {
				pers = new Personnel(
						rs.getString("Nom"),
						rs.getString("MotPasse"),
						rs.getString("Role"),
						rs.getBoolean("Archive")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pers;
	}
	
	public List<Personnel> selectAll() throws DALException {
		List<Personnel> personnelList = new ArrayList<>();
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			rs = stm.executeQuery(Queries.getQuerySelectAll("Personnels"));
			while (rs.next()) {
				personnelList.add(new Personnel(
						rs.getInt("CodePers"),
						rs.getString("Nom"),
						rs.getString("MotPasse"),
						rs.getString("Role"),
						rs.getBoolean("Archive")
				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return personnelList;
	}
	
	public void insert(Personnel personnel) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			if (stm.executeUpdate(Queries.getPersonnelQueryInsert(personnel), Statement.RETURN_GENERATED_KEYS) == 1) {
				rs = stm.getGeneratedKeys();
				if (rs.next()) {
					personnel.setCodePers(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}
	
	public boolean update(Personnel personnel) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			stm.executeUpdate(Queries.getPersonnelQueryUpdate(personnel));
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}
	
	public boolean delete(Personnel personnel) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			stm.executeUpdate(Queries.getPersonnelQueryDelete(personnel));
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}

}