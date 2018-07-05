package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Agenda;
//import fr.eni.clinique.bo.Race;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Queries {

	private static StringBuilder sql;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
	
	public static String getQuerySelectAll(String table) {
		return "SELECT * FROM " + table;
	}
	
	public static String getQuerySelectById(String table, String code, int id) {
		return "SELECT * FROM " + table + " WHERE " + code + " = " + id;
	}
	public static String getQuerySelectByName(String table, String nom ) {
		return "SELECT * FROM " + table + " WHERE NomClient like '%" + nom+"%' and archive = 'false'";
	}
	public static String getQuerySelectByCodeClient(String table, int CodeClient ) {
		return "SELECT * FROM " + table + " WHERE CodeClient = "+CodeClient+"' and archive = 'false'";
	}
	public static String getQuerySelectByEspece(String table) {
		return "SELECT DISTINCT ESPECE FROM " + table;
	}
	public static String getQuerySelectByRace(String table, String column, String espece) {
		return "SELECT DISTINCT RACE FROM " + table + " WHERE " + column + " = '" + espece+"'";
	}
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
		sql.append("', Archive = '").append(cl.isArchive());
		sql.append("' WHERE CodeClient = ").append(cl.getCodeClient());
		
		return sql.toString();
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
	
	public static String getPersonnelQueryDelete(Personnel pl) {
		return "DELETE FROM Personnels WHERE CodePers = " + pl.getCodePers();
	}
	
	// Animaux
	
	public static String getAnimalQueryInsert(Animal an) {
		sql = new StringBuilder();
		sql.append("INSERT INTO Animaux (");
		sql.append("NomAnimal, Sexe, Couleur, Race, Espece, ");
		sql.append("CodeClient, Tatouage, Antecedents, Archive");
		sql.append(") VALUES ('");
		sql.append(an.getNomAnimal()).append("', '");
		sql.append(an.getSexe()).append("', '");
		sql.append(an.getCouleur()).append("', '");
		sql.append(an.getRace()).append("', '");
		sql.append(an.getEspece()).append("', ");
		sql.append(an.getCodeClient()).append(", '");
		sql.append(an.getTatouage()).append("', '");
		sql.append(an.getAntecedents()).append("', '");
		sql.append(an.isArchive()).append("')");
		
		return sql.toString();
	}
	
	public static String getAnimalQueryUpdate(Animal an) {
		sql = new StringBuilder();
		sql.append("UPDATE Animaux SET ");
		sql.append("NomAnimal = '").append(an.getNomAnimal());
		sql.append("', Sexe = '").append(an.getSexe());
		sql.append("', Couleur = '").append(an.getCouleur());
		sql.append("', Race = '").append(an.getRace());
		sql.append("', Espece = '").append(an.getEspece());
		sql.append("', CodeClient = '").append(an.getCodeClient());
		sql.append("', Tatouage = '").append(an.getTatouage());
		sql.append("', Antecedents = '").append(an.getAntecedents());
		sql.append("', Archive = '").append(an.isArchive());
		sql.append("' WHERE CodeAnimal = ").append(an.getCodeAnimal());
		
		return sql.toString();
	}
	
	public static String getAnimalQueryDelete(Animal an) {
		return "DELETE FROM Animaux WHERE codeAnimal = " + an.getCodeAnimal();
	}
	
	// Agendas
	
	public static String getAgendaQuerySelectByIds(int idV, int idA) {
		return "SELECT * FROM Agendas WHERE CodeVeto = " + idV + " AND CodeAnimal = " + idA;
	}
	
	public static String getAgendaQueryInsert(Agenda ag) {
		sql = new StringBuilder();
		sql.append("INSERT INTO Agendas (");
		sql.append("CodeVeto, CodeAnimal, DateRdv");
		sql.append(") VALUES (");
		sql.append(ag.getCodeVeto()).append(", ");
		sql.append(ag.getCodeAnimal()).append(", '");
		sql.append(sdf.format(ag.getDateRdv())).append("')");
		
		return sql.toString();
	}
	
	public static String getAgendaQueryUpdate(Agenda ag) {
		sql = new StringBuilder();
		sql.append("UPDATE Agendas SET ");
		sql.append("DateRdv = '").append(convertDate(ag.getDateRdv())).append("'");
		sql.append(" WHERE CodeVeto = ").append(ag.getCodeVeto());
		sql.append(" AND CodeAnimal = ").append(ag.getCodeAnimal());
		
		return sql.toString();
	}
	
	public static String getAgendaQueryDelete(Agenda ag) {
		sql = new StringBuilder();
		sql.append("DELETE FROM Agendas");
		sql.append(" WHERE CodeVeto = ").append(ag.getCodeVeto());
		sql.append(" AND CodeAnimal = ").append(ag.getCodeAnimal());
		
		return sql.toString();
	}
	
	public static String convertDate(Date d) {
		//LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		//java.sql.Date sqlDate = java.sql.Date.valueOf(date );
		return sdf.format(d);
	}


	// Races

}