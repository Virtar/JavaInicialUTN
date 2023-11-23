public class MetodoCoyDecod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String codigo="abcdefghijklmnñopqrstuvwxyz";
		String mensajeDeco="hola que tal";
		String mensajeCod="";
		int desplazamiento=2;
		
		char arregloLetras[]= mensajeDeco.toCharArray();
		int indices[]=new int[arregloLetras.length];
		
		
		for (int i = 0; i < arregloLetras.length; i++) {
				
			indices[i] = codigo.indexOf(arregloLetras[i])+desplazamiento;
			
		}	
		
		
		for (int i=0; i < indices.length;i++) {
			
			mensajeCod+=codigo.charAt(indices[i]);
			
		}
		
		System.out.println(mensajeCod);
	//System.out.println(Arrays.toString(indices));
		
//fin codigo
		
		//empieza deco 
		
		
		mensajeDeco=mensajeCod;
		mensajeCod="";
		char arregloLetras2[]= mensajeDeco.toCharArray();
		int indices2[]=new int[arregloLetras2.length];
		
		
		for (int i = 0; i < arregloLetras2.length; i++) {
				
			indices2[i] = codigo.indexOf(arregloLetras2[i])-desplazamiento;
			
		}	
		
		//System.out.println(Arrays.toString(indices2));
		 
		for (int i=0; i < indices2.length;i++) {
			
		if (indices2[i]==-1) {
		
			mensajeCod+=" "; 
			
		}	else {
			
			mensajeCod+=codigo.charAt(indices2[i]);
		}
			
		}
		
		System.out.print(mensajeCod);
		
				
	}
	

	

}

