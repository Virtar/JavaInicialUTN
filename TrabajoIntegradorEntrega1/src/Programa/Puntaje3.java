package Programa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Domain.Equipo;
import Domain.Partido;
import Domain.Pronostico;
import Enum.Resultado;

public class Puntaje3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String archivoPronosticos = "src\\Files\\pronostico.csv" ;
		String archivoResultados = "src\\Files\\resultados.csv" ;
			
		int idPartido;
		int puntos=0;
				
		//Cargar Partidos 
		
		List<String> resultadosLista = new ArrayList<String>();
		
				
		try {
			resultadosLista = Files.readAllLines(Paths.get(archivoResultados));		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Partido[] partido=new Partido[resultadosLista.size()+1];
		
		for (String resultadoLinea : resultadosLista) {
			
			 String[] arrayDeLinea = resultadoLinea.split(",", 5);	
			
			 idPartido=Integer.parseInt(arrayDeLinea[0]);	
			 
			 Equipo equipoLocal=new Equipo(arrayDeLinea[1],"");
			 
			 Equipo equipoVisitante=new Equipo(arrayDeLinea[4],"");
			 
			 partido[idPartido]=new Partido(equipoLocal, equipoVisitante, Integer.parseInt(arrayDeLinea[2]), Integer.parseInt(arrayDeLinea[3]) );		 
			
			 //Ver Partidos y resultados 
			 /*
			  System.out.println((partido[idPartido]).mostrarPartido());
			  System.out.println(partido[idPartido].resultado(equipoLocal));
			  System.out.println(partido[idPartido].resultado(equipoVisitante));
			  */
		
		}
			 
		//Pronosticos
			 
				//
				//
			 
		List<String> pronosticosLista = new ArrayList<String>();	 
		
		try {
			
			pronosticosLista = Files.readAllLines(Paths.get(archivoPronosticos));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Pronostico[] pronostico=new Pronostico[pronosticosLista.size()+1]; 
		
		for (String pronosticoLinea : pronosticosLista) {
				
			String[] arrayDeLinea = pronosticoLinea.split(",", 6);	
			
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
			System.out.println("Puntaje = "+puntos);
	}
	
}
