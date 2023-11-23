
public class Promedio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numeros[]=new int[] {5,5,6};
		float resultado=sumatoria(numeros);
		resultado=resultado/numeros.length;
		
		System.out.println("Promedio "+resultado);		
	}
	
	private static int sumatoria(int[] numerosASumar) {


		int suma=0;
		for (int i=0;i<numerosASumar.length;i++) 
		{
			suma=suma+numerosASumar[i];
		}
		return suma;

	}
}

	


