package died.guia06;

import java.util.Comparator;

public class CompararCreditos implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		/** o1 < o2 --> Negativo
		 *  o1 > o2 --> Positivo
		 *  o1 = o2 --> Cero
		 */
		return o1.creditosObtenidos() - o2.creditosObtenidos();
	}

}
