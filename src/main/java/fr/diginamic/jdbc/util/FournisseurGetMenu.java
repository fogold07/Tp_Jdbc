package fr.diginamic.jdbc.util;

import java.util.Scanner;

import fr.diginamic.jdbc.exceptions.FournisseurNotFoundException;
import fr.diginamic.jdbc.exceptions.FournisseurUpdateException;
import fr.diginamic.jdbc.service.FournisseurService;
import fr.diginamic.jdbc.service.MenuService;
import fr.diginamic.jdbc.service.RunService;
import fr.diginamic.jdbc.service.impl.FournisseurServiceImpl;
import fr.diginamic.jdbc.service.impl.MenuServiceImpl;
import fr.diginamic.jdbc.service.impl.RunServiceImpl;

/**
 * Classe qui exécute les actions sur la table Fournisseur en fonction de la
 * saisie de l'utilisateur en console.
 * 
 * @author Christian Ingold
 *
 */
public class FournisseurGetMenu {
	private static FournisseurService fournisseurSelection = new FournisseurServiceImpl();

	private static RunService rsi = new RunServiceImpl();

	/**
	 * Méthode qui récupère et traite les informations pour le CRUD sur l'entité
	 * 
	 * @param sousMenu
	 */
	public static void traiterFournisseur(int sousMenu) {
		String paramStr1;
		String paramStr2;

		Scanner scanner = new Scanner(System.in);
		switch (sousMenu) {
		case 0:
			rsi.lancerMenu();
			break;
		
		case 1:
			System.out.println("Saisir nom du fournisseur");
			paramStr1 = scanner.nextLine();
			fournisseurSelection.creerFournisseur(paramStr1);
			break;

		// modification
		case 2:
			fournisseurSelection.recupererFournisseurs(sousMenu);
			System.out.println("Saisir l'ancien nom parmi la liste");
			paramStr1 = scanner.nextLine();
			System.out.println("Saisir nouveau nom");
			paramStr2 = scanner.nextLine();
			try {
				fournisseurSelection.updateFournisseur(paramStr1, paramStr2);
			} catch (FournisseurUpdateException fue) {
				System.err.println(fue.getMessage());
			}
			break;

		// Suppression
		case 3:
			fournisseurSelection.recupererFournisseurs(sousMenu);
			System.out.println("Saisir à partir de la liste ci-dessus, le nom du fournisseur à supprimer");
			paramStr1 = scanner.nextLine();

			try {
				fournisseurSelection.supprimerFournisseur(paramStr1);
			} catch (FournisseurNotFoundException fne) {
				System.err.println(fne.getMessage());
			}

			break;

		// Liste complète
		case 4:
			fournisseurSelection.recupererFournisseurs(sousMenu);
			break;

		// Visualisation élément
		case 5:
			fournisseurSelection.recupererFournisseurs(sousMenu);
			System.out.println("Nom du fournisseur dont vous souhaitez avoir le détail: ");
			paramStr1 = scanner.nextLine();
			try {
				fournisseurSelection.visualiser(paramStr1);
			} catch (FournisseurNotFoundException fne) {
				System.err.println(fne.getMessage());
			}
			break;
			
		default:
			System.err.println("Erreur de saisie !");
			break;
		}

	}
}
