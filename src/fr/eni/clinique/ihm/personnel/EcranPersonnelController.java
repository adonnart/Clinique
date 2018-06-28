package fr.eni.clinique.ihm.personnel;


public class EcranPersonnelController {
	private EcranPersonnel ecrClient;

	public EcranPersonnel startFrame() {
		ecrClient = new EcranPersonnel();
		ecrClient.setVisible(true);
		return ecrClient;
	}
}
