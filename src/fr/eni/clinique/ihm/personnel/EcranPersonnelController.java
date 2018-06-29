package fr.eni.clinique.ihm.personnel;
import java.util.List;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelManager;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.MainFrame;
import fr.eni.clinique.ihm.form.Formulaire;

public class EcranPersonnelController {
	private EcranPersonnel ecrPersonnel;
	private MainFrame ecrMain;
	private List<Personnel> listPersonnel;
	// Attributs
	private PersonnelManager mger;

	private static EcranPersonnelController instance;

	public static synchronized EcranPersonnelController get() {
		if (instance == null) {
			instance = new EcranPersonnelController();
		}
		return instance;
	}

	public EcranPersonnelController() {

		try {
			mger = PersonnelManager.getInstance();	
			listPersonnel = mger.getAllPersonnel();
		} catch (fr.eni.clinique.bll.BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public EcranPersonnel openEcranPersonnel() {
		ecrPersonnel = new EcranPersonnel();
		ecrPersonnel.setVisible(true);
		return ecrPersonnel;
	}
	
	public List<Personnel> getListPersonnel() {
		return listPersonnel;
	}
	
	public void refresh(){
			
	}
	public EcranPersonnel getEcranPersonnel() {
		return ecrPersonnel;
	}
}
