package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.service.ArticleService;

/** 
 * Classe implémente les services.
 * @author Christian I
 *
 */
public class ArticleServiceImpl implements ArticleService {
	private ArticleDao adi = new ArticleDaoImpl();
	

	/** Méthode qui récupère la saisie l'User et crée l'article
	 * @param ref
	 * @param designation
	 * @param prix
	 * @param id_fou
	 */
	@Override
	public void creerArticle(String ref, String designation, double prix, int id_fou) {
		Article article = new Article(ref, designation, prix, id_fou);
		try {
			adi.creer(article);
			System.out.println("Article " + article.getRef() + " ajouté dans la table.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

	/**
	 * Méthode qui récupère la saisie de l'User pour la mise à jour d'un article
	 * @param ref
	 * @param designation
	 * @param prix
	 * @param id_fou
	 */
	@Override
	public void updateArticle(String ref, String designation, double prix, int id_fou) {
		Article article = new Article(designation, prix, id_fou);
		try {
			article.setRef(ref);
			int nb = adi.update(article);
			String str = nb > 0 ? nb + " ligne update" : "UPDATE FAILED !";
			System.out.println(str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** Méthode qui renvoie la liste des articles
	 * @param paramSousMenu as int (choix du sous menu)
	 */
	@Override
	public void recupererArticles(int paramSousMenu) {
		List<Article> articles = new ArrayList<>();
		try {
			articles = adi.extraire();
			switch (paramSousMenu) {
			case 4:
				for (Article article : articles) {
					System.out.println(article);
				}
				break;
			case 2:
			case 3:
			case 5:
				for (Article article : articles) {
					System.out.println("[REF: " + article.getRef() + " -> " + article.getDesignation() + " ]");
				}
				break;
			default:
				break;
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/** 
	 * Méthode qui supprime l'article de la ref saisie par l'User
	 * Elle supprime également toutes les compos liées à l'article le cas échéant.
	 * @param ref article
	 */
	@Override
	public void supprimerArticle(String ref) {
		try {
			Article a = adi.findOne(ref);
			String str = adi.delete(a)? ref+" supprimé." : "DELETE FAILED !" ;
			System.out.println(str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** Méthode qui affiche le fournisseur dont l'User veut le détail
	 * @param ref article
	 */
	@Override
	public void visualiser(String ref) {
		try {
			String str = adi.findOne(ref)!=null?adi.findOne(ref).toString():"NOT FOUND !";
			System.out.println(str);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
