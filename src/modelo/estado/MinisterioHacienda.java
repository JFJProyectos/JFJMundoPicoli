package modelo.estado;

import java.util.ArrayList;

import modelo.presupuesto.Presupuesto;
import modelo.ser.Adulto;

//Elabora el presupuesto y decide sobre capital y deuda 
public class MinisterioHacienda {
	private Presupuesto presupuesto;
	
	public MinisterioHacienda() {
		super();
		
	}
	public Presupuesto crearPresupuesto(long cantidadMenores, long cantidadAncianos,
										long cantidadTrabajadores,ArrayList<Adulto>parados) {
		
		presupuesto = new Presupuesto(cantidadMenores, cantidadAncianos, cantidadTrabajadores, parados);
		return presupuesto;
	}
	
	
	
}
