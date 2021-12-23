package fr.diginamic.jdbc.service;


import fr.diginamic.jdbc.exceptions.FournisseurNotFoundException;
import fr.diginamic.jdbc.exceptions.FournisseurUpdateException;

/**
 * Interface qui définit les méthodes services sur les fournisseurs.
 * 
 * @author Christian Ingold
 *
 */
public interface FournisseurService {
	void creerFournisseur(String nomFournisseur);

	void updateFournisseur(String ancienNom, String nouveauNom) throws FournisseurUpdateException;

	void recupererFournisseurs();

	void supprimerFournisseur(String nomFournisseur) throws FournisseurNotFoundException;

	void visualiser(String nomFournisseur) throws FournisseurNotFoundException;
}
