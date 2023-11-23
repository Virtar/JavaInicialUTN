import java.util.Arrays;
import java.util.Collections;

public class Metodo1BBis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean ordenAscendente=false;
		int numeros[]= {55,2,25};
		int arreglo1[]=new int[numeros.length];
		
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
