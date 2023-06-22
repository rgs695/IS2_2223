package es.unican.is2.ListaTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.Lista.ListaOrdenadaAcotada;

import static org.junit.jupiter.api.Assertions.*;

public class ListaOrdenadaAcotadaTest {

	int capacidad =3; // Definir la capacidad deseada
	ListaOrdenadaAcotada<Integer> lista = new ListaOrdenadaAcotada<>(capacidad);

	@BeforeEach
	public void setUp() {
		lista = new ListaOrdenadaAcotada<>(capacidad);
	}

	@Test
	public void testGet() {

		lista.add(1);
		lista.add(2);
		lista.add(3);

		//si anhado uno mas salta la excepcion
		assertThrows(IndexOutOfBoundsException.class, () -> lista.get(10));
		
		assertEquals(1, lista.get(0));
		assertEquals(2, lista.get(1));
		assertEquals(3, lista.get(2));
	}

	@Test
	public void testAdd() {
		lista.add(2);
		lista.add(1);
		lista.add(3);
		
		//si anhado uno mas salta la excepcion
		assertThrows(RuntimeException.class, () -> lista.add(3));

		assertEquals(3, lista.size());
		assertEquals(1, lista.get(0));
		assertEquals(2, lista.get(1));
		assertEquals(3, lista.get(2));
	}
	

	@Test
	public void testRemove() {
		lista.add(1);
		lista.add(2);
		lista.add(3);

		//si elimino fuera del rango salta la excepcion
		assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(10));
		
		Integer removedElement = lista.remove(1);

		assertEquals(2, removedElement);
		assertEquals(2, lista.size());
		assertEquals(1, lista.get(0));
		assertEquals(3, lista.get(1));
	}

	@Test
	public void testSize() {
		assertEquals(0, lista.size());

		lista.add(1);
		lista.add(2);

		assertEquals(2, lista.size());

		lista.remove(0);

		assertEquals(1, lista.size());
	}

	@Test
	public void testClear() {
		lista.add(1);
		lista.add(2);

		assertEquals(2, lista.size());

		lista.clear();

		assertEquals(0, lista.size());
	}
}
