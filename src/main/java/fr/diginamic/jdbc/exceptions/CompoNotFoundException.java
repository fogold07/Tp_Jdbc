package fr.diginamic.jdbc.exceptions;

/**
 * Classe qui définit l'erreur à afficher lorsqu'une Compo n'existe pas en BdD.
 * 
 * @author Christian Ingold
 *
 */
public class CompoNotFoundException extends Exception {

	public CompoNotFoundException(String message) {
		super(message);

	}
}
