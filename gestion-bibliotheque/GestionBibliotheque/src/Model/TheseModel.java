package model;

import java.sql.Statement;
import java.util.Date;

public class TheseModel {
	
	private String titre; 
	private Date dtSoutenance; 
	
	private Connexion currentCnx;

	public TheseModel(String titre, Connexion currentCnx) {
		super();
		this.titre = titre;
		this.currentCnx = currentCnx;
	} 
	
	public void deleteThese(String titre) throws Exception{
		
		String query =  "DELETE FROM these WHERE titre = '" + titre + "' "; 
		
		try { 
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			
			st.executeUpdate(query); 
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new Exception(); 
			
		}
		
	}
	
}
