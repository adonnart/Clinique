package fr.eni.clinique.ihm.client;


public class EcranClientController {
	private static EcranClientController instance;
	EcranClient ecrClient;
	

	public static synchronized EcranClientController get() {
		if (instance == null) {
			instance = new EcranClientController();
		}
		return instance;
	}

	public EcranClientController() {

	}
	public EcranClient startFrame() {
		ecrClient = new EcranClient();
		ecrClient.setVisible(true);
		return ecrClient;
	}
}
