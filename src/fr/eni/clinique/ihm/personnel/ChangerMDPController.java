package fr.eni.clinique.ihm.personnel;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelManager;

public class ChangerMDPController {

	private static ChangerMDPController instance;

	ChangerMDP ecrChangerMDP;
	PersonnelManager mger;
	public static synchronized ChangerMDPController get() {
		if (instance == null) {
			instance = new ChangerMDPController();
		}
		return instance;
	}

	public ChangerMDPController() {

		try {
			mger = PersonnelManager.getInstance();	
			
		} catch (fr.eni.clinique.bll.BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ChangerMDP openChangerMDP() {
		ecrChangerMDP = new ChangerMDP();
		ecrChangerMDP.setVisible(true);
		return ecrChangerMDP;
	}
	public String nouveauMDP(){	
		return ecrChangerMDP.getTxtMDP().getText();
		}
	
}
