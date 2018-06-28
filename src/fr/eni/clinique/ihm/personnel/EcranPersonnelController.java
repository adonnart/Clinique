package fr.eni.clinique.ihm.personnel;
import fr.eni.clinique.bll.PersonnelManager;
import fr.eni.clinique.ihm.MainFrame;

public class EcranPersonnelController {
	private EcranPersonnel ecrPersonnel;
	private MainFrame ecrMain;
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

}
