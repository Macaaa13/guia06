package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	//Constructor
	public Alumno(String n, Integer l) {
		nombre = n;
		nroLibreta = l;
		cursando = new ArrayList<Curso>();
		aprobados = new ArrayList<Curso>();
	}
	
	//Getters y Setters
	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}
	
	public List<Curso> getCursando() {
		return cursando;
	}

	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}
	
	//M�todos
	public int creditosObtenidos() {
		int creditos = 0;
		if(!(aprobados.isEmpty())) {
			for(Curso c: aprobados) {
				creditos += c.getCreditos();
			}
		}
		return creditos;
	}

	public void aprobar(Curso c) {
		/** Si la lista est� vac�a, ningun curso puede ser aprobado
		 *  Si el curso no est� en la lista, no se curs� y no puede ser aprobado
		 *  Si intenta aprobar un curso ya aprobado, �ste no se encontrar�a en la lista cursando
		 */
		if(!(cursando.isEmpty()) && cursando.contains(c)) {
			cursando.remove(c);
			aprobados.add(c);
			c.getInscriptos().remove(this);
		}
	}

	public void inscripcionAceptada(Curso c) {
		if(c.inscribir(this)) {
			System.out.println("La inscripci�n del alumno " + this.nombre + " fue aceptada");
		}
		else {
			System.out.println("La inscripci�n del alumno " + this.nombre + " fue rechazada");
		}
	}
	
	@Override
	public boolean equals(Object o) {
		return (o instanceof Alumno && ((Alumno)o).nroLibreta == this.nroLibreta);
	}

	@Override
	public int compareTo(Alumno o) {
		/**Retorna:
		* Negativo si el nombre del alumno o va despu�s
		* 0 si son iguales
		* Positivo si el nombre del alumno o va antes
		*/
		return this.nombre.compareTo(o.nombre);
	}

	@Override
	public String toString() {
		return nombre + ", Libreta: " + nroLibreta + ", Cr�ditos: " + this.creditosObtenidos();
	}
	
	

}
