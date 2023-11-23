
public class Metodo1A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String frase="Hola Bienvenidos ";
		int c=0;
		
		for (int i=0;i<frase.length();i++)
		{
			if (frase.charAt(i)=='e')
			{
				c++;
			}
		}
		System.out.println("Cantidad de e "+c);
	}

}
