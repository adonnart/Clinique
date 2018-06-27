package fr.eni.clinique.bll;

import fr.eni.clinique.bo.Personnel;

public class AppliTestBLL {

	public static void main(String[] args) {
			//Instanciation du jeu d'essai 
			Personnel unPersonnel = new Personnel("nouveauNom","nouveauPw","Rol",true);
			Personnel unPersonnel2 = new Personnel("PersNom","mdp","Rol",true);
			Personnel unPersonnel3 = new Personnel("PersonnelNom","PersonnelPw","Rol",true);

			LoginManager mger;
			try {
				mger = LoginManager.getInstance();
				System.out.println(mger.checkConnexion(unPersonnel));
				System.out.println(mger.checkConnexion(unPersonnel2));
				System.out.println(mger.checkConnexion(unPersonnel3));
				

			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
	}
}
