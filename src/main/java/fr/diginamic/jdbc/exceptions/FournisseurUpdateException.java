package fr.diginamic.jdbc.exceptions;

public class FournisseurUpdateException extends Exception {

	public FournisseurUpdateException() {
		this("UPDATE FAILED !");
	}

	public FournisseurUpdateException(String message) {
		super(message);

	}


}
