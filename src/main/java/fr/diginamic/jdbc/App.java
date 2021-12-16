package fr.diginamic.jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.service.impl.ArticleServiceImpl;
import fr.diginamic.jdbc.service.impl.BonServiceImpl;
import fr.diginamic.jdbc.service.impl.FournisseurServiceImpl;

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
	 * @param args tableau de String en pramètre facultatif
	 */
	private static FournisseurServiceImpl fournisseurSelection = new FournisseurServiceImpl();
	private static ArticleServiceImpl articleSelection = new ArticleServiceImpl();
	private static BonServiceImpl bonSelection = new BonServiceImpl();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int sousMenu = 0;
		String param1 = null;
		String param2 = null;
		int id = 0;
		double param3 = 0.0d;
		int param4 = 0;
		int param5 = 0;
		boolean runAgain = true;
		String resp;

		while (runAgain) {

			System.out.println("Choisir l'entité que vous voulez gérer: 1 = Fournisseur, 2 = Article, 3 = Bon");
			int menu = Integer.parseInt(scanner.nextLine());

			// Enregistrement des informations saisies par l'User

			switch (menu) {

			// Fournisseur ---------------------------------------------------
			case 1:
				System.out.println(
						"Choisir l'action à effectuer sur la table Fournisseur : 1 = Créer, 2 = Modifier, 3 = Supprimer, 4 = Liste complete, 5 = Visualisation d'un élément");
				sousMenu = Integer.parseInt(scanner.nextLine());

				switch (sousMenu) {
				// création
				case 1:
					System.out.println("Saisir nom du fournisseur");
					param1 = scanner.nextLine();
					fournisseurSelection.creerFournisseur(param1);
					break;

				// modification
				case 2:
					fournisseurSelection.recupererFournisseurs().stream().forEach(f -> System.out.println(f));
					System.out.println("Saisir l'ancien nom parmi la liste");
					param1 = scanner.nextLine();
					System.out.println("Saisir nouveau nom");
					param2 = scanner.nextLine();
					int nb = fournisseurSelection.updateFournisseur(param1, param2);
					System.out.println(nb + "ligne(s) update. Ancien nom : " + param1 + ", Nouveau nom: " + param2);
					break;

				// Suppression
				case 3:
					fournisseurSelection.recupererFournisseurs().stream().forEach(f -> System.out.println(f));
					System.out.println("Saisir à partir de la liste ci-dessus, le nom du fournisseur à supprimer");
					param1 = scanner.nextLine();
					boolean isDelete = fournisseurSelection.supprimerFournisseur(param1);
					if (isDelete) {
						System.out.println(param1 + " supprimé de la table");
					} else {
						System.out.println("Aucun fournisseur supprimé !");
					}
					break;
				// Liste complète
				case 4:
					fournisseurSelection.recupererFournisseurs().stream().forEach(f -> System.out.println(f));
					break;
				// Visualisation élément
				case 5:
					System.out.println("Nom du fournisseur que vous souhaitez visualiser: ");
					param1 = scanner.nextLine();
					System.out.println(fournisseurSelection.visualiser(param1));
					break;
				default:
					System.out.println("Erreur de saisie !");
					break;
				}
				break;
			// --------------------------------------------------------------

			// Article -------------------------------------
			case 2:
				System.out.println(
						"Choisir l'action à effectuer sur la table Article : 1 = Créer, 2 = Modifier, 3 = Supprimer, 4 = Liste complete, 5 = Visualisation d'un élément");
				sousMenu = Integer.parseInt(scanner.nextLine());

				switch (sousMenu) {
				// création
				case 1:
					System.out.println("Saisir REF (alphanumérique): ");
					param1 = scanner.nextLine();

					System.out.println("Saisir Désignation: ");
					param2 = scanner.nextLine();

					System.out.println("Saisir Prix ");
					param3 = Double.parseDouble(scanner.nextLine());

					System.out.println("Saisir id_fournisseur parmis la liste:");
					fournisseurSelection.recupererFournisseurs().stream().forEach(f -> System.out.println(f));
					id = Integer.parseInt(scanner.nextLine());

					articleSelection.creerArticle(param1, param2, param3, id);
					break;

				// modification
				case 2:
					articleSelection.vueSimplifie();
					System.out.println("Saisir REF de l'article à mettre à jour : ");
					param1 = scanner.nextLine();
					System.out.println("Saisir nouvelle Désignation: ");
					param2 = scanner.nextLine();

					System.out.println("Saisir nouveau Prix ");
					param3 = Double.parseDouble(scanner.nextLine());

					System.out.println("Saisir nouvel id_fournisseur parmis la liste:");
					fournisseurSelection.recupererFournisseurs().stream().forEach(f -> System.out.println(f));
					id = Integer.parseInt(scanner.nextLine());

					int nb = articleSelection.updateArticle(param1, param2, param3, id);
					System.out.println(nb + " ligne(s) update. Article : " + param1 + " à jour");
					break;

				// Suppression
				case 3:
					articleSelection.vueSimplifie();
					System.out.println("Saisir à partir de la liste ci-dessus, la ref de l'article à supprimer");
					param1 = scanner.nextLine();
					boolean isDelete = articleSelection.supprimerArticle(param1);
					if (isDelete) {
						System.out.println("Ref "+param1 + " supprimé de la table");
					} else {
						System.out.println("Aucun fournisseur supprimé !");
					}
					break;
				// Liste complète
				case 4:
					articleSelection.recupererArticles().stream().forEach(f -> System.out.println(f));
					break;
				// Visualisation élément
				case 5:
					articleSelection.vueSimplifie();
					System.out.println("Saisir la ref à visualiser: ");
					param1 = scanner.nextLine();
					System.out.println(articleSelection.visualiser(param1));
					break;
				default:
					System.out.println("Erreur de saisie !");
					break;
				}
				break;
			// --------------------------------------------------------------

			// Bon -------------------------------------
			case 3:
				System.out.println(
						"Choisir l'action à effectuer sur la table Bon : 1 = Créer, 2 = Modifier, 3 = Supprimer, 4 = Liste complete, 5 = Visualisation d'un élément");
				sousMenu = Integer.parseInt(scanner.nextLine());

				switch (sousMenu) {
				// création
				case 1:
					System.out.println("Saisir le numéro: ");
					param4 = Integer.parseInt(scanner.nextLine());

					System.out.println("Saisir Date (dd-mm-yyy): ");
					param2 = scanner.nextLine();

					System.out.println("Saisir delai");
					param5 = Integer.parseInt(scanner.nextLine());

					System.out.println("Saisir id_fournisseur parmis la liste:");
					fournisseurSelection.recupererFournisseurs().stream().forEach(f -> System.out.println(f));
					id = Integer.parseInt(scanner.nextLine());

					try {
						bonSelection.creerBon(param4, param2, param5, id);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;

				// modification
				case 2:
					bonSelection.vueSimplifie();
					System.out.println("Saisir le numéro: ");
					param4 = Integer.parseInt(scanner.nextLine());

					System.out.println("Saisir Date (dd-mm-yyyy): ");
					param2 = scanner.nextLine();

					System.out.println("Saisir delai");
					param5 = Integer.parseInt(scanner.nextLine());

					System.out.println("Saisir id_fournisseur parmis la liste:");
					fournisseurSelection.recupererFournisseurs().stream().forEach(f -> System.out.println(f));
					id = Integer.parseInt(scanner.nextLine());

					int nb;
					try {
						nb = bonSelection.updateBon(param4, param2, param5, id);
						System.out.println(nb + " ligne(s) update. Bon : #" + param4 + " à jour");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				// Suppression
				case 3:
					bonSelection.vueSimplifie();
					System.out.println("Saisir à partir de la liste ci-dessus, le numéro de bon à supprimer");
					param4 = Integer.parseInt(scanner.nextLine());
					boolean isDelete = bonSelection.supprimerBon(param4);
					if (isDelete) {
						System.out.println("Bon # "+param4 + " supprimé de la table");
					} else {
						System.out.println("Aucun fournisseur supprimé !");
					}
					break;

				// Liste complète
				case 4:
					bonSelection.recupererBons().stream().forEach(f -> System.out.println(f));
					break;

				// Visualisation élément
				case 5:
					bonSelection.vueSimplifie();
					System.out.println("Saisir le numéro du bon à visualiser: ");
					param4 = Integer.parseInt(scanner.nextLine());
					System.out.println(bonSelection.visualiser(param4));
					break;
				default:
					System.out.println("Erreur de saisie !");
					break;
				}
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
				System.out.println("Merci et à bientôt");
			}
		}
		scanner.close();
		// testBonDao();
		// testArticleDao();

	}

	public static void testBonDao() {

		BonDaoImpl select;

		try {
			/*
			 * select = new BonDaoImpl(); //test findOne
			 * 
			 * Bon art = new Bon(); art = select.findOne(2); System.out.println(art);
			 * 
			 * 
			 * // test extraire /* List<Bon> articles = new ArrayList<>(); articles =
			 * select.extraire();
			 * 
			 * 
			 * for (Bon article : articles) { System.out.println(article); }
			 */

			// test update
			// int nb = select.update(new Bon(2, Date(2019,03,02,09,30,00), 6, 2)));
			select = new BonDaoImpl();

			String dateStr = "07-12-2020";
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date date = sdf1.parse(dateStr);
			java.sql.Date dateSql = new java.sql.Date(date.getTime());

			Bon bon = new Bon(2, dateSql, 5, 2);

			// Bon bon = new Bon(2, 6, 2);
			bon.setId(2);
			int nb = select.update(bon);
			// System.out.println(nb);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testArticleDao() {
		ArticleDaoImpl adi;

		try {
			adi = new ArticleDaoImpl();
			Article art = new Article("Perceuse P1", 74.99, 1);
			art.setRef("A01");
			adi.update(art);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
