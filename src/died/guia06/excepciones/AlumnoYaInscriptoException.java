package died.guia06.excepciones;

public class AlumnoYaInscriptoException extends Exception {
	
	public AlumnoYaInscriptoException(String msg) {
		super("Error: " + msg);
	}
	
}
