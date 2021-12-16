package fr.diginamic.jdbc;

import java.text.ParseException;
import java.util.Scanner;

import fr.diginamic.jdbc.service.impl.ArticleServiceImpl;
import fr.diginamic.jdbc.service.impl.BonServiceImpl;
import fr.diginamic.jdbc.service.impl.CompoServiceImpl;
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
public class AppTest {

	/**
	 * Point principal à gérer pour notre TP
	 * 
	 * @param args tableau de String en paramètre facultatif
	 */
	private static FournisseurServiceImpl fournisseurSelection = new FournisseurServiceImpl();
	private static ArticleServiceImpl articleSelection = new ArticleServiceImpl();
	private static BonServiceImpl bonSelection = new BonServiceImpl();
	private static CompoServiceImpl compoSelection = new CompoServiceImpl();

	public static void main(String[] args) {
		// mettre tout ce bloc dans un try and catch
		try {	
		Scanner scanner = new Scanner(System.in);

		int sousMenu = 0;
		String paramStr1 = null;
		String paramStr2 = null;
		int paramInt1 = 0;
		double paramDbl = 0.0d;
		int paramInt2 = 0;
		int paramInt3 = 0;
		boolean runAgain = true;
		String resp;

		while (runAgain) {

			System.out.println(
					"Choisir l'entité que vous voulez gérer: 1 = Fournisseur, 2 = Article, 3 = Bon, 4 = Créer Compo.");
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
					paramStr1 = scanner.nextLine();
					fournisseurSelection.creerFournisseur(paramStr1);
					break;

				// modification
				case 2:
					fournisseurSelection.recupererFournisseurs().stream().forEach(f -> System.out.println(f));
					System.out.println("Saisir l'ancien nom parmi la liste");
					paramStr1 = scanner.nextLine();
					System.out.println("Saisir nouveau nom");
					paramStr2 = scanner.nextLine();
					int nb = fournisseurSelection.updateFournisseur(paramStr1, paramStr2);
					System.out
							.println(nb + "ligne(s) update. Ancien nom : " + paramStr1 + ", Nouveau nom: " + paramStr2);
					break;

				// Suppression
				case 3:
					fournisseurSelection.recupererFournisseurs().stream().forEach(f -> System.out.println(f));
					System.out.println("Saisir à partir de la liste ci-dessus, le nom du fournisseur à supprimer");
					paramStr1 = scanner.nextLine();
					boolean isDelete = fournisseurSelection.supprimerFournisseur(paramStr1);
					if (isDelete) {
						System.out.println(paramStr1 + " supprimé de la table");
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
					paramStr1 = scanner.nextLine();
					System.out.println(fournisseurSelection.visualiser(paramStr1));
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
					paramStr1 = scanner.nextLine();

					System.out.println("Saisir Désignation: ");
					paramStr2 = scanner.nextLine();

					System.out.println("Saisir Prix ");
					paramDbl = Double.parseDouble(scanner.nextLine());

					System.out.println("Saisir id_fournisseur parmis la liste:");
					fournisseurSelection.recupererFournisseurs().stream().forEach(f -> System.out.println(f));
					paramInt1 = Integer.parseInt(scanner.nextLine());

					articleSelection.creerArticle(paramStr1, paramStr2, paramDbl, paramInt1);
					break;

				// modification
				case 2:
					articleSelection.vueSimplifie();
					System.out.println("Saisir REF de l'article à mettre à jour : ");
					paramStr1 = scanner.nextLine();
					System.out.println("Saisir nouvelle Désignation: ");
					paramStr2 = scanner.nextLine();

					System.out.println("Saisir nouveau Prix ");
					paramDbl = Double.parseDouble(scanner.nextLine());

					System.out.println("Saisir nouvel id_fournisseur parmis la liste:");
					fournisseurSelection.recupererFournisseurs().stream().forEach(f -> System.out.println(f));
					paramInt1 = Integer.parseInt(scanner.nextLine());

					int nb = articleSelection.updateArticle(paramStr1, paramStr2, paramDbl, paramInt1);
					System.out.println(nb + " ligne(s) update. Article : " + paramStr1 + " à jour");
					break;

				// Suppression
				case 3:
					articleSelection.vueSimplifie();
					System.out.println("Saisir à partir de la liste ci-dessus, la ref de l'article à supprimer");
					paramStr1 = scanner.nextLine();
					boolean isDelete = articleSelection.supprimerArticle(paramStr1);
					if (isDelete) {
						System.out.println("Ref " + paramStr1 + " supprimé de la table");
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
					paramStr1 = scanner.nextLine();
					System.out.println(articleSelection.visualiser(paramStr1));
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
					paramInt2 = Integer.parseInt(scanner.nextLine());

					System.out.println("Saisir Date (dd-mm-yyy): ");
					paramStr2 = scanner.nextLine();

					System.out.println("Saisir delai");
					paramInt3 = Integer.parseInt(scanner.nextLine());

					System.out.println("Saisir id_fournisseur parmis la liste:");
					fournisseurSelection.recupererFournisseurs().stream().forEach(f -> System.out.println(f));
					paramInt1 = Integer.parseInt(scanner.nextLine());

					try {
						bonSelection.creerBon(paramInt2, paramStr2, paramInt3, paramInt1);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;

				// modification
				case 2:
					bonSelection.recupererBons(sousMenu);
					System.out.println("Saisir le numéro: ");
					paramInt2 = Integer.parseInt(scanner.nextLine());

					System.out.println("Saisir Date (dd-mm-yyyy): ");
					paramStr2 = scanner.nextLine();

					System.out.println("Saisir delai");
					paramInt3 = Integer.parseInt(scanner.nextLine());

					System.out.println("Saisir id_fournisseur parmis la liste:");
					fournisseurSelection.recupererFournisseurs().stream().forEach(f -> System.out.println(f));
					paramInt1 = Integer.parseInt(scanner.nextLine());

					int nb;
					try {
						nb = bonSelection.updateBon(paramInt2, paramStr2, paramInt3, paramInt1);
						System.out.println(nb + " ligne(s) update. Bon : #" + paramInt2 + " à jour");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				// Suppression
				case 3:
					bonSelection.recupererBons(sousMenu);
					System.out.println("Saisir à partir de la liste ci-dessus, le numéro de bon à supprimer");
					paramInt2 = Integer.parseInt(scanner.nextLine());
					boolean isDelete = bonSelection.supprimerBon(paramInt2);
					if (isDelete) {
						System.out.println("Bon # " + paramInt2 + " supprimé de la table");
					} else {
						System.out.println("Aucun fournisseur supprimé !");
					}
					break;

				// Liste complète
				case 4:
					bonSelection.recupererBons(sousMenu);
					//bonSelection.recupererBons().stream().forEach(f -> System.out.println(f));
					break;

				// Visualisation élément
				case 5:
					bonSelection.recupererBons(sousMenu);
					System.out.println("Saisir le numéro du bon à visualiser: ");
					paramInt2 = Integer.parseInt(scanner.nextLine());
					
					if(bonSelection.visualiser(paramInt2) == null) {
						System.out.println("NOT FOUND!");
					} else {
						System.out.println(bonSelection.visualiser(paramInt2));
					}
					
					break;
				default:
					System.out.println("Erreur de saisie !");
					break;
				}
				break;
				
			//----------------------------------------
				
			// ----- Compo
			case 4:
				articleSelection.vueSimplifie();
				System.out.println("Saisir l'article (REF): ");
				paramStr1 = scanner.nextLine();
				bonSelection.recupererBons(sousMenu);
				System.out.println("Saisir le numéro de bon: ");
				paramInt1 = Integer.parseInt(scanner.nextLine());
				System.out.println("Saisir la qté: ");
				paramInt2 = Integer.parseInt(scanner.nextLine());
				compoSelection.creerCompo(paramStr1, paramInt1, paramInt2);

				compoSelection.recupererCompos().stream().forEach(c -> System.out.println(c));
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
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
