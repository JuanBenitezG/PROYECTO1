package model.logic;

import model.data_structures.ArregloDinamico;



import java.io.FileReader;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import model.data_structures.Lista;
import model.data_structures.ListaEncadenada;
import model.data_structures.ShellSort;


public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private Lista <String> datos;
	private Lista<pelicula> datosArreglo;
	private Lista<pelicula> datosLista;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ArregloDinamico(7);
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico(capacidad);
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datosArreglo.size();
	}
	public void conocerUnDirector(String pDirector){
		int peliculas=0;
		double sumapromedios=0;
		for(int i=-1; i<datosArreglo.size()-1;i++){
			if(datosArreglo.getElement(i).getDirector().contains(pDirector)){
				System.out.println(""+datosArreglo.getElement(i).getOriginal_title());
				peliculas++;
				sumapromedios+=datosArreglo.getElement(i).getVote_average();
			}
		}
		System.out.println("El numero de películas de "+pDirector+" es:"+peliculas+" y el promedio de la calificación de sus películas es: "+(sumapromedios/peliculas));
	}
	public void conocerUnActor(String pActor){
		int peliculas=0;
		double sumapromedios=0;
		ArregloDinamico<String> directores;
		directores = new ArregloDinamico<>(20);
		for(int i=-1; i<datosArreglo.size()-1;i++){
			for(int j=0;j<5;j++){
				if(datosArreglo.getElement(i).getActorN(j).contains(pActor)){
					System.out.println(""+datosArreglo.getElement(i).getOriginal_title());
					peliculas++;
					sumapromedios+=datosArreglo.getElement(i).getVote_average();
					directores.addLast(datosArreglo.getElement(i).getDirector());
				}
			}
		}
		String max="";
		int maximo=0;
		for(int i=-1; i<directores.size()-1;i++){
			String act=directores.getElement(i);
			int maxlocal=0;
			System.out.println(i);
			for(int j=-1;j<directores.size()-1;j++){
				if(act.equalsIgnoreCase(directores.getElement(j))){
					maxlocal+=1;
				}
				if(maxlocal>maximo){
					max=directores.getElement(j);
				}
			}
		}
		System.out.println("El numero de películas de "+pActor+" es:"+peliculas+" y el promedio de la calificación de las películas es: "+(sumapromedios/peliculas));
		System.out.println("El director con más colaboraciones de este actor es: "+max);
	}

	//TODO cambio
	//mucho más eficiente del O(n^10)
	public void crearRanking(String filtro, String orden){

		if(filtro.equalsIgnoreCase("PROMEDIO")&& orden.equalsIgnoreCase("PEORES")){
			int N= datosArreglo.size();
			for (int i = -1; i < 10; i++)
			{
				int min = i; 
				for (int j = i+1; j < N-1; j++)
					if (datosArreglo.getElement(j).getVote_average()<datosArreglo.getElement(min).getVote_average())
						min = j;
				datosArreglo.exchange(i, min);
			}
		}
		else if(filtro.equalsIgnoreCase("PROMEDIO")&& orden.equalsIgnoreCase("MEJORES")){
			int N= datosArreglo.size();
			for (int i = -1; i < 10; i++)
			{
				int max = i; 
				for (int j = i+1; j < N-1; j++)
					if (datosArreglo.getElement(j).getVote_average()>datosArreglo.getElement(max).getVote_average())
						max = j;

				datosArreglo.exchange(i, max);
			}
		}
		else if(filtro.equalsIgnoreCase("VOTOS")&& orden.equalsIgnoreCase("PEORES")){
			int N= datosArreglo.size();
			for (int i = -1; i < 10; i++)
			{
				int min = i; 
				for (int j = i+1; j < N-1; j++)
					if (datosArreglo.getElement(j).getVote_count()<datosArreglo.getElement(min	).getVote_count())
						min = j;
				datosArreglo.exchange(i, min);
			}
		}
		else if(filtro.equalsIgnoreCase("VOTOS")&& orden.equalsIgnoreCase("MEJORES")){
			int N= datosArreglo.size();
			for (int i = -1; i < 10; i++)
			{
				int max = i; 
				for (int j = i+1; j < N-1; j++)
					if (datosArreglo.getElement(j).getVote_count()>datosArreglo.getElement(max	).getVote_count())
						max = j;

				datosArreglo.exchange(i, max);
			}
		}

		for (int m=-1;m<9;m++){
			System.out.println(m+2+"."+datosArreglo.getElement(m).getOriginal_title());
		}

	}




	public  void cargarDatos(boolean print1) throws  Exception{
		long to= System.nanoTime();
		CSVReader csvReader = new CSVReader(new FileReader( "./data/SmallMovies.csv"));
		CSVReader csvReader2 = new CSVReader(new FileReader( "./data/MoviesCastingRaw-small.csv"));
		String []nextLine;
		String [] nextLine2;
		datosLista= new ListaEncadenada<pelicula>(null, 0);
		datosArreglo= new ArregloDinamico<pelicula>(5000);
		csvReader.readNext() ;
		csvReader2.readNext();
		String[] por2=null;
		String[] por=null;

		while((nextLine=csvReader.readNext())!=null&& (nextLine2= csvReader2.readNext())!=null){

			por=nextLine[0].split(";");
			por2= nextLine2[0].split(";");
			pelicula in= new pelicula(Integer.parseInt(por[0]), por[1], por[2], por[3], por[4], por[5], 
					por[6], por[7], por[8], por[9], por[10], por[11], por[12], por[13],
					por[14], por[15], por[16],
					Float.parseFloat(por[17]) 	,Integer.parseInt(por[18]), Integer.parseInt(por[19]), Integer.parseInt(por[20]), Integer.parseInt(por[21]),por2[1],por2[3],por2[5],por2[7],por2[9],por2[12]);

			datosLista.addFirst(in);
			datosArreglo.addLast(in);
		}
		csvReader.close();
		long tf=System.nanoTime();
		double tiempof=(double)(tf-to)*1.0e-9;
		if(print1){
			System.out.println(" Los datos se demoraron en cargar:  "+tiempof );
		}
	}


	//TODO cambio
	//uní los dos "cargar datos" y los puse en variables llamadas datoslista y datosarreglo para no reusarlo cada vez que se hace un requerimiento

	//TODO cambio 
	//eliminé los métoos buscar y eliminar ya que no estaban en uso. De igual forma en el test


	//TODO darpeldir ahora se basa en la variable que ya está creada y imprime el requerimiento
	public void darpelDir(String pNombreDir) {

		try {
			double promedio=0;
			int pelis=0;
			for(int c=-1;c<datosArreglo.size()-1;c++){


				if( datosArreglo.getElement(c).getVote_average()>6 && datosArreglo.getElement(c).getDirector().contains(pNombreDir) ){
					System.out.println("el id es "+ datosArreglo.getElement(c).getId()+"\n"+
							" su titulo es  "+datosArreglo.getElement(c).getTitle()+"\n"+
							"pertenece al genero de " +datosArreglo.getElement(c).getGenres()+"\n"
							+"fue lanzada  "+ datosArreglo.getElement(c).getRelease_date()+"\n"+
							"y su actores fueron   "+ datosArreglo.getElement(c).getActor_1() +  "\n"
							+ datosArreglo.getElement(c).getActor_2() +  "\n"
							+ datosArreglo.getElement(c).getActor_3()+  "\n"
							+ datosArreglo.getElement(c).getActor_4() +  "\n"
							+ datosArreglo.getElement(c).getActor_5() +  "\n"
							); 
					promedio=datosArreglo.getElement(c).getVote_average();
					pelis +=1;
				}

			}
			System.out.println("El número de buenas películas de "+pNombreDir+" es: "+pelis+" y su promedio de votos es: "+(promedio/pelis));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Lista<pelicula> req5(String gener){
		ArregloDinamico<pelicula> peliculas;
		Lista<pelicula> peliculasSel= new ArregloDinamico<pelicula>(2000);
		try {
			peliculas = (ArregloDinamico<pelicula>) datosArreglo;
			int suma=0; 
			int total=0;
			int prom=0;

			for(int c=0; c<peliculas.size()-1;c++){

				pelicula comp = peliculas.darElemento(c);
				if(comp.getGenres().contains(gener)){

					peliculasSel.addFirst(comp);
					System.out.println("el nombre de una de las peliculas que pertenece al genero dado es "+ comp.getTitle() );
					suma+= comp.getVote_average();
					total++;
				}
			}

			prom=suma/total;

			System.out.println(" el promedio de calificacion de las peliculas del genero es   "+  prom +   "\n"
					+ " y se encontraron " + total+ " peliculas"

					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return peliculasSel;
	}

	public Lista<pelicula>req6(pelicula[]pel,String gener){

		if(pel.length<10){
			return null;
		}else{

			pelicula ret[];
			pelicula[]add= new pelicula[pel.length];
			int t=0;
			for(int c=0;c<add.length;c++){
				pelicula comp= pel[c];
				if(comp.getGenres().equals(gener) ){
					add[t]=pel[c];
					t++;	

				}
			}	
			ShellSort ord= new ShellSort();
			ord.sort(add);
			Lista<pelicula> retu= new ArregloDinamico<pelicula>(2000);
			int b=0;
			pelicula[]first=ordMezcla(pel, gener);

			for(int k=0;k<first.length;k++){

				retu.addFirst(first[k]);

			}
			for(int p=0;p<add.length/2;p++){

				retu.addFirst(add[0]);	
			}
			return retu;
		}




	}

	public pelicula[] ordMezcla(pelicula[]pel,String gener){

		pelicula[] ner=null;
		int t=0;
		for(int i=0;i<pel.length;i++){
			if(pel[i].getGenres().equals(gener)){

				ner[t]=pel[i];
				t++;
			}


		}



		int i, j,k;
		int nELementosizq= ner.length/2;
		int nElementosder= ner.length;
		pelicula arregloizq[]= new pelicula[nELementosizq];
		pelicula arregloder[]= new pelicula[nElementosder];

		for(int r=0;r<ner.length;r++){

			arregloizq[r]=pel[r];



			for(int p=nELementosizq;p<nELementosizq+nElementosder;p++){

				arregloizq[p-nELementosizq]=pel[p];

			}

			// recursividad

			arregloizq= ordMezcla(arregloizq, gener);
			arregloder= ordMezcla(arregloder,gener);
			i=0;
			j=0;
			k=0;
			while(arregloizq.length!=j&& arregloder.length!=k){
				pelicula pelicula1= arregloizq[j];
				pelicula pelicula2= arregloder[k];
				if(pelicula1.getVote_count()> pelicula2.getVote_count()){

					ner[i]=arregloizq[j];
					i++;
					j++; 
				}else{
					ner[i]= arregloder[k];
					i++;
					k++;

				}

			}
			// arreglo final

			while(arregloizq.length!=j){

				ner[i]= arregloizq[j];
				i++;
				j++;

			}
			while(arregloder.length!=k){
				ner[i]= arregloder[k];
				i++;
				k++;
			}
		}
		return ner;
	}
}
