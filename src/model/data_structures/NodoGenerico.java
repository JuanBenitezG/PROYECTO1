package model.data_structures;

public class   NodoGenerico  <T extends Comparable <T>>  {
	T perteneciente;
	NodoGenerico siguiente;
	public T getPerteneciente() {
		return perteneciente;
	}
	public NodoGenerico(T perteneciente, NodoGenerico p ) {
		super();
		this.perteneciente = perteneciente;
		this.siguiente = p;
	}
	public void setPerteneciente(T perteneciente) {
		this.perteneciente = perteneciente;
	}
	public NodoGenerico getSiguiente() {
		return siguiente;
		
	}
	public T getSiguientet() {
		
		return (T) siguiente.perteneciente;
	}

	


	public T setPerteneciente(){
		return perteneciente;
	}
	public void setSiguiente(T siguiente) {
		NodoGenerico p= new NodoGenerico(siguiente, null);
		this.siguiente = p;
	}

	public void setSiguienteNodo( NodoGenerico siguiente) {

		this.siguiente = siguiente;
	}


}
