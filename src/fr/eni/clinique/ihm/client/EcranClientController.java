package fr.eni.clinique.ihm.client;

import java.util.List;

import fr.eni.clinique.bll.AnimalManager;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animal;

public class EcranClientController {
	private static EcranClientController instance;
	EcranClient ecrClient;
	private List<Animal> listAnimal;
	private AnimalManager mger;

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
			listAnimal = mger.getAnimalByClient(1);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAnimal;
	}
	
}
