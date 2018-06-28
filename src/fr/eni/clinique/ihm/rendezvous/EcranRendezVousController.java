package fr.eni.clinique.ihm.rendezvous;

public class EcranRendezVousController {

	private EcranRendezVous ecranRdv;
	
	public EcranRendezVous startFrame() {
		ecranRdv = new EcranRendezVous();
		ecranRdv.setVisible(true);
		return ecranRdv;
	}

}