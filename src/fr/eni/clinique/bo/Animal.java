package fr.eni.clinique.bo;

public class Animal {

	private Integer codeAnimal, codeClient;
	private String nomAnimal, couleur, race, espece, tatouage, antecedents;
	private char sexe;
	private boolean archive;
	
	public Animal(Integer codeAnimal, String nomAnimal, char sexe, String couleur, String race, 
				  String espece, Integer codeClient, String tatouage, String antecedents, boolean archive) {
		super();
		this.codeAnimal = codeAnimal;
		this.nomAnimal = nomAnimal;
		this.sexe = sexe;
		this.couleur = couleur;
		this.race = race;
		this.espece = espece;
		this.codeClient = codeClient;
		this.tatouage = tatouage;
		this.antecedents = antecedents;
		this.archive = archive;
	}
	
	public Animal(String nomAnimal, char sexe, String couleur, String race, 
				  String espece, Integer codeClient, String tatouage, String antecedents, boolean archive) {
		super();
		this.nomAnimal = nomAnimal;
		this.sexe = sexe;
		this.couleur = couleur;
		this.race = race;
		this.espece = espece;
		this.codeClient = codeClient;
		this.tatouage = tatouage;
		this.antecedents = antecedents;
		this.archive = archive;
	}
	
	public Integer getCodeAnimal() { return codeAnimal; }
	public void setCodeAnimal(Integer codeAnimal) { this.codeAnimal = codeAnimal; }
	
	public Integer getCodeClient() { return codeClient; }
	public void setCodeClient(Integer codeClient) { this.codeClient = codeClient; }
	
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
	
	public char getSexe() { return sexe; }
	public void setSexe(char sexe) { this.sexe = sexe; }
	
	public boolean isArchive() { return archive; }
	public void setArchive(boolean archive) { this.archive = archive; }
	
	@Override
	public String toString() {
		return "Animal [sexe=" + sexe + ", codeAnimal=" + codeAnimal + ", codeClient=" + codeClient + ", archive="
				+ archive + ", nomAnimal=" + nomAnimal + ", couleur=" + couleur + ", race=" + race + ", espece="
				+ espece + ", tatouage=" + tatouage + ", antecedents=" + antecedents + "]";
	}

}