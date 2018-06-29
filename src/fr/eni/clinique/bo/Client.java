package fr.eni.clinique.bo;

import java.util.List;

public class Client {

	private Integer codeClient;
	private String nomClient, prenomClient, adresse1, adresse2;
	private String codePostal, ville, numTel, email, assurance, remarque;
	private List<Animal> listAnimal;
	private boolean archive;
	
	public Client() { }
	
	public Client(Integer codeClient,String nomClient, String prenomClient, 
				  String adresse1, String adresse2, String codePostal, String ville, 
				  String numTel, String assurance, String email, String remarque, boolean archive) {
		super();
		setCodeClient(codeClient);
		setNomClient(nomClient);
		setPrenomClient(prenomClient);
		setAdresse1(adresse1);
		setAdresse2(adresse2);
		setCodePostal(codePostal);
		setVille(ville);
		setNumTel(numTel);
		setAssurance(assurance);
		setEmail(email);
		setRemarque(remarque);
		setArchive(archive);
	}
	
	public Client(String nomClient, String prenomClient, 
				  String adresse1, String adresse2, String codePostal, String ville, 
				  String numTel, String assurance, String email, String remarque, boolean archive) {
		super();
		setNomClient(nomClient);
		setPrenomClient(prenomClient);
		setAdresse1(adresse1);
		setAdresse2(adresse2);
		setCodePostal(codePostal);
		setVille(ville);
		setNumTel(numTel);
		setAssurance(assurance);
		setEmail(email);
		setRemarque(remarque);
		setArchive(archive);
	}
	
	public Integer getCodeClient() { return codeClient; }
	public void setCodeClient(Integer codeClient) { this.codeClient = codeClient; }
	
	public String getNomClient() { return nomClient; }
	public void setNomClient(String nomClient) { this.nomClient = nomClient; }
	
	public String getPrenomClient() { return prenomClient; }
	public void setPrenomClient(String prenomClient) { this.prenomClient = prenomClient; }
	
	public String getAdresse1() { return adresse1; }
	public void setAdresse1(String adresse1) { this.adresse1 = adresse1; }
	
	public String getAdresse2() { return adresse2; }
	public void setAdresse2(String adresse2) { this.adresse2 = adresse2; }
	
	public String getCodePostal() { return codePostal; }
	public void setCodePostal(String codePostal) { this.codePostal = codePostal; }
	
	public String getVille() { return ville; }
	public void setVille(String ville) { this.ville = ville; }
	
	public String getNumTel() { return numTel; }
	public void setNumTel(String numTel) { this.numTel = numTel; }
	
	public String getAssurance() { return assurance; }
	public void setAssurance(String assurance) { this.assurance = assurance; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getRemarque() { return remarque; }
	public void setRemarque(String remarque) { this.remarque = remarque; }
	
	public boolean isArchive() { return archive; }
	public void setArchive(Boolean archive) { this.archive = archive; }
	
	public List<Animal> getListAnimal() { return listAnimal; }
	public void setListAnimal(List<Animal> listAnimal) { this.listAnimal = listAnimal; }
	
	public void addAnimal(Animal animal){ listAnimal.add(animal); }
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n[");
		sb.append("\n\t").append("CodeClient").append("\t=\t").append(codeClient);
		sb.append("\n\t").append("NomClient").append("\t=\t").append(nomClient);
		sb.append("\n\t").append("PrenomClient").append("\t=\t").append(prenomClient);
		sb.append("\n\t").append("Adresse1").append("\t=\t").append(adresse1);
		sb.append("\n\t").append("Adresse2").append("\t=\t").append(adresse2);
		sb.append("\n\t").append("CodePostal").append("\t=\t").append(codePostal);
		sb.append("\n\t").append("Ville").append("\t\t=\t").append(ville);
		sb.append("\n\t").append("NumTel").append("\t\t=\t").append(numTel);
		sb.append("\n\t").append("Assurance").append("\t=\t").append(assurance);
		sb.append("\n\t").append("Email").append("\t\t=\t").append(email);
		sb.append("\n\t").append("Remarque").append("\t=\t").append(remarque);
		sb.append("\n\t").append("Archive").append("\t\t=\t").append(archive);
		sb.append("\n\t").append("Animaux ?").append("\t=\t");
		sb.append("\n]");
		
		return sb.toString();
	}

}