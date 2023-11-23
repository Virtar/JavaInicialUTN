
public class Metodo1C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int vector[]=new int [] {12,56,88,96,77};
		int x=60;
		int y=0;
		
		for (int v : vector) {
			if (v>x) {
				y+=v;
				
			}
		}
		
		System.out.print(y);
	}

}
