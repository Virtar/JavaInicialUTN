package Programa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Equipo;
import Domain.Participante;
import Domain.Partido;
import Domain.Pronostico;
import Domain.Ronda;
import Domain.Fase;
import Enum.Resultado;
import Domain.Base;

public class Puntaje {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Asigno rutas a variables
		String archivoResultados = "src\\main\\java\\Files\\resultadosTP3.csv" ;
		String archivoConfiguracion = "src\\main\\java\\Files\\configuracion.csv"; 
		
		
		
		//Leo archivo configuracion
		
		List<String> configuracionLista = new ArrayList<String>();
				
		try {
			configuracionLista = Files.readAllLines(Paths.get(archivoConfiguracion));		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] arrayConfig =configuracionLista.get(0).split(",");
		
		//Asigno configuracion de puntos
		int puntosPorAcierto=Integer.parseInt(arrayConfig[0]);
		int puntosExtraPorRonda=Integer.parseInt(arrayConfig[1]);
		int puntosExtraPorFase=Integer.parseInt(arrayConfig[2]);
		
		int partidosPorRonda=0;
		int aciertoPorRonda=0;
		int rondasPorFase=0;
		int partidosPorRondaPorFase=0;
		int aciertoPorFase=0;
				
		
		
		
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
		
		int cantColumnas=6;
		for (int i=0; i < resultadosLista.size(); i++ ) {	
			
			String[] arrayDeLinea = resultadosLista.get(i).split(",");	

	        if(arrayDeLinea.length != cantColumnas) {
	        	
		        System.out.println("Error! diferente cantidad de campos a la espereda");
		        System.exit(1);	 
	        
	        }

	        try {
	            Integer.parseInt(arrayDeLinea[3]); 
	            Integer.parseInt(arrayDeLinea[4]); 
	            
	        } catch (Exception e) {
	        	
	            System.out.println("Error! goles debe ser un entero");
	            System.exit(1);	            
	        }
	        
	    }
		
		
		//Creo lista para partidos y rondas
		
		List<Partido> partidos=new ArrayList<Partido>();
		List<Ronda> rondas=new ArrayList<Ronda>();
		List<Fase> fases=new ArrayList<Fase>();

		//Itero lista de resultados
		
		boolean asignarRonda= false;
		boolean asignarFase= false;
		
		for (int i=0; i < resultadosLista.size(); i++ ) {	
			
			String[] arrayDeLinea = resultadosLista.get(i).split(",", 6);	
		
			 Equipo equipoLocal=new Equipo(arrayDeLinea[2],"");
			 
			 Equipo equipoVisitante=new Equipo(arrayDeLinea[5],"");
			
			 // Creo partido y agrego a lista
			 
			 Partido partido= new Partido(equipoLocal, equipoVisitante, Integer.parseInt(arrayDeLinea[3]), Integer.parseInt(arrayDeLinea[4]) );	
			 
			 partidos.add(partido);	
		
			 // Controlo cambio de ronda	 
			if (i != resultadosLista.size()-1) {
				String[] arrayDeLineaSiguiente = resultadosLista.get(i+1).split(",", 6);	
				if (!arrayDeLinea[1].equals(arrayDeLineaSiguiente[1])) {
					asignarRonda= true;
				}
			} else {
				asignarRonda= true;
			}
			 
			// Creo ronda y agrego a lista
			if (asignarRonda) {	
				
				
				Partido[] parRnd= new Partido[partidos.size()];
				
				Ronda ron= new Ronda(arrayDeLinea[1], partidos.toArray(parRnd) );
				rondas.add(ron);	
				
				//System.out.println(ron.mostrarRonda());	
				
				partidos.clear();
				asignarRonda= false;
			}	
						
			// Controlo cambio de fase	 
			if (i != resultadosLista.size()-1) {
				String[] arrayDeLineaSiguiente = resultadosLista.get(i+1).split(",", 6);	
				if (!arrayDeLinea[0].equals(arrayDeLineaSiguiente[0])) {
					asignarFase= true;
				}
			} else {
				asignarFase= true;
			}
			 
			// Creo Fase y agrego a lista
			if (asignarFase) {					
				
				Ronda[] parFs= new Ronda[rondas.size()];
				
				Fase fas= new Fase(arrayDeLinea[0], rondas.toArray(parFs) );
				fases.add(fas);	
				
				//System.out.println(fas.mostrarFase());	
				
				rondas.clear();
				asignarFase= false;
			}

		}
		
		
		/* 
		 ************************** 
		 * Gestión de pronósticos *
		 **************************
		 */ 

		
		//Creo una lista para pronósticos e intenta cargar datos 
		
		int puntos=0;
		
		
		//Consulto cantidad total de pronósticos
		
		int cantidadPronosticos=0;
		
		try {
			cantidadPronosticos= Base.consultarDBTotalDePronosticos();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Base.desconectarDB();
		
		//Creo una lista de participantes y agrego cada participante a la lista
		
		Pronostico[] pronostico=new Pronostico[cantidadPronosticos]; 
		
		List<Participante> participantes = new ArrayList<Participante>();
		
		//Consulto participantes
		ResultSet setParticipantes;
		
		try {
			
		setParticipantes = Base.consultarDBParticipantes();	
		
			while(setParticipantes.next())
			{
				Participante participante= new Participante(setParticipantes.getString("persona"), puntos);
				participantes.add(participante);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Base.desconectarDB();
		
			
		// Cargo cada uno de los pronósticos
		
		int i =0;
		
				// Itero por participantes
				for (Participante pp: participantes ) {
 
					// Itero set pronósticos
						
					ResultSet setPronosticosParticipante;
					
					try {
						
						setPronosticosParticipante = Base.consultarDBPronosticos(pp);	
					
						while(setPronosticosParticipante.next())
						{
							
							// Itero por fase
							for (Fase ff: fases) {
							
							// Itero por rondas
								for ( Ronda rr: ff.getRondas()) {
									
								//Recupero partidos de cada ronda
									for ( Partido p: rr.getPartidos()) {
											
									 
										//Valido que los equipos del partido coincidan con los equipos del pronostico
										
										if (p.getEquipo1().getNombre().equals(setPronosticosParticipante.getString("equipo_local")) && 
											p.getEquipo2().getNombre().equals(setPronosticosParticipante.getString("equipo_visitante"))) {
											
											//Asigno resultado al pronostico
											Resultado pronos;
										 	
												if (setPronosticosParticipante.getString("resultado").contains("l")) {
													
													pronos= Resultado.ganador ;
													
												} else if (setPronosticosParticipante.getString("resultado").contains("e")) {
												
													pronos= Resultado.empate;
													
												} else {	
													
													pronos= Resultado.perdedor;
													
												}
																							
												
											//Creo pronostico
											pronostico[i]=new Pronostico(p, p.getEquipo1(), pronos);		 																						
											
											//Acumulo puntos
											puntos+=pronostico[i].puntos(puntosPorAcierto);
											//Acumulo puntos por ronda
											aciertoPorRonda+=pronostico[i].puntos(puntosPorAcierto);
											//Acumulo puntos por fase
											aciertoPorFase+=pronostico[i].puntos(puntosPorAcierto);
											
																
											//Seteo puntos al participante
											pp.setPuntos(puntos);
											
											//Acumulo cantidad de partidos por ronda
											partidosPorRonda++;
											
											i++;	
											
											
											//Valido que cantidad partidos por ronda contra el acumulador
											if(rr.getPartidos().length==partidosPorRonda) {
												//Acumulo cantidad de partidos por ronda por fase
												partidosPorRondaPorFase+=rr.getPartidos().length;
												//Acumulo ronda por fase
												rondasPorFase++;
												
												//Valido que cantidad puntos maximos por ronda vs obtenidos
												if(rr.getPartidos().length*puntosPorAcierto==aciertoPorRonda) {
													//Sumo puntos extra
													puntos+=puntosExtraPorRonda;
													//Seteo puntos al participante
													pp.setPuntos(puntos);
													
													}
												
												//Valido que cantidad rondas por fase contra el acumulador
												if(ff.getRondas().length==rondasPorFase) {
													//Valido que cantidad puntos maximos de partidos por fase vs aciertos obtenidos													
													if(partidosPorRondaPorFase*puntosPorAcierto==aciertoPorFase) {
														
														//Sumo puntos extra
														puntos+=puntosExtraPorFase;
														//Seteo puntos al participante
														pp.setPuntos(puntos);
														
														}
													
													//Reset de acumuladores de fase
													aciertoPorFase=0;
													partidosPorRondaPorFase=0;
													rondasPorFase=0;
													}
												
											//Reset de acumuladores de Ronda	
											partidosPorRonda=0;
											aciertoPorRonda=0;
											}
										} //fin validar partidos
																			
									} //fin partidos								
									
								} //fin rondas								
								
							} //fin fases
							
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
				//reset de puntos por participante	
				puntos=0;	
					
				} //fin participantes
						
				
				
				//itero participantes y muestro puntaje
				
				for (Participante pp: participantes ) {
					
					System.out.println(pp.mostrarParticipante());
		
				}
				
				Base.desconectarDB();	
				
				
	}
	
}
