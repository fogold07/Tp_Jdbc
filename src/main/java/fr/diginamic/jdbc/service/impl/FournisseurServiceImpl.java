package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.exceptions.FournisseurNotFoundException;
import fr.diginamic.jdbc.exceptions.FournisseurUpdateException;
import fr.diginamic.jdbc.service.FournisseurService;

/**
 * Classe implémente les méthodes CRUD avec en paramètres les informations
 * saisies en console sur l'entité Fournisseur.
 * 
 * @author Christian Ingold
 *
 */
public class FournisseurServiceImpl implements FournisseurService {
	private FournisseurDao fdi = new FournisseurDaoImpl();

	/**
	 * Méthode qui récupère la saisie l'User et crée le fournisseur.
	 * 
	 * @param nomFournisseur
	 */
	@Override
	public void creerFournisseur(String nomFournisseur) {
	
		try {
			Fournisseur fournisseur = fdi.creer(new Fournisseur(nomFournisseur));
			System.out.println("Fournisseur " + fournisseur.getNom() + " ajouté la table.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Méthode qui récupère la saisie de l'User pour la mise à jour d'un fournisseur
	 * 
	 * @param ancienNom  as String
	 * @param nouveauNom as String
	 * @throws FournisseurUpdateException : update failed
	 */
	@Override
	public void updateFournisseur(String ancienNom, String nouveauNom) throws FournisseurUpdateException {
		int nb;
		try {
			nb = fdi.update(ancienNom, nouveauNom);
			if (nb <= 0) {
				throw new FournisseurUpdateException("UPDATE FAILED !\n");
			}

			System.out.println(nb + " ligne update");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Méthode qui affiche la liste des fournisseurs.
	 */
	@Override
	public void recupererFournisseurs() {
		try {
			List<Fournisseur> fournisseurs = new ArrayList<>();
			fournisseurs = fdi.extraire();
			for (Fournisseur fournisseur : fournisseurs) {
				System.out.println(fournisseur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode qui supprime le fournisseur saisi par l'User. Elle supprime également
	 * tous les articles, les bons et les compos liés au fournisseur le cas échéant.
	 * 
	 * @param nomFournisseur
	 * @throws FournisseurNotFoundException : fournisseur non trouvé
	 */
	@Override
	public void supprimerFournisseur(String nomFournisseur) throws FournisseurNotFoundException {
		try {
			if (fdi.findOne(nomFournisseur) == null) {
				throw new FournisseurNotFoundException("FOURNISSEUR NOT FOUND !\n");
			}
			Fournisseur f = fdi.findOne(nomFournisseur);
			
			String str = fdi.delete(f) ? nomFournisseur + " supprimé." : "DELETE FAILED !";
			System.out.println(str);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode qui affiche le fournisseur dont l'User veut le détail.
	 * 
	 * @param nomFournisseur
	 * @throws FournisseurNotFoundException : fournisseur non trouvé
	 */
	@Override
	public void visualiser(String nomFournisseur) throws FournisseurNotFoundException {
		try {
			if (fdi.findOne(nomFournisseur) == null) {
				throw new FournisseurNotFoundException("FOURNISSEUR NOT FOUND !\n");
			}
			String str = fdi.findOne(nomFournisseur).toString();
			System.out.println(str);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
