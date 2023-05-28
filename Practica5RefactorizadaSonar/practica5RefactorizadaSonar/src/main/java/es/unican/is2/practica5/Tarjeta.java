package es.unican.is2.practica5;

public abstract class Tarjeta {
	
	protected String mNumero, mTitular;		
	protected CuentaAhorro mCuentaAsociada;
	
	//CC = 1
	//CCog = 0
	protected Tarjeta(String numero, String titular, CuentaAhorro c) {
		mNumero = numero;
		mTitular = titular;
		mCuentaAsociada = c;
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param x Cantidad a retirar. 
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	//CC = 1
	//CCog = 0
	public abstract void retirar(double x) throws saldoInsuficienteException, datoErroneoException;

	/**
	 * Pago en establecimiento con la tarjeta
	 * @param datos Concepto del pago
	 * @param x Cantidada a pagar
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	//CC = 1
	//CCog = 0
	public abstract void pagoEnEstablecimiento(String datos, double x)
			throws saldoInsuficienteException, datoErroneoException;
	
	//CC = 1
	//CCog = 0
	//Nuevo metodo(pull up method)
	public Cuenta getCuentaAsociada() {
		return mCuentaAsociada;
	}
	
	//WMC = 4
	//CCog = 0
}