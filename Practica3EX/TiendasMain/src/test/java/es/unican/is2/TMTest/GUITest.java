package es.unican.is2.TMTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.*;
import org.fest.swing.fixture.FrameFixture;
import es.unican.is2.TB.GestionTiendas;
import es.unican.is2.TC.IEmpleadosDAO;
import es.unican.is2.TC.ITiendasDAO;
import es.unican.is2.TD.EmpleadosDAO;
import es.unican.is2.TD.TiendasDAO;
import es.unican.is2.TG.VistaGerente;


class GUITest {


	private FrameFixture demo;

	@BeforeEach
	public void setUp() {
		ITiendasDAO daoTiendas = new TiendasDAO();
		IEmpleadosDAO daoEmpleados = new EmpleadosDAO();
		GestionTiendas negocio = new GestionTiendas(daoEmpleados, daoTiendas);
		VistaGerente gui = new VistaGerente(negocio, negocio);
		demo = new FrameFixture(gui);
		gui.setVisible(true);	

	}

	@AfterEach
	public void tearDown() {
		demo.cleanUp();
	}

		@Test
		public void testConsultaTiendaCasoValido() {
	
			// Comprobamos que la interfaz tiene el aspecto deseado
			demo.button("btnBuscar").requireText("Buscar");
	
			// Escribimos un nombre
			demo.textBox("txtNombreTienda").enterText("SantanderCentro");
			demo.button("btnBuscar").click();
			// Comprobamos la salida
			demo.textBox("txtDireccionTienda").requireText("Paseo Pereda 3 Santander 39001");
			demo.textBox("txtTotalSueldos").requireText("3012.5");
	
			// Sleep para visualizar la salida del test
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

		@Test
		public void testConsultaTiendaCasoSinNombre() {
	
			// Comprobamos que la interfaz tiene el aspecto deseado
			demo.button("btnBuscar").requireText("Buscar");
	
			// Escribimos un nombre
			demo.textBox("txtNombreTienda").enterText("");
			demo.button("btnBuscar").click();
			// Comprobamos la salida
			demo.textBox("txtDireccionTienda").requireText("Tienda no existe");
	
			// Sleep para visualizar la salida del test
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	@Test
	public void testNumeroEmpleados() {

		// Comprobamos que la interfaz tiene el aspecto deseado
		demo.button("btnBuscar").requireText("Buscar");

		// Escribimos un nombre
		demo.textBox("txtNombreTienda").enterText("SantanderCentro");
		demo.button("btnBuscar").click();
		// Comprobamos la salida

		demo.list().requireItemCount(3);
		String arrayEmpleados[] = demo.list().contents();

		assertEquals("Pepe", arrayEmpleados[0]);
		assertEquals("Juan", arrayEmpleados[1]);
		assertEquals("Pepe", arrayEmpleados[2]);

		// Sleep para visualizar la salida del test
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

		@Test
		public void testConsultaTiendaNombreErroneo() {
			// Comprobamos que la interfaz tiene el aspecto deseado
			demo.button("btnBuscar").requireText("Buscar");
	
			// Escribimos un nombre
			demo.textBox("txtNombreTienda").enterText("Madrid");
			demo.button("btnBuscar").click();
			// Comprobamos la salida
			demo.textBox("txtDireccionTienda").requireText("Tienda no existe");
	
			// Sleep para visualizar la salida del test
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

}


