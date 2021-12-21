package fr.diginamic.jdbc.dao;

public class Requetes {

	//table Fournisseur
	public static final String TOUS_LES_FOURNISSEURS = "SELECT * FROM fournisseur";
	
	//public static final String FIND_ONE_FOURNISSEUR = "SELECT * FROM fournisseur WHERE nom=? ";
	
	public static final String FIND_ONE_FOURNISSEUR = "SELECT * FROM fournisseur WHERE nom=:nom ";
	
	public static final String AJOUT_FOURNISSEUR = "INSERT INTO fournisseur(nom) VALUES (?)";

	public static final String UPDATE_FOURNISSEUR = "UPDATE fournisseur SET nom =? WHERE nom =?";

	public static final String SUPPR_FOURNISSEUR = "DELETE FROM fournisseur WHERE id =?";
	
	//SUPPRESSION EN CASCADE DES ELEMENTS EN LIAISON AVEC FOURNISSEUR A SUPPRIMER	
	public static final String SUPPR_ARTICLE_LIE_AU_FOURNISSEUR = "DELETE FROM article WHERE id_fou = ?";
	
	public static final String SUPPR_BON_LIE_AU_FOURNISSEUR = "DELETE FROM bon WHERE id_fou = ?";
	
	public static final String SUPPR_COMPO_LIE_AU_FOURNISSEUR = "DELETE FROM compo WHERE id_art IN (SELECT a.id FROM article a WHERE a.id_fou = ?) OR id_bon IN (SELECT b.id FROM bon b WHERE b.id_fou = ?)";
	
	//table Article
	public static final String TOUS_LES_ARTICLES = "SELECT * FROM article";
	
	public static final String FIND_ONE_ARTICLE = "SELECT * FROM article WHERE ref=?";
	
	public static final String AJOUT_ARTICLE = "INSERT INTO article(ref,designation,prix,id_fou) VALUES (?,?,?,?)";

	public static final String UPDATE_ARTICLE = "UPDATE article SET designation=?, prix=?, id_fou=?  WHERE ref=?";

	public static final String SUPPR_ARTICLE = "DELETE FROM article WHERE id =?";
	
	
		
	//table Bon
	public static final String TOUS_LES_BONS = "SELECT * FROM bon";
	
	public static final String FIND_ONE_BON = "SELECT * FROM bon WHERE numero=?";
	
	public static final String AJOUT_BON = "INSERT INTO bon(numero, date_cmde, delai, id_fou) VALUES (?,?,?,?)";

	public static final String UPDATE_BON = "UPDATE bon SET date_cmde=?, delai=?, id_fou=? WHERE numero=?";

	public static final String SUPPR_BON = "DELETE FROM bon WHERE id =?";
	
	
	//table Compo
	public static final String TOUTES_LES_COMPOS =  "SELECT * FROM compo";
	
	public static final String AJOUT_COMPO = "INSERT INTO compo(id_art, id_bon, qte) VALUES (?,?,?)";
	
	public static final String UPDATE_COMPO = "UPDATE compo SET id_art=?, id_bon=?, qte=? WHERE id=?";
	
	public static final String SUPPR_COMPO = "DELETE FROM compo WHERE id =?";
	
	public static final String SUPPR_COMPO_LIEE_ARTICLE = "DELETE FROM compo WHERE id_art =?";
	
	public static final String SUPPR_COMPO_LIEE_BON = "DELETE FROM compo WHERE id_bon =?";
}
