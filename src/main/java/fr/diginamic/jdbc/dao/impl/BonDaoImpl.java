package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnexionBdd;
import fr.diginamic.jdbc.dao.BonDao;
import fr.diginamic.jdbc.dao.Requetes;
import fr.diginamic.jdbc.entites.Bon;

/**
 * Classe qui implémente les opérations du CRUD en base de données de la table
 * Bon.
 * 
 * @author Christian Ingold
 *
 */
public class BonDaoImpl implements BonDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * Etablissement de la connexion dans le constructeur.
	 * 
	 * @throws Exception
	 */
	public BonDaoImpl() /* throws Exception */ {
		try {
			con = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// if(con == null) throw new SQLException("Connexion inexistante !");
	}

	/**
	 * Destructeur et fermeture automatique de la connexion à la BDD.
	 */
	@Override
	protected void finalize() throws Throwable {
		if (this.con != null)
			this.con.close();
	}

	/**
	 * Méthode qui permet d'extraire toute la liste des bons.
	 * 
	 * @return bon as ArrayList
	 */
	@Override
	public List<Bon> extraire() throws SQLException {
		List<Bon> bons = new ArrayList<>();

		try {
			this.ps = this.con.prepareStatement(Requetes.TOUS_LES_BONS);
			this.rs = this.ps.executeQuery();

			while (rs.next()) {
				Bon b = new Bon(rs.getInt("id"), rs.getInt("numero"), rs.getDate("date_cmde"), rs.getInt("delai"),
						rs.getInt("id_fou"));
				bons.add(b);
			}
			return bons;

		} finally {
			if (this.rs != null && !this.rs.isClosed()) {
				this.rs.close();
			}
			if (this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}
	}

	/**
	 * Méthode qui permet de créer un bon en BdD.
	 */
	@Override
	public Bon creer(Bon bon) throws SQLException {

		try {
			this.ps = this.con.prepareStatement(Requetes.AJOUT_BON);
			this.ps.setInt(1, bon.getNumero());
			this.ps.setDate(2, bon.getDate_cmde());
			// this.ps.setDate(2, new java.sql.Date(bon.getDate_cmde().getTime()));
			this.ps.setInt(3, bon.getDelai());
			this.ps.setInt(4, bon.getId_fou());
			this.ps.executeUpdate();
			
			//Requete pour retourner le bon crée
			this.ps = this.con.prepareStatement(Requetes.FIND_ONE_BON);
			this.ps.setInt(1, bon.getNumero());
			this.rs = this.ps.executeQuery();
			if (this.rs.next()) {
				Bon elementTrouve = new Bon(rs.getInt("id"), rs.getInt("numero"), rs.getDate("date_cmde"),
						rs.getInt("delai"), rs.getInt("id_fou"));
				return elementTrouve;
			}
			else return null;

		} finally {
			if (this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}

	}

	/**
	 * Méthode qui met à jour un bon.
	 * 
	 * @param bon as Bon (bon avec information à mettre à jour)
	 * @return nb ligne mise à jour as int
	 */
	@Override
	public int update(Bon bon) throws SQLException {
		try {
			this.ps = this.con.prepareStatement(Requetes.UPDATE_BON);
			this.ps.setDate(1, bon.getDate_cmde());
			// this.ps.setDate(1, new java.sql.Date(bon.getDate_cmde().getTime()));
			this.ps.setInt(2, bon.getDelai());
			this.ps.setInt(3, bon.getId_fou());
			this.ps.setInt(4, bon.getNumero());

			int nb = this.ps.executeUpdate();

			return nb;
		} finally {
			if (this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}
	}

	/**
	 * Méthode qui supprime un bon de la BdD ainsi que tous les éléments de la table Compo
	 * auxquels il est lié.
	 * 
	 * @param numeroBon as int
	 * @return boolean
	 */
	@Override
	public boolean delete(Bon bon) throws SQLException {
		try {
			// SUPPRESSION DE LA COMPO LIEE AU BON
			this.ps = this.con.prepareStatement(Requetes.SUPPR_COMPO_LIEE_BON);
			this.ps.setInt(1, bon.getId());
			this.ps.executeUpdate();

			// SUPPRESSION DU BON
			this.ps = this.con.prepareStatement(Requetes.SUPPR_BON);
			this.ps.setInt(1, bon.getId());
			int nb = this.ps.executeUpdate();

			return nb > 0 ? true : false;

		} finally {
			if (this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}
	}

	/**
	 * Méthode qui renvoie les informations d'un bon.
	 * 
	 * @param numeroBon as int
	 * @return elementTrouve as Bon
	 */
	@Override
	public Bon findOne(int numeroBon) throws SQLException {
		try {
			this.ps = this.con.prepareStatement(Requetes.FIND_ONE_BON);
			this.ps.setInt(1, numeroBon);
			this.rs = this.ps.executeQuery();
			if (this.rs.next()) {
				Bon elementTrouve = new Bon(rs.getInt("id"), rs.getInt("numero"), rs.getDate("date_cmde"),
						rs.getInt("delai"), rs.getInt("id_fou"));
				return elementTrouve;
			}
			else return null;

		} finally {
			if (this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}
	}

}
