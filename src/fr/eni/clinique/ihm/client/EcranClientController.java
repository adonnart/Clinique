package fr.eni.clinique.ihm.client;


public class EcranClientController {
	private EcranClient ecrClient;

	public EcranClient startFrame() {
		ecrClient = new EcranClient();
		ecrClient.setVisible(true);
		return ecrClient;
	}
}
