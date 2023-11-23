package Programa;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Domain.Equipo;
import Domain.Partido;
import Domain.Pronostico;
import Enum.Resultado;

/**
 * @author lucas
 *
 */
public class Puntaje {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String archivoPronosticos = "src\\Files\\pronostico.csv" ;
		String archivoResultados = "src\\Files\\resultados.csv" ;
		
		Partido[] partido=new Partido[18];
		Pronostico[] pronostico=new Pronostico[18];
		
		int idPartido;
		int puntos=0;
		
		
		//Cargar Partidos 
		
		
		try {
				for (String linea : Files.readAllLines(Paths.get(archivoResultados))){
				
				 String[] arrayDeLinea = linea.split(",", 5);	
				
				 idPartido=Integer.parseInt(arrayDeLinea[0]);	
				 
				 Equipo equipoLocal=new Equipo(arrayDeLinea[1],"");
				 
				 Equipo equipoVisitante=new Equipo(arrayDeLinea[4],"");
				 
				 partido[idPartido]=new Partido(equipoLocal, equipoVisitante, Integer.parseInt(arrayDeLinea[2]), Integer.parseInt(arrayDeLinea[3]));		 
				
				 //Ver Partidos y resultados 
				/* 
				  System.out.println((partido[idPartido]).mostrarPartido());
				  System.out.println(partido[idPartido].resultado(equipoLocal));
				  System.out.println(partido[idPartido].resultado(equipoVisitante));
				  */
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			 
		//Pronosticos
		
		try {
			
	
				for (String linea : Files.readAllLines(Paths.get(archivoPronosticos))){
				
				String[] arrayDeLinea = linea.split(",", 6);	
				
				idPartido=Integer.parseInt(arrayDeLinea[0]);	
				
				Resultado pronos;
				 	
					if (arrayDeLinea[2].contains("x")) {
						
						pronos= Resultado.ganador ;
					} else if (arrayDeLinea[3].contains("x")) {
					
						pronos= Resultado.empate;
						
					} else  {	
						
						pronos= Resultado.perdedor;
						
					}
					
				pronostico[idPartido]=new Pronostico(partido[idPartido], partido[idPartido].getEquipo1(), pronos);		 
				
				
				
				
				//System.out.println(pronostico[idPartido].mostrarPronostico()+" PUNTOS: "+pronostico[idPartido].puntos());
			 
				puntos+=pronostico[idPartido].puntos(); 
				
				}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Puntaje = "+puntos);
		
	}
		
}
	



