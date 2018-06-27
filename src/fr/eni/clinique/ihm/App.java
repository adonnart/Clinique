package fr.eni.clinique.ihm;

import javax.swing.SwingUtilities;

public class App {

	// Lancement de l'application
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				EcranLoginController.get().startApp();
			}
		});

	}
}
