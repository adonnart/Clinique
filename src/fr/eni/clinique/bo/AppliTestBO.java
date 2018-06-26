package fr.eni.clinique.bo;

import java.util.Date;

public class AppliTestBO {

	public static void main(String[] args) {
	
		Animal unAnimal = new Animal('M', 1, 1, true, "testnomanimal", 
				   "Blanc", "chien", "Chien", "Non", "Aucun");
		
		Client unClient = new Client(1, "nomtest", "prenomtest", "15 rue de ", "15 rue de ",
				"35000", "Rennes", "054215612", "Oui", "test@test.com", "remarque",
				true);
		unClient.addAnimal(unAnimal);
				
		System.out.println(unClient);
		System.out.println(unAnimal);
		
		Personnel unPersonnel = new Personnel(1,"PersonnelNom","PersonnelMotPasse","Rol",true);
		System.out.println(unPersonnel);
		
		Agenda unAgenda = new Agenda(1,1,new Date());
		Agenda unAgenda2 = new Agenda(unPersonnel,unAnimal,new Date());
		System.out.println(unAgenda);
		System.out.println(unAgenda2);
		System.out.println(unAgenda2.getCodeVeto());
		unAgenda2.getCodeVeto();
		
	}

}
