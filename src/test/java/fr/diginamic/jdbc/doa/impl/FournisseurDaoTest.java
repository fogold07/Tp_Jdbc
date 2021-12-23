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
	
	/**
	 * Test unitaire qui vérifie la mise à jour d'un fournisseur.
	 * @throws SQLException
	 */
	@Test
	public void test_fournisseur_update() throws SQLException {
		Fournisseur f = new Fournisseur("toto");

		int nb = fdao.update(f.getNom(), "Mes fournisseurs");
		
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
	
	@Test
	public void test_fournisseur_delete() throws SQLException {
		Fournisseur f = fdao.findOne("TESTUNIT");
		
		Boolean result = fdao.delete(f);
		
		assertThat(result, is(true));
	}
	
	@Test 
	public void test_fournisseur_creer() {
		
	}
}
