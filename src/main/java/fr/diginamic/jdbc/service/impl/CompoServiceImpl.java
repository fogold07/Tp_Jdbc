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
	
	/** Méthode qui met à jour la compo avec les informations saisies en console
	 * @param idCompo
	 * @param id_art
	 * @param id_bon
	 * @param qte
	 */
	public void updateCompo(int idCompo, int id_art, int id_bon, int qte) {
		Compo c = new Compo(idCompo, id_art, id_bon, qte);
		int nb; 
		try {
			nb = cdi.update(c);
			String str = nb > 0 ? nb + " ligne update" : "UPDATE FAILED !";
			System.out.println(str);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**Méthode qui supprime la compo dont l'id est saisi.
	 * @param idCompo
	 */
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
