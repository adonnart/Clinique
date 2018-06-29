package fr.eni.clinique.ihm.form;

import java.util.List;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelManager;
import fr.eni.clinique.bo.Personnel;

import fr.eni.clinique.ihm.personnel.EcranPersonnelController;

public class FormulaireController {
	private Formulaire ecrFormulaire;
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

	public FormulaireController() {

		try {
			mger = PersonnelManager.getInstance();	
			listPersonnel = mger.getAllPersonnel();
		} catch (fr.eni.clinique.bll.BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Formulaire openFormulaire() {
		ecrFormulaire = new Formulaire();
		ecrFormulaire.setVisible(true);
		return ecrFormulaire;
	}
	
	public List<Personnel> getListPersonnel() {
		return listPersonnel;
	}

	public void AjouterPersonnel() {
		Personnel p = new Personnel();
		p.setNom(ecrFormulaire.getTxtNom().getText());
		p.setMotPasse(ecrFormulaire.getTxtPassword().getText());
		p.setRole(ecrFormulaire.getTxtRole().getText());
		try {
			mger.addPersonnel(p);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
