package fr.diginamic.jdbc.util;

import java.util.Scanner;

import fr.diginamic.jdbc.service.impl.FournisseurServiceImpl;

/** Classe qui exécute les actions sur la table Fournisseur en fonction de la saisie de l'utilisateur en console.
 * @author Christian I
 *
 */
public class FournisseurGetMenu {
	private static FournisseurServiceImpl fournisseurSelection = new FournisseurServiceImpl();
	

	public static void traiterFournisseur(int sousMenu) {
		String paramStr1;
		String paramStr2;

		Scanner scanner = new Scanner(System.in);
		switch (sousMenu) {
		case 1:
			System.out.println("Saisir nom du fournisseur");
			paramStr1 = scanner.nextLine();
			fournisseurSelection.creerFournisseur(paramStr1);
			break;

		// modification
		case 2:
			fournisseurSelection.recupererFournisseurs();
			System.out.println("Saisir l'ancien nom parmi la liste");
			paramStr1 = scanner.nextLine();
			System.out.println("Saisir nouveau nom");
			paramStr2 = scanner.nextLine();
			fournisseurSelection.updateFournisseur(paramStr1, paramStr2);
			break;

		// Suppression
		case 3:
			fournisseurSelection.recupererFournisseurs();
			System.out.println("Saisir à partir de la liste ci-dessus, le nom du fournisseur à supprimer");
			paramStr1 = scanner.nextLine();
			fournisseurSelection.supprimerFournisseur(paramStr1);
			break;

		// Liste complète
		case 4:
			fournisseurSelection.recupererFournisseurs();
			break;

		// Visualisation élément
		case 5:
			System.out.println("Nom du fournisseur que vous souhaitez visualiser: ");
			paramStr1 = scanner.nextLine();
			fournisseurSelection.visualiser(paramStr1);
			break;
		default:
			System.out.println("Erreur de saisie !");
			break;
		}

	}
}
