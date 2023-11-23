import java.util.Scanner;
public class OperacionesC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeroInicio = 5;
		int numeroFin = 14;
		
		int i = numeroInicio;
		
		
		Scanner num=new Scanner(System.in);
		
		System.out.print ("0 para numeros pares o 1 para impares ");
		
		int paroimpar=num.nextInt();
		
		while (i<=numeroFin) {
			if (paroimpar==0) {
			
				if (i%2==0) {
				System.out.println(i);
			}
			}
		
			else 
				if (paroimpar==1) {
					if (i%2!=0) {
					System.out.println(i);
					}
					
		
	}
		i++;	
	}
	}
}
	


