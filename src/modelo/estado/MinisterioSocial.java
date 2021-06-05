package modelo.estado;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import modelo.presupuesto.Presupuesto;
import modelo.ser.Comportamiento;
import modelo.ser.Ser;

//Se encargad de gestionar menores,ancianos y parados
// se encarga del pago de estos sectores
public class MinisterioSocial implements Comportamiento{

	private ArrayList<Ser> menores = new ArrayList<>();
	private ArrayList<Ser> ancianos = new ArrayList<>();
	private ArrayList<Ser> parados;
	private Observer observador = new Observer() {

		@Override
		public void update(Observable o, Object arg) {
			parados.add(menores.remove(menores.indexOf(arg)));

		}
	};

	// Ministerio social se encarga de pasar menores a parados cuando se hacen
	// adultos
	public MinisterioSocial(ArrayList<Ser> parados) {
		super();
		this.parados = parados;
	}

	public void añadeEsteMenor(Ser ser) {
		menores.add(ser);
		ser.addAdultoObserver(observador);
	}

//	public void establecerNacimientos(long trabajadoresFaltantes) {
//		// TODO Auto-generated method stub
//
//	}

	public ArrayList<Ser> getMenores() {
		return menores;
	}

	public ArrayList<Ser> getAncianos() {
		return ancianos;
	}

//	public void pagoSector(Presupuesto miPresupuesto) {
//		for (Ser ser : ancianos) {
//			alimentar(miPresupuesto.getPgoAncianos(), ser.getEsperanzaVida());
//		}
//		for (Ser ser : menores) {
//			alimentar(miPresupuesto.getPagoMenores(), ser.getEsperanzaVida());
//		}
//		for (Ser ser : parados) {
//			alimentar(miPresupuesto.getPagoParados(), ser.getEsperanzaVida());
//		}
//	}

	@Override
	public float alimentar(int sueldo, float esperanzaVida) {
		return esperanzaVida;

	}
}
