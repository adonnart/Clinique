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
		sql.append(cl.getNomClient());
		sql.append("', '");
		sql.append(cl.getPrenomClient());
		sql.append("', '");
		sql.append(cl.getAdresse1());
		sql.append("', '");
		sql.append(cl.getAdresse2());
		sql.append("', '");
		sql.append(cl.getCodePostal());
		sql.append("', '");
		sql.append(cl.getVille());
		sql.append("', '");
		sql.append(cl.getNumTel());
		sql.append("', '");
		sql.append(cl.getAssurance());
		sql.append("', '");
		sql.append(cl.getEmail());
		sql.append("', '");
		sql.append(cl.getRemarque());
		sql.append("', '");
		sql.append(cl.isArchive());
		sql.append("');");
		
		return sql.toString();
	}
	
	public static String getClientQueryUpdate(Client cl) {
		sql = new StringBuilder();
		sql.append("UPDATE Clients SET ");
		sql.append("NomClient = '");
		sql.append(cl.getNomClient());
		sql.append("', PrenomClient = '");
		sql.append(cl.getPrenomClient());
		sql.append("', Adresse1 = '");
		sql.append(cl.getAdresse1());
		sql.append("', Adresse2 = '");
		sql.append(cl.getAdresse2());
		sql.append("', CodePostal = '");
		sql.append(cl.getCodePostal());
		sql.append("', Ville = '");
		sql.append(cl.getVille());
		sql.append("', NumTel = '");
		sql.append(cl.getNumTel());
		sql.append("', Assurance = '");
		sql.append(cl.getAssurance());
		sql.append("', Email = '");
		sql.append(cl.getEmail());
		sql.append("', Remarque = '");
		sql.append(cl.getRemarque());
		sql.append("' WHERE CodeClient = ");
		sql.append(cl.getCodeClient());
		sql.append(";");
		
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
		sql.append(pl.getNom());
		sql.append("', '");
		sql.append(pl.getMotPasse());
		sql.append("', '");
		sql.append(pl.getRole());
		sql.append("', '");
		sql.append(pl.isArchive());
		sql.append("');");
		
		return sql.toString();
	}
	
	public static String getPersonnelQueryUpdate(Personnel pl) {
		sql = new StringBuilder();
		sql.append("UPDATE Personnels SET ");
		sql.append("Nom = '");
		sql.append(pl.getNom());
		sql.append("', MotPasse = '");
		sql.append(pl.getMotPasse());
		sql.append("', Role = '");
		sql.append(pl.getRole());
		sql.append("', Archive = '");
		sql.append(pl.isArchive());
		sql.append("' WHERE CodePers = ");
		sql.append(pl.getCodePers());
		sql.append(";");
		
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