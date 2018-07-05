package fr.eni.clinique.ihm;


import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.client.EcranClientController;
import fr.eni.clinique.ihm.login.EcranLoginController;
import fr.eni.clinique.ihm.personnel.EcranPersonnelController;
import fr.eni.clinique.ihm.rendezvous.EcranRendezVousController;

public class MainFrameController {
		private MainFrame ecrMain;
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
			menuGestion();
			return ecrMain;
		}
		
		public void menuGestion(){
			Personnel p = EcranLoginController.get().getPersonnelConnected();
			//affichage du role
			String s = p.getRole();
			if (p.getRole().equalsIgnoreCase("sec")){
				ecrMain.getMenuGestionRdv().setVisible(true);
				ecrMain.getmenuGestionPersonnel().setVisible(false);
				ecrMain.getMenuAgenda().setVisible(false);
				s = "Secrétaire";
			}
			else if (p.getRole().equalsIgnoreCase("adm")){
				ecrMain.getMenuGestionRdv().setVisible(true);
				ecrMain.getmenuGestionPersonnel().setVisible(true);
				ecrMain.getMenuAgenda().setVisible(true);
				s = "Administrateur";
			}
			else if (p.getRole().equalsIgnoreCase("vet")){
				ecrMain.getMenuGestionRdv().setVisible(false);
				ecrMain.getmenuGestionPersonnel().setVisible(true);
				ecrMain.getMenuAgenda().setVisible(false);
				s = "Vétérinaire";
				}
			ecrMain.setTitle("Connecté en tant que : "+s+"("+p.getNom()+")");
			ecrMain.setVisible(true);
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
