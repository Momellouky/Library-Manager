package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LivreModel {
	
	private String isbn; 
	private String titre; 
	private Date dtEdition; 
	private String resume; 
	
	private Connexion currentCnx;
	
	
	
	public LivreModel() {
		super();
	}



	public LivreModel(String isbn, Connexion currentCnx) {
		super();
		this.isbn = isbn;
		this.currentCnx = currentCnx;
	}



	public LivreModel(String isbn, String titre, Date dtEdition, String resume, Connexion currentCnx) {
		super();
		this.isbn = isbn;
		this.titre = titre;
		this.dtEdition = dtEdition;
		resume = resume;
		this.currentCnx = currentCnx;
	} 
	
	
	public LivreModel(Connexion currentCnx) {
		
		this.currentCnx = currentCnx; 
		
	}



	public ResultSet resumeLivre() throws Exception{
		
		ResultSet rs = null; 
		String query =  "Select resume from livre where isbn =  '" + this.isbn + "'";    
		
		try { 
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			
			rs = st.executeQuery(query); 
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new Exception(); 
			
		}
		
		return rs; 
	}
	
	public void insertLivre(String isbn, String titre, Date dtEdition, String resume, Object [] motsCles) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat(); 
		String queryForeignKey = "set foreign_Key_checks = 0"; 
		String queryAddLivre = "insert into livre values('" + isbn + "' , '" + titre + "' ,  STR_TO_DATE('" + sdf.format(dtEdition).substring(0, 10) + "','%d/%m/%Y'), '" + resume + "' )" ;
		String queryMotsCles = "insert into motsClesLivre values('" + isbn + "' , '" ; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement();
			Statement st2 = currentCnx.getMyCnx().createStatement();
			
			st.executeQuery(queryForeignKey); 
			
			st2.executeUpdate(queryAddLivre);
			
			for(int i = 0; i < motsCles.length ; i++) {
				Statement st3 = currentCnx.getMyCnx().createStatement();
				st3.executeUpdate(queryMotsCles + motsCles[i ] + "' )"); 
			}
			
		}catch(Exception e) { 
			
			e.printStackTrace(); 
			throw new Exception(); 
			
		}
		
	}
	
	public void updateLivre() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(); 
		String foreignChecks = "set foreign_key_checks = 0"; 
		String query = "Update livre set titre = '" + this.titre + "' , dateedition = STR_TO_DATE('"+ sdf.format(dtEdition).substring(0, 10) + "','%d/%m/%Y') "
				+ ", resume = '" + this.resume + "' WHERE isbn = '" + this.isbn + "' "; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(foreignChecks); 
			st.executeUpdate(query); 
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			throw new Exception(); 
			
		}
		
	}

	public void deleteLivre(String isbn) throws SQLException{
		
		String query =  "DELETE FROM livre WHERE isbn = '" + isbn + "' "; 
		
		try { 
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			
			st.executeUpdate(query); 
			
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			throw new SQLException(); 
			
		}
	}



	public void insertExemplaire(String numInv, String isbn, String titre, Date date, String resume,
			Object[] motsCles) throws Exception{
		
		String foreignKey = "set foreign_key_checks = 0"; 
		String query = "insert into exemplaire values ('" + numInv + "' , '" + isbn + "' , 'neuf' ) "; 
		try { 
			
//			insertLivre(isbn, titre, date, resume, motsCles);
			Statement st = currentCnx.getMyCnx().createStatement(); 
			Statement st2 = currentCnx.getMyCnx().createStatement(); 
			
			st2.executeQuery(foreignKey);
			st.executeUpdate(query); 
			
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			throw new Exception(); 
			
		}
		
		
	}
	
}
