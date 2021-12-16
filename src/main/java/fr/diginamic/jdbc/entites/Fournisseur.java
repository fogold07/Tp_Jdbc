package fr.diginamic.jdbc.entites;

/** Construit un fournisseur
 * @author christian I
 *
 */
public class Fournisseur {

	private int id;
	private String nom;
	
	/** Constructeur de fourniqsseur
	 */
	public Fournisseur() {
		super();
	}
	
	/** Constructeur de fourniqsseur
	 * @param nom as String
	 */
	public Fournisseur(String nom) {
		super();
		this.nom = nom;
	}
	
	/** Constructeur de fourniqsseur
	 * @param id as int
	 * @param nom as String
	 */
	public Fournisseur(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}


	/** getter getId
	 * @return
	 */
	public int getId() {
		return id;
	}

	/** getter getNom
	 * @return
	 */
	public String getNom() {
		return nom;
	}


	/** setter de l'id
	 * @param id to set id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**setter du nom
	 * @param nom to set nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public String toString() {
		return "[id: " + id + ", nom: " + nom + "]";
	}
	
	
}

