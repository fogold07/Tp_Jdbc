package fr.diginamic.jdbc.exceptions;

/**
 * Classe qui définit l'erreur à afficher lorsqu'un bon n'existe pas en BdD.
 * 
 * @author Christian Ingold
 *
 */
public class BonNotFoundException extends Exception {

	public BonNotFoundException(String message) {
		super(message);

	}
}
