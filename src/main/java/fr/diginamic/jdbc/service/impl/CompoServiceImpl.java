package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.dao.BonDao;
import fr.diginamic.jdbc.dao.CompoDao;
import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.dao.impl.CompoDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Compo;

public class CompoServiceImpl {
	private CompoDao cdi = new CompoDaoImpl();
	
	/** Méthode qui crée une compo à partir des éléments saisis en console
	 * @param ref
	 * @param numeroBon
	 * @param qte
	 */
	public void creerCompo(String ref, int numeroBon, int qte) {

		ArticleDao adi = new ArticleDaoImpl();
		BonDao bdi = new BonDaoImpl();
		
		try {
			Article art = adi.findOne(ref);
			Bon bon = bdi.findOne(numeroBon);

			Compo compo = new Compo(art.getId(), bon.getId(), qte);
			cdi.creer(compo);
			System.out.println("Compo ajouté à la table !");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	/** Méthode qui affiche la liste de toutes les compos
	 * 
	 */
	public void recupererCompos() {
		List<Compo> compos = new ArrayList<Compo>();
		
		try {
			compos = cdi.extraire();
			compos.stream().forEach(c -> System.out.println(c));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void supprimerCompo(int idCompo) {
		try {
			
			boolean isDelete = cdi.delete(idCompo);
			if (isDelete) {
				System.out.println("Compo # " + idCompo + " supprimée de la table");
			} else {
				System.out.println("DELETE FAILED !");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}

}
