package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import died.guia06.comparadores.*;
import died.guia06.excepciones.*;
import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	//Constructores
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(Integer id, String nombre, Integer ciclo, Integer cupo, Integer creditos, Integer creditosReq) {
		this.id = id;
		this.nombre = nombre;
		this.cicloLectivo = ciclo;
		this.cupo = cupo;
		this.creditos = creditos;
		this.creditosRequeridos = creditosReq;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	//Getters y Setters
	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}

	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}
	
	public List<Alumno> getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(List<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}

	public Integer getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public Registro getLog() {
		return log;
	}

	public void setLog(Registro log) {
		this.log = log;
	}

	//MÈtodos
	/**
	 * Este m√©todo, verifica si el alumno se puede inscribir y si es as√≠ lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que est√° inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno est√° inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simult√°neo a no m√°s de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		boolean b = true;
		//El alumno no puede inscribirse a un curso al que ya est· inscripto
		if(this.inscriptos.contains(a)) {
			System.out.println("Ya est· inscripto al curso");
			b = false;
		}
		//El alumno debe tener como mÌnimo los crÈditos necesarios
		if(a.creditosObtenidos() < this.creditosRequeridos) {
			System.out.println("No posee crÈditos suficientes para cursar");
			b = false;
		}
		//El curso debe tener cupo
		if(!(inscriptos.isEmpty()) && this.inscriptos.size() == this.cupo) {
			System.out.println("El curso no tiene cupo");
			b = false;
		}
		//El alumno solo puede hacer 3 cursos del mismo ciclo lectivo al mismo tiempo 
		if(this.cantidadCicloLectivo(a.getCursando(), this.cicloLectivo)==3) {
			System.out.println("Solo se pueden hacer 3 cursos con el mismo ciclo lectivo a la vez");
			b = false;
		}
		//Si b es true significa que se cumplieron las condiciones anteriores
		if(b){
			try {
				log.registrar(this, "inscribir ",a.toString());
				this.inscriptos.add(a);
				a.getCursando().add(this);
			} catch (IOException e) {
				System.out.println("Error al registrar inscripciÛn");
				b = false;
			}
		}
		return b;
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptosPorNombre() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			CompararNombre comparador = new CompararNombre();
			Collections.sort(inscriptos, comparador);
			System.out.println(inscriptos);
		} catch (IOException e) {
			System.out.println("Error al registrar impresiÛn de listado por nombre");
		}
	}
	
	/**
	 * imprime los inscriptos ordenados por cantidad de crÈditos
	 */
	public void imprimirInscriptosPorCreditos() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			CompararCreditos comparador = new CompararCreditos();
			Collections.sort(inscriptos, comparador);
			System.out.println(inscriptos);
		} catch (IOException e) {
			System.out.println("Error al registrar impresiÛn de listado por crÈditos");
		}
	}
	
	/**
	 * imprime los inscriptos por n˙mero de libreta
	 */
	public void imprimirInscriptosPorLibreta() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
			CompararLibreta comparador = new CompararLibreta();
			Collections.sort(inscriptos, comparador);
			System.out.println(inscriptos);
		} catch (IOException e) {
			System.out.println("Error al registrar impresiÛn de listado por libreta");
		}
	}
	
	//Paso 07	
	public void inscribirAlumno(Alumno a) throws AlumnoYaInscriptoException, CreditosInsuficientesException, CupoLlenoException, LimiteMateriasMismoCicloException, IOException, RegistroAuditoriaException {
		System.out.println("Inscribiendo a "+ a.getNombre() +" en el curso "+ this.nombre+"...");
		//El alumno no puede inscribirse a un curso al que ya est· inscripto
		if(this.inscriptos.contains(a)) {
			throw new AlumnoYaInscriptoException("Ya est· inscripto al curso");
		}
		//El alumno debe tener como mÌnimo los crÈditos necesarios
		if(a.creditosObtenidos() < this.creditosRequeridos) {
			throw new CreditosInsuficientesException("No posee crÈditos suficientes para cursar");
		}
		//El curso debe tener cupo
		if(!(inscriptos.isEmpty()) && this.inscriptos.size() == this.cupo) {
			throw new CupoLlenoException("El curso est· lleno");
		}
		//El alumno solo puede hacer 3 cursos del mismo ciclo lectivo al mismo tiempo 
		if(this.cantidadCicloLectivo(a.getCursando(), this.cicloLectivo)==3) {
			throw new LimiteMateriasMismoCicloException("Solo se pueden hacer 3 cursos con el mismo ciclo lectivo a la vez");
		}
		try{
			log.registrar(this, "inscribir ",a.toString());
			this.inscriptos.add(a);
			a.getCursando().add(this);
		}
		catch (IOException e) {
			throw new RegistroAuditoriaException("Error al registrar la inscripciÛn");
		}	
	}
	
	//MÈtodos auxiliares
	public int cantidadCicloLectivo(List<Curso> cursando, Integer ciclo) {
		/** Se pasa como argumentos la lista de cursos que el alumno est· cursando
		 *  y el ciclo del curso al que se quiere inscribir.
		 *  Un alumno solo puede cursar 3 cursos del mismo ciclo lectivo, por lo que el
		 *  mÈtodo devuelve la cantidad de cursos que el alumno est· cursando con 
		 *  el mismo ciclo lectivo que el curso al que se quiere inscribir.
		 */
		int cantCiclo = 0;
		if(!cursando.isEmpty()) {
			for(Curso c: cursando) {
				if(c.cicloLectivo == ciclo) {
					cantCiclo++;
				}
			}
		}
		return cantCiclo;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
