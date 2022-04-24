package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TheseModel {
	
	private String titre; 
	private Date dtSoutenance; 
	
	private Connexion currentCnx;

	public TheseModel() {}
	
	
	
	public TheseModel(Connexion currentCnx) {
		super();
		this.currentCnx = currentCnx;
	}



	public TheseModel(String titre, Connexion currentCnx) {
		super();
		this.titre = titre;
		this.currentCnx = currentCnx;
	}

	public TheseModel(String titre, Date dtSoutenance,  Connexion currentCnx) {
		super();
		this.titre = titre;
		this.dtSoutenance = dtSoutenance; 
		this.currentCnx = currentCnx;
	} 
	
	public void ajouterThese(String titre, String nomAuteur, String prenomAuteur, Date dtSoutenance) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String queryAddThese = "INSERT INTO these VALUES('" + titre + "', STR_TO_DATE('" + sdf.format(dtSoutenance) + "' , '%Y-%m-%d'))"; 
		String searchIdAuteur = "SELECT id from auteur where nom = '" + nomAuteur + "' and prenom = '" + prenomAuteur + "' "; 
		
 		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			Statement st2 = currentCnx.getMyCnx().createStatement(); 
			Statement st3 = currentCnx.getMyCnx().createStatement(); 
			
			ResultSet rs = st.executeQuery(searchIdAuteur); 
			st2.executeUpdate(queryAddThese); 
			String addAuteurThese = new String(); 
			if(!rs.next() == false)
				addAuteurThese = "insert into ecrirethese values ('" + rs.getString(1) + "' , '" + titre + "' )";  
				
			
			st3.executeUpdate(addAuteurThese); 
			
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			throw new Exception(); 
			
		}
	
	}
	
	public void UpdateThese() throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String foreignChecks = "set foreign_key_checks = 0"; 
		String query = "Update these set datesoutenance = STR_TO_DATE('"+ sdf.format(dtSoutenance).substring(0, 10) + "','%Y-%m-%d')"
				+"WHERE titre = '" + this.titre + "' "; 
		
	try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(foreignChecks); 
			st.executeUpdate(query); 
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			throw new Exception(); 
			
		}
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
