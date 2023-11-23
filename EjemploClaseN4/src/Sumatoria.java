
public class Sumatoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numeros[]=new int[] {1,37,16};
		int resultado=0;
		int x=15;
		
		for (int i=0;i<numeros.length;i++) {
			
			if (numeros[i]>x) {
			
			resultado=resultado+numeros[i];
		
			}
		}
		System.out.print(resultado);
	}

}
