package fr.eni.clinique.ihm.rendezvous;

public class EcranRendezVousController {

	private EcranRendezVous ecranRdv;
	
	private static EcranRendezVousController instance;

	public static synchronized EcranRendezVousController get() {
		if (instance == null) {
			instance = new EcranRendezVousController();
		}
		return instance;
	}
	public EcranRendezVousController(){
		
	}
	public EcranRendezVous startFrame() {
		ecranRdv = new EcranRendezVous();
		ecranRdv.setVisible(true);
		return ecranRdv;
	}

}