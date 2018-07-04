package fr.eni.clinique.dal;

import java.util.Date;
import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Agenda;

public class AppliTestDAL {

	private static ClientDAO clientDAO = DAOFactory.getClientDAO();
	private static PersonnelDAO personnelDAO = DAOFactory.getPersonnelDAO();
	private static AnimalDAO animalDAO = DAOFactory.getAnimalDAO();
	private static AgendaDAO agendaDAO = DAOFactory.getAgendaDAO();
	
	private static List<Client> listClients;
	private static List<Personnel> listPersonnels;
	private static List<Animal> listAnimaux;
	private static List<Agenda> listAgendas;
	
	private static Client unClient1, unClient2, unClient3, unClient4;
	private static Personnel unPersonnel1, unPersonnel2, unPersonnel3, unPersonnel4;
	private static Animal unAnimal1, unAnimal2, unAnimal3, unAnimal4;
	private static Agenda unAgenda1, unAgenda2, unAgenda3;
	
	private static Date d = new Date();
	private static StringBuffer sb;
	
	public static void main(String[] args) {
		
		testClient();
		testPersonnel();
		testAnimal();
		testAgenda();
		//testRaz();
		
	}
	
	public static void testClient() {
		
		// Jeu d'essai
		unClient1 = new Client("nomtest1", "prenomtest1", "1 rue ce", "appt 1", 
				"35000", "Rennes", "0123456789", "Oui", "test@test.com", "remarque", false);
		unClient2 = new Client("nomtest2", "prenomtest2", "1 rue ce", "appt 1", 
				"35000", "Rennes", "0123456789", "Oui", "test@test.com", "remarque", false);
		unClient3 = new Client("nomtest3", "prenomtest3", "1 rue ce", "appt 1", 
				"35000", "Rennes", "0123456789", "Oui", "test@test.com", "remarque", false);
		unClient4 = new Client("nomtest4", "prenomtest4", "1 rue ce", "appt 1", 
				"35000", "Rennes", "0123456789", "Oui", "test@test.com", "remarque", false);
		
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
			System.out.println("Sélection d'un client par id :" + clientDAO.selectById(3));
			
			// Sélection de tous les clients
			listClients = clientDAO.selectAll();
			System.out.println("Sélection de tous les clients :\n" + listClients.toString());
			
			// Modification d'un client
			System.out.println("Client avant modification :" + unClient1.toString());
			
			unClient1.setNomClient("nouveauNom");
			unClient1.setPrenomClient("nouveauPrenom");
			unClient1.setVille("Nantes");
			unClient1.setArchive(false);
			clientDAO.update(unClient1);
			
			System.out.println("Client après modification :" + clientDAO.selectById(unClient1.getCodeClient()));
			
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
		
		// Jeu d'essai
		unPersonnel1 = new Personnel("nomtest1", "pwtest1", "VET", true);
		unPersonnel2 = new Personnel("nomtest2", "pwtest2", "SEC", true);
		unPersonnel3 = new Personnel("nomtest3", "pwtest3", "ADM", true);
		unPersonnel4 = new Personnel("nomtest4", "pwtest4", "SEC", true);
		
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
			System.out.println("Sélection d'un personnel par id :" + personnelDAO.selectById(3));
			
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
		
		// Jeu d'essai
		unAnimal1 = new Animal("nomtest1", 'M', "Blanc", "Dalmatien", "Chien", unClient1.getCodeClient(), "Non", "Aucun", false);
		unAnimal2 = new Animal("nomtest2", 'F', "Beige", "Siamois", "Chat", unClient1.getCodeClient(), "Non", "Aucun", false);
		unAnimal3 = new Animal("nomtest3", 'M', "Gris", "Chartreux", "Chat", unClient1.getCodeClient(), "Oui", "Oui", false);
		unAnimal4 = new Animal("nomtest4", 'F', "Noir", "Beauceron", "Chien", unClient2.getCodeClient(), "Oui", "Oui", false);
		
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
			System.out.println("Sélection d'un animal par id :" + animalDAO.selectById(3));
			
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
		
		// Jeu d'essai
		unAgenda1 = new Agenda(1, 1, d);
		unAgenda2 = new Agenda(2, 2, d);
		unAgenda3 = new Agenda(3, 3, d);
		
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
			System.out.print("Sélection d'un agenda par id : ");
			System.out.println(agendaDAO.selectByIds(unAgenda1.getCodeVeto(), unAgenda1.getCodeAnimal()));
					
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
				sb.append(Queries.convertDate(ag.getDateRdv())).append("\n");
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
				sb.append(Queries.convertDate(ag.getDateRdv())).append("\n");
			}
			System.out.println(sb.toString());
			
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	public static void testRaz() {
		
		try {
			agendaDAO.delete(unAgenda1);
			agendaDAO.delete(unAgenda2);
			
			animalDAO.delete(unAnimal1);
			animalDAO.delete(unAnimal2);
			animalDAO.delete(unAnimal3);
			
			personnelDAO.delete(unPersonnel1);
			personnelDAO.delete(unPersonnel2);
			personnelDAO.delete(unPersonnel3);
			
			clientDAO.delete(unClient1);
			clientDAO.delete(unClient2);
			clientDAO.delete(unClient3);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}

}