package model;

import java.sql.*;

public class UsagerModel {
	
	private String cin, nom, prenom; 
	private Connexion currentCnx; 
	
	public UsagerModel(Connexion currentCnx) {
		
		this.currentCnx = currentCnx; 
		
	}
	
	public ResultSet getUsager(String cin) {
		
		ResultSet rs = null; 
		String query = "Select cin, nom, prenom " + 
				"FROM usager " + 
				"WHERE cin = '" + cin + "'" ; 
	
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement();
			rs = st.executeQuery(query); 
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return rs; 
		
	}
	
	public boolean isEnseignant(String cin) {
		
		ResultSet rs = null; 
		
		String query = "SELECT cin FROM enseignant Where cin = '" + cin + "'"; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement();
			rs = st.executeQuery(query); 
			
			if(rs.next() == true)
				return true; 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false; 
		
	}
	
	public boolean isEtudiant(String cin) {
		
		ResultSet rs = null; 
		
		String query = "SELECT cin FROM etudiant Where cin = '" + cin + "'"; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement();
			rs = st.executeQuery(query); 
			
			if(rs.next() == true)
				return true; 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false; 
		
	}
}
