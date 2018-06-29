package fr.eni.clinique.bo;

public class Personnel {

	private Integer codePers;
	private String nom, motPasse, role;
	private boolean archive;
	
	public Personnel() { }
	
	public Personnel(Integer codePers,String nom, String motPasse, String role, boolean archive) {
		setCodePers(codePers);
		setNom(nom);
		setMotPasse(motPasse);
		setRole(role);
		setArchive(archive);
	}
	
	public Personnel(String nom, String motPasse, String role, boolean archive) {
		setNom(nom);
		setMotPasse(motPasse);
		setRole(role);
		setArchive(archive);
	}
	
	public Integer getCodePers() { return codePers; }
	public void setCodePers(Integer codePers) { this.codePers = codePers; }
	
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	
	public String getMotPasse() { return motPasse; }
	public void setMotPasse(String motPasse) { this.motPasse = motPasse; }
	
	public String getRole() { return role; }
	public void setRole(String role) { this.role = role.toUpperCase(); }
	
	public boolean isArchive() { return archive; }
	public void setArchive(Boolean archive) { this.archive = archive; }
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n[");
		sb.append("\n\t").append("CodePers").append("\t=\t").append(codePers);
		sb.append("\n\t").append("Nom").append("\t\t=\t").append(nom);
		sb.append("\n\t").append("MotPasse").append("\t=\t").append(motPasse);
		sb.append("\n\t").append("Role").append("\t\t=\t").append(role);
		sb.append("\n\t").append("Archive").append("\t\t=\t").append(archive);
		sb.append("\n]");
		
		return sb.toString();
	}

}