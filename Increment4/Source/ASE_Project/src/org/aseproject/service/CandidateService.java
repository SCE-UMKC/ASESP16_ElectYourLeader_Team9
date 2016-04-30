package org.aseproject.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.aseproject.database.Database;
import org.aseproject.model.Candidate;
import org.aseproject.model.Emailer;

public class CandidateService {
	
	Database db = new Database();
	Emailer emailer;
	
	public boolean insertCandidateData(Candidate candidate) throws ClassNotFoundException, SQLException, FileNotFoundException{
		
		System.out.println("Inside VoterService, insertCandidateData method");
		System.out.println("Creating connection");
		Connection conn = db.connect();
		
		System.out.println("Inside insertCandidateData method");
		System.out.println("firstName "+candidate.getFirstName());
		System.out.println("lastName "+candidate.getLastName());
		System.out.println("uid "+candidate.getUid());
		System.out.println("dob "+candidate.getDob());
		System.out.println("state "+candidate.getState());
		System.out.println("state "+candidate.getParty());
		System.out.println("emailId "+candidate.getEmailId());
		System.out.println("password1 "+candidate.getPassword1());
		System.out.println("password2 "+candidate.getPassword2());
		System.out.println("highSchoolName "+candidate.getHighSchoolName());
		System.out.println("schoolPassingOutWeekYear "+candidate.getSchoolPassingOutWeekYear());
		System.out.println("underGradSchoolName "+candidate.getUnderGradSchoolName());
		System.out.println("gradSchoolName "+candidate.getGradSchoolName());
		System.out.println("gradPassingOutWeekYear "+candidate.getGradPassingOutWeekYear());
		System.out.println("employer1 "+candidate.getEmployer1());
		System.out.println("employerYear1 "+candidate.getEmployerYear1());
		System.out.println("employer2 "+candidate.getEmployer2());
		System.out.println("employerYear2 "+candidate.getEmployerYear2());
		System.out.println("employer3 "+candidate.getEmployer3());
		System.out.println("employerYear3 "+candidate.getEmployerYear3());
		System.out.println("employerYear3 "+candidate.getEmployerYear3());
		System.out.println("picture "+candidate.getMyFileFileName());
		
		// 2. Create a statement
		Statement myStmt = conn.createStatement();
		
		System.out.println("Checking if the record is already present");
		
		PreparedStatement stmt = conn.prepareStatement("select * from candidate where uid=? or emailId=?");
		stmt.setString(1, candidate.getUid());
		stmt.setString(2, candidate.getEmailId());
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()){
			System.out.println("UID or EmailId is already used, so not inserting the record");
			db.close(conn);
			return false;
		}
		
		else{
						
		// 3. Insert a new employee
		System.out.println("Inserting a new candidate record to database\n");
		
		String sql = "INSERT INTO candidate (firstName, lastName, uid, dob, state, emailId, password1, password2, highSchoolName, schoolPassingOutWeekYear,"
						+ " underGradSchoolName, underGradPassingOutWeekYear, gradSchoolName, gradPassingOutWeekYear, employer1, employerYear1,"
						+ " employer2, employerYear2, employer3, employerYear3, deletionStatus, candidateSnap, party, votecount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setString(1, candidate.getFirstName());
		statement.setString(2, candidate.getLastName());
		statement.setString(3, candidate.getUid());
		statement.setString(4, candidate.getDob());
		statement.setString(5, candidate.getState());
		statement.setString(6, candidate.getEmailId());
		statement.setString(7, candidate.getPassword1());
		statement.setString(8, candidate.getPassword2());
		statement.setString(9, candidate.getHighSchoolName());
		statement.setString(10, candidate.getSchoolPassingOutWeekYear());
		statement.setString(11, candidate.getUnderGradSchoolName());
		statement.setString(12, candidate.getUnderGradPassingOutWeekYear());
		statement.setString(13, candidate.getGradSchoolName());
		statement.setString(14, candidate.getGradPassingOutWeekYear());
		statement.setString(15, candidate.getEmployer1());
		statement.setString(16, candidate.getEmployerYear1());
		statement.setString(17, candidate.getEmployer2());
		statement.setString(18, candidate.getEmployerYear2());
		statement.setString(19, candidate.getEmployer3());
		statement.setString(20, candidate.getEmployerYear3());
		statement.setString(21, "false");
		
		System.out.println("Before loading file");
		
		
		File theFile = new File(candidate.getMyFileFileName());
		System.out.println("reading input file: "+theFile.getAbsolutePath());
		FileInputStream input = new FileInputStream(theFile);
		statement.setBinaryStream(22, input);
		
		System.out.println("After loading file");
		
		statement.setString(23, candidate.getParty());
		statement.setInt(24, 0);
		
		int rowsInserted = statement.executeUpdate();
		System.out.println("No. of rows inserted "+rowsInserted);
			
		ResultSet myRs = myStmt.executeQuery("select * from candidate");
			
		// 5. Process the result set
		while (myRs.next()) {
			System.out.println(myRs.getString("lastName") + ", " + myRs.getString("firstName"));
		}
		
		// 6. Closing database connection
		db.close(conn);
		return true;
		}
		
}
	
	public Candidate verifyLogin(Candidate candidate) throws ClassNotFoundException, SQLException, IOException{
		System.out.println("Inside VoterService, verifyLogin method");
		System.out.println("Creating connection");
		Connection conn = db.connect();
		
		System.out.println("emailId "+candidate.getEmailId());
		System.out.println("password1 "+candidate.getPassword1());
		
		System.out.println("Verifying the login details by querying");
		
		PreparedStatement stmt = conn.prepareStatement("select * from candidate where emailId=? and password1=?");
		stmt.setString(1, candidate.getEmailId());
		stmt.setString(2, candidate.getPassword1());
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()){
			String username = rs.getString("emailId");
			String password = rs.getString("password1");
			
			if(StringUtils.equals(username, candidate.getEmailId()) && StringUtils.equals(password, candidate.getPassword1())){
				System.out.println("if the username and password are correct");
				
				candidate.setFirstName(rs.getString("firstName"));
				candidate.setLastName(rs.getString("lastName"));
				candidate.setUid(rs.getString("uid"));
				candidate.setDob(rs.getString("dob"));
				candidate.setState(rs.getString("state"));
				candidate.setEmailId(username);
				candidate.setGradSchoolName(rs.getString("gradSchoolName"));
				candidate.setUnderGradSchoolName(rs.getString("underGradSchoolName"));
				candidate.setHighSchoolName(rs.getString("highSchoolName"));
				candidate.setProfileImage(rs.getBlob("candidateSnap"));
				
				File picFile = new File("C:/Users/SWARGAM/workspace/ASE_Project/WebContent/images/regImage.gif");
				FileOutputStream output = new FileOutputStream(picFile);
				
				InputStream input = rs.getBinaryStream("candidateSnap");
				
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0){
					output.write(buffer);
				}
				db.close(conn);
				return candidate;
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
	
	public boolean verifyEmail(Candidate candidate) throws ClassNotFoundException, SQLException{
		
		System.out.println("Inside CandidateService, verifyEmail method");
		System.out.println("Creating connection");
		Connection conn = db.connect();
		
		System.out.println("emailId "+candidate.getEmailId());
		System.out.println("Verifying the email details by querying");
		
		PreparedStatement stmt = conn.prepareStatement("select * from candidate where emailId=?");
		stmt.setString(1, candidate.getEmailId());
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()){
			String email = rs.getString("emailId");
			String password = rs.getString("password1");
			
			if(StringUtils.equals(email, candidate.getEmailId())){
				System.out.println("EmailId is registered in candidates");
				
				String subject = "Password for Election commission";
				emailer = new Emailer();
				emailer.send(email,password,subject);
				System.out.println("password is sent to candidate EmailId");
				db.close(conn);
				return true;
			}
			else{
				System.out.println("EmailId is not yet registered in candidates");
				db.close(conn);
				return false;
			}
		}
		
		db.close(conn);
		return false;
		
	}
	
	public ArrayList<Candidate> candidateSearch(String state) throws ClassNotFoundException, SQLException{
		
		
		System.out.println("Inside CandidateService, candidateSearch method");
		System.out.println("State "+state);
		System.out.println("Creating connection");
		Connection conn = db.connect();
		
		PreparedStatement stmt = conn.prepareStatement("select * from candidate where state=?");
		stmt.setString(1, state);
		
		ResultSet rs = stmt.executeQuery();
		
		Candidate candidate = null;
		ArrayList<Candidate> candidateList = new ArrayList<Candidate>(); 
		
		while(rs.next()){
			candidate = new Candidate();
			candidate.setFirstName(rs.getString("firstName"));
			candidate.setLastName(rs.getString("lastName"));
			candidate.setUid(rs.getString("uid"));
			candidate.setParty(rs.getString("party"));
			candidateList.add(candidate);
			
		}
		
		return candidateList;
		
		
	}
	
	public void updateVoteCount(String candidateSSN) throws SQLException, ClassNotFoundException{
		
		System.out.println("Inside CandidateService, updateVoteCount method");
		System.out.println("Creating connection");
		Connection conn = db.connect();
		
		System.out.println("Candidate SSN: "+candidateSSN);
		System.out.println("Verifying the email details by querying");
		
		PreparedStatement stmt = conn.prepareStatement("select * from candidate where uid=?");
		stmt.setString(1, candidateSSN);
		
		ResultSet rs = stmt.executeQuery();
		Integer count = 100;
		
		if(rs.next()){
		count = rs.getInt("votecount");
		System.out.println("Vote Count for candidate before update "+candidateSSN+" is "+count);
		count = count + 1;
		System.out.println("Vote Count for candidate after update "+candidateSSN+" is "+count);
		}
		
		PreparedStatement stmt1 = conn.prepareStatement("update candidate set votecount=? where uid=?");
		stmt1.setInt(1, count );
		stmt1.setString(2, candidateSSN);	
		
		int rowsUpdated = stmt1.executeUpdate();
		System.out.println("No. of rows updated "+rowsUpdated);
		
		
	}

}
