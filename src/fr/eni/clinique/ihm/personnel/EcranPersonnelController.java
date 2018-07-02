package fr.eni.clinique.ihm.personnel;
import java.util.List;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelManager;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.MainFrame;
import fr.eni.clinique.ihm.MainFrameController;
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
		try {
			listPersonnel = mger.getAllPersonnel();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPersonnel;
	}
	
	public void refresh(){
		ecrPersonnel.dispose();	
	}
	public EcranPersonnel getEcranPersonnel() {
		return ecrPersonnel;
	}
	public void supprimer(){

		try {
		    int selectedRow = ecrPersonnel.getTablePersonnel().getSelectedRow();
		    System.out.println(selectedRow);
		    	Personnel p = listPersonnel.get(selectedRow);
		    	p.setArchive(true);
			mger.updatePersonnel(p);;
			refresh();
			MainFrameController.get().gestionPersonnel();	
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void changer(){
		int selectedRow = ecrPersonnel.getTablePersonnel().getSelectedRow();
		Personnel p = listPersonnel.get(selectedRow);
		p.setMotPasse(ChangerMDPController.get().nouveauMDP());
		try {
			mger.updatePersonnel(p);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		refresh();
		MainFrameController.get().gestionPersonnel();	
	}
}
