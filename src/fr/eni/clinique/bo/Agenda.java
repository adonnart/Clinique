package fr.eni.clinique.bo;

import java.util.Date;

public class Agenda {

	private Personnel p;
	private Animal a;
	private long codeVeto, codeAnimal;
	private Date dateRdv; // 00 - 15 - 30 - 45 ?

	public Agenda(Personnel p, Animal a, Date dateRdv) {
		super();
		this.codeVeto = p.getCodePers();
		this.codeAnimal = a.getCodeAnimal();
		this.dateRdv = dateRdv;
	}

	public Agenda(long codeV, long codeA, Date dateRdv) {
		super();
		this.codeVeto = codeV;
		this.codeAnimal = codeA;
		this.dateRdv = dateRdv;
	}

	public Personnel getPersonnel() { return p; }
	public void setPersonnel(Personnel p) { this.p = p; }

	public Animal getAnimal() { return a; }
	public void setAnimal(Animal a) { this.a = a; }

	public long getCodeVeto() { return codeVeto; }
	public void setCodeVeto(long codeVeto) { this.codeVeto = codeVeto; }

	public long getCodeAnimal() { return codeAnimal; }
	public void setCodeAnimal(long codeAnimal) { this.codeAnimal = codeAnimal; }

	public Date getDateRdv() { return dateRdv; }
	public void setDateRdv(Date dateRdv) { this.dateRdv = dateRdv; }

	@Override
	public String toString() {
		return "Agenda [p=" + p + ", a=" + a + ", codeVeto=" + codeVeto + ", codeAnimal=" + codeAnimal + ", dateRdv="
				+ dateRdv + "]";
	}

}