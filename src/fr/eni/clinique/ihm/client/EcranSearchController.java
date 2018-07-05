package fr.eni.clinique.ihm.client;


import java.util.List;



import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientManager;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.ihm.MainFrameController;


	public class EcranSearchController {

		private static EcranSearchController instance;

		private EcranSearch ecrSearch;
		private 	ClientManager mger;
		private List<Client> listClient;
		private 	List<Client> listContains;
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
		public List<Client> getAllListClient() {
			try {
				listClient= mger.getAllClient();
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listClient;
		}
		
		public List<Client> getListClient() {
			try {
				String search = EcranClientController.get().ecrClient.getTextSearch().getText();
				listClient= mger.selectClientByName(search);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listClient;
		}
		public void  refresh(){
			ecrSearch.getTableClient();
		}

		public void selectClient() {
			
			int selectedRow = ecrSearch.getTableClient().getSelectedRow();
			Client p= listClient.get(selectedRow);
			EcranClientController.get().refresh();
			EcranClientController.get().setCodeClient(p.getCodeClient());
			MainFrameController.get().gestionClient();
			EcranClientController.get().loadClient(p);
			ecrSearch.dispose();
			
		}
		
		
	}

