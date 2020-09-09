package controller;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo(22);
	}

	//TODO cambio
	//la opción 1 sólo carga los datos y la 2 da las peliculas buenas del director
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();
			int option=0;
			try{
				option = lector.nextInt();
			}
			catch (Exception e) {
				view.printMessage("--------- \n Opcion Invalida, reinicie e ingrese un valor numérico !! \n---------");
				break;
			}
			switch(option){
			case 1:
				view.printMessage("--------- \nCargar los datos de las películas ");
				modelo = new Modelo(7); 
				try {
					modelo.cargarDatos(true);
					view.printMessage("Datos cargados");
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;
				} catch (Exception e) {
					System.out.println("Los datos no se pudieron cargar");
				}

			case 2: 
				view.printMessage("--------- \n Indique un nombre y un apellido del director"); 
				dato = lector.next();
				String apellido=lector.next();
				String resp=dato+" "+apellido;
				modelo.darpelDir(resp);		
				view.printMessage( "\n---------");						
				break;
			case 3:
				view.printMessage("--------- \n Indique si quiere el ranking por VOTOS o por PROMEDIO");
				dato = lector.next();
				if(!(dato.equalsIgnoreCase("VOTOS")||dato.equalsIgnoreCase("PROMEDIO"))){
					view.printMessage("--------- \n Valores inválidos, indique VOTOS o PROMEDIO");
					view.printMessage( "\n---------");
					break;
				}
				view.printMessage("--------- \n Indique si es orden MEJORES o PEORES");
				String respu=lector.next();
				if(!(respu.equalsIgnoreCase("MEJORES")||dato.equalsIgnoreCase("PEORES"))){
					view.printMessage("--------- \n Valores inválidos, indique MEJORES o PEORES");
					view.printMessage( "\n---------");
					break;
				}
				modelo.crearRanking(dato, respu);
				view.printMessage( "\n---------");						
				break;	
			case 4:
				view.printMessage("--------- \n Indique un nombre y un apellido del director"); 
				dato = lector.next();
				String apellid=lector.next();
				String res=dato+" "+apellid;
				modelo.conocerUnDirector(res);
				view.printMessage( "\n---------");						
				break;
			case 5:
				view.printMessage("--------- \n Indique un nombre y un apellido del actor"); 
				dato = lector.next();
				String apell=lector.next();
				String r=dato+" "+apell;
				modelo.conocerUnActor(r);
				view.printMessage( "\n---------");						
				break;
			case 6:
				view.printMessage("--------- \n Indique el género"); 
				dato = lector.next();
				modelo.req5(dato);
				view.printMessage( "\n---------");						
				break;
			case 7: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}


		}

	}	
}
