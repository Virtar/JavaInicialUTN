import java.util.Scanner;
public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ent= new Scanner(System.in);

		System.out.print("Ingrese usuario ");

		String u1=ent.next();

		System.out.print("Ingrese clave ");

		String c1=ent.next();

		if (usuarioValido(u1,c1))

		{

			System.out.println("Bienvenido");

		}

		else

		{

			System.out.println("Credenciales invalidas");

		}

	}

 

	private static boolean usuarioValido(String usuario, String clave)

	{

		String usuarioSistema="admin";

		String claveSistema="Hf89Cv";

		boolean resultado=false;

		if (usuario.equals(usuarioSistema))

		{

			if (clave.equals(claveSistema))

			{

				resultado=true;

			}

			else

			{

				System.out.println("La clave no coincide");

			}

		}

		else

		{

			System.out.println("Nombre de usuario no coincide");

		}

		return resultado;		

	}

	

}