package fr.diginamic.jdbc;

import java.util.Scanner;

import fr.diginamic.jdbc.util.ArticleGetMenu;
import fr.diginamic.jdbc.util.BonGetMenu;
import fr.diginamic.jdbc.util.CompoGetMenu;
import fr.diginamic.jdbc.util.FournisseurGetMenu;

/**
 * @author christophe Germain
 * 
 *         Programme principal
 * 
 *         Objectif du programme :
 * 
 *         Gérer des Bons de commande d'Articles
 * 
 *         1 - CRUD Fournisseur 2 - CRUD Article 3 - CRUD Bon 4 - Gérer des
 *         Compo pour faire le lien entre un article et un bon avec une qté
 * 
 *         En reprenant les consignes des TP 4 - 5 - 6
 * 
 *         Gérer un menu avec l'utilisation de la classe scanner pour pouvoir
 *         choisir 1 Gérer Fournisseur 2 Gérer Article 3 Gérer Bon 4 Créer lien
 *         Compo (on aura directement la possibilité de saisir le nom de
 *         l'article , le numéro du bon et de la qté )
 * 
 * 
 *         Sous Menus des choix 1 2 3 1 Créer 2 Modifier (demander le nom ou le
 *         numéro (pour le bon) ) 3 Supprimer (demander le nom ou le numéro
 *         (pour le bon) ) 4 Liste Compléte 5 Visualisation d'un élément
 *         (demander le nom ou le numéro (pour le bon) )
 * 
 *         (pour la création : saisir les informations correspondantes aux
 *         rubriques de la table correspondante )
 * 
 *         Gérer les Dao et les services pour répondre à la gestion des menus
 * 
 *         La validation des informations se fait par la touche Entrée
 **/
public class App {

	/**
	 * Point principal à gérer pour notre TP
	 * 
	 * @param args tableau de String en paramètre facultatif
	 */


	public static void main(String[] args) {
		
		try {
			Scanner scanner = new Scanner(System.in);

			int sousMenu = 0;

			boolean runAgain = true;
			String resp;

			while (runAgain) {

				System.out.println(
						"Choisir la table que vous voulez gérer: 1 = Fournisseur, 2 = Article, 3 = Bon, 4 = Compo.");
				int menu = Integer.parseInt(scanner.nextLine());

				// Enregistrement des informations saisies par l'User

				switch (menu) {

				// Fournisseur
				case 1:
					System.out.println(
							"Choisir l'action à effectuer sur la table Fournisseur : 1 = Créer, 2 = Modifier, 3 = Supprimer, 4 = Liste complete, 5 = Visualisation d'un élément.");

					sousMenu = Integer.parseInt(scanner.nextLine());

					FournisseurGetMenu.traiterFournisseur(sousMenu);

					break;

				// Article
				case 2:
					System.out.println(
							"Choisir l'action à effectuer sur la table Article : 1 = Créer, 2 = Modifier, 3 = Supprimer, 4 = Liste complete, 5 = Visualisation d'un élément.");

					sousMenu = Integer.parseInt(scanner.nextLine());

					ArticleGetMenu.traiterArticle(sousMenu);
					break;

				// Bon
				case 3:
					System.out.println(
							"Choisir l'action à effectuer sur la table Bon : 1 = Créer, 2 = Modifier, 3 = Supprimer, 4 = Liste complète, 5 = Visualisation d'un élément.");

					sousMenu = Integer.parseInt(scanner.nextLine());

					BonGetMenu.traiterBon(sousMenu);
					break;

				// Compo
				case 4:
					System.out.println("Choisir action sur la table Compo : 1 = Créer, 2 = Modifier, 3 = Supprimer, 4 = Liste complète.");
					sousMenu = Integer.parseInt(scanner.nextLine());
					CompoGetMenu.traiterCompo(sousMenu);
					break;
				default:
					System.out.println("Erreur de saisie !");
					break;
				}

				System.out.println("Gérer d'autres tables ? O/N");
				resp = (scanner.nextLine()).toUpperCase();
				if (resp.equals("O")) {
					runAgain = true;
				} else {
					runAgain = false;
					System.out.println("Merci et à bientôt !");
				}
			}

			scanner.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
