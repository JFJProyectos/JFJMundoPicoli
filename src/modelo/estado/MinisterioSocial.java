package modelo.estado;

import java.util.ArrayList;

import modelo.ser.Ser;

//Se encargad de gestionar menores,ancianos y parados
// se encarga del pago de estos sectores
public class MinisterioSocial {
	
	private ArrayList<Ser> menores = new ArrayList<>();
	private ArrayList<Ser> ancianos = new ArrayList<>();
	
	
	
	public MinisterioSocial() {
		super();
	}



	public void establecerNacimientos(long trabajadoresFaltantes) {
		// TODO Auto-generated method stub
		
	}



	public ArrayList<Ser> getMenores() {
		return menores;
	}



	public ArrayList<Ser> getAncianos() {
		return ancianos;
	}
}
