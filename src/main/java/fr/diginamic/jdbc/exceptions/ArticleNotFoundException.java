package fr.diginamic.jdbc.exceptions;

/**
 * Classe qui définit l'erreur à afficher lorsqu'un article n'existe pas en BdD.
 * 
 * @author Christian Ingold
 *
 */
public class ArticleNotFoundException extends Exception {

	public ArticleNotFoundException(String message) {
		super(message);

	}
}
