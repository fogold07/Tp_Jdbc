package fr.diginamic.jdbc.util;

import java.util.Scanner;

import fr.diginamic.jdbc.service.ArticleService;
import fr.diginamic.jdbc.service.FournisseurService;
import fr.diginamic.jdbc.service.impl.ArticleServiceImpl;
import fr.diginamic.jdbc.service.impl.FournisseurServiceImpl;

/** Classe qui exécute les actions sur la table Article en fonction de la saisie de l'utilisateur en console.
 * @author Christian I
 *
 */
public class ArticleGetMenu {

	private static FournisseurService fournisseurSelection = new FournisseurServiceImpl();
	private static ArticleService articleSelection = new ArticleServiceImpl();
	
	public static void traiterArticle(int sousMenu) {
		String paramStr1;
		String paramStr2;
		int paramInt1;
		
		double paramDbl = 0.0d;

		Scanner scanner = new Scanner(System.in);
		switch (sousMenu) {
		// création
		case 1:
			System.out.println("Saisir REF (alphanumérique): ");
			paramStr1 = scanner.nextLine();

			System.out.println("Saisir Désignation: ");
			paramStr2 = scanner.nextLine();

			System.out.println("Saisir Prix ");
			paramDbl = Double.parseDouble(scanner.nextLine());

			System.out.println("Saisir id_fournisseur parmis la liste:");
			fournisseurSelection.recupererFournisseurs();
			paramInt1 = Integer.parseInt(scanner.nextLine());

			articleSelection.creerArticle(paramStr1, paramStr2, paramDbl, paramInt1);
			break;

		// modification
		case 2:

			System.out.println("Saisir REF de l'article à mettre à jour : ");
			articleSelection.recupererArticles(sousMenu);
			paramStr1 = scanner.nextLine();
			System.out.println("Saisir nouvelle Désignation: ");
			paramStr2 = scanner.nextLine();

			System.out.println("Saisir nouveau Prix ");
			paramDbl = Double.parseDouble(scanner.nextLine());

			System.out.println("Saisir nouvel id_fournisseur parmis la liste:");
			fournisseurSelection.recupererFournisseurs();
			paramInt1 = Integer.parseInt(scanner.nextLine());

			articleSelection.updateArticle(paramStr1, paramStr2, paramDbl, paramInt1);
			break;

		// Suppression
		case 3:
			System.out.println("Saisir à partir de la liste ci-dessous, la ref de l'article à supprimer");
			articleSelection.recupererArticles(sousMenu);
			paramStr1 = scanner.nextLine();
			articleSelection.supprimerArticle(paramStr1);
			break;
		// Liste complète
		case 4:
			articleSelection.recupererArticles(sousMenu);
			break;
		// Visualisation élément
		case 5:
			System.out.println("Saisir la ref à visualiser: ");
			articleSelection.recupererArticles(sousMenu);
			paramStr1 = scanner.nextLine();
			articleSelection.visualiser(paramStr1);
			break;
		default:
			System.out.println("Erreur de saisie !");
			break;
		}


	}
	
}
