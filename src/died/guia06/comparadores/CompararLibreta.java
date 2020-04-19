package died.guia06.comparadores;

import java.util.Comparator;

import died.guia06.Alumno;

public class CompararLibreta implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		//Ordena de menor a mayor
		return o1.getNroLibreta() - o2.getNroLibreta();
	}

}
