package fr.eni.clinique.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginManager;
import fr.eni.clinique.bo.Personnel;

public class EcranLoginController implements ILoginObserver {

	private EcranLogin ecrLogin;
	// Attributs
	private LoginManager mger;

	private static EcranLoginController instance;

	public static synchronized EcranLoginController get() {
		if (instance == null) {
			instance = new EcranLoginController();
		}
		return instance;
	}

	public EcranLoginController() {

		try {
			mger = LoginManager.getInstance();
		} catch (fr.eni.clinique.bll.BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void startApp() {
		ecrLogin = new EcranLogin();
		ecrLogin.setVisible(true);

	}

	@Override
	public void valider() {
		System.out.println("test valider");
		Personnel p = new Personnel();
		p.setNom(ecrLogin.getTxtNom().getText());	
		p.setMotPasse(new String(ecrLogin.getPassField().getPassword()));
		System.out.println(new String(ecrLogin.getPassField().getPassword()));
		try {
			
			if (mger.checkConnexion(p).equalsIgnoreCase("false")) {
				ecrLogin.msgErreur("Login ERROR");
			}
			if(mger.checkConnexion(p).equals("sec")){
				JOptionPane.showMessageDialog(ecrLogin,"Login Secretaire","Connexion",JOptionPane.PLAIN_MESSAGE);
			}
			if(mger.checkConnexion(p).equals("vet")){
				JOptionPane.showMessageDialog(ecrLogin,"Login Veterinaire","Connexion",JOptionPane.PLAIN_MESSAGE);
			}
			if(mger.checkConnexion(p).equals("adm")){
				JOptionPane.showMessageDialog(ecrLogin,"Login Administrateur","Connexion",JOptionPane.PLAIN_MESSAGE);
			}
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
