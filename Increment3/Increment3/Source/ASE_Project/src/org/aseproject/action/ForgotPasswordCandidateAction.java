package org.aseproject.action;

import java.sql.SQLException;

import org.aseproject.model.Candidate;
import org.aseproject.service.CandidateService;

import com.opensymphony.xwork2.ActionSupport;

public class ForgotPasswordCandidateAction extends ActionSupport{
	
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
			loginStatus = candidateService.verifyEmail(candidate);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Inside validate method catch block of ForgotPasswordVoterAction");
			e.printStackTrace();
		}
		
		if(loginStatus){
			System.out.println("Email found, now execute method must be called to execute");
		}
		else{
			addFieldError("emailId","Given emailId is not yet registered, please give your registered emailId");
		}
	}
	
	public String execute(){
		System.out.println("Inside execute method");
		System.out.println("emailId "+candidate.getEmailId());
		
		return SUCCESS;
		
	}
	
	

}
