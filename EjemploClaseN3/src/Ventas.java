import java.util.Scanner;
public class Ventas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int ventas[]=new int [5];
		ventas[0]=50;
		ventas[1]=45;
		ventas[2]=60;
		ventas[3]=49;
		ventas[4]=65;
*/
		/*int ventas[]= {50,45,60,49,65};*/
		
		int ventas[]=new int[5];
		
		Scanner ent=new Scanner (System.in);
		
		for (int i=0;i<ventas.length;i++)
		{
			System.out.print("Venta ");
			ventas[i]=ent.nextInt();
		}
		
		int a=0;
		
		System.out.println("Cantidad de elementos "+ventas.length);
		
		for (int i=0; i<ventas.length;i++)
		{
			System.out.println(ventas[i]);
			a=a+ventas[i];
		}
		System.out.println("Cantidad total de ventas "+a);
	}

}
