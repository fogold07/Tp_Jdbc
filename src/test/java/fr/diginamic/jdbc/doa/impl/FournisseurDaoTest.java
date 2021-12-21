package fr.diginamic.jdbc.doa.impl;

import java.sql.SQLException;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoTest {

	private FournisseurDao fdao = new FournisseurDaoImpl();
	
	@Test
	public void test_fournisseur_update() throws SQLException {
		Fournisseur f1 = new Fournisseur("Mes fournisseurs");

		int nb = fdao.update(f1.getNom(), "toto");
		
		assertThat(nb, is(1));
	}
	
	@Test 
	public void test_fournisseur_findOne() throws SQLException {
		String nom = "FDM SA";
		
		Fournisseur f = null;
		
		f = fdao.findOne(nom);
		
		assertNotNull(f);
		assertThat(f.getNom(), is(equalTo("FDM SA")));
		//assertNull(f);
		
	}
}
