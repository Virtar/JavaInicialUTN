import java.util.Scanner;
public class OperacionesB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeroInicio = 5;
		int numeroFin = 14;
		
		int i = numeroInicio;
		
		
		Boolean par=false;
		
		while (i<=numeroFin) {
			if (par==true) {
			
				if (i%2==0) {
				System.out.println(i);
			}
			}
		
			else 
				if (par==false) {
					if (i%2!=0) {
					System.out.println(i);
					}
					
		
	}
		i++;	
	}
	}
}

	
