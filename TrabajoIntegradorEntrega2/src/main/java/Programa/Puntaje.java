package Programa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Domain.Equipo;
import Domain.Participante;
import Domain.Partido;
import Domain.Pronostico;
import Domain.Ronda;
import Enum.Resultado;

public class Puntaje {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Asigno rutas a variables
		String archivoPronosticos = "src\\main\\java\\Files\\pronostico.csv" ;
		String archivoResultados = "src\\main\\java\\Files\\resultados.csv" ;
			
		
				
		/*Gestión de rondas*/
		//Creo una lista para resultados e intenta cargar datos
		
		List<String> resultadosLista = new ArrayList<String>();
		
				
		try {
			resultadosLista = Files.readAllLines(Paths.get(archivoResultados));		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Valido el contenido del archivo de resultados
		
		int cantColumnas=5;
		for (int i=0; i < resultadosLista.size(); i++ ) {	
			
			String[] arrayDeLinea = resultadosLista.get(i).split(",");	

	        if(arrayDeLinea.length != cantColumnas) {
	        	
		        System.out.println("Error! diferente cantidad de campos a la espereda");
		        System.exit(1);	 
	        
	        }

	        try {
	            Integer.parseInt(arrayDeLinea[2]); 
	            Integer.parseInt(arrayDeLinea[3]); 
	            
	        } catch (Exception e) {
	        	
	            System.out.println("Error! goles debe ser un entero");
	            System.exit(1);	            
	        }
	        
	    }
		
		
		//Creo lista para partidos y rondas
		
		List<Partido> partidos=new ArrayList<Partido>();
		List<Ronda> rondas=new ArrayList<Ronda>();

		//Itero lista de resultados
		
		boolean asignarRonda= false;
		
		for (int i=0; i < resultadosLista.size(); i++ ) {	
			
			String[] arrayDeLinea = resultadosLista.get(i).split(",", 5);	
		
			 Equipo equipoLocal=new Equipo(arrayDeLinea[1],"");
			 
			 Equipo equipoVisitante=new Equipo(arrayDeLinea[4],"");
			
			 // Creo partido y agrego a lista
			 
			 Partido partido= new Partido(equipoLocal, equipoVisitante, Integer.parseInt(arrayDeLinea[2]), Integer.parseInt(arrayDeLinea[3]) );	
			 
			 partidos.add(partido);	
		
			 // Controlo cambio de ronda	 
			if (i != resultadosLista.size()-1) {
				String[] arrayDeLineaSiguiente = resultadosLista.get(i+1).split(",", 5);	
				if (!arrayDeLinea[0].equals(arrayDeLineaSiguiente[0])) {
					asignarRonda= true;
				}
			} else {
				asignarRonda= true;
			}
			 
			// Creo ronda y agrego a lista
				if (asignarRonda) {	
					
					
					Partido[] parRnd= new Partido[partidos.size()];
					
					Ronda ron= new Ronda(arrayDeLinea[0], partidos.toArray(parRnd) );
					rondas.add(ron);	
					
					//System.out.println(ron.mostrarRonda());	
					
					partidos.clear();
					asignarRonda= false;
				}	
			 
	
		}
		
		
		/*Gestión de pronósticos*/ 

		
		//Creo una lista para pronósticos e intenta cargar datos
		
		List<String> pronosticosLista = new ArrayList<String>();	 
		
		int puntos=0;
		
		try {
			
			pronosticosLista = Files.readAllLines(Paths.get(archivoPronosticos));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Creo una lista de participantes y agrego cada participante a la lista
		
	
		Pronostico[] pronostico=new Pronostico[pronosticosLista.size()+1]; 
		
		List<Participante> participantes = new ArrayList<Participante>();
		
		String participanteNombre="";
		
		
		
		for (String pronosticoLinea : pronosticosLista) {
			
			String[] arrayDeLinea = pronosticoLinea.split(",", 6);	
			
			if (!participanteNombre.equals(arrayDeLinea[0])) {
				participanteNombre=arrayDeLinea[0];
				
				Participante participante= new Participante(participanteNombre, puntos);
				participantes.add(participante);
				
				
			}
		}
		
			
		// Cargo cada uno de los pronósticos
		
		
		int i =0;
		
				// Itero por participantes
				for (Participante pp: participantes ) {
		
						// Itero por línea de datos, pronósticos
						for (String pronosticoLinea : pronosticosLista) {
								
							String[] arrayDeLinea = pronosticoLinea.split(",", 6);	
															
							// Itero por rondas
							for (int a=0; a<rondas.size();a++) {
							
								//Recupero partidos de cada ronda
								for ( Partido p: rondas.get(a).getPartidos()) {
										
									
									//Valido que los equipos del partido coincidan con con los equipos del pronostico
									if (pp.getNombre().equals(arrayDeLinea[0]) && 
										p.getEquipo1().getNombre().equals(arrayDeLinea[1]) && 
										p.getEquipo2().getNombre().equals(arrayDeLinea[5])) {
										
										//Asigno resultado al pronostico
										Resultado pronos;
									 	
											if (arrayDeLinea[2].contains("x")) {
												
												pronos= Resultado.ganador ;
											} else if (arrayDeLinea[3].contains("x")) {
											
												pronos= Resultado.empate;
												
											} else  {	
												
												pronos= Resultado.perdedor;
												
											}
										//Creo pronostico
										pronostico[i]=new Pronostico(p, p.getEquipo1(), pronos);		 																						
										//Acumulo puntos
										puntos+=pronostico[i].puntos();
										//Seteo puntos al participante
										pp.setPuntos(puntos);
										i++;
											
									}	
								}
							}

								
						}

						puntos=0;
				}	
				//itero participantes y muestro puntaje
				for (Participante pp: participantes ) {
					
					System.out.println(pp.mostrarParticipante());
		
				}
	}
	
}
