package model;

import java.sql.Statement;

public class ExemplaireModel {
	
	private String numInv; 
	private String etat;
	private Connexion currentCnx; 
	
	
	public ExemplaireModel(String etat, String numInv, Connexion currentCnx) {
		
		super();
		this.etat = etat;
		this.currentCnx = currentCnx;
		this.numInv = numInv; 
		
	}
	
	
	public void updateEtat() throws Exception{
		
		String query = "UPDATE exemplaire " + 
				"SET etat = '" + this.etat + "' " + 
				"WHERE numinvantaire = '" + this.numInv + "' " ; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(query); 
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			throw new Exception(); 
			
		}
		
	}
	
	
	
}
