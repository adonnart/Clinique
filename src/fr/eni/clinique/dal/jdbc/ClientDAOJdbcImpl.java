package fr.eni.clinique.dal.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Client;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.JdbcTools;
import fr.eni.clinique.dal.Request;

public class ClientDAOJdbcImpl implements ClientDAO{
	Client client;
	public Client selectById(int id) throws DALException {
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
		client = new Client(nomClient,prenomClient, adresse1,adresse2, codePostal, ville, numTel,assurance,email,remarque,archive);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;

	}
	public List<Client> selectAll() throws DALException {
		List<Client> clientList = new ArrayList<>();
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
					
				clientList.add(new Client(codeClient,nomClient,prenomClient, adresse1,adresse2, codePostal, ville, numTel,assurance,email,remarque,archive));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return clientList;
	}

	public boolean update(Client cli) throws DALException {
		StringBuilder SQL = new StringBuilder("UPDATE dbo.ARTICLES SET ");
		SQL.append("', nomclient = '");
		SQL.append(client.getNomClient());
		SQL.append("', prenomclient = '");
		SQL.append(client.getPrenomClient());
		SQL.append("', adresse1 = ");
		SQL.append(client.getAdresse1());
		SQL.append(", adresse2 = ");
		SQL.append(client.getAdresse2());
		SQL.append(", codepostal = ");
		SQL.append(client.getCodePostal());
		SQL.append(", ville = ");
		SQL.append(client.getVille());
		SQL.append(", numtel= ");
		SQL.append(client.getNumTel());
		SQL.append(", assurance = ");
		SQL.append(client.getAssurance());
	
		SQL.append(" WHERE codeclient = ");
		SQL.append(client.getCodeClient());
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			stm.executeUpdate(SQL.toString());
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}

	public void insert(Client client) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			int nbRow = stm.executeUpdate(Request.getClientRequestInsert(client), Statement.RETURN_GENERATED_KEYS);
			if (nbRow == 1) {
				ResultSet rs = stm.getGeneratedKeys();
				if (rs.next()) {
					client.setCodeClient(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}

	public boolean delete(Client client) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			stm.executeUpdate(Request.getClientRequestDelete(client));
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}
}
