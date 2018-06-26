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
			ResultSet rc = stm.executeQuery(Request.getClientRequestSelectById(id));
			while (rc.next()) {
				String nomClient = rc.getString("nomclient");
				String prenomClient = rc.getString("prenomClient");
				String adresse1 = rc.getString("adresse1");
				String adresse2 = rc.getString("adresse2");
				String codePostal = rc.getString("codepostal");
				String ville = rc.getString("ville");
				String numTel = rc.getString("numtel");
				String assurance = rc.getString("assurance");
				String email = rc.getString("email");
				String remarque = rc.getString("remarque");
				Boolean archive = rc.getBoolean("archive");
				
				pers = new Personnel(nomClient, prenomClient, adresse1, adresse2, codePostal, 
									ville, numTel, assurance, email, remarque, archive);
			}
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
		
		return pers;
	}

	public List<Personnel> selectAll() throws DALException {
		List<Personnel> clientList = new ArrayList<>();
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			ResultSet rc = stm.executeQuery(Request.getClientRequestSelectAll());
			while (rc.next()) {
				Integer codeClient = rc.getInt("codeclient");
				String nomClient = rc.getString("nomclient");
				String prenomClient = rc.getString("prenomClient");
				String adresse1 = rc.getString("adresse1");
				String adresse2 = rc.getString("adresse2");
				String codePostal = rc.getString("codepostal");
				String ville = rc.getString("ville");
				String numTel = rc.getString("numtel");
				String assurance = rc.getString("assurance");
				String email = rc.getString("email");
				String remarque = rc.getString("remarque");
				Boolean archive = rc.getBoolean("archive");
					
				clientList.add(new Personnel(codeClient, nomClient, prenomClient, adresse1, adresse2, codePostal, 
										  ville, numTel, assurance, email, remarque, archive));
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