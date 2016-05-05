package org.aseproject.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class Database {

	private String theUser;
	private String thePassword;
	private String theDburl;
	
	private Connection dbConn = null;
	
	public Connection connect() throws SQLException, ClassNotFoundException{
		
		try {
			// 1. Load the properties file
			Properties props = new Properties();
			props.load(new FileInputStream("C:/database.properties"));
			
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2. Read the props
			theUser = props.getProperty("user");
			thePassword = props.getProperty("password");
			theDburl = props.getProperty("dburl");
			
			System.out.println("Connecting to database...");
			System.out.println("Database URL: " + theDburl);
			System.out.println("User: " + theUser);
			
			// 3. Get a connection to database
			dbConn = DriverManager.getConnection(theDburl, theUser, thePassword);

			System.out.println("\nConnection successful!\n");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dbConn;
	}
	
	public void close(Connection conn) throws SQLException{
		conn.close();
	}
}
