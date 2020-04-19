package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoTest {

	Alumno a1;
	Curso c1;
	Curso c2;
	
	@BeforeEach
	public void init() {
		a1 = new Alumno("Juan", 100);
		c1 = new Curso();
		c1.setCreditosRequeridos(0);
	}
	
	//Test del método tieneCreditos
	@Test
	void testNoTieneCreditos() {
		//Al no haber aprobado ningun curso, los créditos del alumno son 0
		int esperado = a1.creditosObtenidos();
		assertEquals(esperado, 0);
	}
	
	@Test
	void testTieneCreditos() {
		/** El curso c1 otorga 10 créditos
		 *  Como el alumno aprobó el curso (para lo cual debe estar inscripto a éste), 
		 *  esperado debe valer 10
		 */
		c1.setCreditos(10);
		a1.inscripcionAceptada(c1);
		a1.aprobar(c1);
		int esperado = a1.creditosObtenidos();
		assertEquals(esperado, 10);
	}
	
	//Test del método aprobar
	@Test
	void testAprobarCursoCursado() {
		/** Al haber cursado el curso c1, el alumno puede aprobarlo.
		 *  Al aprobarlo, a1 se quita de la lista de inscriptos, y 
		 *  c1 se agrega a la lista de aprobados y se quita de la lista de cursando
		 */
		a1.inscripcionAceptada(c1);
		a1.aprobar(c1);
		assertFalse(a1.getCursando().contains(c1));
		assertTrue(a1.getAprobados().contains(c1));
		assertFalse(c1.getInscriptos().contains(a1));
	}
	
	@Test
	void testAprobarCursoNoCursado() {
		/** El alumno no se inscribió al curso c1, por lo que no puede aprobarlo
		 *  Al no aprobarlo, la lista de aprobados no lo contiene al curso c1
		 */
		a1.aprobar(c1);
		assertFalse(a1.getAprobados().contains(c1));
	}
	
	//Test del método inscripcionAceptada
	@Test
	void testInscripcionAceptada() {
		// Si la inscripción fue aceptada, el curso c1 debería aparecer en la lista cursados
		a1.inscripcionAceptada(c1);
		assertTrue(a1.getCursando().contains(c1));
	}
	
	@Test
	void testInscripcionNoAceptada() {
		// Si la inscripción no fue aceptada, el curso c1 no debería aparecer en la lista cursados
		Curso c2 = new Curso();
		c2.setCreditosRequeridos(10); //c1 ya tiene creditos seteados, por eso se usa un nuevo curso
		a1.inscripcionAceptada(c2);
		assertFalse(a1.getCursando().contains(c2));
	}

}
