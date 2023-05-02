package es.unican.is2.practica5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


public class CuentaAhorro extends Cuenta {

	private List<Movimiento> mMovimientos;
	private LocalDate mFechaDeCaducidadTarjetaDebito;
	private LocalDate mFechaDeCaducidadTarjetaCredito;
	private double limiteDebito;

	//CC = 1
	//CCog = 0
	public CuentaAhorro(String numCuenta, LocalDate date, LocalDate date2) throws datoErroneoException {
		super(numCuenta);
		this.mFechaDeCaducidadTarjetaDebito = date;
		this.mFechaDeCaducidadTarjetaCredito = date2;
		mMovimientos = new LinkedList<Movimiento>();
		limiteDebito = 1000;
	}
	//CC = 2
	//CCog = 2
	public void ingresar(double x) throws datoErroneoException {
		if (x <= 0)
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC("Ingreso en efectivo");
		m.setI(x);
		this.mMovimientos.add(m);
	}
	//CC = 3
	//CCog = 4
	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {
		if (x <= 0)
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		if (getSaldo() < x)
			throw new saldoInsuficienteException("Saldo insuficiente");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC("Retirada de efectivo");
		m.setI(-x);
		this.mMovimientos.add(m);
	}
	//CC = 2
	//CCog = 2
	public void ingresar(String concepto, double x) throws datoErroneoException {
		if (x <= 0)
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC(concepto);
		m.setI(x);
		this.mMovimientos.add(m);
	}
	//CC = 3
	//CCog = 4
	public void retirar(String concepto, double x) throws saldoInsuficienteException, datoErroneoException {
		if (getSaldo() < x)
			throw new saldoInsuficienteException("Saldo insuficiente");
		if (x <= 0)
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC(concepto);
		m.setI(-x);
		this.mMovimientos.add(m);
	}
	//CC = 2
	//CCog = 1
	public double getSaldo() {
		double r = 0.0;
		for (int i = 0; i < this.mMovimientos.size(); i++) {
			Movimiento m = (Movimiento) mMovimientos.get(i);
			r += m.getI();
		}
		return r;
	}
	//CC = 1
	//CCog = 0
	public void addMovimiento(Movimiento m) {
		mMovimientos.add(m);
	}
	//CC = 1
	//CCog = 0
	public List<Movimiento> getMovimientos() {
		return mMovimientos;
	}
	//CC = 1
	//CCog = 0
	public LocalDate getCaducidadDebito() {
		return this.mFechaDeCaducidadTarjetaDebito;
	}
	//CC = 1
	//CCog = 0
	public LocalDate getCaducidadCredito() {
		return this.mFechaDeCaducidadTarjetaCredito;
	}
	//CC = 1
	//CCog = 0
	public double getLimiteDebito() {
		return limiteDebito;
	}
	
	//WMC = 18
	//CCog = 13 (Contribuyen los dos metodos de ingresar y de retirar y getSaldo)

}