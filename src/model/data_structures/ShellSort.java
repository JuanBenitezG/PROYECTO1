package model.data_structures;

import java.util.ArrayList;

public class ShellSort {

	

	public static void sort(Comparable[]
			array){
		int salto,i,j,k;
		Comparable auxiliar;
		salto= array.length/2;
		while(salto>0){
			for(i=salto;i<array.length && array[i]!=null  ;i++){
				j=i-salto;
				while(j>=0){
					k=j+salto;
					if(array[j].compareTo(array[k])!=1){
						j--;
					}else{
						
						auxiliar=array[j];
						array[j]= array[k];
						array[k]=auxiliar;
						j-=salto;
					}

				}


			}


			salto=salto/2;
		}




	}

	
	
}
