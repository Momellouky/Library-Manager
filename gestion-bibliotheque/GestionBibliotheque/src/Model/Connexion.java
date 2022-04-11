package model;

import java.sql.*;

import javax.swing.JOptionPane; 

public class Connexion {
	
	private String pilote ;
	private Connection myCnx;
	private String url; 
	
	public void connect() throws Exception, ClassNotFoundException{ 
		
		try {
			
			pilote = new String("com.mysql.jdbc.Driver"); 
			Class.forName(pilote); 
			
			url = "jdbc:mysql://localhost:3306/bibliotheque"; 
			myCnx = DriverManager.getConnection(url, "root", "root"); 
			
		}catch(ClassNotFoundException e) {
			
			throw new ClassNotFoundException();
			
		}
		catch(SQLException e ) {
			
			throw new Exception();
			
		}
		
		
	}
	
	public void disconnect() throws Exception{
		
		try {
			
			myCnx.close();
			
		} catch (SQLException e) {
			
			throw new Exception(); 
			
		}
		
	}
	
	public ResultSet requete(String table, String condition) {
		
		ResultSet rs = null; 
		String query = "SELECT * FROM " + table ; 
		
		try {
			
			Statement st = myCnx.createStatement(); 
			rs = st.executeQuery(query); 
			
		}catch(Exception e) {
			
		}
			
			
		
		return rs; 
		
	}
	
	public Connection getMyCnx() {
		return myCnx;
	}
	
}
