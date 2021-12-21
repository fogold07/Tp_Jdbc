package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;

public interface FournisseurDao {
	List<Fournisseur> extraire() throws SQLException;
	void creer(Fournisseur fournisseur) throws SQLException;
	int update(String ancienNom , String nouveauNom) throws SQLException;
	boolean delete(Fournisseur fournisseur) throws SQLException;
	Fournisseur findOne(String nomFournisseur) throws SQLException ;
}
