package fr.diginamic.jdbc.service;

public interface CompoService {

	void creerCompo(String ref, int numeroBon, int qte);
	
	void recupererCompos();
	
	void updateCompo(int idCompo, int id_art, int id_bon, int qte);
	
	void supprimerCompo(int idCompo);
	
}
