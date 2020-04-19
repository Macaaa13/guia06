package died.guia06.excepciones;

public class CreditosInsuficientesException extends Exception {

	public CreditosInsuficientesException(String msg) {
		super("Error: " + msg);
	}
	
}
