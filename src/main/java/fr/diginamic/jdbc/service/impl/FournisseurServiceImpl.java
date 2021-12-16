package fr.diginamic.jdbc.service.impl;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;
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
			// TODO A basculer dans l'imple creerFournisseur de FournisseurServiImpl
			System.out.println( fournisseur.getNom() + " ajouté la table Fournisseur");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	/** Méthode qui récupère la saisie de l'User pour la mise à jour d'un fournisseur
	 * @param ancienNom
	 * @param nouveauNom
	 * @return int (nbre de ligne mise à jour)
	 */
	public int updateFournisseur(String ancienNom, String nouveauNom) {
		try {
			return fdi.update(ancienNom, nouveauNom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	/** Méthode qui renvoie la liste des fournisseurs
	 * @return List des fournisseurs
	 */
	public List<Fournisseur> recupererFournisseurs() {
		try {
			return fdi.extraire();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** Méthode qui supprime le fournisseur saisi par l'User
	 * @param nomFournisseur
	 * @return boolean si oui ou non fournisseur supprimé
	 */
	public boolean supprimerFournisseur(String nomFournisseur) {
		try {
			return fdi.delete(nomFournisseur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	/** Méthode qui affiche le fournisseur dont l'User veut le détail
	 * @param nomFournisseur
	 * @return fournisseur
	 */
	public Fournisseur visualiser(String nomFournisseur) {
		try {
			return fdi.findOne(nomFournisseur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
