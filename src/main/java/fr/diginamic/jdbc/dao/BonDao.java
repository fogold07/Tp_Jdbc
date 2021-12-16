package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Bon;

public interface BonDao {
	List<Bon> extraire() throws SQLException;
	void creer(Bon bon) throws SQLException;
	int update(Bon bon) throws SQLException;
	boolean delete(int numeroBon) throws SQLException;
	Bon findOne(int numeroBon) throws SQLException;
	void simpleView() throws SQLException;
}
