package fr.eni.clinique.ihm.client;

import java.util.List;

import fr.eni.clinique.bll.AnimalManager;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientManager;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;

public class AjouterClientController {
		private static AjouterClientController instance;
		private AjouterClient ecrAjouter;
		private List<Animal> listAnimal;
		private AnimalManager mger;
		private ClientManager climger;
		private int codeClient = 0;
		private Client client;

		public static synchronized AjouterClientController get() {
			if (instance == null) {
				instance = new AjouterClientController();
			}
			return instance;
		}

		public AjouterClientController() {
			try {
				mger = AnimalManager.getInstance();	
				climger = ClientManager.getInstance();	
			} catch (fr.eni.clinique.bll.BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public AjouterClient startFrame() {
			ecrAjouter = new AjouterClient();
			ecrAjouter.setVisible(true);
			return ecrAjouter;
		}

		public void valider() {
			client = new Client();
			client.setNomClient(ecrAjouter.getTextNom().getText());
			client.setPrenomClient(ecrAjouter.getTextPrenom().getText());
			client.setAdresse1(ecrAjouter.getTextAdresse().getText());
			client.setAdresse2(ecrAjouter.getTextAdresse2().getText());
			client.setCodePostal(ecrAjouter.getTextCP().getText());
			client.setVille(ecrAjouter.getTextVille().getText());

			try {
				climger.addClient(client);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ecrAjouter.dispose();
		}
}
