package died.guia06.excepciones;

public class CupoLlenoException extends Exception {

	public CupoLlenoException(String msg) {
		super("Error: " + msg);
	}
}
