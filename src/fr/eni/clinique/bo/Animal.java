package fr.eni.clinique.bo;

public class Animal {

	private Integer codeAnimal, codeClient;
	private String nomAnimal, couleur, race, espece, tatouage, antecedents;
	private char sexe;
	private boolean archive;
	
	public Animal() { }
	
	public Animal(Integer codeAnimal, String nomAnimal, char sexe, String couleur, String race, 
				  String espece, Integer codeClient, String tatouage, String antecedents, boolean archive) {
		super();
		setCodeAnimal(codeAnimal);
		setNomAnimal(nomAnimal);
		setSexe(sexe);
		setCouleur(couleur);
		setRace(race);
		setEspece(espece);
		setCodeClient(codeClient);
		setTatouage(tatouage);
		setAntecedents(antecedents);
		setArchive(archive);
	}
	
	public Animal(String nomAnimal, char sexe, String couleur, String race, 
				  String espece, Integer codeClient, String tatouage, String antecedents, boolean archive) {
		super();
		setNomAnimal(nomAnimal);
		setSexe(sexe);
		setCouleur(couleur);
		setRace(race);
		setEspece(espece);
		setCodeClient(codeClient);
		setTatouage(tatouage);
		setAntecedents(antecedents);
		setArchive(archive);
	}
	
	public Integer getCodeAnimal() { return codeAnimal; }
	public void setCodeAnimal(Integer codeAnimal) { this.codeAnimal = codeAnimal; }
	
	public String getNomAnimal() { return nomAnimal; }
	public void setNomAnimal(String nomAnimal) { this.nomAnimal = nomAnimal; }

	public char getSexe() { return sexe; }
	public void setSexe(char sexe) { this.sexe = sexe; }
	
	public String getCouleur() { return couleur; }
	public void setCouleur(String couleur) { this.couleur = couleur; }
	
	public String getRace() { return race; }
	public void setRace(String race) { this.race = race; }
	
	public String getEspece() { return espece; }
	public void setEspece(String espece) { this.espece = espece; }
	
	public Integer getCodeClient() { return codeClient; }
	public void setCodeClient(Integer codeClient) { this.codeClient = codeClient; }
	
	public String getTatouage() { return tatouage; }
	public void setTatouage(String tatouage) { this.tatouage = tatouage; }
	
	public String getAntecedents() { return antecedents; }
	public void setAntecedents(String antecedents) { this.antecedents = antecedents; }
	
	public boolean isArchive() { return archive; }
	public void setArchive(boolean archive) { this.archive = archive; }
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n[");
		sb.append("\n\t").append("CodeAnimal").append("\t=\t").append(codeAnimal);
		sb.append("\n\t").append("NomAnimal").append("\t=\t").append(nomAnimal);
		sb.append("\n\t").append("Sexe").append("\t\t=\t").append(sexe);
		sb.append("\n\t").append("Couleur").append("\t\t=\t").append(couleur);
		sb.append("\n\t").append("Race").append("\t\t=\t").append(race);
		sb.append("\n\t").append("Espece").append("\t\t=\t").append(espece);
		sb.append("\n\t").append("CodeClient").append("\t=\t").append(codeClient);
		sb.append("\n\t").append("Tatouage").append("\t=\t").append(tatouage);
		sb.append("\n\t").append("Antecedents").append("\t=\t").append(antecedents);
		sb.append("\n\t").append("Archive").append("\t\t=\t").append(archive);
		sb.append("\n]");
		
		return sb.toString();
	}

}