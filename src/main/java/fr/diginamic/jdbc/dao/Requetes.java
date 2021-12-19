package fr.diginamic.jdbc.dao;

public class Requetes {

	//table Fournisseur
	public static final String TOUS_LES_FOURNISSEURS = "SELECT * FROM fournisseur";
	
	public static final String FIND_ONE_FOURNISSEUR = "SELECT * FROM fournisseur WHERE nom=? ";
	
	public static final String AJOUT_FOURNISSEUR = "INSERT INTO fournisseur(nom) VALUES (?)";

	public static final String UPDATE_FOURNISSEUR = "UPDATE fournisseur SET nom =? WHERE nom =?";

	public static final String SUPPR_FOURNISSEUR = "DELETE FROM fournisseur WHERE nom =?";
	
	//table Article
	public static final String TOUS_LES_ARTICLES = "SELECT * FROM article";
	
	public static final String FIND_ONE_ARTICLE = "SELECT * FROM article WHERE ref=?";
	
	public static final String AJOUT_ARTICLE = "INSERT INTO article(ref,designation,prix,id_fou) VALUES (?,?,?,?)";

	public static final String UPDATE_ARTICLE = "UPDATE article SET designation=?, prix=?, id_fou=?  WHERE ref=?";

	public static final String SUPPR_ARTICLE = "DELETE FROM article WHERE ref =?";
		
	//table Bon
	public static final String TOUS_LES_BONS = "SELECT * FROM bon";
	
	public static final String FIND_ONE_BON = "SELECT * FROM bon WHERE numero=?";
	
	public static final String AJOUT_BON = "INSERT INTO bon(numero, date_cmde, delai, id_fou) VALUES (?,?,?,?)";

	public static final String UPDATE_BON = "UPDATE bon SET date_cmde=?, delai=?, id_fou=? WHERE numero=?";

	public static final String SUPPR_BON = "DELETE FROM bon WHERE numero =?";
	
	
	//table Compo
	public static final String TOUTES_LES_COMPOS =  "SELECT * FROM compo";
	
	public static final String AJOUT_COMPO = "INSERT INTO compo(id_art, id_bon, qte) VALUES (?,?,?)";
	
	public static final String SUPPR_COMPO = "DELETE FROM compo WHERE id =?";
}
