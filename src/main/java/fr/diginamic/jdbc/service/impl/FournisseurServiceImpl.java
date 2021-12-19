package fr.diginamic.jdbc.service.impl;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;

public class FournisseurServiceImpl {
	private FournisseurDao fdi = new FournisseurDaoImpl();
	
	/** Méthode qui récupère la saisie l'User et crée le fournisseur
	 * @param nomFournisseur
	 */
	public void creerFournisseur(String nomFournisseur) {
		Fournisseur fournisseur = new Fournisseur(nomFournisseur);
		try {
			fdi.creer(fournisseur);
			System.out.println( "Fournisseur " + fournisseur.getNom() + " ajouté la table.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	/** Méthode qui récupère la saisie de l'User pour la mise à jour d'un fournisseur
	 * @param ancienNom as String
	 * @param nouveauNom as String
	 */
	public void updateFournisseur(String ancienNom, String nouveauNom) {
		int nb;
		try {
			nb = fdi.update(ancienNom, nouveauNom);
			String str = nb > 0 ? nb + " ligne update" : "UPDATE FAILED !";
			System.out.println(str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** Méthode qui renvoie la liste des fournisseurs.
	 */
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
	
	/** Méthode qui supprime le fournisseur saisi par l'User
	 * @param nomFournisseur
	 */
	public void supprimerFournisseur(String nomFournisseur) {
		try {
			String str = fdi.delete(nomFournisseur) ? nomFournisseur + " supprimé." : "DELETE FAILED !";
			System.out.println(str);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/** Méthode qui affiche le fournisseur dont l'User veut le détail
	 * @param nomFournisseur
	 */
	public void visualiser(String nomFournisseur) {
		try {
			String str = fdi.findOne(nomFournisseur) != null ? fdi.findOne(nomFournisseur).toString() : "NOT FOUND !";
			System.out.println(str);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
