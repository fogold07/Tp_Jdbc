package fr.diginamic.jdbc.service;

/**
 * Interface qui définit les méthodes services sur les articles.
 * 
 * @author Christian Ingold
 *
 */
public interface ArticleService {

	void creerArticle(String ref, String designation, double prix, int id_fou);

	void updateArticle(String ref, String designation, double prix, int id_fou);

	void recupererArticles(int paramSousMenu);

	void supprimerArticle(String ref);

	void visualiser(String ref);

}
