package es.unican.is2.practica5;

import java.util.LinkedList;
import java.util.List;

public class CuentaValores extends Cuenta {

	private List<Valor> valores;


	//CC = 1
	//CCog = 0
	public CuentaValores(String numCuenta) {
		super(numCuenta);
		valores = new LinkedList<Valor>();
	}

	//CC = 1
	//CCog = 0
	public List<Valor> getValores() {
		return valores;
	}

	//CC = 3
	//CCog = 2
	public boolean anhadeValor(Valor valor) {
		for (Valor v:valores) {
			if (v.getEntidad().equals(valor.getEntidad()))
				return false;
		}
		valores.add(valor);
		return true;
	}

	//CC = 2
	//CCog = 1
	@Override
	public double getSaldo() {
		double total = 0.0;
		for (Valor v : valores) {
			total += v.getCotizacion() * v.getNumValores();
		}
		return total;
	}
	
	//WMC = 7
	//CCog = 3
}


