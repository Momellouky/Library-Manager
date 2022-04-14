package model;

import java.sql.Statement;
import java.util.Date;

public class LivreModel {
	
	private String isbn; 
	private String titre; 
	private Date dtEdition; 
	private String Resume; 
	
	private Connexion currentCnx;
	
	
	
	public LivreModel(String isbn, Connexion currentCnx) {
		super();
		this.isbn = isbn;
		this.titre = titre;
		this.currentCnx = currentCnx;
	}



	public LivreModel(String isbn, String titre, Date dtEdition, String resume, Connexion currentCnx) {
		super();
		this.isbn = isbn;
		this.titre = titre;
		this.dtEdition = dtEdition;
		Resume = resume;
		this.currentCnx = currentCnx;
	} 
	

	public void deleteLivre(String isbn) throws Exception{
		
		String query =  "DELETE FROM livre WHERE isbn = '" + isbn + "' "; 
		
		try { 
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			
			st.executeUpdate(query); 
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new Exception(); 
			
		}
	}
	
}
