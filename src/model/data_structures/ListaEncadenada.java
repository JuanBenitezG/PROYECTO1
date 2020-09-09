package model.data_structures;

public class ListaEncadenada <T extends Comparable<T>>implements Lista<T> {

	private NodoGenerico NodoMadre;
	private int Size;
	private NodoGenerico ultimo;
	

	public ListaEncadenada(T nodoMadre, int size) {
		super();
		NodoMadre = new NodoGenerico(nodoMadre, null);
		Size = 1;
	}

	@Override
	public void addFirst(T element) {
		
	
		
		NodoGenerico principal = new NodoGenerico(element, NodoMadre);
		if(NodoMadre==null){
			NodoMadre= principal;
		}
		else{
				NodoGenerico p= NodoMadre;
				NodoMadre=principal;
				NodoMadre.setSiguienteNodo(p);	
				
		}
		Size++;
		// TODO Auto-generated method stub

	}

	public void add(T element) {
		
	
		
		NodoGenerico principal = new NodoGenerico(element, NodoMadre);
		NodoGenerico buscar= NodoMadre;
		if(NodoMadre==null){
			NodoMadre= principal;
		}
	
		else{
			while(buscar.getSiguiente()!=null){
				buscar= buscar.getSiguiente();
			}
			buscar.setSiguiente(element);
		}
		
		Size++;
		// TODO Auto-generated method stub

	}
	
	
	
	
	@Override
	public void addLast(T element) {
		// TODO Auto-generated method stub

		ultimo.setSiguiente(element);

		ultimo= new NodoGenerico(element, null);
		Size--;
	}

	@Override
	public void insertElement(T element, int pos) {
		// TODO Auto-generated method stub

		if (pos==1){
			addFirst(element);

		}
		else if (pos==Size   ) {
			addLast(element);
		}
		else {	NodoGenerico insertar = new NodoGenerico(element, null);
		NodoGenerico buscar = NodoMadre;
		while(pos-2!=0){

			buscar = buscar.getSiguiente();
			pos--;
		}

		insertar.setSiguienteNodo(buscar.getSiguiente());
		buscar.setSiguienteNodo(buscar);

		}
		Size++;

	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		NodoGenerico ret= NodoMadre;

		NodoMadre=NodoMadre.getSiguiente();
		Size--;
		return (T) ret.setPerteneciente();

	}

	public NodoGenerico ultimo(){

		ultimo = NodoMadre;
		if( ultimo != null )
		{
			while( ultimo.getSiguiente() != null )
			{
				ultimo = (NodoGenerico) ultimo.getSiguiente();

			}
		}
		return  ultimo;
	}


	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		T remove= (T) ultimo().setPerteneciente();
		ultimo=null;
		Size--;
		return remove;

	}

	@Override
	public T deleteElement(int pos) {
		NodoGenerico delete=null;
		if (pos==1){
			delete=NodoMadre;
			removeFirst();

		}
		else if ( pos==Size   ) {
			delete=ultimo;
			removeLast();

		}
		else {	
			NodoGenerico buscar = NodoMadre;
			while(pos-2==0){

				buscar = buscar.getSiguiente();
				pos--;
			}
			delete= buscar.getSiguiente();
			buscar.setSiguienteNodo(buscar.getSiguiente().getSiguiente());
		}
		// TODO Auto-generated method stub

		Size--;
		return (T) delete.perteneciente;
	}

	@Override
	public T firstElement() {
		// TODO Auto-generated method stub
		T perteneciente = (T) NodoMadre.getPerteneciente();
		return	perteneciente;
	}

	@Override
	public T lastElement() {
		// TODO Auto-generated method stub
	  NodoGenerico buscar= NodoMadre;
	while(buscar.getSiguientet()!=null){
		buscar=buscar.getSiguiente();
		
	}
	ultimo=buscar;
	return (T) ultimo.getPerteneciente();

	}




	@Override
	public T getElement(int pos) {
		// TODO Auto-generated method stub
		NodoGenerico buscar = NodoMadre;
		while(pos!=0){

			buscar = buscar.getSiguiente();
			pos--;
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return Size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if( NodoMadre !=null ){
			return false;
		}
		return true;
	}

	@Override
	public int isPresent(T element) {
		// TODO Auto-generated method stub
		int p=0;
		NodoGenerico buscar = NodoMadre;
		while(buscar.getSiguiente()!=null){
			p++;
			if(buscar.getPerteneciente().compareTo(element)==0){

				return p;
			}
		}

		return -1;

	}

	@Override
	public void exchange(int pos1, int pos2) {
		// TODO Auto-generated method stub
		NodoGenerico 	buscar= NodoMadre;
		NodoGenerico  buscar2=	NodoMadre; 
		NodoGenerico Remp1=null;
		NodoGenerico Remp2=null;
		while(pos1-1==0){

			buscar = buscar.getSiguiente();
			pos1--;
		}
		Remp1= buscar;
		while(pos2-1==0){

			buscar2 = buscar.getSiguiente();
			pos1--;
		}
		Remp2= buscar2;

		this.insertElement((T) Remp1.getPerteneciente(), pos2);
		this.insertElement((T) Remp2.getPerteneciente(), pos1);




	}

	@Override
	public void changeInfo(int pos, T element) {
		this.deleteElement(pos);
		insertElement(element, pos);


		// TODO Auto-generated method stub

	}


}




	
	
	
	
