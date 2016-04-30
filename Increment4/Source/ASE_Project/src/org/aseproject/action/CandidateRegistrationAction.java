package org.aseproject.action;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.aseproject.model.Candidate;
import org.aseproject.service.CandidateService;
import org.aseproject.service.VoterService;

import com.opensymphony.xwork2.ActionSupport;

public class CandidateRegistrationAction extends ActionSupport{
	
	private Candidate candidate;

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	public void validate(){
		if(!StringUtils.equals(candidate.getPassword1(),candidate.getPassword2())){
			System.out.println("Inside validate method");
			addFieldError("password1","password and re-entered password are not equal");
			addFieldError("password2","password and re-entered password are not equal");
		}
	}
	
	public String execute() throws ClassNotFoundException, SQLException, FileNotFoundException{
		
		System.out.println("Inside execute method");
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
		System.out.println("picture "+candidate.getMyFileFileName());
		
		CandidateService candidateService= new CandidateService();
		boolean status = candidateService.insertCandidateData(candidate);
		
		if(status){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}

}
