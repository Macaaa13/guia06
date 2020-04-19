package died.guia06.comparadores;

import java.util.Comparator;

import died.guia06.Alumno;

public class CompararNombre implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		return o1.compareTo(o2);
	}

}
