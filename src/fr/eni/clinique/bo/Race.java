package fr.eni.clinique.bo;

public class Races {

	private String race, espece;

	public Races(String race, String espece) {
		super();
		this.race = race;
		this.espece = espece;
	}

	public String getRace() { return race; }
	public void setRace(String race) { this.race = race; }

	public String getEspece() { return espece; }
	public void setEspece(String espece) { this.espece = espece; }

}
