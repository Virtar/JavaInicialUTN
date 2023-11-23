import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;



public class Metodo1a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int numeros[]= {55,2,25};
		String orden="d";
		
		int arreglo1[]=new int[numeros.length];
		boolean ordenAscendente=false;
		
		if (orden=="a") {
			ordenAscendente=true;
			
		} else if (orden=="d") {
			ordenAscendente=false;
		}
		

		
		
		if (ordenAscendente) {
			
			Arrays.sort(numeros);
			System.out.println(Arrays.toString(numeros));
					
			   
			     
		} else {
			
			Arrays.sort(numeros);
			int newc = numeros.length-1;
			
			for (int c=0 ; c< numeros.length; c++) {
				
				arreglo1[newc]=numeros[c]; 
				
				newc--;
		}   
			System.out.println(Arrays.toString(arreglo1));
		}
		
	
	}
}
