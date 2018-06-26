package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.jdbc.ClientDAO;
import fr.eni.clinique.dal.jdbc.PersonnelDAO;

public class AppliTestDAL {

	public static void main(String[] args) {
		
		/* Clients */
		
		// Déclaration et instanciation de la DAO
		ClientDAO clientDAO = DAOFactory.getClientDAO();
		
		// Instanciation du jeu d'essai
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
			System.out.println("Client ajouté :\n\t" + unClient1.toString());
			clientDAO.insert(unClient2);
			System.out.println("Client ajouté :\n\t" + unClient2.toString());
			clientDAO.insert(unClient3);
			System.out.println("Client ajouté :\n\t" + unClient3.toString());
			
			// Sélection d'un client par id
			int id = unClient1.getCodeClient();
			Client c = clientDAO.selectById(id);
			System.out.println("Sélection d'un client par id (" + id + ") :\n\t" + c.toString());
			
			// Sélection de tous les clients
			List<Client> listClients = clientDAO.selectAll();
			System.out.println("Sélection de tous les clients :\n\t" + listClients.toString());
			
			// Modification d'un client
			System.out.println("Client avant modification :\n\t" + unClient1.toString());
			
			unClient1.setNomClient("nouveauNom");
			unClient1.setPrenomClient("nouveauPrenom");
			unClient1.setVille("Nantes");
			
			clientDAO.update(unClient1);
			
			System.out.println("Client après modification :\n\t" + unClient1.toString());
			System.out.println(clientDAO.selectById(id));
			
			// Suppression d'un client
			StringBuffer sb;
			List<Client> clients;
			
			System.out.println("Liste des clients avant suppression :");
			clients = clientDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Client cl : clients) {
				sb.append(cl.getCodeClient()).append(" - ");
				sb.append(cl.getNomClient()).append("\n");
			}
			System.out.println(sb.toString());
			
			System.out.println("Suppression du client :\n\t" + unClient2.toString() + "\n");
			clientDAO.delete(unClient2);
			
			System.out.println("Liste des clients après suppression :");
			clients = clientDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Client cl : clients) {
				sb.append(cl.getCodeClient()).append(" - ");
				sb.append(cl.getNomClient()).append("\n");
			}
			System.out.println(sb.toString());
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		/* Personnels */
		
		// Déclaration et instanciation de la DAO
		PersonnelDAO personnelDAO = DAOFactory.getPersonnelDAO();
		
		// Instanciation du jeu d'essai
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
			int id = unPersonnel1.getCodePers();
			Personnel p = personnelDAO.selectById(id);
			System.out.println("Sélection d'un personnel par id (" + id + ") :\n\t" + p.toString());
			
			// Sélection de tous les personnels
			List<Personnel> listPersonnels = personnelDAO.selectAll();
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
			StringBuffer sb;
			List<Personnel> personnels;
			
			System.out.println("Liste des personnels avant suppression :");
			personnels = personnelDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Personnel pl : personnels) {
				sb.append(pl.getCodePers()).append(" - ");
				sb.append(pl.getNom()).append("\n");
			}
			System.out.println(sb.toString());
			
			System.out.println("Suppression du personnel :\n\t" + unPersonnel2.toString() + "\n");
			personnelDAO.delete(unPersonnel2);
			
			System.out.println("Liste des personnels après suppression :");
			personnels = personnelDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Personnel cl : personnels) {
				sb.append(cl.getCodePers()).append(" - ");
				sb.append(cl.getNom()).append("\n");
			}
			System.out.println(sb.toString());
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}

}