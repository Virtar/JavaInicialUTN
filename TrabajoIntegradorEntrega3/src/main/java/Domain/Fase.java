/**
 * 
 */
package Domain;


/**
 * @author lucas
 *
 */
public class Fase {

	private String nro;
	private Ronda[] rondas;
	
	
	
	public Fase(String nro, Ronda[] rondas) {
		this.rondas = rondas;
		this.nro = nro;
	}

	public String getNro() {
		return nro;
	}
	
	public void setNro(String nro) {
		this.nro = nro;
	}
	
	public Ronda[] getRondas() {
		return rondas;
	}
	
	public void setRondas(Ronda[] rondas) {
		this.rondas = rondas;
	}

	
    public String mostrarFase(){
        
    	String rondasFase="";
    	for(Ronda r : rondas) {
    		
    		rondasFase += r.mostrarRonda()+"\n";
    	}
        		
        return("Fase: "+this.getNro()+"\n"+rondasFase);
        
        
    }
    
	
}
