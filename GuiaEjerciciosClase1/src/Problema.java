import java.util.Scanner;

public class Problema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner ingresos=new Scanner(System.in);
		System.out.print ("complete sueldo ");
		int sueldo=ingresos.nextInt();
	
		Scanner vehiculos=new Scanner(System.in);
		System.out.print ("Cantidad de autos que posee ");
		int autos=vehiculos.nextInt();
		
		Scanner casas=new Scanner(System.in);
		System.out.print("Cantidad de inmuebles ");
		int inmuebles=casas.nextInt();
		
		Scanner lujos=new Scanner(System.in);
		System.out.print("Cantidad de embarcaciones, aeronaves y activos societarios ");
		int bienesLujo=lujos.nextInt();
		
		
		if ((sueldo>=489083) || (autos>=3) ||(inmuebles>=3) || (bienesLujo>0)) {
			System.out.print("pertenece al segmento de ingresos altos");
		} else {
			System.out.print("No pertenece al segmento de ingresos altos");
		}
		
	}

}
