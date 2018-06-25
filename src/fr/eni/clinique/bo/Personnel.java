package fr.eni.clinique.bo;

public class Personnel {

	private Integer codePers;
	private String nom;
	private String motPasse;
	private String role;
	private Boolean archive;
	
	
	
	public Personnel(){
		
	}
	
	public Personnel(Integer codePers, String nom, String motPasse, String role, Boolean archive) {
		super();
		this.codePers = codePers;
		this.nom = nom;
		this.motPasse = motPasse;
		this.role = role;
		this.archive = archive;
	}
	
	
	@Override
	public String toString() {
		return "Personnel [codePers=" + codePers + ", nom=" + nom + ", motPasse=" + motPasse + ", role=" + role
				+ ", archive=" + archive + "]";
	}

	public Integer getCodePers() {
		return codePers;
	}
	public void setCodePers(Integer codePers) {
		this.codePers = codePers;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	
	
}
