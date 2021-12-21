package fr.diginamic.jdbc.util;

import java.text.ParseException;
import java.util.Scanner;

import fr.diginamic.jdbc.service.BonService;
import fr.diginamic.jdbc.service.FournisseurService;
import fr.diginamic.jdbc.service.impl.BonServiceImpl;
import fr.diginamic.jdbc.service.impl.FournisseurServiceImpl;


/** Classe qui exécute les actions sur la table Bon en fonction de la saisie de l'utilisateur en console.
 * @author Christian I
 *
 */
public class BonGetMenu {
	private static FournisseurService fournisseurSelection = new FournisseurServiceImpl();
	private static BonService bonSelection = new BonServiceImpl();

	
	public static void traiterBon(int sousMenu) {
		String paramStr2;
		int paramInt1;
		int paramInt2;
		int paramInt3;
		// double paramDbl = 0.0d;

		Scanner scanner = new Scanner(System.in);

		switch (sousMenu) {
		// création

		case 1:
			System.out.println("Saisir le numéro: ");
			paramInt2 = Integer.parseInt(scanner.nextLine());

			System.out.println("Saisir Date (dd-mm-yyy): ");
			paramStr2 = scanner.nextLine();

			System.out.println("Saisir delai");
			paramInt3 = Integer.parseInt(scanner.nextLine());

			System.out.println("Saisir id_fournisseur parmis la liste:");
			fournisseurSelection.recupererFournisseurs();
			paramInt1 = Integer.parseInt(scanner.nextLine());

			try {
				bonSelection.creerBon(paramInt2, paramStr2, paramInt3, paramInt1);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			break;

		// modification
		case 2:
			bonSelection.recupererBons(sousMenu);
			System.out.println("Saisir le numéro du bon à modifier: ");
			paramInt2 = Integer.parseInt(scanner.nextLine());

			System.out.println("Saisir Date (dd-mm-yyyy): ");
			paramStr2 = scanner.nextLine();

			System.out.println("Saisir delai");
			paramInt3 = Integer.parseInt(scanner.nextLine());

			System.out.println("Saisir id_fournisseur parmis la liste:");
			fournisseurSelection.recupererFournisseurs();
			paramInt1 = Integer.parseInt(scanner.nextLine());

			try {
				bonSelection.updateBon(paramInt2, paramStr2, paramInt3, paramInt1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		// Suppression
		case 3:
			System.out.println("Saisir à partir de la liste ci-dessus, le numéro de bon à supprimer :");
			bonSelection.recupererBons(sousMenu);
			paramInt2 = Integer.parseInt(scanner.nextLine());

			bonSelection.supprimerBon(paramInt2);
			break;

		// Liste complète
		case 4:
			bonSelection.recupererBons(sousMenu);
			break;

		// Visualisation élément
		case 5:
			bonSelection.recupererBons(sousMenu);
			System.out.println("Saisir le numéro du bon à visualiser: ");
			paramInt2 = Integer.parseInt(scanner.nextLine());

			bonSelection.visualiser(paramInt2);
			break;
		default:
			System.out.println("Erreur de saisie !");
			break;
		}

	}
	
}
