package es.unican.is2.practica5;

import java.util.LinkedList;

import java.util.List;

public class Cliente {

	public String nombre;
	public String calle;
	public String zip;
	public String localidad;
	public String telefono;
	public String dni;

	private List<Cuenta> Cuentas = new LinkedList<Cuenta>();
	
	//CC = 1
	//CCog = 0
	public Cliente(String titular, String calle, String zip, String localidad, 
			String telefono, String dni) {  
		this.nombre = titular;
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
		this.telefono = telefono;
		this.dni = dni;
	}

	//CC = 1
	//CCog = 0
	public void cambiaDireccion(String calle, String zip, String localidad) {
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}
	
	//CC = 1
	//CCog = 0
	public void anhadeCuenta(Cuenta c) {
		Cuentas.add(c);
	}
	
	//CC = 2
	//CCog = 1
	public double getSaldoTotal() {
		double total = 0.0;
		for (Cuenta c: Cuentas) {  
			total += c.getSaldo(); //nuevo metodo abstracto
		}

		return total;
	}
	
	//CC = 1
	//CCog = 0
	public String getNombre() {
		return nombre;
	}
	
	//CC = 1
	//CCog = 0
	public String getCalle() {
		return calle;
	}
	
	//CC = 1
	//CCog = 0
	public String getZip() {
		return zip;
	}
	
	//CC = 1
	//CCog = 0
	public String getLocalidad() {
		return localidad;
	}
	
	//CC = 1
	//CCog = 0
	public String getTelefono() {
		return telefono;
	}
	
	//CC = 1
	//CCog = 0
	public String getDni() {
		return dni;
	}

	//WMC = 11
	//CCog = 1

}