package fr.eni.clinique.ihm.animaux;

import fr.eni.clinique.bll.AnimalManager;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Race;
import fr.eni.clinique.ihm.MainFrameController;
import fr.eni.clinique.ihm.client.EcranClientController;


public class EcranAnimauxController {
	private static EcranAnimauxController instance;
	private EcranAnimaux ecrAnimaux;
	private AnimalManager animger;
	private Client client;
	private Race race;
	private Animal animal;
	
	public static synchronized EcranAnimauxController get() {
		if (instance == null) {
			instance = new EcranAnimauxController();
		}
		return instance;
	}

	public EcranAnimauxController() {
		try {
			animger = AnimalManager.getInstance();
			
		} catch (fr.eni.clinique.bll.BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public EcranAnimaux startFrame() {
		ecrAnimaux = new EcranAnimaux();
		loadAnimal();
		ecrAnimaux.setVisible(true);
		return ecrAnimaux;
	}
	public  void setAnimal(Animal animal){
		this.animal = animal;
	}
	public void setNomClient(Client client){
		this.client = client;
	}
	public Animal loadAnimal(){
		if (animal.getCodeAnimal() != null){
			ecrAnimaux.getTextNom().setText(animal.getNomAnimal());
			ecrAnimaux.getTextCouleur().setText(animal.getCouleur());
			ecrAnimaux.getTextTatouage().setText(animal.getTatouage());
			ecrAnimaux.getTextCodeAnimal().setText(animal.getCodeAnimal().toString());	
		}
		
		ecrAnimaux.getTextNomClient().setText(client.getNomClient());
		return animal;
	}

	public void validerModif() {
		if (animal.getCodeAnimal() != null){
			animal.setNomAnimal(ecrAnimaux.getTextNom().getText());
			animal.setCouleur(ecrAnimaux.getTextCouleur().getText());
			animal.setTatouage(ecrAnimaux.getTextTatouage().getText());
		try {
			animger.updateAnimal(animal);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			animal.setRace("Dalmatien");
			animal.setEspece("Chien");
			animal.setNomAnimal(ecrAnimaux.getTextNom().getText());
			animal.setCouleur(ecrAnimaux.getTextCouleur().getText());
			animal.setTatouage(ecrAnimaux.getTextTatouage().getText());
			animal.setCodeClient(client.getCodeClient());
			try {
				animger.addAnimal(animal);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ecrAnimaux.dispose();
		reload();
	}
	public void reload(){
		EcranClientController.get().refresh();
		EcranClientController.get().setCodeClient(client.getCodeClient());
		MainFrameController.get().gestionClient();
		EcranClientController.get().loadClient(client);
	}
}
