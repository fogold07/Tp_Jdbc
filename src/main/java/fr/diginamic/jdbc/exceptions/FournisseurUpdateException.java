package fr.diginamic.jdbc.exceptions;

/**
 * Classe qui définit l'erreur à afficher lorsqu'un fournisseur la mise à jour a échoué en BdD.
 * 
 * @author Christian Ingold
 *
 */
public class FournisseurUpdateException extends Exception {

	public FournisseurUpdateException(String message) {
		super(message);

	}


}
