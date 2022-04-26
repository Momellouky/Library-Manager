package Util;

public class LivreException extends Exception {
	
	private String msj; 
	
	public LivreException(String msj) {
		
		super(msj); 
		this.msj = msj; 
		
	}
	
	public String getMessage() {
		
		return msj; 
		
	}
	
}
