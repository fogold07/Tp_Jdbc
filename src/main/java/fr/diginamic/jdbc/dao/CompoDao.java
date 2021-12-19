package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Compo;

public interface CompoDao {

	List<Compo> extraire() throws SQLException;
	void creer(Compo compo) throws SQLException;
	int update(Compo compo) throws SQLException;
	boolean delete(int idComp) throws SQLException;
}
