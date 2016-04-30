package org.aseproject.action;

import org.aseproject.model.Voter;
import org.aseproject.service.VoterService;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

public class VoterRegistrationAction extends ActionSupport{
	
	private Voter voter;
	private VoterService voterService;

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
	}
	
	public void validate(){
		if(!StringUtils.equals(voter.getPassword1(),voter.getPassword2())){
			System.out.println("Inside validate method");
			addFieldError("password1","password and re-entered password are not equal");
			addFieldError("password2","password and re-entered password are not equal");
		}
	}
	
	public String execute() throws SQLException, ClassNotFoundException, FileNotFoundException{
		
		System.out.println("Inside execute method");
		System.out.println("firstName "+voter.getFirstName());
		System.out.println("lastName "+voter.getLastName());
		System.out.println("uid "+voter.getUid());
		System.out.println("dob "+voter.getDob());
		System.out.println("state "+voter.getState());
		System.out.println("emailId "+voter.getEmailId());
		System.out.println("password1 "+voter.getPassword1());
		System.out.println("password2 "+voter.getPassword2());
		System.out.println("picture "+voter.getMyFileFileName());
		
		voterService = new VoterService();
		boolean insertStatus = voterService.insertVoterData(voter);
		
		if(insertStatus){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
		
		
	}

}
