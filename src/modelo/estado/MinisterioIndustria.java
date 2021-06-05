package modelo.estado;

import java.util.ArrayList;

import modelo.presupuesto.Presupuesto;
import modelo.ser.Adulto;
import modelo.ser.Comportamiento;
import modelo.ser.Ser;

//Se encarga de los trabajadores y parados
//porque se encarga de contratar y despedir
public class MinisterioIndustria implements Comportamiento {
	
	private ArrayList<Ser> trabajadores = new ArrayList<>();
	private ArrayList<Ser> parados = new ArrayList<>();

	
	
	public MinisterioIndustria() {
		super();
	}


	public void contratar(long trabajadoresNecesarios) {
		if(trabajadoresNecesarios >= getParados().size()) {
			for (Ser ser : parados) {
				trabajadores.add(ser);
				parados.remove(ser);
			}
		}else {
			for (int i = 0; i < trabajadoresNecesarios; i++) {
				trabajadores.add(parados.remove(parados.indexOf(i)));
			}
		}
	}
	public void despedir(long demanda, int potencia) {
		while(demanda < calculamosProduccionPeriodica(potencia)) {
			parados.add(trabajadores.remove(trabajadores.size()));
		}
	}
	
	public ArrayList<Ser> getParados() {
		
		return parados;
	}
	
	public long calculamosProduccionPeriodica(int potencia) {
		
		return getTrabajadores().size()*potencia;
	}
	
//	public long pagarCostesFabricacion() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
	public long getProduccionPotencial(int potenciaTrabajador) {
		// tiene qe dar la cantidad de parados y trabajadores * 450
		
		int trabajadoresTotales=trabajadores.size();
		int paradosTotales=parados.size();
		return (trabajadoresTotales+paradosTotales)*potenciaTrabajador;
	}


	public ArrayList<Ser> getTrabajadores() {
		return trabajadores;
	}


	@Override
	public float alimentar(int sueldo, float esperanzaVida) {
		for (Ser ser : trabajadores) {
			ser.recalcularEsperanzaDeVida(sueldo);
		}
		return esperanzaVida;
	}


	public void pagoSector(Presupuesto miPresupuesto) {
		for (Ser ser : trabajadores) {
			alimentar((int) miPresupuesto.getPagoTrabajadores(), ser.getEsperanzaVida());
		}
	}

}

