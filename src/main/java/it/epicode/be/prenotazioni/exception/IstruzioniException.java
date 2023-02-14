package it.epicode.be.prenotazioni.exception;

public class IstruzioniException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IstruzioniException(String message) {
		super("Error: " + message);
	}
}
