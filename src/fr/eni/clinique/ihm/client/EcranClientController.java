package fr.eni.clinique.ihm.client;

import java.util.List;

import fr.eni.clinique.bll.AnimalManager;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientManager;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;

public class EcranClientController {
	private static EcranClientController instance;
	EcranClient ecrClient;
	private List<Animal> listAnimal;
	private AnimalManager mger;
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
			mger = AnimalManager.getInstance();	
			
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
			listAnimal = mger.getAnimalByClient(codeClient);
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
		client.setArchive(true);
		try {
			
			climger.updateClient(client);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void ajouter(){
		AjouterClientController.get().startFrame();
	}
}
