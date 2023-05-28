package es.unican.is2.practica5;

//clase abstracta
public abstract class Cuenta {
	
	private String numCuenta;
	
	//CC = 1
	//CCog = 0
	protected Cuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	
	//CC = 1
	//CCog = 0
	public String getNumCuenta() {
		return numCuenta;
	}
	
	//CC = 1
	//CCog = 0
	//nuevo metodo abstracto
	public abstract double getSaldo();
	
	
	//WMC = 3
	//CCog = 0
}
