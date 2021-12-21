package fr.diginamic.jdbc.util;

import java.util.Scanner;

import fr.diginamic.jdbc.service.ArticleService;
import fr.diginamic.jdbc.service.BonService;
import fr.diginamic.jdbc.service.CompoService;
import fr.diginamic.jdbc.service.impl.ArticleServiceImpl;
import fr.diginamic.jdbc.service.impl.BonServiceImpl;
import fr.diginamic.jdbc.service.impl.CompoServiceImpl;

/** Classe qui exécute les actions sur la table Compo en fonction de la saisie de l'utilisateur en console.
 * @author Christian I
 *
 */

public class CompoGetMenu {
	private static ArticleService articleSelection = new ArticleServiceImpl();
	private static BonService bonSelection = new BonServiceImpl();
	private static CompoService compoSelection = new CompoServiceImpl();
	
	public static void traiterCompo(int sousMenu) {
		String paramStr1;
		int paramInt1;
		int paramInt2;
		int paramInt3;
		int paramInt4;
		
		
		Scanner scanner = new Scanner(System.in);
		//1 = Créer, 2 = Modifier, 3 = Supprimer, 4 = Liste complète
		switch (sousMenu) {
		// création
		case 1:
			System.out.println("Saisir l'article (REF): ");
			articleSelection.recupererArticles(5);
			paramStr1 = scanner.nextLine();
			System.out.println("Saisir le numéro de bon: ");
			bonSelection.recupererBons(5);
			paramInt1 = Integer.parseInt(scanner.nextLine());
			System.out.println("Saisir la qté: ");
			paramInt2 = Integer.parseInt(scanner.nextLine());
			compoSelection.creerCompo(paramStr1, paramInt1, paramInt2);
			break;
		
		case 2:
			compoSelection.recupererCompos();
			System.out.println("Saisir l'id_compo à modifier : ");
			paramInt1 = Integer.parseInt(scanner.nextLine());
			System.out.println("Saisir le nouvel id_article: ");
			paramInt2 = Integer.parseInt(scanner.nextLine());
			System.out.println("Saisir le nouvel id_bon: ");
			paramInt3 = Integer.parseInt(scanner.nextLine());
			System.out.println("Saisir la nouvelle qté: ");
			paramInt4 = Integer.parseInt(scanner.nextLine());
			compoSelection.updateCompo(paramInt1, paramInt2, paramInt3, paramInt4);
			break;
			
		// suppression
		case 3:
			compoSelection.recupererCompos();
			System.out.println("Saisir l'id de la compo à supprimer : ");
			paramInt1 = Integer.parseInt(scanner.nextLine());
			compoSelection.supprimerCompo(paramInt1);
			break;
			
		// visualisation
		case 4:
			compoSelection.recupererCompos();
			break;
		default:
			System.out.println("Erreur de saisie !");
			break;
		}
		

	}

}
