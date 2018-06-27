package fr.eni.clinique.ihm;

import javax.swing.SwingUtilities;

import fr.eni.clinique.ihm.EcranLogin;

public class App {

	// Lancement de l'application
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				EcranLogin ecran = new EcranLogin();
				ecran.setVisible(true);
			}
		});

	}
}
