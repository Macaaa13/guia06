package died.guia06.comparadores;

import java.util.Comparator;

import died.guia06.Alumno;

public class CompararCreditos implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		/** Ordena de menor a mayor
		 *  o1 < o2 --> Negativo
		 *  o1 > o2 --> Positivo
		 *  o1 = o2 --> Cero, en este caso pasan a compararse por nombre
		 */
		if(o1.creditosObtenidos() - o2.creditosObtenidos() == 0) {
			CompararNombre comparador = new CompararNombre();
			return comparador.compare(o1, o2);
		}
		else {
			return o1.creditosObtenidos() - o2.creditosObtenidos();
		}
	}

}
