package org.aseproject.action;

import java.sql.SQLException;
import java.util.ArrayList;

import org.aseproject.model.Candidate;
import org.aseproject.service.CandidateService;

import com.opensymphony.xwork2.ActionSupport;

public class CandidateSearchAction extends ActionSupport{
	
	private String state;
	private ArrayList<Candidate> candidateList;
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ArrayList<Candidate> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(ArrayList<Candidate> candidateList) {
		this.candidateList = candidateList;
	}

	public String execute() throws ClassNotFoundException, SQLException{
		
		System.out.println("Inside execute method");
		System.out.println("Selected State "+state);
		
		CandidateService candidateService = new CandidateService();
		candidateList = candidateService.candidateSearch(state);
		
		return SUCCESS;
		
	}

}
