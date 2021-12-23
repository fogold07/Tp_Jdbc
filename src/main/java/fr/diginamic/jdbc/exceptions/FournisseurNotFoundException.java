package fr.diginamic.jdbc.exceptions;

/**
 * Classe qui définit l'erreur à afficher lorsqu'un fournisseur n'existe pas en BdD.
 * 
 * @author Christian Ingold
 *
 */
public class FournisseurNotFoundException extends Exception {

	public FournisseurNotFoundException(String message) {
		super(message);

	}


}
