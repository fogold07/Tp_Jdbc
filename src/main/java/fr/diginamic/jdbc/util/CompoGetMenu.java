package fr.diginamic.jdbc.util;

import java.util.Scanner;

import fr.diginamic.jdbc.service.impl.ArticleServiceImpl;
import fr.diginamic.jdbc.service.impl.BonServiceImpl;
import fr.diginamic.jdbc.service.impl.CompoServiceImpl;

/** Classe qui exécute les actions sur la table Compo en fonction de la saisie de l'utilisateur en console.
 * @author Christian I
 *
 */

public class CompoGetMenu {
	private static ArticleServiceImpl articleSelection = new ArticleServiceImpl();
	private static BonServiceImpl bonSelection = new BonServiceImpl();
	private static CompoServiceImpl compoSelection = new CompoServiceImpl();
	
	public static void traiterCompo(int sousMenu) {
		String paramStr1;
		int paramInt1;
		int paramInt2 = 0;
		
		Scanner scanner = new Scanner(System.in);
		
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
			
		// suppression
		case 2:
			compoSelection.recupererCompos();
			System.out.println("Saisir l'id de la compo à supprimer : ");
			paramInt1 = Integer.parseInt(scanner.nextLine());
			compoSelection.supprimerCompo(paramInt1);
			break;
		
		// visualisation
		case 3:
			compoSelection.recupererCompos();
			break;
		default:
			System.out.println("Erreur de saisie !");
			break;
		}
		

	}

}
