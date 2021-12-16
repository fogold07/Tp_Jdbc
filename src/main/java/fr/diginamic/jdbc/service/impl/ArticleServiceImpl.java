package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.entites.Article;

public class ArticleServiceImpl {
	private ArticleDao adi = new ArticleDaoImpl();
	

	/** Méthode qui récupère la saisie l'User et crée l'article
	 * @param ref
	 * @param designation
	 * @param prix
	 * @param id_fou
	 */
	public void creerArticle(String ref, String designation, double prix, int id_fou) {
		Article article = new Article(ref, designation, prix, id_fou);
		try {
			adi.creer(article);
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
	 * @return int nb article mis à jour
	 */
	public int updateArticle(String ref, String designation, double prix, int id_fou) {
		Article article = new Article(designation, prix, id_fou);
		try {
			article.setRef(ref);
			return adi.update(article);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	/** Méthode qui renvoie la liste des articles
	 * @return List des articles
	 */
	public List<Article> recupererArticles() {
		try {
			return adi.extraire();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/** Méthode qui supprime l'article de la ref saisie par l'User
	 * @param ref article
	 * @return boolean
	 */
	public boolean supprimerArticle(String ref) {
		try {
			return adi.delete(ref);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	/** Méthode qui affiche le fournisseur dont l'User veut le détail
	 * @param ref article
	 * @return article
	 */
	public Article visualiser(String ref) {
		try {
			return adi.findOne(ref);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	/** Méthode qui renvoie une vue simplifiée des articles
	 *  (ref et désignation)
	 */
	public void vueSimplifie() {
		try {
			adi.simpleView();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
