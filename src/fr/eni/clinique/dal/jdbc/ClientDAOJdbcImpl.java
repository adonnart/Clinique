/**
 * 
 */
package fr.eni.clinique.dal.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Client;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.JdbcTools;
import fr.eni.clinique.dal.Request;

/**
 * @author MOI
 * 
 */
public class ClientDAOJdbcImpl implements ClientDAO{
	Client client;
	public Client selectById(int id) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			ResultSet rc = stm.executeQuery(Request.getClientRequestSelectById(id));
			while (rc.next()) {
				long codeClient = rc.getLong("codeclient");
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
		client = new Client(codeClient,nomClient,prenomClient, adresse1,adresse2, codePostal, ville, numTel,assurance,email,remarque,archive);
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
				long codeClient = rc.getLong("codeclient");
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

	public Boolean update(Client cli) throws DALException {
		StringBuilder SQL = new StringBuilder("UPDATE dbo.ARTICLES SET ");
		SQL.append("reference = '");
		SQL.append(client.getCodeClient());
		SQL.append("', designation = '");
		SQL.append(article.getDesignation().trim());
		SQL.append("', marque = '");
		SQL.append(article.getMarque().trim());
		SQL.append("', prixUnitaire = ");
		SQL.append(article.getPrixUnitaire());
		SQL.append(", qteStock = ");
		SQL.append(article.getQteStock());

		SQL.append(" WHERE idArticle = ");
		SQL.append(article.getIdArticle());
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			stm.executeUpdate(SQL.toString());
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}

	public void insert(Client client) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			int nbRow = stm.executeUpdate(Request.getArticleRequestInsert(article), Statement.RETURN_GENERATED_KEYS);
			if (nbRow == 1) {
				ResultSet rs = stm.getGeneratedKeys();
				if (rs.next()) {
					article.setIdArticle(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}

	public Boolean delete(Article article) throws DALException {
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			stm.executeUpdate(Request.getArticleRequestDelete(article));
			return true;
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
	}
	
	@Override
	public List<Article> selectByMark(String mark) throws DALException {
		List<Stylo> stylo = new ArrayList<>();
		List<Ramette> ramette = new ArrayList<>();
		List<Article> articleList = new ArrayList<>();
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			ResultSet rc = stm.executeQuery(Request.getArticleRequestSelectByMark(mark));
			while (rc.next()) {
				int idArticle = rc.getInt("idArticle");
				String reference = rc.getString("reference");
				String couleur = rc.getString("couleur");
				String designation = rc.getString("designation");
				String marque = rc.getString("marque");
				float prixUnitaire = rc.getFloat("prixUnitaire");
				int qteStock = rc.getInt("qteStock");
				int grammage = rc.getInt("grammage");

				if (Type.STYLO.name().equals(rc.getString("Type").trim().toUpperCase())) {
					stylo.add(new Stylo(idArticle, marque, reference, designation, prixUnitaire, qteStock, couleur));
				} else {
					ramette.add(new Ramette(idArticle, marque, reference, designation, prixUnitaire, qteStock, grammage));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (!stylo.isEmpty()) {
			articleList.addAll(stylo);
		}

		if (!ramette.isEmpty()) {
			articleList.addAll(ramette);
		}
		return articleList;
	}

	@Override
	public List<Article> selectByKeyWord(String word) throws DALException {
		List<Stylo> stylo = new ArrayList<>();
		List<Ramette> ramette = new ArrayList<>();
		List<Article> articleList = new ArrayList<>();
		try (Statement stm = JdbcTools.getConnection().createStatement()) {
			ResultSet rc = stm.executeQuery(Request.getArticleRequestSelectByKeyWord(word));
			while (rc.next()) {
				int idArticle = rc.getInt("idArticle");
				String reference = rc.getString("reference");
				String couleur = rc.getString("couleur");
				String designation = rc.getString("designation");
				String marque = rc.getString("marque");
				float prixUnitaire = rc.getFloat("prixUnitaire");
				int qteStock = rc.getInt("qteStock");
				int grammage = rc.getInt("grammage");

				if (Type.STYLO.name().equals(rc.getString("Type").trim().toUpperCase())) {
					stylo.add(new Stylo(idArticle, marque, reference, designation, prixUnitaire, qteStock, couleur));
				} else {
					ramette.add(new Ramette(idArticle, marque, reference, designation, prixUnitaire, qteStock, grammage));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!stylo.isEmpty()) {
			articleList.addAll(stylo);
		}

		if (!ramette.isEmpty()) {
			articleList.addAll(ramette);
		}
		return articleList;
	}

}
