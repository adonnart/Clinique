package fr.eni.clinique.dal;

import java.util.Date;
import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Agenda;

public class AppliTestDAL {

	private static int id;
	private static StringBuffer sb;
	
	public static void main(String[] args) {
		
		testClient();
		//testPersonnel();
		testAnimal();
		//testAgenda();
		
	}
	
	public static void testClient() {
		
		// Déclarations
		DAO<Client> clientDAO = DAOFactory.getClientDAO();
		List<Client> listClients;
		
		// Jeu d'essai
		Client unClient1 = new Client("nomtest1", "prenomtest1", "adsfsdf", "adresse2", "35000", "Rennes", 
				"054215612", "Oui", "test@test.com", "remarque", true);
		Client unClient2 = new Client("nomtest2", "prenomtest2", "15 rue de ", "15 rue de ", "35000", "Rennes",
				"054215612", "Oui", "test@test.com", "remarque", true);
		Client unClient3 = new Client("nomtest3", "prenomtest3", "18 rue de ", "18 rue de ", "35000", "Rennes",
				"054215612", "Oui", "test@test.com", "remarque", true);
		
		try {
			// Ajout des clients
			System.out.println("Ajout des clients... ");
			clientDAO.insert(unClient1);
			System.out.println("Client ajouté :\n" + unClient1.toString());
			clientDAO.insert(unClient2);
			System.out.println("Client ajouté :\n" + unClient2.toString());
			clientDAO.insert(unClient3);
			System.out.println("Client ajouté :\n" + unClient3.toString());
			
			// Sélection d'un client par id
			id = unClient1.getCodeClient();
			Client c = clientDAO.selectById(id);
			System.out.println("Sélection d'un client par id (" + id + ") :\n" + c.toString());
			
			// Sélection de tous les clients
			listClients = clientDAO.selectAll();
			System.out.println("Sélection de tous les clients :\n" + listClients.toString());
			
			// Modification d'un client
			System.out.println("Client avant modification :\n" + unClient1.toString());
			
			unClient1.setNomClient("nouveauNom");
			unClient1.setPrenomClient("nouveauPrenom");
			unClient1.setVille("Nantes");
			
			clientDAO.update(unClient1);
			
			System.out.println("Client après modification :\n" + unClient1.toString());
			System.out.println(clientDAO.selectById(id));
			
			// Suppression d'un client			
			System.out.println("Liste des clients avant suppression :");
			listClients = clientDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Client cl : listClients) {
				sb.append(cl.getCodeClient()).append(" - ");
				sb.append(cl.getNomClient()).append("\n");
			}
			System.out.println(sb.toString());
			
			System.out.println("Suppression du client :\n" + unClient2.toString() + "\n");
			clientDAO.delete(unClient2);
			
			System.out.println("Liste des clients après suppression :");
			listClients = clientDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Client cl : listClients) {
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
		Personnel unPersonnel1 = new Personnel("nomtest1", "pwtest1", "vet", true);
		Personnel unPersonnel2 = new Personnel("nomtest2", "pwtest2", "sec", true);
		Personnel unPersonnel3 = new Personnel("nomtest3", "pwtest3", "adm", true);
		
		try {
			// Ajout des personnels
			System.out.println("Ajout des personnels... ");
			personnelDAO.insert(unPersonnel1);
			System.out.println("Personnel ajouté :\n\t" + unPersonnel1.toString());
			personnelDAO.insert(unPersonnel2);
			System.out.println("Personnel ajouté :\n\t" + unPersonnel2.toString());
			personnelDAO.insert(unPersonnel3);
			System.out.println("Personnel ajouté :\n\t" + unPersonnel3.toString());
			
			// Sélection d'un personnel par id
			id = unPersonnel1.getCodePers();
			Personnel p = personnelDAO.selectById(id);
			System.out.println("Sélection d'un personnel par id (" + id + ") :\n\t" + p.toString());
			
			// Sélection de tous les personnels
			listPersonnels = personnelDAO.selectAll();
			System.out.println("Sélection de tous les personnels :\n\t" + listPersonnels.toString());
			
			// Modification d'un personnel
			System.out.println("Personnel avant modification :\n\t" + unPersonnel1.toString());
			
			unPersonnel1.setNom("nouveauNom");
			unPersonnel1.setMotPasse("nouveauPw");
			unPersonnel1.setRole("sec");
			
			personnelDAO.update(unPersonnel1);
			
			System.out.println("Personnel après modification :\n\t" + unPersonnel1.toString());
			System.out.println(personnelDAO.selectById(id));
			
			// Suppression d'un personnel			
			System.out.println("Liste des personnels avant suppression :");
			listPersonnels = personnelDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Personnel pl : listPersonnels) {
				sb.append(pl.getCodePers()).append(" - ");
				sb.append(pl.getNom()).append("\n");
			}
			System.out.println(sb.toString());
			
			System.out.println("Suppression du personnel :\n\t" + unPersonnel2.toString() + "\n");
			personnelDAO.delete(unPersonnel2);
			
			System.out.println("Liste des personnels après suppression :");
			listPersonnels = personnelDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Personnel pl : listPersonnels) {
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
		Animal unAnimal1 = new Animal("nomtest1", 'M', "Blanc", "Dalmatien", "Chien", 7, "Non", "Aucun", true);
		Animal unAnimal2 = new Animal("nomtest2", 'F', "Beige", "Siamois", "Chat", 8, "Non", "Aucun", true);
		Animal unAnimal3 = new Animal("nomtest3", 'M', "Gris", "Chartreux", "Chat", 9, "Oui", "Oui", true);
		
		try {
			// Ajout des animaux
			System.out.println("Ajout des animaux... ");
			animalDAO.insert(unAnimal1);
			System.out.println("Animal ajouté :" + unAnimal1.toString());
			animalDAO.insert(unAnimal2);
			System.out.println("Animal ajouté :" + unAnimal2.toString());
			animalDAO.insert(unAnimal3);
			System.out.println("Animal ajouté :" + unAnimal3.toString());
			
			// Sélection d'un animal par id
			id = unAnimal1.getCodeAnimal();
			Animal a = animalDAO.selectById(id);
			System.out.println("Sélection d'un animal par id (" + id + ") :" + a.toString());
			
			// Sélection de tous les animaux
			listAnimaux = animalDAO.selectAll();
			System.out.println("Sélection de tous les animaux :" + listAnimaux.toString());
			
			// Modification d'un animal
			System.out.println("Animal avant modification :" + unAnimal1.toString());
			
			unAnimal1.setNomAnimal("nouveauNom");
			unAnimal1.setCouleur("Beige");
			unAnimal1.setRace("golden");
			
			animalDAO.update(unAnimal1);
			
			System.out.println("Animal après modification :" + unAnimal1.toString());
			System.out.println(animalDAO.selectById(id));
			
			// Suppression d'un animal
			System.out.println("Liste des animaux avant suppression :");
			listAnimaux = animalDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Animal an : listAnimaux) {
				sb.append(an.getCodeAnimal()).append(" - ");
				sb.append(an.getNomAnimal()).append("\n");
			}
			System.out.println(sb.toString());
			
			System.out.println("Suppression de l'animal :" + unAnimal2.toString() + "\n");
			animalDAO.delete(unAnimal2);
			
			System.out.println("Liste des animaux après suppression :");
			listAnimaux = animalDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Animal an : listAnimaux) {
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
		
		// Jeu d'essai
		Agenda unAgenda1 = new Agenda(1, 1, new Date());
		Agenda unAgenda2 = new Agenda(2, 2, new Date());
		Agenda unAgenda3 = new Agenda(3, 3, new Date());
		
		try {
			// Ajout des agendas
			System.out.println("Ajout des agendas... ");
			agendaDAO.insert(unAgenda1);
			System.out.println("Agenda ajouté :\n\t" + unAgenda1.toString());
			agendaDAO.insert(unAgenda2);
			System.out.println("Agenda ajouté :\n\t" + unAgenda2.toString());
			agendaDAO.insert(unAgenda3);
			System.out.println("Agenda ajouté :\n\t" + unAgenda3.toString());
			
			// Sélection d'un agenda par id
			id = unAgenda1.getCodeAnimal();
			Agenda a = agendaDAO.selectById(id);
			System.out.println("Sélection d'un agenda par id (" + id + ") :\n\t" + a.toString());
			
			// Sélection de tous les agendas
			listAgendas = agendaDAO.selectAll();
			System.out.println("Sélection de tous les agendas :\n\t" + listAgendas.toString());
			
			// Modification d'un agenda
			System.out.println("Agenda avant modification :\n\t" + unAgenda1.toString());
			
			unAgenda1.setCodeAnimal(3);
			unAgenda1.setDateRdv(new Date());
			
			agendaDAO.update(unAgenda1);
			
			System.out.println("Agenda après modification :\n\t" + unAgenda1.toString());
			System.out.println(agendaDAO.selectById(id));
			
			// Suppression d'un agenda
			System.out.println("Liste des agendas avant suppression :");
			listAgendas = agendaDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - ID - Date\n");
			for (Agenda ag : listAgendas) {
				sb.append(ag.getCodeVeto()).append(" - ");
				sb.append(ag.getCodeAnimal()).append(" - ");
				sb.append(ag.getDateRdv()).append("\n");
			}
			System.out.println(sb.toString());
			
			System.out.println("Suppression de l'agenda :\n\t" + unAgenda2.toString() + "\n");
			agendaDAO.delete(unAgenda2);
			
			System.out.println("Liste des agendas après suppression :");
			listAgendas = agendaDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Agenda ag : listAgendas) {
				sb.append(ag.getCodeVeto()).append(" - ");
				sb.append(ag.getCodeAnimal()).append(" - ");
				sb.append(ag.getDateRdv()).append("\n");
			}
			System.out.println(sb.toString());
			
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}