
public class Cadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String frase="La casa de al lado tiene un balcon con geranios. Todos los dias, se riegan";
		String Domicilio="Constituyentes 3456";
		int c=0;
		
		System.out.println("Cantidad de letras "+ frase.length());
		for (int i=0;i<Domicilio.length();i++)
		{
			if (Domicilio.charAt(i)=='e')
			{
				c++;
			}
		}
		System.out.println("Cantidad de e "+c);
		System.out.println("A mayusculas "+Domicilio.toUpperCase());
	}

}
