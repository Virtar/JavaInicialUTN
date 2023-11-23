public class Metodo1B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numero1=55;
		int numero2=2;
		int numero3=25;
		
		int numeros[]=new int [3];
		
		boolean ordenDescendente=false;
		
		if (ordenDescendente) {
			if (numero1 > numero2  && numero1 > numero3)
			{
			 System.out.println(numero1);
			 
				if ( numero2 > numero3)
					{
					 System.out.println(numero2);
					 System.out.println(numero3);
				} else { 
					 System.out.println(numero3);
					 System.out.println(numero2);
				}
			 
			} else if (numero2 > numero1  && numero2 > numero3) {
				
				 System.out.println(numero2);
			
				 if ( numero1 > numero3)
					{
					 System.out.println(numero1);
					 System.out.println(numero3);
					} else { 
						 System.out.println(numero3);
						 System.out.println(numero1);
					}
			
			} else { 
			
				System.out.println(numero3);
				
				 if ( numero1 > numero2)
					{
					 System.out.println(numero1);
					 System.out.println(numero2);
					} else { 
						 System.out.println(numero2);
						 System.out.println(numero1);
					}
				
				
			}	
				
				

			
			
		} else {
			
		
		if (numero1 < numero2  && numero1 < numero3)
		{
		 System.out.println(numero1);
		 
		 if ( numero2 < numero3)
			{
			 System.out.println(numero2);
			 System.out.println(numero3);
			} else { 
				 System.out.println(numero3);
				 System.out.println(numero2);
			}
		 
		} else if (numero2 < numero1  && numero2 < numero3) {
			
			 System.out.println(numero2);
		
			 if ( numero1 < numero3)
				{
				 System.out.println(numero1);
				 System.out.println(numero3);
				} else { 
					 System.out.println(numero3);
					 System.out.println(numero1);
				}
		
		} else { 
		
			System.out.println(numero3);
			
			 if ( numero1 < numero2)
				{
				 System.out.println(numero1);
				 System.out.println(numero2);
				} else { 
					 System.out.println(numero2);
					 System.out.println(numero1);
				}
			
			
		}	
			
		
		
		
		}
		
		
		
			
		} //no borrar
		
	}
				
	


