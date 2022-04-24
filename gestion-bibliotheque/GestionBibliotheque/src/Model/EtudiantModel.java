package model;

import java.sql.ResultSet;
import java.sql.Statement;

public class EtudiantModel {
	
	private String cin; 
	private String nom, prenom; 
	private String numTel, email, adresse; 
	private Connexion currentCnx; 
	
	
	
	public EtudiantModel(String cin, String nom, String prenom, String numTel, String email, String adresse, Connexion currentCnx) {
		super();
		this.cin = cin;
		this.nom = nom; 
		this.prenom = prenom; 
		this.numTel = numTel;
		this.email = email;
		this.adresse = adresse;
		this.currentCnx = currentCnx;
	}

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
	
	
	public ResultSet getEtudiant(String cin) throws Exception{
		
		ResultSet rs = null; 
		
		String query = "Select * " + 	
				"From usager u " + 
				"Where u.cin = '" + cin + "'" ; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			rs = st.executeQuery(query); 
			
		}catch(Exception e) {
			
			throw new Exception(); 
			
		}
		
		return rs; 
	}
	
	public void updateEtudiant() throws Exception{
		
		String queryForeignKey = "set foreign_key_checks = 0"; 
		String queryUpdateUsagerTable = "update usager set cin = '" + this.cin + "' , nom = '" + this.nom + "' , prenom = '" + this.prenom + "' , " 
				+ " email = '" + this.email + "' , numTel = '" + this.numTel + "' where cin = '" + this.cin + "' " ; 
		String queryUpdateEtudiantTable = "update etudiant set adresse = '" + this.adresse + "' where cin = '" + this.cin + "' "; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(queryForeignKey); 
			st.executeUpdate(queryUpdateUsagerTable); 
			st.executeUpdate(queryUpdateEtudiantTable); 
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			throw new Exception(); 
			
		}
		
	}
}
