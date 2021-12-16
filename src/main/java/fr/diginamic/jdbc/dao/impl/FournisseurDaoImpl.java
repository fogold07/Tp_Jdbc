package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnexionBdd;
import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.Requetes;
import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoImpl implements FournisseurDao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**Etablissement de la connexion dans le constructeur
	 * @throws Exception
	 */
	public FournisseurDaoImpl() /*throws Exception*/ {
		try {
			con = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//if(con == null) throw new SQLException("Connexion inexistante !");
	}

	/**
	 * Destructeur et fermeture automatique de la connexion à la BDD
	 */
	@Override
	protected void finalize() throws Throwable {
		if(this.con != null) this.con.close();
	}
	
	/**
	 * Méthode qui permet d'extraire toute le liste des fournisseurs
	 * @return fournisseurs ArrayList
	 */
	@Override
	public List<Fournisseur> extraire() throws SQLException {
		List<Fournisseur> fournisseurs = new ArrayList<>();
		
		try {
			this.ps = this.con.prepareStatement(Requetes.TOUS_LES_FOURNISSEURS);
			this.rs = this.ps.executeQuery();
			
			while(rs.next()) {
				Fournisseur f = new Fournisseur(rs.getInt("id"), rs.getString("nom"));
				fournisseurs.add(f);
			}
			return fournisseurs;
		
		} finally {
			if(this.rs != null && !this.rs.isClosed()) {
				this.rs.close();
			}
			if(this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}
	}

	/**
	 * méthode qui permet de créer un fournisseur en BdD
	 */
	@Override
	public void creer(Fournisseur fournisseur) throws SQLException {
		try {
			this.ps = this.con.prepareStatement(Requetes.AJOUT_FOURNISSEUR);
			this.ps.setString(1, fournisseur.getNom());
			int nb = this.ps.executeUpdate();
			System.out.println(nb + " nouvelle entrée. " + fournisseur.getNom() + " ajouté la table Fournisseur");
			
		} finally {
			if(this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}

	}

	/**
	 * Méthode qui met à jour le nom d'un fournisseur
	 * @return nb ligne mise à jour as int
	 */
	@Override
	public int update(String ancienNom, String nouveauNom) throws SQLException {
		try {
			this.ps = this.con.prepareStatement(Requetes.UPDATE_FOURNISSEUR);

			this.ps.setString(1, nouveauNom);
			this.ps.setString(2, ancienNom);
			int nb = this.ps.executeUpdate();
			//System.out.println(nb + "ligne(s) update. Ancien nom : " + ancienNom + ", Nouveau nom: " + nouveauNom);
			return nb;
		} finally {
			if(this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}
		
	}

	/**
	 * Méthode qui suprrime un fournisseur
	 * @param nomFournisseur as String
	 * @return boolean 
	 */
	@Override
	public boolean delete(String nomFournisseur) throws SQLException {
		try {
			this.ps = this.con.prepareStatement(Requetes.SUPPR_FOURNISSEUR);
			this.ps.setString(1, nomFournisseur);
			int nb = this.ps.executeUpdate();
			return nb > 0 ? true : false;

		} finally {
			if(this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}

	}

	/**
	 * Méthode qui renvoie les inforamtions d'un article
	 * @param nomFournisseur as String
	 * @return fournisseur as Fournisseur
	 */
	
	@Override
	public Fournisseur findOne(String nomFournisseur) throws SQLException {
		
		try {
			this.ps = this.con.prepareStatement(Requetes.FIND_ONE_FOURNISSEUR);
			this.ps.setString(1, nomFournisseur);
			this.rs = this.ps.executeQuery();
			while(this.rs.next()) {
				Fournisseur elementTrouve = new Fournisseur(rs.getInt("id"), rs.getString("nom"));
				return elementTrouve;
			}
			
		} finally {
			if(this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
		}
		return null;
	}

}
