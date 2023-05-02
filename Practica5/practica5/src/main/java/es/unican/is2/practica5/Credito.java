package es.unican.is2.practica5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


public class Credito extends Tarjeta {

	private double mCredito;
	private List<Movimiento> mMovimientosMensuales;
	private List<Movimiento> mhistoricoMovimientos;

	//CC = 1
	//CCog = 0
	public Credito(String numero, String titular, CuentaAhorro c, double credito) {
		super(numero, titular, c);
		mCredito = credito;
		mMovimientosMensuales = new LinkedList<Movimiento>();
		mhistoricoMovimientos = new LinkedList<Movimiento>();
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param x Cantidad a retirar. Se aplica una comisión del 5%.
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	//CC = 3
	//CCog = 4
	@Override
	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {
		if (x<0)
			throw new datoErroneoException("No se puede retirar una cantidad negativa");

		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC("Retirada en cajero automático");
		x += x * 0.05; // Añadimos una comisión de un 5%
		m.setI(-x);

		if (getGastosAcumulados()+x > mCredito)
			throw new saldoInsuficienteException("Crédito insuficiente");
		else {
			mMovimientosMensuales.add(m);
		}
	}
	//CC = 2
	//CCog = 4
	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws saldoInsuficienteException, datoErroneoException {
		if (x<0)
			throw new datoErroneoException("No se puede retirar una cantidad negativa");

		if (getGastosAcumulados() + x > mCredito)
			throw new saldoInsuficienteException("Saldo insuficiente");

		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC("Compra a crédito en: " + datos);
		m.setI(-x);
		mMovimientosMensuales.add(m);
	}

	//CC = 2
	//CCog = 1
	public double getGastosAcumulados() {
		double r = 0.0;
		for (int i = 0; i < this.mMovimientosMensuales.size(); i++) {
			Movimiento m = (Movimiento) mMovimientosMensuales.get(i);
			r += m.getI();
		}
		return -r;
	}

	//CC = 1
	//CCog = 0
	public LocalDate getCaducidadCredito() {
		return this.mCuentaAsociada.getCaducidadCredito();
	}

	/**
	 * Método que se invoca automáticamente el día 1 de cada mes
	 */
	//CC = 3
	//CCog = 2
	public void liquidar() {
		Movimiento liq = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		liq.setF(now);
		liq.setC("Liquidación de operaciones tarjeta crédito");
		double r = 0.0;
		for (int i = 0; i < this.mMovimientosMensuales.size(); i++) {
			Movimiento m = (Movimiento) mMovimientosMensuales.get(i);
			r += m.getI();
		}
		liq.setI(r);

		if (r != 0)
			mCuentaAsociada.addMovimiento(liq);

		mhistoricoMovimientos.addAll(mMovimientosMensuales);
		mMovimientosMensuales.clear();
	}
	//CC = 1
	//CCog = 0
	public List<Movimiento> getMovimientosUltimoMes() {
		return mMovimientosMensuales;
	}
	//CC = 1
	//CCog = 0
	public Cuenta getCuentaAsociada() {
		return mCuentaAsociada;
	}
	//CC = 1
	//CCog = 0
	public List<Movimiento> getMovimientos() {
		return mhistoricoMovimientos;
	}
	
	//WMC = 15
	//CCog = 11 (Contribuyen liquidar, getGastosAcumulados, pagoEnEstablecimiento y retirar)

}