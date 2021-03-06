package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.dao.BonDao;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.service.BonService;

/**
 * Classe implémente les méthodes CRUD avec en paramètres les informations
 * saisies en console sur l'entité Bon.
 * 
 * @author Christian Ingold
 *
 */
public class BonServiceImpl implements BonService {
	private BonDao bdi = new BonDaoImpl();


	/**
	 *  Méthode qui récupère la saisie l'User et crée le bon.
	 *  
	 *  @param numero (n° du bon as int)
	 *  @param dateStr (date as String)
	 *  @param delai as int
	 *  @param id_fou as int
	 */
	@Override
	public void creerBon(int numero, String dateStr, int delai, int id_fou) throws ParseException {

		// conversion du String en sql.date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = sdf.parse(dateStr);
		java.sql.Date dateSql = new java.sql.Date(date.getTime());

		try {
			Bon bon = bdi.creer(new Bon(numero, dateSql, delai, id_fou));
			System.out.println("Bon n°" + bon.getNumero() + " ajouté à la table");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Méthode qui récupère la saisie de l'User pour la mise à jour d'un bon.
	 * 
	 * @param numero
	 * @param dateStr
	 * @param delai
	 * @param id_fou
	 * @throws ParseException
	 */
	@Override
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
			if (nb>0) System.out.println(nb + " ligne update");
			else System.err.println("UPDATE FAILED ON BON !");
			
//			String str = nb > 0 ? nb + " ligne update. Bon n°" + numero + " mis à jour." : "UPDATE FAILED !";
//			System.out.println(str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode qui renvoie la liste de tous les bons.
	 * 
	 * @param paramSousMenu as int (choix du sous menu)
	 */
	@Override
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
					System.out.println("[N° bon: " + bon.getNumero() + " ]");
				}
				break;
			default:
				System.err.println("WRONG VALUE !");
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Méthode qui supprime le bon du numéro saisie par l'User.
	 * Elle supprime également toutes les compos liées au bon le cas échéant.
	 * 
	 * @param numéro du bon
	 */
	@Override
	public void supprimerBon(int numeroBon) {
		try {
			Bon b = bdi.findOne(numeroBon);
			if(b == null || !bdi.delete(b)) System.err.println("DELETE FAILED ON BON !");
			else System.out.println("Bon n° " + numeroBon + " supprimé.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Méthode qui affiche le bon dont l'User veut avoir le détail.
	 * 
	 * @param numeroBon as int
	 */
	@Override
	public void visualiser(int numeroBon) {
		try {
			if (bdi.findOne(numeroBon) != null) System.out.println(bdi.findOne(numeroBon));
			else System.err.println("BON NOT FOUND !");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
