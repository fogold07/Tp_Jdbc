package fr.diginamic.jdbc.service.impl;

import fr.diginamic.jdbc.service.SousMenuService;

/**
 * Classe permet d'afficher les différents choix du sous-menu standard.
 * 
 * @author Christian Ingold
 *
 */
public class SousMenuServiceImpl implements SousMenuService {

	/**
	 * Méthode qui affiche les différents choix du sous-menu.
	 */
	@Override
	public void displaySousMenu(String choix) {
		
		if(choix.equals("Compo")) {
			System.out.println("********* SOUS-MENU " + choix.toUpperCase() + " ***********");
			System.out.println("Choisir l'action à effectuer sur la table "+ choix +" :");
			System.out.println("1 -> Créer");
			System.out.println("2 -> Modifier");
			System.out.println("3 -> Supprimer");
			System.out.println("4 -> Liste complète");
			
			System.out.println("(0 : Retour au Menu principal)");
			System.out.print("Votre choix: ");
		}
		else {
			System.out.println("********* SOUS-MENU " + choix.toUpperCase() + " ***********");
			System.out.println("Choisir l'action à effectuer sur la table "+ choix +" :");
			System.out.println("1 -> Créer");
			System.out.println("2 -> Modifier");
			System.out.println("3 -> Supprimer");
			System.out.println("4 -> Liste complète");
			System.out.println("5 -> Visualiser un élément");
			
			System.out.println("(0 : Retour au Menu principal)");
			System.out.print("Votre choix: ");
		}
		
		
	}

	@Override
	public void displayTitleActionSousMenu(int ch) {
		if(ch == 1) System.out.println("********** CREATION **************");
		if(ch == 2) System.out.println("********** MODIFICATION **************");
		if(ch == 3) System.out.println("********** SUPPRESSION **************");
		if(ch == 4) System.out.println("********** LISTE COMPLETE **************");
		if(ch == 5) System.out.println("********** VISUALISATION UN ELEMENT **************");
	}

}
