package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Bon;

/**
* Interface qui définit les méthodes obligatoires du CRUD pour le table Bon.
* 
* @author Christian Ingold
*
*/
public interface BonDao {
	List<Bon> extraire() throws SQLException;
	void creer(Bon bon) throws SQLException;
	int update(Bon bon) throws SQLException;
	boolean delete(Bon bon) throws SQLException;
	Bon findOne(int numeroBon) throws SQLException;
}
