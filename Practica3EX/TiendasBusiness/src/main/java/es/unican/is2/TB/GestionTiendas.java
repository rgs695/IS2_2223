package es.unican.is2.TB;

import es.unican.is2.TC.*;

public class GestionTiendas implements IGestionTiendas, IGestionEmpleados {
	
	private IEmpleadosDAO daoEmpleados;
	private ITiendasDAO daoTiendas;
	
	public GestionTiendas(IEmpleadosDAO daoEmpleados, ITiendasDAO daoTiendas) {
		this.daoEmpleados = daoEmpleados;
		this.daoTiendas = daoTiendas;
	}
	
	//-----------IGestionEmpleados----------//
	
	/**
	 * Añade un nuevo empleado a una tienda
	 * @param e Empleado que se quiere añadir
	 * @param nombre Nombre de la tienda
	 * @return El empleado añadido
	 * 		   null si no se anhade porque no se encuentra la tienda
	 * @throws OperacionNoValida si el empleado ya existe
	 */
	public Empleado altaEmpleado(Empleado e, String nombre) throws OperacionNoValida {
		Tienda t = daoTiendas.tienda(nombre);
		Empleado nuevoEmpleado = daoEmpleados.empleado(e.getDNI());
		if (t == null) {
			return null;	//tienda no se encuentra
		}
		if (nuevoEmpleado != null) {
			throw new OperacionNoValida(e.getDNI());	//empleado ya existe
		}
		//anhadir empleado
		t.getEmpleados().add(nuevoEmpleado);
		daoEmpleados.actualizaEmpleado(nuevoEmpleado);
		
		return nuevoEmpleado;
	}

	/**
	 * Elimina un empleado de una tienda 
	 * @param dni DNI del empleado
	 * @param nombre Nombre de la tienda
 	 * @return El empleado eliminado
 	 *         null si el empleado o la tienda no existen
 	 * @throws OperacionNoValida si el empleado no pertenece a la tienda indicada
	 */
	public Empleado bajaEmpleado(String dni, String nombre) throws OperacionNoValida {
		Empleado empleadoBaja = daoEmpleados.eliminaEmpleado(dni);
		Tienda t = daoTiendas.tienda(nombre);
		if (empleadoBaja == null || t == null) {
			return null;	//el empleado o la tienda no existen
		}
		if (!t.getEmpleados().contains(empleadoBaja)) {
			throw new OperacionNoValida(dni);	//empleado no pertenece a la tienda indicada
		}
		daoTiendas.actualizaTienda(t);
		return empleadoBaja;
	}

	
	/**
	 * Retorna el empleado con el dni indicado
	 * @param dni
	 * @return El empleado con el dni indicado
	 *         null si no existe
	 */
	public Empleado empleado(String dni) {
		return daoEmpleados.empleado(dni);
	}

	//-----------IGestionTiendas----------//
	/**
	 * Añade una nueva tienda
	 * @param t Tienda que se desea anhadir
	 * @return La tienda anhadida
	 * 		   null si no se anhade porque ya existe
	 */
	public Tienda altaTienda(Tienda t) {
		return daoTiendas.creaTienda(t);
	}

	
	/**
	 * Elimina una tienda
	 * @param nombre Nombre de la tienda que se desea eliminar
	 * @return La tienda eliminada
	 * 		   null si no se elimina porque no se encuentra 
	 * @throws OperacionNoValida si la tienda existe 
	 *         pero tiene empleados
	 */
	public Tienda bajaTienda(String nombre) throws OperacionNoValida {
		Tienda t = daoTiendas.eliminaTienda(nombre);
		if (t == null) {
			throw new OperacionNoValida(nombre);
		}
		return t;
	}

	
	/**
	 * Retorna una tienda dado su nombre
 	 * @param nombre Nombre de la tienda
	 * @return La tienda
	 * 			null si no existe
	 */
	public Tienda tienda(String nombre) {
		return daoTiendas.tienda(nombre);
	}

}
