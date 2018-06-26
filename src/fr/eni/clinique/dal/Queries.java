package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
//import fr.eni.clinique.bo.Animal;
//import fr.eni.clinique.bo.Agenda;
//import fr.eni.clinique.bo.Race;

public abstract class Queries {

	private static StringBuilder sql;
	
	// Clients
	
	public static String getClientQueryInsert(Client cl) {
		sql = new StringBuilder();
		sql.append("INSERT INTO Clients (");
		sql.append("NomClient, PrenomClient, Adresse1, Adresse2, CodePostal, ");
		sql.append("Ville, NumTel, Assurance, Email, Remarque, Archive");
		sql.append(") VALUES ('");
		sql.append(cl.getNomClient()).append("', '");
		sql.append(cl.getPrenomClient()).append("', '");
		sql.append(cl.getAdresse1()).append("', '");
		sql.append(cl.getAdresse2()).append("', '");
		sql.append(cl.getCodePostal()).append("', '");
		sql.append(cl.getVille()).append("', '");
		sql.append(cl.getNumTel()).append("', '");
		sql.append(cl.getAssurance()).append("', '");
		sql.append(cl.getEmail()).append("', '");
		sql.append(cl.getRemarque()).append("', '");
		sql.append(cl.isArchive()).append("')");
		
		return sql.toString();
	}
	
	public static String getClientQueryUpdate(Client cl) {
		sql = new StringBuilder();
		sql.append("UPDATE Clients SET ");
		sql.append("NomClient = '").append(cl.getNomClient());
		sql.append("', PrenomClient = '").append(cl.getPrenomClient());
		sql.append("', Adresse1 = '").append(cl.getAdresse1());
		sql.append("', Adresse2 = '").append(cl.getAdresse2());
		sql.append("', CodePostal = '").append(cl.getCodePostal());
		sql.append("', Ville = '").append(cl.getVille());
		sql.append("', NumTel = '").append(cl.getNumTel());
		sql.append("', Assurance = '").append(cl.getAssurance());
		sql.append("', Email = '").append(cl.getEmail());
		sql.append("', Remarque = '").append(cl.getRemarque());
		sql.append("' WHERE CodeClient = ").append(cl.getCodeClient());
		
		return sql.toString();
	}
	
	public static String getClientQuerySelectAll() {
		return "SELECT * FROM Clients";
	}
	
	public static String getClientQuerySelectById(int id) {
		return "SELECT * FROM Clients WHERE CodeClient = " + id;
	}
	
	public static String getClientQueryDelete(Client cl) {
		return "DELETE FROM Clients WHERE CodeClient = " + cl.getCodeClient();
	}
	
	// Personnels
	
	public static String getPersonnelQueryInsert(Personnel pl) {
		sql = new StringBuilder();
		sql.append("INSERT INTO Personnels (");
		sql.append("Nom, MotPasse, Role, Archive");
		sql.append(") VALUES ('");
		sql.append(pl.getNom()).append("', '");
		sql.append(pl.getMotPasse()).append("', '");
		sql.append(pl.getRole()).append("', '");
		sql.append(pl.isArchive()).append("')");
		
		return sql.toString();
	}
	
	public static String getPersonnelQueryUpdate(Personnel pl) {
		sql = new StringBuilder();
		sql.append("UPDATE Personnels SET ");
		sql.append("Nom = '").append(pl.getNom());
		sql.append("', MotPasse = '").append(pl.getMotPasse());
		sql.append("', Role = '").append(pl.getRole());
		sql.append("', Archive = '").append(pl.isArchive());
		sql.append("' WHERE CodePers = ").append(pl.getCodePers());
		
		return sql.toString();
	}
	
	public static String getPersonnelQuerySelectAll() {
		return "SELECT * FROM Personnels";
	}
	
	public static String getPersonnelQuerySelectById(int id) {
		return "SELECT * FROM Personnels WHERE codePers = " + id;
	}
	
	public static String getPersonnelQueryDelete(Personnel pl) {
		return "DELETE FROM Personnels WHERE codePers = " + pl.getCodePers();
	}
	
	// Animaux
	
	
	
	// Agendas
	
	
	
	// Races

}