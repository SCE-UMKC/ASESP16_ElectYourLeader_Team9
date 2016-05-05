package org.aseproject.action;

import java.sql.SQLException;

import org.aseproject.model.Candidate;
import org.aseproject.service.CandidateService;

import com.opensymphony.xwork2.ActionSupport;

public class CandidateLoginAction extends ActionSupport{
	
	private Candidate candidate;
	private CandidateService candidateService;
	
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	public void validate(){
		candidateService = new CandidateService();
		boolean loginStatus = false;
		
		try {
			loginStatus = candidateService.verifyLogin(candidate);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Inside validate method catch block of CandidateLoginAction");
			e.printStackTrace();
		}
		
		if(loginStatus){
			System.out.println("Login successful, now execute method must be called execute");
		}
		else{
			addFieldError("password1","Username or password is incorrect");
		}
		
	}
	
	public String execute(){
		System.out.println("Inside execute method");
		System.out.println("emailId "+candidate.getEmailId());
		System.out.println("password1 "+candidate.getPassword1());
		
		return SUCCESS;
		
	}
	
	

}
