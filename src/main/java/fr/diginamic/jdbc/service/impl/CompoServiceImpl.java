package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
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
	
	public void creerCompo(String ref, int numeroBon, int qte) {

		ArticleDao adi = new ArticleDaoImpl();
		BonDao bdi = new BonDaoImpl();
		
		try {
			Article art = adi.findOne(ref);
			Bon bon = bdi.findOne(numeroBon);

			Compo compo = new Compo(art.getId(), bon.getId(), qte);
			cdi.creer(compo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public List<Compo> recupererCompos() {
		try {
			return cdi.extraire();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
