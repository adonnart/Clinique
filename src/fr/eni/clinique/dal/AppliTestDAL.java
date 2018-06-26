package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.jdbc.ClientDAO;

public class AppliTestDAL {

	public static void main(String[] args) {

		// D�claration et instanciation de la DAO
		ClientDAO clientDAO = DAOFactory.getClientDAO();

		// Instanciation du jeu d'essai
		Client unClient1 = new Client("nomtest1", "prenomtest1", "adsfsdf", "adresse2", "35000", "Rennes", "054215612",
				"Oui", "test@test.com", "remarque", true);
		Client unClient2 = new Client("nomtest2", "prenomtest2", "15 rue de ", "15 rue de ", "35000", "Rennes",
				"054215612", "Oui", "test@test.com", "remarque", true);
		Client unClient3 = new Client("nomtest3", "prenomtest3", "15 rue de ", "15 rue de ", "35000", "Rennes",
				"054215612", "Oui", "test@test.com", "remarque", true);
		System.out.println("Ajout des Clients... ");

		try {
			clientDAO.insert(unClient1);
			System.out.println("Client ajout�  : " + unClient1.toString());
			clientDAO.insert(unClient2);
			System.out.println("Client ajout�  : " + unClient2.toString());
			clientDAO.insert(unClient3);
			System.out.println("Client ajout�  : " + unClient3.toString());

			// S�lection d'un client par id
			Client c = clientDAO.selectById(unClient1.getCodeClient());
			System.out.println("S�lection d'un client par id  : " + c.toString());

			// S�lection de tous les clients
			List<Client> listClients = clientDAO.selectAll();
			System.out.println("S�lection de tous les clients  : " + listClients.toString());

			// Modification d'un article
			System.out.println("Modification d'un client : ");
			System.out.println("Client avant modification : " + unClient1.toString());
			unClient1.setNomClient("nouveau ");
			unClient1.setPrenomClient("nouveau ");
			unClient1.setVille("Nantes");
			clientDAO.update(unClient1);
			System.out.println("Client apr�s modification  : " + unClient1.toString());
			System.out.println(clientDAO.selectById(unClient1.getCodeClient()));
			System.out.println("Liste des clients avant suppression : ");
			StringBuffer sb1 = new StringBuffer();
			List<Client> clients = clientDAO.selectAll();
			for (Client client : clients) {
				sb1.append(client.getCodeClient());
				sb1.append(", nom=");
				sb1.append(client.getNomClient()).append("]\n");
			}
			System.out.println(sb1.toString());
			System.out.println("---------------------------------------------------------------");
			// Suppression d'un article
			System.out.println("Suppression de client  : " + unClient2.toString());
			clientDAO.delete(unClient2);
			clients = clientDAO.selectAll();
			System.out.println("Liste des clients apr�s suppression : ");
			StringBuffer sb2 = new StringBuffer();

			for (Client client : clients) {
				sb2.append(client.getCodeClient());
				sb2.append(", ref=");
				sb2.append(client.getNomClient()).append("]\n");
			}
			System.out.println(sb2.toString());
			System.out.println("---------------------------------------------------------------");
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
}