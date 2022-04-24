package model;

import java.sql.ResultSet;
import java.sql.Statement;

public class ExemplaireModel {
	
	private String numInv; 
	private String etat;
	private Connexion currentCnx; 
	
	
	
	public ExemplaireModel(Connexion currentCnx) {
		super();
		this.currentCnx = currentCnx;
	}


	public ExemplaireModel(String etat, String numInv, Connexion currentCnx) {
		
		super();
		this.etat = etat;
		this.currentCnx = currentCnx;
		this.numInv = numInv; 
		
	}
	
	
	public void updateEtat() throws Exception{
		
		String query = "UPDATE exemplaire " + 
				"SET etat = '" + this.etat + "' " + 
				"WHERE numinvantaire = '" + this.numInv + "' " ; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(query); 
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			throw new Exception(); 
			
		}
		
	}
	
	public ResultSet getRerard(String period) throws Exception{
		
		ResultSet rs = null; 
		String query = new String(); 
		
		if(period == "jrs") {
			
//			query = "SELECT distinct l.titre, ee.dateemprunt from emprunteexemplaire ee, exemplaire e, livre l "
//					+ "where ee.numinvantaire = e.numinvantaire and e.isbn = l.isbn " 
//					+ "and datediff(sysdate(), ee.dateemprunt ) > 9 or datediff(sysdate(), ee.dateemprunt) > 17 "; 
			
			query = "call getRetardJrs()"; 
			
			
			try {
				
				Statement st = currentCnx.getMyCnx().createStatement();
				rs = st.executeQuery(query); 
				
			}catch(Exception e) {
				e.printStackTrace();
				throw new Exception(); 
			}
			
			
		}else if(period == "mois") {
			
			query = "SELECT l.titre, ee.dateemprunt from emprunteexemplaire ee, exemplaire e, livre l "
					+ "where ee.numinvantaire = e.numinvantaire and e.isbn = l.isbn " 
					+ "and datediff(sysdate(), ee.dateemprunt ) > 30"; 
			
			try {
				
				Statement st = currentCnx.getMyCnx().createStatement();
				rs = st.executeQuery(query); 
				
			}catch(Exception e) {
				e.printStackTrace();
				throw new Exception(); 
			}
			
		}
		
		return rs; 
		
	}
	
	
	
}
