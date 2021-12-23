package fr.diginamic.jdbc.service.impl;

import fr.diginamic.jdbc.service.MenuService;

/**
 * Classe implémente les méthodes sur l'affichage du menu principal.
 * 
 * @author Christian Ingold
 *
 */
public class MenuServiceImpl implements MenuService {

	/**
	 * Méthode qui affiche les différents choix du menu principal.
	 */
	@Override
	public void displayMenu() {

		System.out.println("***** MENU PRINCIPAL ********");
		System.out.println("Choisir la table que vous voulez gérer:");
		System.out.println("1 -> Fournisseur");
		System.out.println("2 -> Article");
		System.out.println("3 -> Bon");
		System.out.println("4 -> Compo");
		System.out.print("=> Votre choix: ");
	}


}
