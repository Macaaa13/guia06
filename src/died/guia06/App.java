package died.guia06;

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

		
		// ------ Impresión de Inscriptos ------
		System.out.println("Curso 1: ");
		c1.imprimirInscriptos();
		System.out.println("Curso 2: ");
		c2.imprimirInscriptos();
		System.out.println("Curso 3: ");
		c3.imprimirInscriptos();
		System.out.println("Curso 4: ");
		c4.imprimirInscriptos();
		System.out.println("Curso 5: ");
		c5.imprimirInscriptos();
		System.out.println("Curso 6: ");
		c6.imprimirInscriptos();
		System.out.println("Curso 7: ");
		c7.imprimirInscriptos();
		System.out.println("Curso 8: ");
		c8.imprimirInscriptos();
		
		// ------ Primera Inscripción ------
		
		//Alumnos inscriptos a tiempo en:
		//Física
		c1.inscribir(a3);
		c1.inscribir(a6);
		
		//AMI
		c2.inscribir(a1);
		c2.inscribir(a3);
		c2.inscribir(a5);
		
		//AGA
		c3.inscribir(a1);
		c3.inscribir(a3);
		c3.inscribir(a5);
		
		//Algoritmos
		c4.inscribir(a2);
		c4.inscribir(a6);
		
		//Alumnos intentando inscribirse tarde en:
		/** [Se usa inscripcionAceptada en vez de inscribir para que
		 *   muestre por pantalla si la inscripción fue aceptada o no]
		 */
		//Física
		a4.inscripcionAceptada(c1);
		a2.inscripcionAceptada(c1); //Cupo lleno
		
		//Algoritmos
		a4.inscripcionAceptada(c4);
		a5.inscripcionAceptada(c4);
		
		// ------ Impresión de Inscriptos ------
		System.out.println("Curso 1: ");
		c1.imprimirInscriptos();
		System.out.println("Curso 2: ");
		c2.imprimirInscriptos();
		System.out.println("Curso 3: ");
		c3.imprimirInscriptos();
		System.out.println("Curso 4: ");
		c4.imprimirInscriptos();
		System.out.println("Curso 5: ");
		c5.imprimirInscriptos();
		System.out.println("Curso 6: ");
		c6.imprimirInscriptos();
		System.out.println("Curso 7: ");
		c7.imprimirInscriptos();
		System.out.println("Curso 8: ");
		c8.imprimirInscriptos();
		
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
		c1.inscribir(a2);
		c1.inscribir(a4); //Ya inscripto
		c1.inscribir(a1); //Cupo lleno

		//AMI
		c2.inscribir(a4);
		
		//AGA
		c3.inscribir(a4); //a4 ya está cursando 3 materias del ciclo 1
		
		//Algoritmos
		
		//AMII
		c5.inscribir(a1); //Créditos insuficientes
		c5.inscribir(a5);
		
		//Física 2
		c6.inscribir(a5);
		
		//Química
		c7.inscribir(a1);
		c7.inscribir(a5);
		c7.inscribir(a3); //Cupo lleno
		
		//Inglés
		c8.inscribir(a5); //a5 ua está cursando 3 materias del ciclo 2
		
		
		// ------ Impresión de Inscriptos ------
		System.out.println("Curso 1: ");
		c1.imprimirInscriptos();
		System.out.println("Curso 2: ");
		c2.imprimirInscriptos();
		System.out.println("Curso 3: ");
		c3.imprimirInscriptos();
		System.out.println("Curso 4: ");
		c4.imprimirInscriptos();
		System.out.println("Curso 5: ");
		c5.imprimirInscriptos();
		System.out.println("Curso 6: ");
		c6.imprimirInscriptos();
		System.out.println("Curso 7: ");
		c7.imprimirInscriptos();
		System.out.println("Curso 8: ");
		c8.imprimirInscriptos();
	}
}
