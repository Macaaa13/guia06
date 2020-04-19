package died.guia06;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {

	//3 alumnos para probar el cupo m�ximo cuando �ste es 2
	Alumno a1;
	Alumno a2;
	Alumno a3;
	//4 cursos para probar la cantidad m�xima de cursos del mismo ciclo lectivo 
	Curso c1;
	Curso c2;
	Curso c3;
	Curso c4;
	
	@BeforeEach
	public void init() {
		a1 = new Alumno("Juan", 100);
		a2 = new Alumno("Anna", 200);
		a3 = new Alumno("Mat�as", 300);
		c1 = new Curso();
		c1.setCupo(2);
		c2 = new Curso();
		c3 = new Curso();
		c4 = new Curso();
		//Al no pedir cr�ditos para cursar, la inscripci�n de los alumnos es m�s f�cil
		c2.setCreditosRequeridos(0);
		c3.setCreditosRequeridos(0);
		c4.setCreditosRequeridos(0);
		//Todos los cursos tienen el mismo ciclo lectivo
		c1.setCicloLectivo(2);
		c2.setCicloLectivo(2);
		c3.setCicloLectivo(2);
		c4.setCicloLectivo(2);
		//El alumno a1 est� inscripto a los cursos c2 y c3
		c2.inscribir(a1);
		c3.inscribir(a1);
	}
	
	//Test del m�todo inscribir
	@Test
	/** Si el alumno no tiene los cr�ditos suficientes para cursar, no se agrega
	 *  a la lista de inscriptos
	*/
	void testInscribirCreditosInsuficientes() {
		c2.setCreditos(5);
		a1.aprobar(c2);
		c1.setCreditosRequeridos(10);
		c1.inscribir(a1);
		assertFalse(c1.getInscriptos().contains(a1));
	}
	
	@Test
	/** Si el alumno tiene los cr�ditos suficientes para cursar, se agrega a
	 *  la lista de inscriptos
	*/
	void testInscribirCreditosSuficientes() {
		c2.setCreditos(5);
		a1.aprobar(c2);
		c1.setCreditosRequeridos(5);
		c1.inscribir(a1);
		assertTrue(c1.getInscriptos().contains(a1));
	}
	
	@Test
	/** Si el curso tiene el cupo lleno, no se agrega el alumno a1 a la lista de
	 *  inscriptos.
	 *  Los alumnos a2 y a3 se inscriben al curso c1 desde el test y no en beforeEach
	 *  porque se debe setear un valor de cr�ditos requeridos a c1 y hacerlo en beforeEach
	 *  generar�a conflicto con los 2 test anteriores
	 *  Como el cupo m�ximo es 2 y a2 y a3 est�n inscriptos, el curso ya
	 *  est� lleno.
	 */
	void testInscribirSinCupo() {
		c1.setCreditosRequeridos(0);
		c1.inscribir(a2);
		c1.inscribir(a3);
		c1.inscribir(a1);
		assertFalse(c1.getInscriptos().contains(a1));
		
	}
	
	@Test
	/** Si el curso no tiene el cupo lleno, se agrega el alumno a1 a la lista de
	 *  inscriptos.
	 *  Como el curso ten�a un alumno y el cupo es 2, a1 puede inscribirse
	 */
	void testInscribirConCupo() {
		c1.setCreditosRequeridos(0);
		c1.inscribir(a2);
		c1.inscribir(a1);
		assertTrue(c1.getInscriptos().contains(a1));
	}
	
	@Test
	/** Solo se pueden hacer 3 cursos del mismo ciclo lectivo al mismo tiempo.
	 *  Como el alumno a1 ya est� incripto a 3 cursos del ciclo lectivo 2, no
	 *  puede inscribirse al curso c1 y no deber�a aparecer en la lista de alumnos
	 *  inscriptos.
	 */
	void testCantCursosMismoCicloExcedida() {
		c1.setCreditosRequeridos(0);
		c4.inscribir(a1);
		c1.inscribir(a1);
		assertFalse(c1.getInscriptos().contains(a1));
	}
	
	@Test
	/** Solo se pueden hacer 3 cursos del mismo ciclo lectivo al mismo tiempo.
	 *  Como el alumno a1 todav�a no llego al m�ximo de cursos del ciclo lectivo 2,
	 *  puede inscribirse al curso c1 y deber�a aparecer en la lista de alumnos
	 *  inscriptos.
	 */
	void testCantCursosMismoCicloNoExcedida() {
		c1.setCreditosRequeridos(0);
		c1.inscribir(a1);
		assertTrue(c1.getInscriptos().contains(a1));
	}
	
	@Test
	void testInscribirCursoYaInscripto() {
		assertFalse(c2.inscribir(a1));
	}
	
	//Test del m�todo imprimirInscriptos	
	@Test
	/** Si la lista pudo registrarse sin problemas, deber�a estar ordenada alfab�ticamente.
	 *  Si la comparo con otra lista con los mismos elementos ordenados alfab�ticamente, 
	 *  ambas listas deber�an ser iguales
	 */
	void testImprimirInscriptos() {
		CompararNombre comparador = new CompararNombre();
		List<Alumno> lista = new ArrayList<Alumno>();
		lista.add(a3);
		lista.add(a1);
		lista.add(a2);
		Collections.sort(lista, comparador);
		
		c4.setCupo(3);
		c4.inscribir(a1);
		c4.inscribir(a2);
		c4.inscribir(a3);
		System.out.println(c4.getInscriptos());
		c4.imprimirInscriptos();
		assertEquals(c4.getInscriptos(), lista);
	}

}
