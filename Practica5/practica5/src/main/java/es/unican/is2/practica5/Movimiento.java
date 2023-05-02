package es.unican.is2.practica5;

import java.time.LocalDateTime;

public class Movimiento {
	private String mConcepto;
	private LocalDateTime mFecha;
	private double mImporte;

	//CC =1
	//CCog = 0
	public double getI() {
		return mImporte;
	}

	//CC =1
	//CCog = 0
	public void setI(double newMImporte) {
		mImporte = newMImporte;
	}
	
	//CC =1
	//CCog = 0
	public String getC() {
		return mConcepto;
	}

	//CC =1
	//CCog = 0
	public void setC(String newMConcepto) {
		mConcepto = newMConcepto;
	}

	//CC =1
	//CCog = 0
	public LocalDateTime getF() {
		return mFecha;
	}

	//CC =1
	//CCog = 0
	public void setF(LocalDateTime newMFecha) {
		mFecha = newMFecha;
	}
	
	//CC = 6
	//CCog = 0
}