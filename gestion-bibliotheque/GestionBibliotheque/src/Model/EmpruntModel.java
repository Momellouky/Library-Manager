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
	
	public int getNbrEmprunt(String cin ) throws Exception{
		
		ResultSet rs = null;
		int nbrEmprunt = -1; 
//		String query = "Select count(ee.cin) "
//				+ "from emprunteexemplaire ee, empruntthese et "
//				+ "where ee.cin = et.cin "
//				+ "and ee.cin = '" + cin + "' "; 
		
		String query = "call getNbrEmprunt('" + cin + "' ) "; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			rs = st.executeQuery(query);
			
			if(rs.next() == false)
				throw new Exception(); 
			
			do {
			
				nbrEmprunt = Integer.parseInt(rs.getString(1)); 	
				
			}while(rs.next()); 
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new Exception(); 
		}
		
		return nbrEmprunt; 
		
	}
	
	public ResultSet getUsager(String cin) throws Exception{
		
		ResultSet rs = null; 
//		String query = "SELECT u.nom, u.prenom , l.titre" + 
//				" FROM usager u, emprunteexemplaire ee, exemplaire e, livre l " + 
//				"WHERE u.cin = ee.cin " + 
//				"AND ee.numInvantaire = e.numInvantaire " + 
//				"AND e.isbn = l.isbn " + 
//				"AND u.cin = '" + cin + "'" +  
//				"AND ee.dateRetour IS NULL " ; 
		
//		String query = "select nom, prenom "
//				+ "from usager u "
//				+ "where u.cin in ( "
//				+ " select ee.cin from emprunteexemplaire ee, etudiant e "
//				+ " where ee.cin = e.cin "
//				+ "and datediff(sysdate(), ee.dateemprunt) > 9 "
//				+ "and ee.dateretour is null and ee.cin = '" + cin + "' ) "
//				+ "or cin in ( "
//				+ "select et.cin "
//				+ "from empruntthese et, etudiant e "
//				+ "where et.cin = e.cin "
//				+ "and datediff(sysdate(), et.dateemprunt) > 9 "
//				+ "and et.dateretour is null "
//				+ "and et.cin = '" + cin +  "' ) "
//				+ "and u.cin in ( "
//				+ "select ee.cin "
//				+ "from emprunteexemplaire ee, enseignant e "
//				+ "where ee.cin = e.cin "
//				+ "and datediff(sysdate(), ee.dateemprunt) > 17 "
//				+ "and ee.dateretour is null "
//				+ "and ee.cin = '" + cin +  "' ) "
//				+ "or cin in ( "
//				+ "select et.cin from empruntthese et, enseignant e "
//				+ "where et.cin = e.cin "
//				+ "and datediff(sysdate(), et.dateemprunt) > 17 "
//				+ "and et.dateretour is null "
//				+ "and et.cin = '" + cin +  "' ) ";  
		
		String query = "call getUsager('" + cin + "' ) "; 
		
//		String altQuery = "Select distinct nom, prenom, '0' as nbrEmp "
//				+ "from usager "
//				+ "where cin in ( "
//				+ "select cin from etudiant where cin = '" + cin + "' ) "
//				+ "or cin in ( "
//				+ " select cin from enseignant where cin = '" + cin + "' ) "; 
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement();  
			rs = st.executeQuery(query); 
			
//			if(rs.next() == false) {
//				
//				Statement st2 = currentCnx.getMyCnx().createStatement(); 
//				rs = st2.executeQuery(altQuery); 
//			}else {
//				
//				Statement st3 = currentCnx.getMyCnx().createStatement();
//				rs = st3.executeQuery(query); 
//				
//			}
			
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			throw new Exception(); 
			
		}
		
		return rs; 
		
	}
	
	public ResultSet getCurrentThese(String titre) {
		
		ResultSet rs = null; 
//		String query = "SELECT count(et.titre) as nbrThese, a.nom, a.prenom " + 
//				"FROM empruntThese et, auteur a, ecrireThese ect " + 
//				"WHERE et.titre = ect.titreThese " + 
//				"AND ect.idAuteur = a.id " + 
//				"AND et.dateRetour is not null " +
//				"AND et.titre = '" + titre + "' "; 
		
		String query = "call verifierThese_v2('" + titre + "' ) "; 
		
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			rs = st.executeQuery(query); 
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return rs; 
		
	}
	
	public ResultSet getCurrentExemplaire(String isbn) throws Exception{
		
		ResultSet rs = null; 
//		String query = "SELECT count(e.numinvantaire) as numExDispo, l.titre, a.nom, a.prenom, e.numinvantaire " + 
//				"FROM exemplaire e, emprunteexemplaire ee, livre l, auteur a, ecrirelivre el " + 
//				"WHERE e.numinvantaire = ee.numinvantaire " + 
//				"AND e.isbn = l.isbn " + 
//				"AND l.isbn = el.isbnlivre " + 
//				"AND el.idauteur = a.id " + 
//				"AND e.isbn = '" + isbn + "' " + 
//				"AND ee.dateRetour is not null " + 
//				"AND e.etat in ('neuf', 'Bon etat', 'Partiellement abime', 'Tres abime') "; 
		
		String query = "CALL verifierExemplaire_v2(" + isbn + ")"; 
		
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			rs = st.executeQuery(query); 
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new Exception(); 
		}
		
		return rs; 
		
	}
	
	public void insertEmpruntExemplaire(String cin, String exemplaireId, Date dtEmprunt) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		System.out.println(sdf.format(dtEmprunt));
		String queryForeignKeyChecks = "set foreign_key_checks = 0 "; 
		String query = "INSERT INTO emprunteexemplaire(cin, numInvantaire, dateEmprunt) VALUES('" + cin + "','" + exemplaireId + "'," + "STR_TO_DATE('"+ sdf.format(dtEmprunt) + "','%Y-%m-%d'))";                             
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			Statement st2 = currentCnx.getMyCnx().createStatement(); 
			
			st2.executeQuery(queryForeignKeyChecks); 
			st.executeUpdate(query); 
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new Exception();
			
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
		
		System.out.println(this.cin + " " + this.exemplaireId + " " + sdf.format(dtEmprunt));
		
		String queryEmprunteExemplaire = "UPDATE empruntthese " + 
				"SET dateretour = '" + sdf.format(dtRetour) + "' " + 
				"WHERE cin = '" + this.cin + "' " + 
				"AND titre = '" + this.exemplaireId + "' " + 
				"AND dateemprunt = '" + sdf.format(dtEmprunt) + "' " ; 
		
		// STR_TO_DATE('" + sdf.format(dtEmprunt) + "' , '%Y-%m-%d')
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(queryEmprunteExemplaire);
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new Exception(); 
			
		}
		
	}


	public void insertEmpruntThese(String cin, String numInv, String dtEmprunte) throws Exception{
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
//		System.out.println(sdf.format(dtEmprunt));
		String queryForeignKeyChecks = "set foreign_key_checks = 0 "; 
		String query = "INSERT INTO empruntthese(cin, titre, dateEmprunt) VALUES('" + cin + "','" + numInv + "'," + "STR_TO_DATE('"+ dtEmprunte + "','%Y-%m-%d'))";                             
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			Statement st2 = currentCnx.getMyCnx().createStatement(); 
			
			st2.executeQuery(queryForeignKeyChecks); 
			st.executeUpdate(query); 
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new Exception();
			
		}
		
	}
	
	
	public ResultSet getRetardJrs() throws Exception{
		
		
		ResultSet rs = null; 
		String query = new String(); 
		
//		query = "SELECT distinct t.titre, et.dateemprunt from empruntthese et, these t "
//				+ "where et.titre = t.titre  " 
//				+ "and datediff(sysdate(), et.dateemprunt ) > 9 or datediff(sysdate(), et.dateemprunt) > 17 "; 
		
		query = "call getRetardJrs() "; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement();
			rs = st.executeQuery(query); 
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(); 
		}
			
		
		return rs; 
		
	}


	public void envoyerRelanceExemplaire(String cin, String idEmprunt, Date dtEmprunt) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		
		String Query = "UPDATE emprunteexemplaire set daterelence = sysdate() where cin = '" + cin + "' "
				+ " and numinvantaire = '" + idEmprunt + "' and dateemprunt = '" + sdf.format(dtEmprunt) + "' ";
		
		System.err.println(dtEmprunt.toString());
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(Query); 
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			throw new Exception(); 
			
		}
		
	}
	
	public void envoyerRelanceThese(String cin, String idEmprunt, Date dtEmprunt) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 
		String Query = "UPDATE empruntthese set daterelence = sysdate() where cin = '" + cin + "' "
				+ " and titre = '" + idEmprunt + "' and dateemprunt = '" + sdf.format(dtEmprunt) + "' ";
		
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(Query); 
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			throw new Exception(); 
			
		}
		
	}


	public ResultSet getRetardMois() throws Exception{
		
		ResultSet rs = null; 
		String query = new String(); 
		
//		query = "SELECT distinct t.titre, et.dateemprunt from empruntthese et, these t "
//				+ "where et.titre = t.titre  " 
//				+ "and datediff(sysdate(), et.dateemprunt ) > 9 or datediff(sysdate(), et.dateemprunt) > 17 "; 
		
		query = "call getRetardMois() "; 
		
		try {
			
			Statement st = currentCnx.getMyCnx().createStatement();
			rs = st.executeQuery(query); 
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(); 
		}
			
		
		return rs; 
	}


	public void declarerThesePerdu(String idEmprunt) throws Exception{
		
		String query = "insert into thesePerdu values ('" + idEmprunt + "' , '" + 1 + "')"; 
		
		try { 
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(query); 
			
			
		}catch(Exception ex ) {
			
			ex.printStackTrace();
			throw new Exception(); 
			
		}
		
	}


	public void declarerExemplairePerdu(String idEmprunt) throws Exception{
		
		String query = "insert into exemplairePerdu values ('" + idEmprunt + "' , '" + 1 + "')"; 
		
		try { 
			
			Statement st = currentCnx.getMyCnx().createStatement(); 
			st.executeUpdate(query); 
			
			
		}catch(Exception ex ) {
			
			ex.printStackTrace();
			throw new Exception(); 
			
		}
		
	}
}
