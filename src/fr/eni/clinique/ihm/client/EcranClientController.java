package fr.eni.clinique.ihm.client;

import java.util.List;

import fr.eni.clinique.bll.AnimalManager;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientManager;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.ihm.MainFrameController;
import fr.eni.clinique.ihm.animaux.EcranAnimauxController;

public class EcranClientController {
	private static EcranClientController instance;
	EcranClient ecrClient;
	private List<Animal> listAnimal;
	private AnimalManager animger;
	private ClientManager climger;
	private int codeClient = 0;
	private Client client;

	public static synchronized EcranClientController get() {
		if (instance == null) {
			instance = new EcranClientController();
		}
		return instance;
	}

	public EcranClientController() {
		try {
			animger = AnimalManager.getInstance();
			climger = ClientManager.getInstance();
			
		} catch (fr.eni.clinique.bll.BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public EcranClient startFrame() {
		ecrClient = new EcranClient();
		ecrClient.setVisible(true);
		return ecrClient;
	}
	
	public List<Animal> getListAnimal() {
		try {
			listAnimal = animger.getAnimalByClient(codeClient);
			
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAnimal;
	}
	public Client loadClient(Client client){
		ecrClient.getTextCode().setText(client.getCodeClient().toString());
		ecrClient.getTextnom().setText(client.getNomClient());
		ecrClient.getTextPrenom().setText(client.getPrenomClient());
		ecrClient.getTextAdresse().setText(client.getAdresse1());
		ecrClient.getTextAdresse2().setText(client.getAdresse2());
		ecrClient.getTextCP().setText(client.getCodePostal());
		ecrClient.getTextVille().setText(client.getVille());
		this.client = client;
		return client;
	}
	public Client getClient(){
		return this.client;
	}
	public void refresh(){
		ecrClient.dispose();	
	}
	public  void setCodeClient(int codeClient){
		this.codeClient = codeClient;
	}

	public void supprimer() {
		System.out.println(client);
		try {
			//Archivage client
			client.setArchive(true);
			climger.updateClient(client);
			//Archivage animaux du client
			List<Animal> listAnim =animger.getAnimalByClient(client.getCodeClient());
			for (Animal animal : listAnim){
				animal.setArchive(true);
				animger.updateAnimal(animal);
			}
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		codeClient = 0;
		refresh();
		MainFrameController.get().gestionClient();
	}
	public void ajouter(){
		AjouterClientController.get().startFrame();
	}

	public void modifierAnimal() {
		int selectedRow = ecrClient.getTableAnimal().getSelectedRow();
		Animal a= listAnimal.get(selectedRow);
		System.out.println("modif");
		EcranAnimauxController.get().setNomClient(client);
		EcranAnimauxController.get().setAnimal(a);
		EcranAnimauxController.get().startFrame();
	}

	public void ajouterAnimal() {
		EcranAnimauxController.get().setNomClient(client);
		Animal a = new Animal();
		EcranAnimauxController.get().setAnimal(a);
		EcranAnimauxController.get().startFrame();
	}
}
