package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Domain.Equipo;
import Domain.Partido;
import Domain.Pronostico;
import Enum.Resultado;

class TestPuntos {

	@Test
	void Puntos() {
				

        Equipo equipo1 = new Equipo("Argentina","");
        Equipo equipo2 = new Equipo("Francia","");

        Partido partido = new Partido(equipo1,equipo2,3,3);

        Pronostico pronostico = new Pronostico(partido,equipo1,Resultado.empate);
        

        assertEquals(1,pronostico.puntos()); 
		
		
	}

}
