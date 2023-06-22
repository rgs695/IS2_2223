package es.unican.is2.TCTest;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import org.junit.jupiter.api.*;

import es.unican.is2.TC.Categoria;
import es.unican.is2.TC.Empleado;
import es.unican.is2.TC.ParametroIncorrecto;


class EmpleadoTest {

	private Empleado empleado1;
	private Empleado empleado2;
	private Empleado empleado3;
	private Empleado empleado4;
	private Empleado empleado5;
	private Empleado empleado6;
	private Empleado empleado7;
	private Empleado empleado8;
	private Empleado empleado9;
	private Empleado empleado10;



	@BeforeEach
	public void inicia() throws Exception {

		empleado1 = new Empleado("Juan", "12345678A", Categoria.DEPENDIENTE, true, LocalDate.now());
		empleado2 = new Empleado("Jorge", "12345678B", Categoria.ENCARGADO, false, LocalDate.now().minusYears(2));
		
		empleado3 = new Empleado("María", "12345678C", Categoria.DEPENDIENTE, false, LocalDate.now());
		empleado4 = new Empleado("Pedro", "12345678D", Categoria.ENCARGADO, false, LocalDate.now().minusYears(5).minusDays(1));
		empleado5 = new Empleado("Lucía", "12345678E", Categoria.ENCARGADO, false, LocalDate.now().minusYears(10).minusDays(1));
		empleado6 = new Empleado("Sofía", "12345678F", Categoria.ENCARGADO, false, LocalDate.now().minusYears(15).minusDays(1));
		empleado7 = new Empleado("Darío", "12345678G", Categoria.ENCARGADO, true, LocalDate.now());
		empleado8 = new Empleado("Manuel", "12345678H", Categoria.ENCARGADO, true, LocalDate.now().minusYears(5).minusDays(1));
		empleado9 = new Empleado("Daniel", "12345678I", Categoria.ENCARGADO, true, LocalDate.now().minusYears(10).minusDays(1));
		empleado10 = new Empleado("Nuria", "12345678J", Categoria.ENCARGADO, true, LocalDate.now().minusYears(15).minusDays(1));

	}

	//Para comprobar que al utilizar un constructor vacío no se genere un objeto nulo
	@Test
	void testConstructorVacio() {
		Empleado emp = new Empleado();
		assertNotNull(emp);
	}

	@Test
	public void testConstructor() {

		//CASOS VALIDOS
		assertEquals("Juan", empleado1.getNombre());
		assertEquals("12345678A", empleado1.getDNI());
		assertEquals(Categoria.DEPENDIENTE, empleado1.getCategoria());
		assertTrue(empleado1.isBaja());
		assertEquals(LocalDate.now(), empleado1.getFechaContrato());

		assertEquals("Jorge", empleado2.getNombre());
		assertEquals("12345678B", empleado2.getDNI());
		assertEquals(Categoria.ENCARGADO, empleado2.getCategoria());
		assertFalse(empleado2.isBaja());
		assertEquals(LocalDate.now().minusYears(2), empleado2.getFechaContrato());

		//CASOS NO VALIDOS
		assertThrows(ParametroIncorrecto.class, () -> new Empleado("Darío", "12345678E", Categoria.DEPENDIENTE, false, LocalDate.now().plusDays(5)));
	}

	@Test
	void sueldo() {
		
		//CASOS VALIDOS
		assertTrue(empleado1.sueldo() == 750,"El precio fue " + empleado1.sueldo() + " pero el esperado era " + 750);
		assertTrue(empleado2.sueldo() == 1200,"El precio fue " + empleado1.sueldo() + " pero el esperado era " + 1200);
		assertTrue(empleado3.sueldo() == 1000,"El precio fue " + empleado1.sueldo() + " pero el esperado era " + 1000);
		assertTrue(empleado4.sueldo() == 1250,"El precio fue " + empleado1.sueldo() + " pero el esperado era " + 1250);
		assertTrue(empleado5.sueldo() == 1300,"El precio fue " + empleado1.sueldo() + " pero el esperado era " + 1300);
		assertTrue(empleado6.sueldo() == 1350,"El precio fue " + empleado1.sueldo() + " pero el esperado era " + 1350);
		assertTrue(empleado7.sueldo() == 900,"El precio fue " + empleado1.sueldo() + " pero el esperado era " + 900);
		assertTrue(empleado8.sueldo() == 937.5,"El precio fue " + empleado1.sueldo() + " pero el esperado era " + 937.5);
		assertTrue(empleado9.sueldo() == 975,"El precio fue " + empleado1.sueldo() + " pero el esperado era " + 975);
		assertTrue(empleado10.sueldo() == 1012.5,"El precio fue " + empleado1.sueldo() + " pero el esperado era " + 1012.5);
		
	}
	
}

