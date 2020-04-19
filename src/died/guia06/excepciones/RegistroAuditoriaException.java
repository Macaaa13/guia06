package died.guia06.excepciones;

public class RegistroAuditoriaException extends Exception {

	public RegistroAuditoriaException(String msg) {
		super("Error: " + msg);
	}
	
}
