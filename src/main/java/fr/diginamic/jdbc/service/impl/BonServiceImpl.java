package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = sdf1.parse(dateStr);
		java.sql.Date dateSql = new java.sql.Date(date.getTime());
		
		
		Bon bon = new Bon(numero, dateSql, delai, id_fou);
		try {
			bdi.creer(bon);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	/** Méthode qui récupère la saisie de l'User pour la mise à jour d'un bon
	 * @param numero
	 * @param dateStr
	 * @param delai
	 * @param id_fou
	 * @return int nb bon mis à jour
	 * @throws ParseException
	 */
	public int updateBon(int numero, String dateStr, int delai, int id_fou) throws ParseException {
		// conversion du String en sql.date
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = sdf1.parse(dateStr);
		java.sql.Date dateSql = new java.sql.Date(date.getTime());
		
		Bon bon = new Bon(numero, dateSql, delai, id_fou);
		try {
			bon.setNumero(numero);
			return bdi.update(bon);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	/** Méthode qui renvoie la liste des bons
	 * @return List des bons
	 */
	public List<Bon> recupererBons() {
		try {
			return bdi.extraire();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/** Méthode qui supprime le bon du numéro saisie par l'User
	 * @param numéro du bon
	 * @return boolean
	 */
	public boolean supprimerBon(int numeroBon) {
		try {
			return bdi.delete(numeroBon);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	

	/** Méthode qui affiche le bon dont l'User veut le détail
	 * @param numeroBon
	 * @return bon
	 */
	public Bon visualiser(int numeroBon) {
		try {
			return bdi.findOne(numeroBon);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	/** Méthode qui affiche une vue simplifiée des bons
	 * (numéro de bon)
	 */
	public void vueSimplifie() {
		try {
			bdi.simpleView();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
