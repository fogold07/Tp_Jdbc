package fr.diginamic.jdbc;

import java.util.Scanner;

import fr.diginamic.jdbc.service.RunService;
import fr.diginamic.jdbc.service.impl.RunServiceImpl;

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
		RunService rsi = new RunServiceImpl();
		try {
			Scanner scanner = new Scanner(System.in);
			boolean runAgain = true;
			
			while (runAgain) {
				rsi.lancerMenu();
				runAgain = rsi.stopMenu();
			}
			scanner.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	}
