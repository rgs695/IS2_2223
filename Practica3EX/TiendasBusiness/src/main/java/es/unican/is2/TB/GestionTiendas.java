package es.unican.is2.TB;

import es.unican.is2.TC.*;

public class GestionTiendas implements IGestionTiendas, IGestionEmpleados {
	
	private IEmpleadosDAO daoEmpleados;
	private ITiendasDAO daoTiendas;
	
	public GestionTiendas(IEmpleadosDAO daoEmpleados, ITiendasDAO daoTiendas) {
		this.daoEmpleados = daoEmpleados;
		this.daoTiendas = daoTiendas;
	}
	
	
	public Empleado altaEmpleado(Empleado e, String nombre) throws OperacionNoValida {
		// TODO Auto-generated method stub
		return null;
	}

	public Empleado bajaEmpleado(String dni, String nombre) throws OperacionNoValida {
		// TODO Auto-generated method stub
		return null;
	}

	public Empleado empleado(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	public Tienda altaTienda(Tienda t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Tienda bajaTienda(String nombre) throws OperacionNoValida {
		// TODO Auto-generated method stub
		return null;
	}

	public Tienda tienda(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
