package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Client;

public abstract class Request {

	private static StringBuilder sql;
	
	// Clients
	
	public static String getClientRequestInsert(Client client) {
		sql = new StringBuilder();
		sql.append("INSERT INTO dbo.clients (");
		sql.append("nomclient, prenomclient, adresse1, adresse2, codepostal, ");
		sql.append("ville, numtel, assurance, email, remarque, archive");
		sql.append(") VALUES ('");
		sql.append(client.getNomClient());
		sql.append("', '");
		sql.append(client.getPrenomClient());
		sql.append("', '");
		sql.append(client.getAdresse1());
		sql.append("', '");
		sql.append(client.getAdresse2());
		sql.append("', '");
		sql.append(client.getCodePostal());
		sql.append("', '");
		sql.append(client.getVille());
		sql.append("', '");
		sql.append(client.getNumTel());
		sql.append("', '");
		sql.append(client.getAssurance());
		sql.append("', '");
		sql.append(client.getEmail());
		sql.append("', '");
		sql.append(client.getRemarque());
		sql.append("', '");
		sql.append(client.isArchive());
		sql.append("');");
		
		return sql.toString();
	}
	
	public static String getClientRequestSelectAll() {
		return "SELECT * FROM dbo.clients";
	}
	
	public static String getClientRequestSelectById(int id) {
		return "SELECT * FROM dbo.clients WHERE codeClient = " + id;
	}
	
	public static String getClientRequestDelete(Client client) {
		return "DELETE FROM dbo.clients WHERE codeClient = " + client.getCodeClient();
	}
	
	// Personnels
	
	public static String getPersonnelRequestSelectAll() {
		return "SELECT * FROM dbo.personnels";
	}
	
	public static String getPersonnelRequestSelectById(int id) {
		return "SELECT * FROM dbo.personnels WHERE codePers = " + id;
	}

}