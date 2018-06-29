package fr.eni.clinique.bo;

import fr.eni.clinique.dal.Queries;

import java.util.Date;

public class Agenda {

	private Personnel p;
	private Animal a;
	private Integer codeVeto, codeAnimal;
	private Date dateRdv;
	
	public Agenda() { }
	
	public Agenda(Personnel p, Animal a, Date dateRdv) {
		setCodeVeto(p.getCodePers());
		setCodeAnimal(a.getCodeAnimal());
		setDateRdv(dateRdv);
	}
	
	public Agenda(Integer codeV, Integer codeA, Date dateRdv) {
		setCodeVeto(codeVeto);
		setCodeAnimal(codeAnimal);
		setDateRdv(dateRdv);
	}
	
	public Personnel getPersonnel() { return p; }
	public void setPersonnel(Personnel p) { this.p = p; }
	
	public Animal getAnimal() { return a; }
	public void setAnimal(Animal a) { this.a = a; }
	
	public Integer getCodeVeto() { return codeVeto; }
	public void setCodeVeto(Integer codeVeto) { this.codeVeto = codeVeto; }
	
	public Integer getCodeAnimal() { return codeAnimal; }
	public void setCodeAnimal(Integer codeAnimal) { this.codeAnimal = codeAnimal; }
	
	public Date getDateRdv() { return dateRdv; }
	public void setDateRdv(Date dateRdv) { this.dateRdv = dateRdv; }
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n[");
		sb.append("\n\t").append("CodeVeto").append("\t=\t").append(codeVeto);
		sb.append("\n\t").append("CodeAnimal").append("\t=\t").append(codeAnimal);
		sb.append("\n\t").append("DateRdv").append("\t\t=\t").append(Queries.convertDate(dateRdv));
		sb.append("\n]");
		
		return sb.toString();
	}

}