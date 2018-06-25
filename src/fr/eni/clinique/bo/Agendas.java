package fr.eni.clinique.bo;

import java.util.Date;

public class Agendas {

	private long codeVeto, codeAnimal;
	private Date dateRdv; // 00 - 15 - 30 - 45 ?

	public Agendas(long codeVeto, long codeAnimal, Date dateRdv) {
		super();
		this.codeVeto = codeVeto;
		this.codeAnimal = codeAnimal;
		this.dateRdv = dateRdv;
	}

	public long getCodeVeto() { return codeVeto; }
	public void setCodeVeto(long codeVeto) { this.codeVeto = codeVeto; }

	public long getCodeAnimal() { return codeAnimal; }
	public void setCodeAnimal(long codeAnimal) { this.codeAnimal = codeAnimal; }

	public Date getDateRdv() { return dateRdv; }
	public void setDateRdv(Date dateRdv) { this.dateRdv = dateRdv; }

}