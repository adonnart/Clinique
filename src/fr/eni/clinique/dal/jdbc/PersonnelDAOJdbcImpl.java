package fr.eni.clinique.dal.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Personnel;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.JdbcTools;
import fr.eni.clinique.dal.Request;

public class PersonnelDAOJdbcImpl implements PersonnelDAO {
	
	Personnel pers;
	
	public Personnel selectById(int id) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			ResultSet rc = stm.executeQuery(Request.getPersonnelRequestSelectById(id));
			while (rc.next()) {
				String nom = rc.getString("nom");
				String motPasse = rc.getString("motPasse");
				String role = rc.getString("role");
				Boolean archive = rc.getBoolean("archive");
				
				pers = new Personnel(nom, motPasse, role, archive);
			}
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
		
		return pers;
	}

	public List<Personnel> selectAll() throws DALException {
		List<Personnel> clientList = new ArrayList<>();
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			ResultSet rc = stm.executeQuery(Request.getPersonnelRequestSelectAll());
			while (rc.next()) {
				Integer codePers = rc.getInt("codePers");
				String nom = rc.getString("nom");
				String motPasse = rc.getString("motPasse");
				String role = rc.getString("role");
				Boolean archive = rc.getBoolean("archive");
					
				clientList.add(new Personnel(codePers, nom, motPasse, role, archive));
			}
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
		
		return clientList;
	}

	public boolean update(Personnel pers) throws DALException {
		StringBuilder SQL = new StringBuilder("UPDATE dbo.ARTICLES SET ");
		SQL.append("', nomclient = '");
		SQL.append(pers.getNomClient());
		SQL.append("', prenomclient = '");
		SQL.append(pers.getPrenomClient());
		SQL.append("', adresse1 = ");
		SQL.append(pers.getAdresse1());
		SQL.append(", adresse2 = ");
		SQL.append(pers.getAdresse2());
		SQL.append(", codepostal = ");
		SQL.append(pers.getCodePostal());
		SQL.append(", ville = ");
		SQL.append(pers.getVille());
		SQL.append(", numtel= ");
		SQL.append(pers.getNumTel());
		SQL.append(", assurance = ");
		SQL.append(pers.getAssurance());
	
		SQL.append(" WHERE codeclient = ");
		SQL.append(pers.getCodeClient());
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			stm.executeUpdate(SQL.toString());
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}

	public void insert(Personnel pers) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			if (stm.executeUpdate(Request.getPersonnelRequestInsert(pers), Statement.RETURN_GENERATED_KEYS) == 1) {
				ResultSet rs = stm.getGeneratedKeys();
				if (rs.next()) {
					pers.setCodePers(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}

	public boolean delete(Personnel pers) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			stm.executeUpdate(Request.getPersonnelRequestDelete(pers));
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}

}