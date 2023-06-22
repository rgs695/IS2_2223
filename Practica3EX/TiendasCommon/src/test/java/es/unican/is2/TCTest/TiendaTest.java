package es.unican.is2.TCTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.*;

import es.unican.is2.TC.Categoria;
import es.unican.is2.TC.Empleado;
import es.unican.is2.TC.Tienda;

public class TiendaTest {

	private Tienda tienda1;
	private Tienda tienda2;
	private Empleado empleado1 = new Empleado("Juan", "12345678A", Categoria.DEPENDIENTE, true, LocalDate.now());
	private Empleado empleado2 = new Empleado("Lucía", "12345678E", Categoria.ENCARGADO, false, LocalDate.now().minusYears(10).minusDays(1));

	
	
	@BeforeEach
	public void inicia() throws Exception {

		tienda1 = new Tienda("SantanderCentro", "Paseo Pereda 3 Santander 39001");
		tienda2 = new Tienda("Alisal", "Calle los cerezo 5 Alisal 39023");

	}
	
	//Para comprobar que al utilizar un constructor vacío no se genere un objeto nulo
	@Test
	void testConstructorVacio() {
		Tienda tienda = new Tienda();
		assertNotNull(tienda);
		assertNotNull(tienda.getEmpleados());
	}
	
	@Test
	public void testConstructor() {

		//CASOS VALIDOS
		assertEquals("SantanderCentro", tienda1.getNombre());
		assertEquals("Paseo Pereda 3 Santander 39001", tienda1.getDireccion());
		
	}
	
	@Test
	void gastoMensualSueldos() {
		
		//CASOS VALIDOS
		//Caso tienda sin empleados
		assertTrue(tienda1.gastoMensualSueldos() == 0, "El resultado fue" + tienda1.gastoMensualSueldos() + "pero el esperado era" + 0);
		
		//Caso tienda con un empleado
		tienda1.getEmpleados().add(empleado1);
		assertTrue(tienda1.gastoMensualSueldos() == 750, "El resultado fue" + tienda1.gastoMensualSueldos() + "pero el esperado era" + 750);
		
		tienda2.getEmpleados().add(empleado2);
		assertTrue(tienda2.gastoMensualSueldos() == 1300, "El resultado fue" + tienda2.gastoMensualSueldos() + "pero el esperado era" + 1300);
		
		//Caso tienda con X empleados (X=2)
		tienda1.getEmpleados().add(empleado2);
		assertTrue(tienda1.gastoMensualSueldos() == 2050, "El resultado fue" + tienda1.gastoMensualSueldos() + "pero el esperado era" + 2050);
		
	}
}
