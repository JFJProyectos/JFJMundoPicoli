package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.presupuesto.Presupuesto;
import modelo.ser.Adulto;
import modelo.ser.Comportamiento;
import modelo.ser.Ser;

class PresupuestoTest {
	ArrayList<Ser> paradosList;

	@BeforeEach
	public void before() {
		paradosList = new ArrayList<>();
		paradosList.add(new Ser());
		paradosList.add(new Ser());
		paradosList.add(new Ser());
		((Comportamiento) paradosList.get(0)).alimentar(0, 120);
		((Comportamiento) paradosList.get(1)).alimentar(0, 120);
		((Comportamiento) paradosList.get(2)).alimentar(0, 120);
	}

	@Test
	public void testPresupuesto() {

		Presupuesto presupuesto = new Presupuesto(10, 10, 10, paradosList);
		long menores = 550, ancianos = 150, trabajadores = 1000, parados = 300;
		int cantidad = 1850;
		presupuesto.establecerPorcentajes(cantidad);
		assertEquals(presupuesto.getPagoMenores(), menores);
		assertEquals(presupuesto.getPgoAncianos(), ancianos);
		assertEquals(presupuesto.getPagoTrabajadores(), trabajadores);
		assertEquals(presupuesto.getPagoParados(), parados);
		assertEquals(-150, presupuesto.calculaDeficit(cantidad));
		((Comportamiento) paradosList.get(0)).alimentar(150, 120);
		((Comportamiento) paradosList.get(1)).alimentar(175, 120);
		((Comportamiento) paradosList.get(2)).alimentar(125, 120);
		presupuesto = new Presupuesto(10, 10, 10,paradosList);
		cantidad = 1000;
		parados=150;
		presupuesto.establecerPorcentajes(cantidad);
		assertEquals(presupuesto.getPagoMenores(), menores);
		assertEquals(presupuesto.getPgoAncianos(), ancianos);
		assertEquals(presupuesto.getPagoTrabajadores(), trabajadores);
		assertEquals(presupuesto.getPagoParados(), parados);
		assertEquals(-850, presupuesto.calculaDeficit(cantidad));
	}
}