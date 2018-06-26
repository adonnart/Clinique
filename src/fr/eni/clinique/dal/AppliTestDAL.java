package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.jdbc.ClientDAO;

public class AppliTestDAL {

	public static void main(String[] args) {

		//Déclaration et instanciation de la DAO
		ClientDAO clientDAO = DAOFactory.getClientDAO();

		//Instanciation du jeu d'essai 
		Client unClient1 = new Client("nomtest1", "prenomtest1", "adsfsdf", "adresse2",
				"35000", "Rennes", "054215612", "Oui", "test@test.com", "remarque",
				true);
		Client unClient2 = new Client("nomtest2", "prenomtest2", "15 rue de ", "15 rue de ",
				"35000", "Rennes", "054215612", "Oui", "test@test.com", "remarque",
				true);
		Client unClient3 = new Client( "nomtest3", "prenomtest3","15 rue de ", "15 rue de ",
				"35000", "Rennes", "054215612", "Oui", "test@test.com", "remarque",
				true);

		System.out.println("Ajout des articles... ");

			try {
			clientDAO.insert(unClient1);
			System.out.println("Article ajouté  : " + unClient1.toString() );
			clientDAO.insert(unClient2);
			System.out.println("Article ajouté  : " + unClient2.toString() );
			clientDAO.insert(unClient3);
			System.out.println("Article ajouté  : " + unClient3.toString() );

//			//Sélection de l'article par id
//			Client a = clientDAO.selectById(unClient1.getCodeClient());
//			System.out.println("Sélection de l'article par id  : " + a.toString() );
//
//			//Sélection de tous les articles
//			List<Client> articles = clientDAO.selectAll();
//			System.out.println("Sélection de tous les articles  : " + articles.toString() );
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	} 

}
//
//			//Modification d'un article
//			System.out.println("Modification d'un article  : " );
//			System.out.println("Article avant modification : "  + a1.toString());
//			((Stylo) a1).setCouleur("noir");
//			((Stylo) a1).setDesignation("Bic bille noir");
//			((Stylo) a1).setReference("BBNoir");
//			articleDAO.update(a1);
//			System.out.println("Article après modification  : " + a1.toString() );
//			
//			
//			//Suppression d'un article
//			System.out.println("Suppression de l'article  : " + a1.toString());
//			articleDAO.delete(a1.getIdArticle());
//			articles = articleDAO.selectAll();
//			System.out.println("Liste des articles après suppression : "  );
//			StringBuffer sb = new StringBuffer();
//			for(Article art: articles){
//				if(art instanceof Stylo){
//					sb.append("Stylo   [id=");
//				}else{
//					sb.append("Ramette [id=");
//				}
//				sb.append(art.getIdArticle());
//				sb.append(", ref=");
//				sb.append(art.getReference()).append("]\n");
//			}
//			System.out.println(sb.toString());
//			System.out.println("---------------------------------------------------------------");
//
//			
//		} catch (DALException e) {
//			e.printStackTrace();
//		}


