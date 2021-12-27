package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnexionBdd;
import fr.diginamic.jdbc.dao.CompoDao;
import fr.diginamic.jdbc.dao.Requetes;
import fr.diginamic.jdbc.entites.Compo;

/**
 * Classe qui implémente les opérations du CRUD en base de données
 * 
 * @author Christian Ingold
 *
 */
public class CompoDaoImpl implements CompoDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * Etablissement de la connexion dans le constructeur
	 * 
	 * @throws Exception
	 */
	public CompoDaoImpl() /* throws Exception */ {
		try {
			con = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// if(con == null) throw new SQLException("Connexion inexistante !");
	}

	/**
	 * Destructeur et fermeture automatique de la connexion à la BDD
	 */
	@Override
	protected void finalize() throws Throwable {
		if (this.con != null)
			this.con.close();
	}

	/**
	 * Méthode qui renvoie toutes les compos en base de données
	 * 
	 * @return List Compos
	 */
	@Override
	public List<Compo> extraire() throws SQLException {
		List<Compo> compos = new ArrayList<>();

		try {
			this.ps = this.con.prepareStatement(Requetes.TOUTES_LES_COMPOS);
			this.rs = this.ps.executeQuery();

			while (rs.next()) {
				Compo c = new Compo(rs.getInt("id"), rs.getInt("id_art"), rs.getInt("id_bon"), rs.getInt("qte"));
				compos.add(c);
			}
			return compos;

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
	 * Méthode qui crée une compo en base de données
	 * 
	 * @param compo
	 */
	@Override
	public int creer(Compo compo) throws SQLException {
		try {
			this.ps = this.con.prepareStatement(Requetes.AJOUT_COMPO);
			this.ps.setInt(1, compo.getId_art());
			this.ps.setInt(2, compo.getId_bon());
			this.ps.setInt(3, compo.getQte());
			int nb = this.ps.executeUpdate();
			return nb;
		
		} finally {
			if (this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}

	}

	/**
	 * Méthode qui supprime une composition dont l'id est passé en paramètre et
	 * retour si oui ou non la suppression a eu lieu
	 * @param idCompo as int
	 * @return boolean
	 */
	@Override
	public boolean delete(int idComp) throws SQLException {
		try {
			this.ps = this.con.prepareStatement(Requetes.SUPPR_COMPO);
			this.ps.setInt(1, idComp);
			int nb = this.ps.executeUpdate();
			return nb > 0 ? true : false;

		} finally {
			if (this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}
	}

	/**Méthode qui met à jour une compo
	 *@param compo
	 *@return nb ligne mise à jour
	 */
	@Override
	public int update(Compo compo) throws SQLException {
		try {
			this.ps = this.con.prepareStatement(Requetes.UPDATE_COMPO);
			this.ps.setInt(1, compo.getId_art());
			this.ps.setInt(2, compo.getId_bon());
			this.ps.setInt(3, compo.getQte());
			this.ps.setInt(4, compo.getId());
			
			int nb = this.ps.executeUpdate();
			return nb;
		} finally {
			if(this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}
	}

}
