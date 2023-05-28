package es.unican.is2.practica5;

import java.time.LocalDateTime;

public class Movimiento {
	private String mConcepto;
	private LocalDateTime mFecha;
	private double mImporte;
	
	//CC = 1
	//CCog = 0
	public double getImporte() {
		return mImporte;
	}
	
	//CC = 1
	//CCog = 0
	public void setImporte(double newMImporte) {
		mImporte = newMImporte;
	}
	
	//CC = 1
	//CCog = 0
	public String getConcepto() {
		return mConcepto;
	}
	
	//CC = 1
	//CCog = 0
	public void setConcepto(String newMConcepto) {
		mConcepto = newMConcepto;
	}
	
	//CC = 1
	//CCog = 0
	public LocalDateTime getFecha() {
		return mFecha;
	}
	
	//CC = 1
	//CCog = 0
	public void setFecha(LocalDateTime newMFecha) {
		mFecha = newMFecha;
	}
	
}