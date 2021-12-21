package fr.diginamic.jdbc.exceptions;

public class FournisseurNotFoundException extends Exception {

	public FournisseurNotFoundException() {
		this("FOURNISSEUR NOT FOUND !");
	}

	public FournisseurNotFoundException(String message) {
		super(message);

	}


}
