package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Compo;

public interface CompoDao {
//TODO Gérer des Compo pour faire le lien entre un article et un bon avec une qté
	// Méthode qui demande 
	List<Compo> extraire() throws SQLException;
	void creer(Compo compo) throws SQLException;
	//int update(String ancienNom , String nouveauNom) throws SQLException;
	boolean delete(int idComp) throws SQLException;
}
