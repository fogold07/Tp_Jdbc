package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnexionBdd;
import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.dao.Requetes;
import fr.diginamic.jdbc.entites.Article;

/**
 * Classe qui implémente les opérations du CRUD en base de données de la table Article.
 * 
 * @author Christian Ingold
 *
 */
public class ArticleDaoImpl implements ArticleDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * Etablissement de la connexion dans le constructeur.
	 * 
	 * @throws Exception
	 */
	public ArticleDaoImpl() /* throws Exception */ {
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
	 * Méthode qui permet d'extraire toute la liste des articles.
	 * 
	 * @return articles ArrayList
	 */
	@Override
	public List<Article> extraire() throws SQLException {
		List<Article> articles = new ArrayList<>();

		try {
			this.ps = this.con.prepareStatement(Requetes.TOUS_LES_ARTICLES);
			this.rs = this.ps.executeQuery();

			while (rs.next()) {
				Article a = new Article(rs.getInt("id"), rs.getString("ref"), rs.getString("designation"),
						rs.getDouble("prix"), rs.getInt("id_fou"));
				articles.add(a);
			}
			return articles;

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
	 * Méthode qui permet de créer un article en BdD.
	 * 
	 * @param article
	 */
	@Override
	public void creer(Article article) throws SQLException {
		try {
			this.ps = this.con.prepareStatement(Requetes.AJOUT_ARTICLE);
			this.ps.setString(1, article.getRef());
			this.ps.setString(2, article.getDesignation());
			this.ps.setDouble(3, article.getPrix());
			this.ps.setInt(4, article.getId_fou());
			this.ps.executeUpdate();

		} finally {
			if (this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}

	}

	/**
	 * Méthode qui met à jour un article.
	 * 
	 * @param article à mettre à jour
	 * @return nb ligne mise à jour as int
	 */
	@Override
	public int update(Article article) throws SQLException {
		try {
			this.ps = this.con.prepareStatement(Requetes.UPDATE_ARTICLE);

			this.ps.setString(1, article.getDesignation());
			this.ps.setDouble(2, article.getPrix());
			this.ps.setInt(3, article.getId_fou());
			this.ps.setString(4, article.getRef());

			int nb = this.ps.executeUpdate();
			return nb;

		} finally {
			if (this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}
	}

	/**
	 * Méthode qui supprime un article de la BdD ainsi que tous les éléments de la table Compo
	 * auxquels il est lié.
	 * 
	 * @param ref as String
	 * @return boolean
	 */
	@Override
	public boolean delete(Article article) throws SQLException {
		try {

			// SUPPRESSION DE LA COMPO LIEE A L'ARTICLE
			this.ps = this.con.prepareStatement(Requetes.SUPPR_COMPO_LIEE_ARTICLE);
			this.ps.setInt(1, article.getId());
			this.ps.executeUpdate();

			// SUPPRESSION DE L'ARTICLE
			this.ps = this.con.prepareStatement(Requetes.SUPPR_ARTICLE);
			this.ps.setInt(1, article.getId());
			int nb = this.ps.executeUpdate();

			return nb > 0 ? true : false;

		} finally {
			if (this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}
	}

	/**
	 * Méthode qui renvoie les informations d'un article.
	 * 
	 * @param ref as String
	 * @return elementTrouve as Article
	 */
	@Override
	public Article findOne(String ref) throws SQLException {
		try {
			this.ps = this.con.prepareStatement(Requetes.FIND_ONE_ARTICLE);
			this.ps.setString(1, ref);
			this.rs = this.ps.executeQuery();
			while (this.rs.next()) {
				Article elementTrouve = new Article(rs.getInt("id"), rs.getString("ref"), rs.getString("designation"),
						rs.getDouble("prix"), rs.getInt("id_fou"));
				return elementTrouve;
			}

		} finally {
			if (this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}
		return null;
	}

}
