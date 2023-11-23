
public class Triangulos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float lado1,lado2,lado3;

	
		lado1=5;
		lado2=5;
		lado3=4;
		
		if (lado1==lado2 && lado2==lado3) {
			System.out.println ("El triangulo es equilatero");
		}
		else 
			if (lado1==lado2 || lado1==lado3 || lado2==lado3) 
			{System.out.println ("El triangulo es isosceles");
			}
			
			else 
			{System.out.println ("El triangulo es escaleno");
			
			}
		
	}

}
