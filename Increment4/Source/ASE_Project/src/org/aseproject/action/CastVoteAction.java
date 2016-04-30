package org.aseproject.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.mail.Session;

import org.aseproject.model.Candidate;
import org.aseproject.model.Voter;
import org.aseproject.service.CandidateService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CastVoteAction extends ActionSupport{

	private static Voter displayVoter;
	private ArrayList<Candidate> candidateList;
	private Map<Integer, String> m1 = new HashMap<Integer, String>();
	


	public static Voter getDisplayVoter() {
		return displayVoter;
	}


	public static void setDisplayVoter(Voter displayVoter) {
		CastVoteAction.displayVoter = displayVoter;
	}
	

	public ArrayList<Candidate> getCandidateList() {
		return candidateList;
	}


	public void setCandidateList(ArrayList<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	
	public Map<Integer, String> getM1() {
		return m1;
	}


	public void setM1(Map m1) {
		this.m1 = m1;
	}


	public String execute() throws ClassNotFoundException, SQLException{
		
		
		
		System.out.println("Inside execute method of CastVoteAction");
		
		System.out.println("FirstName "+displayVoter.getFirstName());
		System.out.println("LastName "+displayVoter.getLastName());
		System.out.println("UID "+displayVoter.getUid());
		System.out.println("DOB "+displayVoter.getDob());
		System.out.println("State "+displayVoter.getState());
		System.out.println("EmailId "+displayVoter.getEmailId());
		
		CandidateService candidateService = new CandidateService();
		candidateList = candidateService.candidateSearch(displayVoter.getState());
		
		Iterator<Candidate> itr = candidateList.iterator();
		int i = 1;
		while(itr.hasNext()){
			Candidate cand = (Candidate)itr.next();
			m1.put( i,cand.getUid() );
			i = i + 1;
		}
		
		VoteCandidateAction.setDisplayVoter(displayVoter);
		VoteCandidateAction.setCandidateList(candidateList);
		VoteCandidateAction.setM1(m1);
		
		
		return SUCCESS;
		
	}


	


}
