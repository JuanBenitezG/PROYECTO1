package model.data_structures;

public class ArregloDinamico <T extends Comparable <T>>  implements Lista <T> {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	public T elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
        elementos = (T[]) new Comparable [max] ;
        tamanoMax = max;
        tamanoAct = 0;
	}
	public void agregar( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[])new Comparable [tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			
		}	
		elementos[tamanoAct] =  dato;
		tamanoAct++;
	}

	// agrega un objeto con la posicion dada


	public void agregarPrimero( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[])new Comparable [tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			
		}	
		for ( int i = 0; i < tamanoAct; i++){

			elementos[i+1]= elementos[i];
		}
		elementos[0]=dato;
		elementos[tamanoAct] =  dato;
		tamanoAct++;
	}

	@Override
	public void addLast( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;}
		elementos[tamanoAct]=dato;
		tamanoAct++;
	}

	public T  deletefirstElement(){
		T r = elementos[0];
		for (int i=0;i<tamanoAct-1;i++){

			elementos[i]=elementos[i+1];
		}
		elementos[tamanoAct-1]=null;
		tamanoAct--;
		return r;
	}

	public T eliminar(int Pos ){
		int pos= Pos+1;
		T r= elementos[pos];
		for(int i=pos;pos<tamanoAct-1;pos++  ){
			elementos[pos]=elementos[pos+1];
		}
		elementos[tamanoAct-1]=null;
		tamanoAct--;
		return r;
	}

	public T firstElement(){
		return elementos[0];
	}
	public T lastElement(){
		return elementos[tamanoAct-1];
	}

	public T getElement(int pos){

		return elementos[pos+1];
	}

	public int darCapacidad() {
		return tamanoMax;
	}


	// borra el primer elemento de la lista


	public T darElemento(int p) {
		int i=p+1;

		if(i< size()&& elementos[i]!=null){
			T elemento =  elementos[i];
			return  elemento;
		}
		else {
			return null;
		}
	}
	// TODO implementar

	public boolean isEmpty(){
		if(elementos[0]==null){
			return true;
		}
		return false;
	}




	public int buscar(T dato) {

		T buscar=null;
		for(int i=1;i<size();i++){
			buscar=(T) elementos[i];
			if(dato.compareTo(buscar)==0){
				return i     ;
			}

		}


		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		return-1;
	}

	public void exchange(int pos, int pos1){
		T cambiar= elementos[pos1+1] ;
		elementos[pos1+1]= elementos[pos+1];
		elementos[pos+1]= cambiar;

	}

	public void changeInfo(int pos, T elem){
		elementos[pos+1]= elem;

	}

	@Override
	public void addFirst( T dato )
	{
		if(elementos[0]==null){
			
			elementos[0]= dato;
		}
		
		
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[])new Comparable [tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		for ( int i = 0; i < size(); i++){

			elementos[i+1]= elementos[i];
		}
		elementos[0]=dato;
		elementos[tamanoAct] =  dato;
		tamanoAct++;
	}



	

	@Override
	public void insertElement(T	dato, int Pos1) {
		int Pos=Pos1+1;
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[])new Comparable [tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			
		}	

		try {
			if(Pos> tamanoAct-1 ){
				throw new Exception("el numero que desea ingresar no esta en el rango para agregar");
			}

			if(Pos== tamanoAct-1){

				elementos[tamanoAct]	=elementos[tamanoAct-1 ];
				elementos[tamanoAct-1 ]= dato;
			}


			for(int i=tamanoAct-1;i>=Pos ;i--){
				if(Pos==i ){
					elementos[i+1]=elementos[i];
					elementos[i]= dato;


				}

				else{

					elementos[i+1]=elementos[i];
				}

			}


		} catch (Exception e) {

			System.out.println("el numero d3e la posicion no esta en el rango de la lista");

		}

		tamanoAct++;
		// TODO Auto-generated method stub

	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		Object First = firstElement();
		T [ ] copia = elementos;
		for(int i =0;i< tamanoAct;i++){

			elementos[i]=copia[i+1];
		}
		elementos[tamanoAct-1]=null;
		tamanoAct-=1;
		return (T) First;
	}

	//borra el ultimo elemento de la lista
	public void borrarUltElemento(){
		tamanoAct-=1;
		elementos[tamanoAct-1]=null;


	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		T r = elementos[tamanoAct-1];
		elementos[tamanoAct-1]=null;
		tamanoAct--;
		return r;
	}

	@Override
	public T deleteElement(int pos ){

		T r= elementos[pos];
		for(int i=pos;pos<tamanoAct-1;pos++  ){
			elementos[pos]=elementos[pos+1];
		}
		elementos[tamanoAct-1]=null;
		tamanoAct--;
		return r;
	}

	@Override
	public int size() {

		return tamanoAct;


	}

	@Override

	public int isPresent(T dato) {
		int p=-1;
		T buscar=null;
		for(int i=1;i<size();i++){
			buscar=(T) elementos[i];
			if(dato.compareTo(buscar)==0){
				return i;

			}

		}


		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		return p;
	}


}


