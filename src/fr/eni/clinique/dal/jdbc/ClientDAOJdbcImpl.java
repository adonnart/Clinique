package fr.eni.clinique.dal.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Client;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.JdbcTools;
import fr.eni.clinique.dal.Queries;

public class ClientDAOJdbcImpl implements ClientDAO {

	private static ResultSet rs = null;
	
	public Client selectById(int id) throws DALException {
		Client client = null;
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			rs = stm.executeQuery(Queries.getClientQuerySelectById(id));
			while (rs.next()) {
				client = new Client(
						rs.getString("NomClient"),
						rs.getString("PrenomClient"),
						rs.getString("Adresse1"),
						rs.getString("Adresse2"),
						rs.getString("CodePostal"),
						rs.getString("Ville"),
						rs.getString("NumTel"),
						rs.getString("Assurance"),
						rs.getString("Email"),
						rs.getString("Remarque"),
						rs.getBoolean("Archive")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return client;
	}
	
	public List<Client> selectAll() throws DALException {
		List<Client> clientList = new ArrayList<>();
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			rs = stm.executeQuery(Queries.getClientQuerySelectAll());
			while (rs.next()) {
				clientList.add(new Client(
						rs.getInt("CodeClient"),
						rs.getString("NomClient"),
						rs.getString("PrenomClient"),
						rs.getString("Adresse1"),
						rs.getString("Adresse2"),
						rs.getString("CodePostal"),
						rs.getString("Ville"),
						rs.getString("NumTel"),
						rs.getString("Assurance"),
						rs.getString("Email"),
						rs.getString("Remarque"),
						rs.getBoolean("Archive")
				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return clientList;
	}
	
	public void insert(Client client) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			if (stm.executeUpdate(Queries.getClientQueryInsert(client), Statement.RETURN_GENERATED_KEYS) == 1) {
				rs = stm.getGeneratedKeys();
				if (rs.next()) {
					client.setCodeClient(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}
	
	public boolean update(Client client) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			stm.executeUpdate(Queries.getClientQueryUpdate(client));
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}
	
	public boolean delete(Client client) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			stm.executeUpdate(Queries.getClientQueryDelete(client));
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}

}