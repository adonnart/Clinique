package fr.eni.clinique.bo;

import java.util.Date;

public class AppliTestBO {

	public static void main(String[] args) {
		
		Animal unAnimal = new Animal("testnomanimal", 'M', "Blanc", "dalmat", "Chien", 1, "Non", "Aucun", true);
		
		Client unClient = new Client("nomtest", "prenomtest", "15 rue de ", "15 rue de ", "35000", "Rennes", 
				"054215612", "Oui", "test@test.com", "remarque", true);
		
		unClient.addAnimal(unAnimal);
		
		System.out.println(unClient);
		System.out.println(unAnimal);
		
		Personnel unPersonnel = new Personnel("PersonnelNom", "PersonnelMotPasse", "vet", true);
		
		System.out.println(unPersonnel);
		
		Agenda unAgenda = new Agenda(1, 1, new Date());
		Agenda unAgenda2 = new Agenda(unPersonnel, unAnimal, new Date());
		System.out.println(unAgenda);
		System.out.println(unAgenda2);
		System.out.println(unAgenda2.getCodeVeto());
		unAgenda2.getCodeVeto();
		
	}

}