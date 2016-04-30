package org.aseproject.action;

import java.io.IOException;
import java.sql.SQLException;

import org.aseproject.model.Candidate;
import org.aseproject.service.CandidateService;

import com.opensymphony.xwork2.ActionSupport;

public class CandidateLoginAction extends ActionSupport{
	
	private Candidate candidate;
	private Candidate displayCandidate;
	private CandidateService candidateService;
	public byte[] profilePic = null;
	
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	public CandidateService getCandidateService() {
		return candidateService;
	}
	public void setCandidateService(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	public Candidate getDisplayCandidate() {
		return displayCandidate;
	}
	public void setDisplayCandidate(Candidate displayCandidate) {
		this.displayCandidate = displayCandidate;
	}
	public void validate(){
		candidateService = new CandidateService();
		boolean loginStatus = false;
		
		try {
			try {
				displayCandidate = candidateService.verifyLogin(candidate);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(displayCandidate != null){
				System.out.println("Candidate details are not null");
				loginStatus = true;
			}
			else
			{
				System.out.println("Candidate details are null");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Inside validate method catch block of CandidateLoginAction");
			e.printStackTrace();
		}
		
		if(loginStatus){
			System.out.println("Candidate Login successful, now execute method must be called execute");
		}
		else{
			addFieldError("password1","Username or password is incorrect");
		}
		
	}
	
	public String execute(){
		System.out.println("Inside execute method");
		System.out.println("FirstName "+displayCandidate.getFirstName());
		System.out.println("LastName "+displayCandidate.getLastName());
		System.out.println("UID "+displayCandidate.getUid());
		System.out.println("DOB "+displayCandidate.getDob());
		System.out.println("State "+displayCandidate.getState());
		System.out.println("EmailId "+displayCandidate.getEmailId());
		System.out.println("GradSchool "+displayCandidate.getGradSchoolName());
		System.out.println("UnderGradSchool "+displayCandidate.getUnderGradSchoolName());
		System.out.println("HighSchool "+displayCandidate.getHighSchoolName());
		System.out.println("Profile Image "+displayCandidate.getProfileImage());
		
		return SUCCESS;
		
	}
	
	

}
