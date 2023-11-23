/**
 * 
 */
package Domain;

/**
 * @author lucas
 *
 */
public class Participante {
	
	private String nombre;
	
	private int puntos;
	
	
	public Participante(String nombre, int puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public void setPuntos(int unosPuntos) {
		this.puntos = unosPuntos;
	}
	
    public String mostrarParticipante(){
        
        return ("Particiante: "+this.getNombre()+" Puntos: "+this.getPuntos());
    }

}
