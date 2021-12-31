package fr.diginamic.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe qui permet de gérer la connexion à la base de données.
 * 
 * @author chris
 *
 */
public class ConnexionBdd {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		Connection connection = ConnexionBdd.getConnection("database");

		return connection;
	}

	public static Connection getConnection(String database) throws SQLException, ClassNotFoundException {

		ResourceBundle fichierConfig = ResourceBundle.getBundle("database");

		String driverName = fichierConfig.getString("database.driver");
		String url = fichierConfig.getString("database.url");
		String user = fichierConfig.getString("database.user");
		String password = fichierConfig.getString("database.password");

		Class.forName(driverName);
		Connection connection = DriverManager.getConnection(url, user, password);

		return connection;

	}

}
