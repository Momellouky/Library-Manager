package model;

import java.sql.ResultSet;
import java.sql.Statement;

public class EtudiantModel {
	
	private String cin; 
	private String adresse; 
	private Connexion currentCnx; 
	
	
	
	public EtudiantModel(Connexion currentCnx) {
		super();
		this.currentCnx = currentCnx;
	}

	public EtudiantModel(String cin, Connexion currentCnx) {
		super();
		this.cin = cin; 
		this.currentCnx = currentCnx;
	}
	
	public ResultSet getEtudiant() throws Exception{
		
		ResultSet rs = null; 
		
		String query = "Select e.cin, u.nom, u.prenom, e.adresse " + 	
				"From usager u, etudiant e " + 
				"Where u.cin = e.cin " ; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			rs = st.executeQuery(query); 
			
		}catch(Exception e) {
			
			throw new Exception(); 
			
		}
		
		return rs; 
	}
	

	public void deleteEtudiant(String cin) throws Exception{
		
		String query =  "DELETE FROM etudiant WHERE cin  = '" + cin + "' "; 
		
		try { 
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			
			st.executeUpdate(query); 
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new Exception(); 
			
		}
		
	}
}
