package fr.diginamic.jdbc.service.impl;

import java.util.Scanner;

import fr.diginamic.jdbc.service.MenuService;
import fr.diginamic.jdbc.service.RunService;
import fr.diginamic.jdbc.service.SousMenuService;
import fr.diginamic.jdbc.util.ArticleGetMenu;
import fr.diginamic.jdbc.util.BonGetMenu;
import fr.diginamic.jdbc.util.CompoGetMenu;
import fr.diginamic.jdbc.util.FournisseurGetMenu;

/**
 * Classe permet de lancer
 * 
 * @author Christian Ingold
 *
 */
public class RunServiceImpl implements RunService {
	Scanner scanner = new Scanner(System.in);
	@Override
	public void lancerMenu() {

		MenuService ms = new MenuServiceImpl();
		SousMenuService sms = new SousMenuServiceImpl();

		final String FOURNISSEUR = "Fournisseur";
		final String ARTICLE = "Article";
		final String BON = "Bon";
		final String COMPO = "Compo";

		int menu;
		int sousMenu;
		

		try {
			
			ms.displayMenu();
			menu = Integer.parseInt(scanner.nextLine());

			switch (menu) {

			// Fournisseur
			case 1:
				sms.displaySousMenu(FOURNISSEUR);
				sousMenu = Integer.parseInt(scanner.nextLine());
				sms.displayTitleActionSousMenu(sousMenu);
				FournisseurGetMenu.traiterFournisseur(sousMenu);

				break;

			// Article
			case 2:
				sms.displaySousMenu(ARTICLE);
				sousMenu = Integer.parseInt(scanner.nextLine());
				sms.displayTitleActionSousMenu(sousMenu);
				ArticleGetMenu.traiterArticle(sousMenu);
				break;

			// Bon
			case 3:
				sms.displaySousMenu(BON);
				sousMenu = Integer.parseInt(scanner.nextLine());
				sms.displayTitleActionSousMenu(sousMenu);
				BonGetMenu.traiterBon(sousMenu);
				break;

			// Compo
			case 4:
				sms.displaySousMenu(COMPO);
				sousMenu = Integer.parseInt(scanner.nextLine());
				sms.displayTitleActionSousMenu(sousMenu);
				CompoGetMenu.traiterCompo(sousMenu);
				break;
			default:
				System.err.println("Erreur de saisie !");
				break;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Boolean stopMenu() {
		String resp;

		System.out.println("");
		System.out.println("****************************");
		System.out.println("****************************");
		System.out.println("Gérer d'autres tables ? O/N");
		resp = (scanner.nextLine()).toUpperCase();
		
		if (resp.equals("O")) {
			return true;
		} else {
			System.out.println("Merci et à bientôt !");
			return false;
		}
	}

}
