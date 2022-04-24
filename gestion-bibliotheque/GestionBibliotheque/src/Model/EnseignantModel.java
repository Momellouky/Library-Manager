package model;

import java.sql.ResultSet;
import java.sql.Statement;

public class EnseignantModel {
	
	private String cin; 
	private String nom, prenom; 
	private String grade;
	private String numTel, email; 
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
	
	
	
	public EnseignantModel(String cin, String nom, String prenom, String grade, String email, String numTel,
			Connexion currentCnx) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.grade = grade;
		this.numTel = numTel;
		this.email = email;
		this.currentCnx = currentCnx;
	}

	public ResultSet getEns() throws Exception{
		
		ResultSet rs = null; 
		
		String query = "Select e.cin, u.nom, u.prenom, e.grade, u.email, u.numTel " + 	
				"From usager u, enseignant e " + 
				"Where u.cin = e.cin " ; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			rs = st.executeQuery(query); 
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new Exception(); 
			
		}
		
		return rs; 
	}
	
	public void UpdateModel() throws Exception{
		
		String queryForeignKey = "set foreign_key_checks = 0"; 
		String queryUpdateEnseignantTable = "update enseignant set grade = '" + this.grade + "' where cin = '" + this.cin + "'";
		String queryUpdateUsagerTable = "update usager set nom = '" + this.nom + "' , " 
				+ "prenom = '" + this.prenom + "' , email = '" + this.email + "' , numTel = '" + this.numTel + "' where cin = '" + this.cin  + "'" ; 
		

		
	try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(queryForeignKey); 
			st.executeUpdate(queryUpdateEnseignantTable);  
			st.executeUpdate(queryUpdateUsagerTable);  
			 
		}catch(Exception ex) {
			
			ex.printStackTrace();
			throw new Exception(); 
			
		}
		
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

	public ResultSet getEns(String cin) throws Exception{
		
		ResultSet rs = null; 
		
		String query = "Select * " + 	
				"From usager u " + 
				"Where u.cin = '" + cin + "' " ; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			rs = st.executeQuery(query); 
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new Exception(); 
			
		}
		
		return rs; 
		
	}
	
	
	
}
