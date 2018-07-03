package fr.eni.clinique.ihm.client;

import java.util.List;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientManager;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;


	public class EcranSearchController {

		private static EcranSearchController instance;

		EcranSearch ecrSearch;
		ClientManager mger;
		public static synchronized EcranSearchController get() {
			if (instance == null) {
				instance = new EcranSearchController();
			}
			return instance;
		}

		public EcranSearchController() {

			try {
				mger = ClientManager.getInstance();	
				
			} catch (fr.eni.clinique.bll.BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public EcranSearch openEcranSearch() {
			ecrSearch = new EcranSearch();
			ecrSearch.setVisible(true);
			return ecrSearch;
		}
		
		public List<Client> getListClient() {
			try {
				listAnimal = mger.getAnimalByClient(1);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listAnimal;
		}
	}

