package modelo.estado;

import java.util.ArrayList;

import modelo.ser.Ser;

//Se encargad de gestionar menores,ancianos y parados
// se encarga del pago de estos sectores
public class MinisterioSocial {
	
	private final ArrayList<Ser> ancianos = new ArrayList<>();
	private final ArrayList<Ser> menores = new ArrayList<>();
	
	
	public MinisterioSocial() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void establecerNacimientos(long trabajadoresFaltantes) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Ser> getAncianos() {
		return ancianos;
	}

	public ArrayList<Ser> getMenores() {
		return menores;
	}

}
