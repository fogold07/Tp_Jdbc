package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;

/**
 * Interface qui définit les méthodes obligatoires du CRUD pour le table Fournisseur.
 * 
 * @author Christian Ingold
 *
 */
public interface FournisseurDao {
	List<Fournisseur> extraire() throws SQLException;
	Fournisseur creer(Fournisseur fournisseur) throws SQLException;
	int update(String ancienNom , String nouveauNom) throws SQLException;
	boolean delete(Fournisseur fournisseur) throws SQLException;
	Fournisseur findOne(String nomFournisseur) throws SQLException ;
}
