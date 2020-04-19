package died.guia06;

import java.io.IOException;

import died.guia06.excepciones.AlumnoYaInscriptoException;
import died.guia06.excepciones.CreditosInsuficientesException;
import died.guia06.excepciones.CupoLlenoException;
import died.guia06.excepciones.LimiteMateriasMismoCicloException;
import died.guia06.excepciones.RegistroAuditoriaException;

public class App {

	public static void main(String[] args) {
		
		Alumno a1 = new Alumno("Juan", 100);
		Alumno a2 = new Alumno("Manuel", 101);
		Alumno a3 = new Alumno("Celeste", 105);
		Alumno a4 = new Alumno("Sol", 107);
		Alumno a5 = new Alumno("Matias", 110);
		Alumno a6 = new Alumno("Anna", 111);
		
		//ID, nombre, ciclo lectivo, cupo, creditos, creditos requeridos
		Curso c1 = new Curso(1,"Física",1,3,5,0);
		Curso c2 = new Curso(2,"AMI",1,3,5,0);
		Curso c3 = new Curso(3,"AGA",1,3,5,0);
		Curso c4 = new Curso(4,"Algoritmos",1,4,5,0);
		Curso c5 = new Curso(5,"AMII",2,3,10,15);
		Curso c6 = new Curso(6,"Física 2",2,3,10,10);
		Curso c7 = new Curso(7,"Química",2,2,10,10);
		Curso c8 = new Curso(8, "Inglés",2,4,5,5);
		
		
		// ------ Primera Inscripción ------
		
		//Alumnos inscriptos a tiempo en:
		//Física
		try {
			c1.inscribirAlumno(a3);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c1.inscribirAlumno(a6);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		
		//AMI
		try {
			c2.inscribirAlumno(a1);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c2.inscribirAlumno(a3);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c2.inscribirAlumno(a5);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		
		//AGA
		try {
			c3.inscribirAlumno(a1);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c3.inscribirAlumno(a3);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c3.inscribirAlumno(a5);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		
		//Algoritmos
		try {
			c4.inscribirAlumno(a2);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c4.inscribirAlumno(a6);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		
		//Alumnos intentando inscribirse tarde en:
		/** [Se usa inscripcionAceptada en vez de inscribir para que
		 *   muestre por pantalla si la inscripción fue aceptada o no]
		 */
		//Física
		try {
			c1.inscribirAlumno(a4);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c1.inscribirAlumno(a2); // Cupo lleno
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		} 
		
		//Algoritmos
		try {
			c4.inscribirAlumno(a4);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c4.inscribirAlumno(a5);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		
		
		// ------ Impresión de Inscriptos por Nombre ------
		System.out.println("\nAlumnos ordenados por Nombre:");
		System.out.println("Curso 1: ");
		c1.imprimirInscriptosPorNombre();
		System.out.println("Curso 2: ");
		c2.imprimirInscriptosPorNombre();
		System.out.println("Curso 3: ");
		c3.imprimirInscriptosPorNombre();
		System.out.println("Curso 4: ");
		c4.imprimirInscriptosPorNombre();
		System.out.println("Curso 5: ");
		c5.imprimirInscriptosPorNombre();
		System.out.println("Curso 6: ");
		c6.imprimirInscriptosPorNombre();
		System.out.println("Curso 7: ");
		c7.imprimirInscriptosPorNombre();
		System.out.println("Curso 8: ");
		c8.imprimirInscriptosPorNombre();
		
		// ------ Primeros Aprobados ------
		//Alumnos aprobados en:
		//Física
		a3.aprobar(c1);
		
		//AMI
		a1.aprobar(c2);
		a3.aprobar(c2);
		a5.aprobar(c2);
		
		//AGA
		a1.aprobar(c3);
		a2.aprobar(c3); //a2 no cursó AGA
		a3.aprobar(c3);
		a5.aprobar(c3);
		
		//Algorimos
		a1.aprobar(c4); //a1 no cursó Algoritmos
		a2.aprobar(c4);
		a5.aprobar(c4);
		a6.aprobar(c4);

		
		// ------ Segunda Inscripción ------
		//Por orden de inscripción:
		//Física
		try {
			c1.inscribirAlumno(a2);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c1.inscribirAlumno(a4); // Ya inscripto
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c1.inscribirAlumno(a1); //Cupo lleno
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}

		//AMI
		try {
			c2.inscribirAlumno(a4);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		
		//AGA
		try {
			c3.inscribirAlumno(a2);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c3.inscribirAlumno(a4); //a4 ya está cursando 3 materias del ciclo 1
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c3.inscribirAlumno(a6);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		
		//Algoritmos
		try {
			c4.inscribirAlumno(a1);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c4.inscribirAlumno(a3);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		
		//AMII
		try {
			c5.inscribirAlumno(a1); //Créditos insuficientes
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c5.inscribirAlumno(a5);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		
		//Física 2
		try {
			c6.inscribirAlumno(a5);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		
		//Química
		try {
			c7.inscribirAlumno(a1);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c7.inscribirAlumno(a5);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c7.inscribirAlumno(a3); //Cupo lleno
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		
		//Inglés
		try {
			c8.inscribirAlumno(a1);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c8.inscribirAlumno(a2);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c8.inscribirAlumno(a3);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		try {
			c8.inscribirAlumno(a5); //a5 ua está cursando 3 materias del ciclo 2
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		} 
		try {
			c8.inscribirAlumno(a6);
		} catch (AlumnoYaInscriptoException | CreditosInsuficientesException | CupoLlenoException
				| LimiteMateriasMismoCicloException | IOException | RegistroAuditoriaException e) {
			System.out.println(e.getMessage());
		}
		
		// ------ Impresión de Inscriptos por Créditos ------
		System.out.println("\nAlumnos ordenados por Créditos:");
		System.out.println("Curso 1: ");
		c1.imprimirInscriptosPorCreditos();
		System.out.println("Curso 2: ");
		c2.imprimirInscriptosPorCreditos();
		System.out.println("Curso 3: ");
		c3.imprimirInscriptosPorCreditos();
		System.out.println("Curso 4: ");
		c4.imprimirInscriptosPorCreditos();
		System.out.println("Curso 5: ");
		c5.imprimirInscriptosPorCreditos();
		System.out.println("Curso 6: ");
		c6.imprimirInscriptosPorCreditos();
		System.out.println("Curso 7: ");
		c7.imprimirInscriptosPorCreditos();
		System.out.println("Curso 8: ");
		c8.imprimirInscriptosPorCreditos();
		
		// ------ Impresión de Inscriptos por Libreta ------
		System.out.println("\nAlumnos ordenados por Libreta:");
		System.out.println("Curso 1: ");
		c1.imprimirInscriptosPorLibreta();
		System.out.println("Curso 2: ");
		c2.imprimirInscriptosPorLibreta();
		System.out.println("Curso 3: ");
		c3.imprimirInscriptosPorLibreta();
		System.out.println("Curso 4: ");
		c4.imprimirInscriptosPorLibreta();
		System.out.println("Curso 5: ");
		c5.imprimirInscriptosPorLibreta();
		System.out.println("Curso 6: ");
		c6.imprimirInscriptosPorLibreta();
		System.out.println("Curso 7: ");
		c7.imprimirInscriptosPorLibreta();
		System.out.println("Curso 8: ");
		c8.imprimirInscriptosPorLibreta();
	}
}
