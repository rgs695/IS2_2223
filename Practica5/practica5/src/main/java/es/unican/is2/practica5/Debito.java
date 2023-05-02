package es.unican.is2.practica5;

import java.time.LocalDate;

public class Debito extends Tarjeta {
	
	private double saldoDiarioDisponible;

	//CC = 1
	//CCog = 0
	public Debito(String numero, String titular, CuentaAhorro c) {
		super(numero, titular, c);
	}
	
	//CC = 2
	//CCog = 2
	@Override
	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {
		if (saldoDiarioDisponible<x) {
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.mCuentaAsociada.retirar("Retirada en cajero automático", x);
		saldoDiarioDisponible-=x;
	}
	
	//CC = 2
	//CCog = 2
	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws saldoInsuficienteException, datoErroneoException {
		if (saldoDiarioDisponible<x) {
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.mCuentaAsociada.retirar("Compra en : " + datos, x);
		saldoDiarioDisponible-=x;
	}
	
	//CC = 1
	//CCog = 0
	public LocalDate getCaducidadDebito() {
		return this.mCuentaAsociada.getCaducidadDebito();
	}
	
	/**
	 * Método invocado automáticamente a las 00:00 de cada día
	 */
	//CC = 1
	//CCog = 0
	public void restableceSaldo() {
		saldoDiarioDisponible = mCuentaAsociada.getLimiteDebito();
	}
	
	//CC = 1
	//CCog = 0
	public CuentaAhorro getCuentaAsociada() {
		return mCuentaAsociada;
	}
	
	//WMC = 8
	//CCog = 4 (pagoEnEstablecimiento, retirar)
}