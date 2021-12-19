package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.dao.BonDao;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.entites.Bon;

public class BonServiceImpl {
	private BonDao bdi = new BonDaoImpl();
	
	/** Méthode qui récupère la saisie l'User et crée le fournisseur
	 * @param nomFournisseur
	 * @throws ParseException 
	 */
	public void creerBon(int numero, String dateStr, int delai, int id_fou) throws ParseException {

		// conversion du String en sql.date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = sdf.parse(dateStr);
		java.sql.Date dateSql = new java.sql.Date(date.getTime());
		
		Bon bon = new Bon(numero, dateSql, delai, id_fou);
		try {
			bdi.creer(bon);
			System.out.println("Bon n°" + bon.getNumero()+" ajouté à la table");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	/** Méthode qui récupère la saisie de l'User pour la mise à jour d'un bon
	 * @param numero
	 * @param dateStr
	 * @param delai
	 * @param id_fou
	 * @throws ParseException
	 */
	public void updateBon(int numero, String dateStr, int delai, int id_fou) throws ParseException {
		// conversion du String en sql.date
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = sdf1.parse(dateStr);
		java.sql.Date dateSql = new java.sql.Date(date.getTime());
		int nb;
		Bon bon = new Bon(numero, dateSql, delai, id_fou);
		try {
			bon.setNumero(numero);
			nb = bdi.update(bon);
			if (nb > 0) {
				System.out.println(nb + " ligne update. Bon n°" + numero + " mis à jour.");
			}
			else {
				System.out.println("UPDATE FAILED !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/** Méthode qui renvoie la liste de tous les bons
	 * @param paramSousMenu as int (choix du sous menu)
	 */
	public void recupererBons(int paramSousMenu) {
		List<Bon> bons = new ArrayList<>();
		try {
			bons = bdi.extraire();
			
			switch (paramSousMenu) {
			case 4:
				for (Bon bon : bons) {
					System.out.println(bon);
				}
				break;
			case 2:
			case 3:
			case 5:
				for (Bon bon : bons) {
					System.out.println("[N° bon: " + bon.getNumero()+ " ]");
				}
				break;
			default:
				System.out.println("WRONG VALUE !");
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/** Méthode qui supprime le bon du numéro saisie par l'User
	 * @param numéro du bon
	 */
	public void supprimerBon(int numeroBon) {
		try {
			
			boolean isDelete = bdi.delete(numeroBon);
			if (isDelete) {
				System.out.println("Bon # " + numeroBon + " supprimé de la table");
			} else {
				System.out.println("DELETE FAILED !");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	

	/** Méthode qui affiche le bon dont l'User veut avoir le détail
	 * @param numeroBon as int 
	 */
	public void visualiser(int numeroBon) {
		try {
			if (bdi.findOne(numeroBon) == null) {
				System.out.println("NOT FOUND !");
			} else {
				System.out.println(bdi.findOne(numeroBon));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
