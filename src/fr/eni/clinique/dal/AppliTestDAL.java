package fr.eni.clinique.dal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Agenda;

public class AppliTestDAL {

	private static int id;
	private static StringBuffer sb;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	public static void main(String[] args) {
		
		testClient();
		//testPersonnel();
		testAnimal();
		testAgenda();
		
	}
	
	public static void testClient() {
		
		// Déclarations
		DAO<Client> clientDAO = DAOFactory.getClientDAO();
		List<Client> listClients;
		
		// Jeu d'essai
		Client unClient1 = new Client("nomtest1", "prenomtest1", "1 rue ce", "appt 1", 
				"35000", "Rennes", "0123456789", "Oui", "test@test.com", "remarque", true);
		Client unClient2 = new Client("nomtest2", "prenomtest2", "1 rue ce", "appt 1", 
				"35000", "Rennes", "0123456789", "Oui", "test@test.com", "remarque", true);
		Client unClient3 = new Client("nomtest3", "prenomtest3", "1 rue ce", "appt 1", 
				"35000", "Rennes", "0123456789", "Oui", "test@test.com", "remarque", true);
		Client unClient4 = new Client("nomtest4", "prenomtest4", "1 rue ce", "appt 1", 
				"35000", "Rennes", "0123456789", "Oui", "test@test.com", "remarque", true);
		
		try {
			// Ajout des clients
			System.out.println("Ajout des clients... ");
			clientDAO.insert(unClient1);
			System.out.println("Client ajouté :" + unClient1.toString());
			clientDAO.insert(unClient2);
			System.out.println("Client ajouté :" + unClient2.toString());
			clientDAO.insert(unClient3);
			System.out.println("Client ajouté :" + unClient3.toString());
			clientDAO.insert(unClient4);
			System.out.println("Client ajouté :" + unClient4.toString());
			
			// Sélection d'un client par id
			id = unClient1.getCodeClient();
			System.out.println("Sélection d'un client par id (" + id + ") :" + clientDAO.selectById(id));
			
			// Sélection de tous les clients
			listClients = clientDAO.selectAll();
			System.out.println("Sélection de tous les clients :\n" + listClients.toString());
			
			// Modification d'un client
			System.out.println("Client avant modification :" + unClient1.toString());
			
			unClient1.setNomClient("nouveauNom");
			unClient1.setPrenomClient("nouveauPrenom");
			unClient1.setVille("Nantes");
			
			clientDAO.update(unClient1);
			
			System.out.println("Client après modification :" + unClient1.toString());
			
			// Suppression d'un client			
			System.out.println("Liste des clients avant suppression :");
			listClients = clientDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Client cl : listClients) {
				if (cl.getCodeClient() < 10) sb.append(" ");
				sb.append(cl.getCodeClient()).append(" - ");
				sb.append(cl.getNomClient()).append("\n");
			}
			System.out.println(sb.toString());
			
			System.out.println("Suppression du client :" + unClient4.toString() + "\n");
			clientDAO.delete(unClient4);
			
			System.out.println("Liste des clients après suppression :");
			listClients = clientDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Client cl : listClients) {
				if (cl.getCodeClient() < 10) sb.append(" ");
				sb.append(cl.getCodeClient()).append(" - ");
				sb.append(cl.getNomClient()).append("\n");
			}
			System.out.println(sb.toString());
			
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testPersonnel() {
		
		// Déclarations
		DAO<Personnel> personnelDAO = DAOFactory.getPersonnelDAO();
		List<Personnel> listPersonnels;
		
		// Jeu d'essai
		Personnel unPersonnel1 = new Personnel("nomtest1", "pwtest1", "VET", true);
		Personnel unPersonnel2 = new Personnel("nomtest2", "pwtest2", "SEC", true);
		Personnel unPersonnel3 = new Personnel("nomtest3", "pwtest3", "ADM", true);
		Personnel unPersonnel4 = new Personnel("nomtest4", "pwtest4", "SEC", true);
		
		try {
			// Ajout des personnels
			System.out.println("Ajout des personnels... ");
			personnelDAO.insert(unPersonnel1);
			System.out.println("Personnel ajouté :" + unPersonnel1.toString());
			personnelDAO.insert(unPersonnel2);
			System.out.println("Personnel ajouté :" + unPersonnel2.toString());
			personnelDAO.insert(unPersonnel3);
			System.out.println("Personnel ajouté :" + unPersonnel3.toString());
			personnelDAO.insert(unPersonnel4);
			System.out.println("Personnel ajouté :" + unPersonnel4.toString());
			
			// Sélection d'un personnel par id
			id = unPersonnel1.getCodePers();
			System.out.println("Sélection d'un personnel par id (" + id + ") :" + personnelDAO.selectById(id));
			
			// Sélection de tous les personnels
			listPersonnels = personnelDAO.selectAll();
			System.out.println("Sélection de tous les personnels :\n" + listPersonnels.toString());
			
			// Modification d'un personnel
			System.out.println("Personnel avant modification :" + unPersonnel1.toString());
			
			unPersonnel1.setNom("nouveauNom");
			unPersonnel1.setMotPasse("nouveauPw");
			unPersonnel1.setRole("sec");
			
			personnelDAO.update(unPersonnel1);
			
			System.out.println("Personnel après modification :" + unPersonnel1.toString());
			
			// Suppression d'un personnel			
			System.out.println("Liste des personnels avant suppression :");
			listPersonnels = personnelDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Personnel pl : listPersonnels) {
				if (pl.getCodePers() < 10) sb.append(" ");
				sb.append(pl.getCodePers()).append(" - ");
				sb.append(pl.getNom()).append("\n");
			}
			System.out.println(sb.toString());
			
			System.out.println("Suppression du personnel :" + unPersonnel4.toString() + "\n");
			personnelDAO.delete(unPersonnel4);
			
			System.out.println("Liste des personnels après suppression :");
			listPersonnels = personnelDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Personnel pl : listPersonnels) {
				if (pl.getCodePers() < 10) sb.append(" ");
				sb.append(pl.getCodePers()).append(" - ");
				sb.append(pl.getNom()).append("\n");
			}
			System.out.println(sb.toString());
			
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testAnimal() {
		
		// Déclarations
		DAO<Animal> animalDAO = DAOFactory.getAnimalDAO();
		List<Animal> listAnimaux;
		
		// Jeu d'essai
		Animal unAnimal1 = new Animal("nomtest1", 'M', "Blanc", "Dalmatien", "Chien", 1, "Non", "Aucun", true);
		Animal unAnimal2 = new Animal("nomtest2", 'F', "Beige", "Siamois", "Chat", 2, "Non", "Aucun", true);
		Animal unAnimal3 = new Animal("nomtest3", 'M', "Gris", "Chartreux", "Chat", 3, "Oui", "Oui", true);
		Animal unAnimal4 = new Animal("nomtest4", 'F', "Noir", "Beauceron", "Chien", 1, "Oui", "Oui", true);
		
		try {
			// Ajout des animaux
			System.out.println("Ajout des animaux... ");
			animalDAO.insert(unAnimal1);
			System.out.println("Animal ajouté :" + unAnimal1.toString());
			animalDAO.insert(unAnimal2);
			System.out.println("Animal ajouté :" + unAnimal2.toString());
			animalDAO.insert(unAnimal3);
			System.out.println("Animal ajouté :" + unAnimal3.toString());
			animalDAO.insert(unAnimal4);
			System.out.println("Animal ajouté :" + unAnimal4.toString());
			
			// Sélection d'un animal par id
			id = unAnimal1.getCodeAnimal();
			System.out.println("Sélection d'un animal par id (" + id + ") :" + animalDAO.selectById(id));
			
			// Sélection de tous les animaux
			listAnimaux = animalDAO.selectAll();
			System.out.println("Sélection de tous les animaux :\n" + listAnimaux.toString());
			
			// Modification d'un animal
			System.out.println("Animal avant modification :" + unAnimal1.toString());
			
			unAnimal1.setNomAnimal("nouveauNom");
			unAnimal1.setCouleur("Beige");
			unAnimal1.setRace("Retriever");
			
			animalDAO.update(unAnimal1);
			
			System.out.println("Animal après modification :" + unAnimal1.toString());
			
			// Suppression d'un animal
			System.out.println("Liste des animaux avant suppression :");
			listAnimaux = animalDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Animal an : listAnimaux) {
				if (an.getCodeAnimal() < 10) sb.append(" ");
				sb.append(an.getCodeAnimal()).append(" - ");
				sb.append(an.getNomAnimal()).append("\n");
			}
			System.out.println(sb.toString());
			
			System.out.println("Suppression de l'animal :" + unAnimal4.toString() + "\n");
			animalDAO.delete(unAnimal4);
			
			System.out.println("Liste des animaux après suppression :");
			listAnimaux = animalDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Animal an : listAnimaux) {
				if (an.getCodeAnimal() < 10) sb.append(" ");
				sb.append(an.getCodeAnimal()).append(" - ");
				sb.append(an.getNomAnimal()).append("\n");
			}
			System.out.println(sb.toString());
			
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testAgenda() {
		
		// Déclarations
		DAO<Agenda> agendaDAO = DAOFactory.getAgendaDAO();
		List<Agenda> listAgendas;
		Date d = new Date();
		
		// Jeu d'essai
		Agenda unAgenda1 = new Agenda(1, 1, d);
		Agenda unAgenda2 = new Agenda(2, 2, d);
		Agenda unAgenda3 = new Agenda(3, 3, d);
		
		try {
			// Ajout des agendas
			System.out.println("Ajout des agendas... ");
			agendaDAO.insert(unAgenda1);
			System.out.println("Agenda ajouté :" + unAgenda1.toString());
			agendaDAO.insert(unAgenda2);
			System.out.println("Agenda ajouté :" + unAgenda2.toString());
			agendaDAO.insert(unAgenda3);
			System.out.println("Agenda ajouté :" + unAgenda3.toString());
			
			// Sélection d'un agenda par id
			id = unAgenda1.getCodeAnimal();
			System.out.println("Sélection d'un agenda par id (" + id + ") :" + agendaDAO.selectById(id));
			
			// Sélection de tous les agendas
			listAgendas = agendaDAO.selectAll();
			System.out.println("Sélection de tous les agendas :\n" + listAgendas.toString());
			
			// Modification d'un agenda
			System.out.println("Agenda avant modification :" + unAgenda1.toString());
			
			unAgenda1.setDateRdv(new Date());
			
			agendaDAO.update(unAgenda1);
			
			System.out.println("Agenda après modification :" + unAgenda1.toString());
			
			// Suppression d'un agenda
			System.out.println("Liste des agendas avant suppression :");
			listAgendas = agendaDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - ID - Date\n");
			for (Agenda ag : listAgendas) {
				if (ag.getCodeVeto() < 10) sb.append(" ");
				sb.append(ag.getCodeVeto()).append(" - ");
				if (ag.getCodeAnimal() < 10) sb.append(" ");
				sb.append(ag.getCodeAnimal()).append(" - ");
				sb.append(sdf.format(ag.getDateRdv())).append("\n");
			}
			System.out.println(sb.toString());
			
			System.out.println("Suppression de l'agenda :" + unAgenda3.toString() + "\n");
			agendaDAO.delete(unAgenda3);
			
			System.out.println("Liste des agendas après suppression :");
			listAgendas = agendaDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Agenda ag : listAgendas) {
				if (ag.getCodeVeto() < 10) sb.append(" ");
				sb.append(ag.getCodeVeto()).append(" - ");
				if (ag.getCodeAnimal() < 10) sb.append(" ");
				sb.append(ag.getCodeAnimal()).append(" - ");
				sb.append(sdf.format(ag.getDateRdv())).append("\n");
			}
			System.out.println(sb.toString());
			
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}