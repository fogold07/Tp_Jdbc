package fr.diginamic.jdbc.entites;

import java.sql.Date;

//import java.util.Date;

public class Bon {
	private int id; 
	private int numero; 
	private Date date_cmde;
	private int delai; 
	private int id_fou;
	
	public Bon() {
		super();
	}


	public Bon(int numero, int delai, int id_fou) {
		super();
		this.numero = numero;
		this.date_cmde = new java.sql.Date((new java.util.Date()).getTime());
		this.delai = delai;
		this.id_fou = id_fou;
	}
	
	public Bon(int numero, Date date_cmde, int delai, int id_fou) {
		super();
		this.numero = numero;
		this.date_cmde = date_cmde;
		this.delai = delai;
		this.id_fou = id_fou;
	}

	public Bon(int id, int numero, Date date_cmde, int delai, int id_fou) {
		super();
		this.id = id;
		this.numero = numero;
		this.date_cmde = date_cmde;
		this.delai = delai;
		this.id_fou = id_fou;
	}

	public int getId() {
		return id;
	}


	public int getNumero() {
		return numero;
	}


	public Date getDate_cmde() {
		return date_cmde;
	}


	public int getDelai() {
		return delai;
	}


	public int getId_fou() {
		return id_fou;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public void setDate_cmde(Date date_cmde) {
		this.date_cmde = date_cmde;
	}


	public void setDelai(int delai) {
		this.delai = delai;
	}


	public void setId_fou(int id_fou) {
		this.id_fou = id_fou;
	}


	@Override
	public String toString() {
		return "Bon [id=" + id + ", numero=" + numero + ", date_cmde=" + date_cmde + ", delai=" + delai + ", id_fou="
				+ id_fou + "]";
	}
	
	
	
}
