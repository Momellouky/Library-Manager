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
	
	public Connection getMyCnx() {
		return myCnx;
	}
	
}
