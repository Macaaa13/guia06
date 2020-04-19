package died.guia06.excepciones;

public class LimiteMateriasMismoCicloException extends Exception {

	public LimiteMateriasMismoCicloException(String msg) {
		super("Error: " + msg);
	}
	
}
