package fr.eni.clinique.ihm.form;

import java.awt.Frame;
import java.util.List;

import javax.swing.JOptionPane;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelManager;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.MainFrameController;
import fr.eni.clinique.ihm.login.EcranLogin;
import fr.eni.clinique.ihm.personnel.EcranPersonnel;
import fr.eni.clinique.ihm.personnel.EcranPersonnelController;

public class FormulaireController {
	private Formulaire ecrFormulaire;
	private List<Personnel> listPersonnel;
	// Attributs
	private PersonnelManager mger;

	private static FormulaireController instance;

	public static synchronized FormulaireController get() {
		if (instance == null) {
			instance = new FormulaireController();
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

	public void ajouterPersonnel() {

		try {	
			Personnel p = new Personnel();
			p.setNom(ecrFormulaire.getTxtNom().getText());
			p.setMotPasse(ecrFormulaire.getTxtPassword().getText());
			p.setRole(ecrFormulaire.getTxtRole().getText());
			p.setArchive(false);
			for (Personnel pers :listPersonnel){
				if (p.getNom().equalsIgnoreCase(pers.getNom())){
					JOptionPane.showMessageDialog(ecrFormulaire, "Ce personnel existe déjà", "", JOptionPane.ERROR_MESSAGE);
					mger.addPersonnel(p);
					ecrFormulaire.dispose();
					refreshtabPersonnel();
				}
			}			
			mger.addPersonnel(p);
			ecrFormulaire.dispose();
			refreshtabPersonnel();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	public void refreshtabPersonnel(){
		EcranPersonnelController.get().refresh();
		MainFrameController.get().gestionPersonnel();	
	}
}
