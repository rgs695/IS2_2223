package es.unican.is2.TC;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Empleado de la tienda, con sus datos personales 
 * y datos de ventas y comisiones
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Empleado")

@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class Empleado {
	
	private String nombre;
	@XmlElement(name="dni")
	private String DNI;
	private Categoria categoria;

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate fechaContrato;
	
	private boolean baja = false;
	
	@XmlTransient
	private final double REDUCCION_BAJA = 0.25;
	
	/**
	 * Constructor sin parámetros. 
	 * IMPTE: No borrar aunque se defina otro
	 */
	public Empleado() {
		
	}
	
    public Empleado(String nombre, String DNI, Categoria categoria, boolean baja, LocalDate fechaContrato) throws ParametroIncorrecto {
    	
    	//Fecha > hoy lanza execepcion
    	if(fechaContrato.isAfter(LocalDate.now())) {
    		throw new ParametroIncorrecto("La fecha de contratacion no puede ser mayor que el dia de hoy");
    	}
    	
    	this.nombre = nombre;
    	this.DNI = DNI;
    	this.categoria = categoria;
    	this.baja = baja;
    	this.fechaContrato = fechaContrato;
    }

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	
	/**
	 * Retorna el dni del vendedor
	 * @return id
	 */
	public String getDNI() {
		return DNI;
	}
	
	/**
	 * Retorna la categoria del empleado
	 */
	public Categoria getCategoria () {
		return categoria;
	}
	
	/**
	 * Retorna la fecha de contrato
	 */
	public LocalDate getFechaContrato() {
		return fechaContrato;
	}
	
	/**
	 * Retorna si el empleado está de baja
	 */
	public boolean isBaja() {
		return baja;
	}
	
	/** 
	 * Dar de baja al empleado
	 */
	public void darDeBaja() {
		this.baja=true;
	}
	
	/**
	 * Dar de alta al empleado
	 */
	public void darDeAlta() {
		this.baja=false;
	}
	
	/**
	 * Retorna el sueldo bruto del empleado
	 */
	@SuppressWarnings("static-access")
	public double sueldo() {
		
		double sueldo = 0, base = 0, aumento = 0;
		
		LocalDate antiguedad1 = LocalDate.now().minusYears(5);
		LocalDate antiguedad2 = LocalDate.now().minusYears(10);
		LocalDate antiguedad3 = LocalDate.now().minusYears(15);
		
		if (categoria == categoria.ENCARGADO) {
			base = 1200;
		} else if (categoria == categoria.DEPENDIENTE) {
			base = 1000;
		}
		
		if (categoria == categoria.ENCARGADO) {
			
			if (fechaContrato.isBefore(antiguedad3)) {
				aumento = 150;
			} else if (fechaContrato.isBefore(antiguedad2)) {
				aumento = 100;
			} else if (fechaContrato.isBefore(antiguedad1)) {
				aumento = 50;
			} else {
				aumento = 0;
			}
		}
		
		sueldo = base + aumento;
		
		if (baja == true) {
			sueldo = sueldo - (sueldo *0.25);
		}
		
		return sueldo;
	}
	
}
