package es.unican.is2.practica5;

/**
 * Clase que representa un valor en bolsa (paquete de acciones). 
 * Cada valor contiene un número de acciones 
 * de una de las entidades del IBEX 35
 */
public class Valor {
	
	private String entidad;	
	private int numAcciones;
	private double cotizacion;
	
	//CC = 1
	//CCog = 0
	public Valor(String entidad, int numAcciones, double cotizacionActual) {
		this.entidad = entidad;
		this.numAcciones = numAcciones;
		this.cotizacion = cotizacionActual;
	}
	
	//CC = 1
	//CCog = 0
	public int getNumValores() {
		return numAcciones;
	}

	//CC = 1
	//CCog = 0
	public void setNumValores(int numValores) {
		this.numAcciones = numValores;
	}

	//CC = 1
	//CCog = 0
	public double getCotizacion() {
		return cotizacion;
	}
	
	//CC = 1
	//CCog = 0
	public void setCotizacion(double cotizacion) {
		this.cotizacion = cotizacion;
	}

	//CC = 1
	//CCog = 0
	public String getEntidad() {
		return entidad;
	}

	//CC = 1
	//CCog = 0
	@Override
	public boolean equals(Object obj) {
		Valor other = (Valor)obj;
		return (entidad.equals(other.entidad) & numAcciones==other.numAcciones);

	}
	
	//CC = 7
	//CCog = 0

}