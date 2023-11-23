import java.util.Arrays;
import java.util.Scanner;

public class Metodo1b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner ingreso=new Scanner(System.in); 
		
		System.out.print("Ingrese un primer numero ");
		int num1=ingreso.nextInt();
		
		System.out.print("Ingrese un segundo numero ");
		int num2=ingreso.nextInt();
		
		System.out.print("Ingrese un tercer numero ");
		int num3=ingreso.nextInt();
		
		System.out.print("Ingrese un orden: A para ascendente o D para descendente ");
		String orden=ingreso.next();
		
		int numeros[]= {num1, num2, num3}; 
		
		//int numeros[]= {55,2,25};
		
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