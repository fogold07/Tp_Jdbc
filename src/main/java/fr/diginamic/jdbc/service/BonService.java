package fr.diginamic.jdbc.service;

import java.text.ParseException;

public interface BonService {

	void creerBon(int numero, String dateStr, int delai, int id_fou) throws ParseException;
	
	void updateBon(int numero, String dateStr, int delai, int id_fou) throws ParseException;
	
	void recupererBons(int paramSousMenu);
	
	void supprimerBon(int numeroBon);
	
	void visualiser(int numeroBon);
	
}
