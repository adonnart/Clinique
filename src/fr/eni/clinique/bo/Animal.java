package fr.eni.clinique.bo;

public class Animal {

	private char sexe;
	private int codeAnimal;
	private long codeClient;
	private boolean archive;
	private String nomAnimal, couleur, race, espece, tatouage, antecedents;

	public Animal(char sexe, int codeAnimal, long codeClient, boolean archive, String nomAnimal, 
				   String couleur, String race, String espece, String tatouage, String antecedents) {
		super();
		this.sexe = sexe;
		this.codeAnimal = codeAnimal;
		this.codeClient = codeClient;
		this.archive = archive;
		this.nomAnimal = nomAnimal;
		this.couleur = couleur;
		this.race = race;
		this.espece = espece;
		this.tatouage = tatouage;
		this.antecedents = antecedents;
	}

	public char getSexe() { return sexe; }
	public void setSexe(char sexe) { this.sexe = sexe; }

	public int getCodeAnimal() { return codeAnimal; }
	public void setCodeAnimal(int codeAnimal) { this.codeAnimal = codeAnimal; }

	public long getCodeClient() { return codeClient; }
	public void setCodeClient(long codeClient) { this.codeClient = codeClient; }

	public boolean isArchive() { return archive; }
	public void setArchive(boolean archive) { this.archive = archive; }

	public String getNomAnimal() { return nomAnimal; }
	public void setNomAnimal(String nomAnimal) { this.nomAnimal = nomAnimal; }

	public String getCouleur() { return couleur; }
	public void setCouleur(String couleur) { this.couleur = couleur; }

	public String getRace() { return race; }
	public void setRace(String race) { this.race = race; }

	public String getEspece() { return espece; }
	public void setEspece(String espece) { this.espece = espece; }

	public String getTatouage() { return tatouage; }
	public void setTatouage(String tatouage) { this.tatouage = tatouage; }

	public String getAntecedents() { return antecedents; }
	public void setAntecedents(String antecedents) { this.antecedents = antecedents; }

	@Override
	public String toString() {
		return "Animal [sexe=" + sexe + ", codeAnimal=" + codeAnimal + ", codeClient=" + codeClient + ", archive="
				+ archive + ", nomAnimal=" + nomAnimal + ", couleur=" + couleur + ", race=" + race + ", espece="
				+ espece + ", tatouage=" + tatouage + ", antecedents=" + antecedents + "]";
	}

}