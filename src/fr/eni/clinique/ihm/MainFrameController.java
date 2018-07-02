package fr.eni.clinique.ihm;

import java.util.List;

import fr.eni.clinique.bll.PersonnelManager;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.client.EcranClient;
import fr.eni.clinique.ihm.client.EcranClientController;
import fr.eni.clinique.ihm.login.EcranLoginController;
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
			Personnel p = EcranLoginController.get().getPersonnelConnected();
			//affichage du role
			String s = p.getRole();
			if (p.getRole().equalsIgnoreCase("sec"))
				s = "Secrétaire";
			else if (p.getRole().equalsIgnoreCase("adm"))
				s = "Administrateur";
			else if (p.getRole().equalsIgnoreCase("vet"))
				s = "Vétérinaire";
			ecrMain.setTitle("Connecté en tant que : "+s+"("+p.getNom()+")");
			ecrMain.setVisible(true);
			return ecrMain;
		}
		
		public void gestionRdv(){
			ecrMain.getDesktopPane().removeAll();
			ecrMain.getDesktopPane().add(EcranRendezVousController.get().startFrame());
		}
		public void gestionClient(){
			ecrMain.getDesktopPane().removeAll();
			ecrMain.getDesktopPane().add(EcranClientController.get().startFrame());	
		}
		
		public void agenda(){
			
		}
		
		public void gestionPersonnel(){
			ecrMain.getDesktopPane().removeAll();
			ecrMain.getDesktopPane().add(EcranPersonnelController.get().openEcranPersonnel());
		}
}
