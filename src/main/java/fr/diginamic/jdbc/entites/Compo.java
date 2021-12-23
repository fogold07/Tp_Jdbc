package fr.diginamic.jdbc.entites;

/**
 * Classe qui définit les attributs de l'élément Compo.
 * 
 * @author Christian Ingold
 *
 */

public class Compo {
	private int id;
	private int id_art;
	private int id_bon;
	private int qte;

	public Compo() {
		super();
	}

	public Compo(int id_art, int id_bon, int qte) {
		super();
		this.id_art = id_art;
		this.id_bon = id_bon;
		this.qte = qte;
	}

	public Compo(int id, int id_art, int id_bon, int qte) {
		super();
		this.id = id;
		this.id_art = id_art;
		this.id_bon = id_bon;
		this.qte = qte;
	}

	public int getId() {
		return id;
	}

	public int getId_art() {
		return id_art;
	}

	public int getId_bon() {
		return id_bon;
	}

	public int getQte() {
		return qte;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setId_art(int id_art) {
		this.id_art = id_art;
	}

	public void setId_bon(int id_bon) {
		this.id_bon = id_bon;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	@Override
	public String toString() {
		return "Compo [id=" + id + ", id_art=" + id_art + ", id_bon=" + id_bon + ", qte=" + qte + "]";
	}

}
