package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.ArregloDinamico;
import model.data_structures.ListaEncadenada;
import model.data_structures.NodoGenerico;
import model.logic.pelicula;

public class TestListaEncadenada {
	private ListaEncadenada lista;

	@Before
	public void setUp1() {
		lista= new ListaEncadenada<Integer>(1, 0);
	}

	public void setUp2() {

		for(int i =2; i< 25; i++){
			lista.add(i);

		}


	}

	@Test
	public void testListaEncadenada() {
		setUp1();
		assertNotNull( "el arreglo dinamico no debería ser nulo.", lista);
		assertEquals("El número de datos es incorrecto.", 1 ,lista.size());
		// TODO
	}


	@Test
	public void exchange(){
		setUp2();
		lista.exchange(1, 17);
		assertEquals("El dato intecambiado es incorrecto.", 2 ,lista.getElement(1));

	}





	

	public void addfIRST(){
		setUp2();
		Comparable comp= 772;
		lista.addFirst(comp);
		assertEquals("El dato intecambiado es incorrecto.",comp ,lista.firstElement());
	}


	@Test
	public void getElement(){
		setUp2();

		assertEquals("El dato intecambiado es incorrecto.",5 ,lista.getElement(5));

	}
	@Test
	public void insertElement(){
		setUp2();
		Comparable comp= 772;
		lista.add(comp);


		assertEquals("El dato intecambiado es incorrecto.",comp ,lista.getElement(lista.size()));	
	}
	@Test
	public void firstElement(){

		setUp2();
		Comparable comp= lista.firstElement();;

		assertEquals("El dato intecambiado es incorrecto.",1 ,lista.firstElement());	
	}

	@Test

	public void LastElement(){

		setUp2();
		Comparable comp= lista.firstElement();;

		assertEquals("El dato intecambiado es incorrecto.",24 ,lista.lastElement());	
	}

	@Test

	public void deleteElementpos(){
		setUp2();
		Comparable comp3=lista.getElement(7);

		assertEquals("El dato intecambiado es incorrecto.",comp3 ,lista.deleteElement(6));	

	}


	@Test	

	public void removeFirst(){

		//Borra pimer elemento
		setUp2();
		lista.removeFirst();
		Comparable comp3=2;

		assertEquals("Se esperaba otro elemento",comp3,lista.getElement(1));
		//Borra ultimo elemento
	}
	@Test	
	public void removelAST(){
		setUp2();
		lista.removeLast();
		assertEquals("Se esperaba otro elemento",24,lista.lastElement());





	}

	@Test
	public void size(){

		setUp2();
		int t= lista.size();

		assertEquals("Se esperaba otro elemento",24,t);


	}




	@Test

	public void changeInfo(){

		setUp2();
		lista.changeInfo(5 , 800);
		assertEquals("El dato intecambiado es incorrecto.",800 ,lista.getElement(5));	
	}
	@Test

	public void Isempty(){
		setUp2();

		assertFalse("el arreglo no deberia estar vacio", lista.isEmpty());
	}

}
