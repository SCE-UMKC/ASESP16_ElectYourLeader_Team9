package org.aseproject.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import org.apache.commons.lang3.StringUtils;
import org.aseproject.database.Database;
import org.aseproject.model.Emailer;
import org.aseproject.model.Voter;

public class VoterService {
	
	Database db = new Database();
	Emailer emailer;
	
	
	public boolean insertVoterData(Voter voter) throws SQLException, ClassNotFoundException, FileNotFoundException{
		
		System.out.println("Inside VoterService, insertVoterData method");
		System.out.println("Creating connection");
		Connection conn = db.connect();
		
		System.out.println("Inside insertVoterData method");
		System.out.println("firstName "+voter.getFirstName());
		System.out.println("lastName "+voter.getLastName());
		System.out.println("uid "+voter.getUid());
		System.out.println("dob "+voter.getDob());
		System.out.println("state "+voter.getState());
		System.out.println("emailId "+voter.getEmailId());
		System.out.println("password1 "+voter.getPassword1());
		System.out.println("password2 "+voter.getPassword2());
		
		// 2. Create a statement
		Statement myStmt = conn.createStatement();
		
		System.out.println("Checking if the record is already present");
		
		PreparedStatement stmt = conn.prepareStatement("select * from voter where uid=? or emailId=?");
		stmt.setString(1, voter.getUid());
		stmt.setString(2, voter.getEmailId());
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()){
			System.out.println("UID or EmailId is already used, so not inserting the record");
			db.close(conn);
			return false;
		}
		else{
				
		// 3. Insert a new employee
		System.out.println("Inserting a new voter record to database\n");
				
		String sql = "INSERT INTO voter (firstName, lastName, uid, dob, state, emailId, password1, password2, voted, deletionStatus, voterSnap) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, voter.getFirstName());
		statement.setString(2, voter.getLastName());
		statement.setString(3, voter.getUid());
		statement.setString(4, voter.getDob());
		statement.setString(5, voter.getState());
		statement.setString(6, voter.getEmailId());
		statement.setString(7, voter.getPassword1());
		statement.setString(8, voter.getPassword2());
		statement.setString(9, "false");
		statement.setString(10, "false");
		
		System.out.println("Before loading file");
		
		
		File theFile = new File(voter.getMyFileFileName());
		System.out.println("reading input file: "+theFile.getAbsolutePath());
		FileInputStream input = new FileInputStream(theFile);
		statement.setBinaryStream(11, input);
		
		System.out.println("After loading file");
		
		//
		
			
		int rowsInserted = statement.executeUpdate();
		System.out.println("No. of rows inserted "+rowsInserted);
			
		ResultSet myRs = myStmt.executeQuery("select * from voter");
			
		// 5. Process the result set
		while (myRs.next()) {
			System.out.println(myRs.getString("lastName") + ", " + myRs.getString("firstName"));
		}
		
		// 6. Closing database connection
		db.close(conn);
		return true;
		}
		
		
	}
	
	public Voter verifyLogin(Voter voter) throws ClassNotFoundException, SQLException, IOException{
		
		System.out.println("Inside VoterService, verifyLogin method");
		System.out.println("Creating connection");
		Connection conn = db.connect();
		
		System.out.println("emailId "+voter.getEmailId());
		System.out.println("password1 "+voter.getPassword1());
		
		System.out.println("Verifying the login details by querying");
		
		PreparedStatement stmt = conn.prepareStatement("select * from voter where emailId=? and password1=?");
		stmt.setString(1, voter.getEmailId());
		stmt.setString(2, voter.getPassword1());
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()){
			String username = rs.getString("emailId");
			String password = rs.getString("password1");
			
			if(StringUtils.equals(username, voter.getEmailId()) && StringUtils.equals(password, voter.getPassword1())){
				System.out.println("if the username and password are correct");
				voter.setFirstName(rs.getString("firstName"));
				voter.setLastName(rs.getString("lastName"));
				voter.setUid(rs.getString("uid"));
				voter.setDob(rs.getString("dob"));
				voter.setState(rs.getString("state"));
				voter.setEmailId(username);
				voter.setProfileImage(rs.getBlob("voterSnap"));
				
				File picFile = new File("C:/Users/SWARGAM/workspace/ASE_Project/WebContent/images");
				FileOutputStream output = new FileOutputStream(picFile);
				
				InputStream input = rs.getBinaryStream("voterSnap");
				
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0){
					output.write(buffer);
				}
				db.close(conn);
				
				return voter;
			}
			else{
				System.out.println("if the username and password are not correct");
				db.close(conn);
				return null;
			}
		}
		
		db.close(conn);
		return null;
		
	}
	
	public boolean verifyEmail(Voter voter) throws ClassNotFoundException, SQLException{
		
		System.out.println("Inside VoterService, verifyEmail method");
		System.out.println("Creating connection");
		Connection conn = db.connect();
		
		System.out.println("emailId "+voter.getEmailId());
		System.out.println("Verifying the email details by querying");
		
		PreparedStatement stmt = conn.prepareStatement("select * from voter where emailId=?");
		stmt.setString(1, voter.getEmailId());
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()){
			String email = rs.getString("emailId");
			String password = rs.getString("password1");
			
			if(StringUtils.equals(email, voter.getEmailId())){
				System.out.println("EmailId is registered in voters");
				
				String subject = "Password for Election commission";
				emailer = new Emailer();
				emailer.send(email,password,subject);
				System.out.println("password is sent voter EmailId");
				db.close(conn);
				return true;
			}
			else{
				System.out.println("EmailId is not yet registered in voters");
				db.close(conn);
				return false;
			}
		}
		
		db.close(conn);
		return false;
		
	}

}
