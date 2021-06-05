package presentador;

import java.util.ArrayList;

import modelo.estado.MinisterioHacienda;
import modelo.estado.MinisterioIndustria;
import modelo.estado.MinisterioSocial;
import modelo.presupuesto.Presupuesto;
import modelo.ser.Adulto;
import modelo.ser.Ser;

public class Estado {
	// Lo que le piden al estado que fabrique
	private long demanda = 0;
	// el aumento de produccion en este periodo
	private float porcentajeAumento;
	// lo cantidad que puede producir el estado
	private long produccionPotencial = 0;
	// lo que realmente produce el estado
	private long produccion;
	// La cantidad que cada trabajador produce por periodo
	private int potenciaTrabajador = 450;
	// dinero que tiene el estado o deuda
	private long capital = 0;
	private MinisterioHacienda ministerioHacienda = new MinisterioHacienda();
	private MinisterioIndustria ministerioIndustria = new MinisterioIndustria();
	private MinisterioSocial ministerioSocial = new MinisterioSocial(ministerioIndustria.getParados());
	private final ArrayList<Ser> seres = new ArrayList<>();
//	private final ArrayList<Ser> menores = new ArrayList<>();
//	private final ArrayList<Ser> ancianos = new ArrayList<>();
//	private final ArrayList<Ser> trabajadores = new ArrayList<>();
//	private final ArrayList<Ser> parados = new ArrayList<>();

	public Estado(long demanda) {
		for (int i = 0; i < demanda / potenciaTrabajador; i++) {
			naceSer();
		}
		// Esto es la historia
		int historia = 0;
		do {
			terminarPeriodo();
			comenzarPeriodo();
			historia++;
		} while (historia < 120);
	}
	
	private void comenzarPeriodo() {
		// TODO Auto-generated method stub
		long trabajadoresNecesarios=demanda/potenciaTrabajador;
		ministerioIndustria.contratar(trabajadoresNecesarios);
		ministerioIndustria.despedir(demanda, potenciaTrabajador);
		long trabajadoresFaltantes=trabajadoresNecesarios-getTrabajadores();
		for (int i = 0; i < trabajadoresFaltantes; i++) {
			naceSer();
			
		}

	}

//	private void establecerNacimientos(long trabajadoresFaltantes) {
//		// TODO Auto-generated method stub
//		
//	}

//	private long getProduccionPotencial() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

//	private void contratar(long trabajadoresNecesarios) {
//		// TODO Auto-generated method stub
//		
//	}

	public long getTrabajadores() {
		return ministerioIndustria.getTrabajadores().size();
	}

	private void terminarPeriodo() {
		// TODO Auto-generated method stub
		capital+=ministerioIndustria.calculamosProduccionPeriodica(potenciaTrabajador);
		//capital-=ministerioIndustria.pagarCostesFabricacion();
		Presupuesto miPresupuesto = ministerioHacienda.crearPresupuesto(ministerioSocial.getMenores().size(),
									ministerioSocial.getAncianos().size(),
									ministerioIndustria.getTrabajadores().size(), ministerioIndustria.getParados());
		
		miPresupuesto.establecerPorcentajes(capital);
		ministerioIndustria.pagoSector(miPresupuesto);
		ministerioSocial.pagoSector(miPresupuesto);
		capital-=miPresupuesto.getTotal();
		envejecer();
		
	}

	private void envejecer() {
		for (Ser ser : seres) {
			ser.envejecer();
		}
	}

//	private ArrayList<Adulto> getParados() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	private long pagarCostesFabricacion() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

//	private long calculamosProduccionPeriodica() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	private void naceSer() {
		Ser ser = new Ser();
		seres.add(ser);
		ministerioSocial.añadeEsteMenor(ser);

	}
}
