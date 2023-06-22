package es.unican.is2.TM;

import es.unican.is2.TB.*;
import es.unican.is2.TD.*;
import es.unican.is2.TG.VistaGerente;

/**
 * Clase principal que construye la aplicaci�n de tres capas y lanza su ejecuci�n
 */
public class Runner {

	public static void main(String[] args) {
		// Componentes capa DAO
		TiendasDAO tiendasDAO = new TiendasDAO();
		EmpleadosDAO empleadosDAO = new EmpleadosDAO();
		
		// Componentes capa negocio
		GestionTiendas negocio = new GestionTiendas(empleadosDAO, tiendasDAO);
		
		// Componentes casa presentacion
		VistaGerente vista = new VistaGerente(negocio, negocio);
		
		// Lanza ejecuci�n
		vista.setVisible(true);
	}

}
