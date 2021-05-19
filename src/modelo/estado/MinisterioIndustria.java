package modelo.estado;

import java.util.ArrayList;

import modelo.ser.Adulto;
import modelo.ser.Ser;

//Se encarga de los trabajadores y parados
//porque se encarga de contratar y despedir
public class MinisterioIndustria {
	
	private ArrayList<Ser> trabajadores = new ArrayList<>();
	private ArrayList<Ser> parados = new ArrayList<>();

	
	
	public MinisterioIndustria() {
		super();
	}


	public void contratar(long trabajadoresNecesarios) {
		
	}
	
	public ArrayList<Adulto> getParados() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public long calculamosProduccionPeriodica() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public long pagarCostesFabricacion() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public long getProduccionPotencial() {
		// TODO Auto-generated method stub
		return 0;
	}


	public ArrayList<Ser> getTrabajadores() {
		return trabajadores;
	}

}

