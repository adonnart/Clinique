package fr.eni.clinique.ihm;

import java.util.List;

import fr.eni.clinique.bll.PersonnelManager;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.personnel.EcranPersonnel;
import fr.eni.clinique.ihm.personnel.EcranPersonnelController;
import fr.eni.clinique.ihm.rendezvous.EcranRendezVousController;

public class MainFrameController {
		private EcranPersonnel ecrPersonnel;
		private MainFrame ecrMain;
		private List<Personnel> listPersonnel;
		private PersonnelManager mger;
		private static MainFrameController instance;

		public static synchronized MainFrameController get() {
			if (instance == null) {
				instance = new MainFrameController();
			}
			return instance;
		}

		public MainFrameController() {

		}
		public MainFrame openMainFrame() {
			ecrMain = new MainFrame();
			ecrMain.setVisible(true);
			return ecrMain;
		}
		
		public void gestionRdv(){
			ecrMain.getDesktopPane().removeAll();
			ecrMain.getDesktopPane().add(EcranRendezVousController.get().startFrame());
		}
		
		public void agenda(){
			
		}
		public void gestionPersonnel(){
			ecrMain.getDesktopPane().removeAll();
			ecrMain.getDesktopPane().add(EcranPersonnelController.get().openEcranPersonnel());
		}
}
