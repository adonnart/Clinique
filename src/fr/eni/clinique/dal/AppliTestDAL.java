package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.jdbc.ClientDAO;

public class AppliTestDAL {

	public static void main(String[] args) {
		
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
				sb.append(cl.getCodeClient());
				sb.append(" - ");
				sb.append(cl.getNomClient());
				sb.append("\n");
			}
			System.out.println(sb.toString());
			
			System.out.println("Suppression du client :\n\t" + unClient2.toString() + "\n");
			clientDAO.delete(unClient2);
			
			System.out.println("Liste des clients après suppression :");
			clients = clientDAO.selectAll();
			sb = new StringBuffer();
			sb.append("ID - Nom\n");
			for (Client cl : clients) {
				sb.append(cl.getCodeClient());
				sb.append(" - ");
				sb.append(cl.getNomClient());
				sb.append("\n");
			}
			System.out.println(sb.toString());
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
}