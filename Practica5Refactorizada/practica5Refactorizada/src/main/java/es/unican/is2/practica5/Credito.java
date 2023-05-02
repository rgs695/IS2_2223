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
		m.setFecha(now);
		m.setConcepto("Retirada en cajero automático");
		x += x * 0.05; // Añadimos una comisión de un 5%
		m.setImporte(-x);

		if (getGastosAcumulados()+x > mCredito)
			throw new saldoInsuficienteException("Crédito insuficiente");
		else {
			mMovimientosMensuales.add(m);
		}
	}

	//CC = 3
	//CCog = 4
	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws saldoInsuficienteException, datoErroneoException {
		if (x<0)
			throw new datoErroneoException("No se puede retirar una cantidad negativa");

		if (getGastosAcumulados() + x > mCredito)
			throw new saldoInsuficienteException("Saldo insuficiente");

		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto("Compra a crédito en: " + datos);
		m.setImporte(-x);
		mMovimientosMensuales.add(m);
	}

	//CC = 1
	//CCog = 0
	public double getGastosAcumulados() {
		double r = calculaGastos();
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
	//CC = 2
	//CCog = 1
	public void liquidar() {
		Movimiento liq = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		liq.setFecha(now);
		liq.setConcepto("Liquidación de operaciones tarjeta crédito");
		double r = calculaGastos();
		liq.setImporte(r);

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
	public List<Movimiento> getMovimientos() {
		return mhistoricoMovimientos;
	}
	
	//CC = 2
	//CCog = 1
	//nuevo metodo extraido de getGastosAcumulados y liquidar
	public double calculaGastos() {
		double r = 0.0;
		for (int i = 0; i < this.mMovimientosMensuales.size(); i++) {
			Movimiento m = (Movimiento) mMovimientosMensuales.get(i);
			r += m.getImporte();
		}
		return r;
	}

	//WMC = 15
	//CCog = 10
}