/**
 * 
 */
package Domain;


/**
 * @author lucas
 *
 */
public class Ronda {

	private String nro;
	private Partido[] partidos;
	
	
	
	public Ronda(String nro, Partido[] partidos) {
		this.partidos = partidos;
		this.nro = nro;
	}

	public String getNro() {
		return nro;
	}
	
	public void setNro(String nro) {
		this.nro = nro;
	}
	
	public Partido[] getPartidos() {
		return partidos;
	}
	
	public void setPartidos(Partido[] partidos) {
		this.partidos = partidos;
	}

	
    public String mostrarRonda(){
        
    	String partidosRonda="";
    	for(Partido p : partidos) {
    		
    		partidosRonda += p.mostrarPartido()+"\n";
    	}
        		
        return("Ronda: "+this.getNro()+"\n"+partidosRonda);
        
        
    }
    
	
}
