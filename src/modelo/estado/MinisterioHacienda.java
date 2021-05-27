package modelo.estado;

import java.util.ArrayList;

import modelo.presupuesto.Presupuesto;
import modelo.ser.Adulto;
import modelo.ser.Ser;

//Elabora el presupuesto y decide sobre capital y deuda 
public class MinisterioHacienda {
	private Presupuesto presupuesto;
	
	public MinisterioHacienda() {
		super();
		
	}
	public Presupuesto crearPresupuesto(long cantidadMenores, long cantidadAncianos,
										long cantidadTrabajadores,ArrayList<Ser>parados) {
		
		presupuesto = new Presupuesto(cantidadMenores, cantidadAncianos, cantidadTrabajadores, parados);
		return presupuesto;
	}
	
	
	
}
