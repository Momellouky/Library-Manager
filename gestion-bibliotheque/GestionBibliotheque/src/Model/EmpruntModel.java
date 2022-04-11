package model;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class EmpruntModel {
	
	private String cin; 
	private String exemplaireId; 
	private Date dtEmprunt; 
	private Date dtRetour; 
	private Connexion currentCnx; 
	
	public EmpruntModel(Connexion currentCnx) {
		
		this.currentCnx = currentCnx; 
		
	}
	
	
	public EmpruntModel(Connexion currentCnx, String cin, String exemplaireId, Date dtEmprunt, Date dtRetour) {
		
		this.currentCnx = currentCnx;
		this.cin = cin; 
		this.exemplaireId = exemplaireId; 
		this.dtEmprunt = dtEmprunt; 
		this.dtRetour = dtRetour; 
		
	}
	
	
	public ResultSet getCurrentEmprunt(String cin) {
		
		ResultSet rs = null; 
		String query = "SELECT u.nom, u.prenom , l.titre" + 
				" FROM usager u, emprunteexemplaire ee, exemplaire e, livre l " + 
				"WHERE u.cin = ee.cin " + 
				"AND ee.numInvantaire = e.numInvantaire " + 
				"AND e.isbn = l.isbn " + 
				"AND u.cin = '" + cin + "'" +  
				"AND ee.dateRetour IS NULL " ; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			rs = st.executeQuery(query); 
			System.out.println("Done");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		return rs; 
		
	}
	
	public ResultSet getCurrentThese(String titre) {
		
		ResultSet rs = null; 
		String query = "SELECT count(et.titre) as nbrThese, a.nom, a.prenom " + 
				"FROM empruntThese et, auteur a, ecrireThese ect " + 
				"WHERE et.titre = ect.titreThese " + 
				"AND ect.idAuteur = a.id " + 
				"AND et.dateRetour is not null " +
				"AND et.titre = '" + titre + "' "; 
		
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			rs = st.executeQuery(query); 
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return rs; 
		
	}
	
	public ResultSet getCurrentExemplaire(String isbn) {
		
		ResultSet rs = null; 
		String query = "SELECT count(e.numinvantaire) as numExDispo, l.titre, a.nom, a.prenom, e.numinvantaire " + 
				"FROM exemplaire e, emprunteexemplaire ee, livre l, auteur a, ecrirelivre el " + 
				"WHERE e.numinvantaire = ee.numinvantaire " + 
				"AND e.isbn = l.isbn " + 
				"AND l.isbn = el.isbnlivre " + 
				"AND el.idauteur = a.id " + 
				"AND e.isbn = '" + isbn + "' " + 
				"AND ee.dateRetour is not null " + 
				"AND e.etat in ('neuf', 'Bon etat', 'Partiellement abime', 'Tres abime') "; 
		
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			rs = st.executeQuery(query); 
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return rs; 
		
	}
	
	public void insertEmpruntExemplaire(String cin, String exemplaireId, Date dtEmprunt) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		System.out.println(sdf.format(dtEmprunt));
		String query = "INSERT INTO emprunteexemplaire(cin, numInvantaire, dateEmprunt) VALUES('" + cin + "','" + exemplaireId + "'," + "STR_TO_DATE('"+ sdf.format(dtEmprunt) + "','%Y-%m-%d'))";                             
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(query); 
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void enregistrerEmprunte() throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String queryEmprunteExemplaire = "UPDATE emprunteexemplaire " + 
				"SET dateretour = STR_TO_DATE('" + sdf.format(dtRetour) + "' , '%Y-%m-%d') " +
				"WHERE cin = '" + this.cin + "' " + 
				"AND numinvantaire = '" + this.exemplaireId + "' " + 
				"AND dateemprunt = STR_TO_DATE('" + sdf.format(dtEmprunt) + "' , '%Y-%m-%d') " ; 
				  
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(queryEmprunteExemplaire);
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new Exception(); 
			
		}
		
	}
	
	public void enregistrerThese() throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String queryEmprunteExemplaire = "UPDATE empruntthese " + 
				"SET dateretour = STR_TO_DATE('" + sdf.format(dtRetour) + "' , '%Y-%m-%d') " +
				"WHERE cin = '" + this.cin + "' " + 
				"AND titre = '" + this.exemplaireId + "' " + 
				"AND dateemprunt = STR_TO_DATE('" + sdf.format(dtEmprunt) + "' , '%Y-%m-%d') " ; 
		
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(queryEmprunteExemplaire);
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new Exception(); 
			
		}
		
	}
	
}
