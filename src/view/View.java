package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar datos");
			System.out.println("2. Dar buenas pel�culas de un director");
			System.out.println("3. Crear ranking de pel�culas");
			System.out.println("4. Conocer a un director");
			System.out.println("5. Conocer a un actor");
			System.out.println("6. Entender un g�nero cinematogr�fico");
			System.out.println("7 .  Exit ");
			
			
			
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
		}
}
