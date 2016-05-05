package org.aseproject.action;

import java.sql.SQLException;

import org.aseproject.model.Voter;
import org.aseproject.service.VoterService;

import com.opensymphony.xwork2.ActionSupport;

public class ForgotPasswordVoterAction extends ActionSupport{
	
	private Voter voter;
	private VoterService voterService;
	

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
	}
	
	public void validate(){
		voterService = new VoterService();
		boolean loginStatus = false;
		
		try {
			loginStatus = voterService.verifyEmail(voter);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Inside validate method catch block of ForgotPasswordVoterAction");
			e.printStackTrace();
		}
		
		if(loginStatus){
			System.out.println("Email found, now execute method must be called execute");
		}
		else{
			addFieldError("emailId","Given emailId is not yet registered, please give your registered emailId");
		}
	}
	
	public String execute(){
		System.out.println("Inside execute method");
		System.out.println("emailId "+voter.getEmailId());
		
		return SUCCESS;
		
	}


}
