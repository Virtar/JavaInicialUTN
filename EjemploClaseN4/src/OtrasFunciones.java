import java.util.Scanner;
public class OtrasFunciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada=new Scanner(System.in);
		System.out.print("Ingrese un numero ");
		int num=entrada.nextInt();
		
		if (esPar(num)) 
		{
			System.out.print("Es PAR");
		}
		else 
		{
			System.out.print("Es IMPAR");
		}
	}

	private static boolean esPar(int numero)
	{
		boolean resultado=false;
		if (numero%2==0) 
				
		{
			resultado=true;
		}
		
		return resultado;
}
}
