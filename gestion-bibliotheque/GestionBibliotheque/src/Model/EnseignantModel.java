package model;

import java.sql.ResultSet;
import java.sql.Statement;

public class EnseignantModel {
	
	private String cin; 
	private String grade;
	private Connexion currentCnx;
	
	
	public EnseignantModel(Connexion currentCnx) {
		super();
		this.currentCnx = currentCnx;
	} 
	
	public EnseignantModel(String cin, Connexion currentCnx) {
		super();
		this.cin = cin; 
		this.currentCnx = currentCnx;
	} 
	
	public ResultSet getEns() throws Exception{
		
		ResultSet rs = null; 
		
		String query = "Select e.cin, u.nom, u.prenom, e.grade " + 	
				"From usager u, enseignant e " + 
				"Where u.cin = e.cin " ; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			rs = st.executeQuery(query); 
			
		}catch(Exception e) {
			
			throw new Exception(); 
			
		}
		
		return rs; 
	}
	
	
	
	public void deleteEns(String cin) throws Exception{
		
		String query =  "DELETE FROM enseignant WHERE cin  = '" + cin + "' "; 
		
		try { 
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			
			st.executeUpdate(query); 
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new Exception(); 
			
		}
		
	}
	
	
	
}
