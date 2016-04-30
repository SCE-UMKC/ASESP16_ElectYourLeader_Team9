package org.aseproject.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.aseproject.model.Candidate;
import org.aseproject.model.Voter;
import org.aseproject.service.CandidateService;
import org.aseproject.service.VoterService;

import com.opensymphony.xwork2.ActionSupport;

public class VoteCandidateAction extends ActionSupport{

private Candidate candidate;
private String candidateSSN;
private static Voter displayVoter;
private static ArrayList<Candidate> candidateList;
private static Map<Integer, String> m1;
	
	
	public static Voter getDisplayVoter() {
	return displayVoter;
}


public static void setDisplayVoter(Voter displayVoter) {
	VoteCandidateAction.displayVoter = displayVoter;
}


public static ArrayList<Candidate> getCandidateList() {
	return candidateList;
}


public static void setCandidateList(ArrayList<Candidate> candidateList) {
	VoteCandidateAction.candidateList = candidateList;
}


public static Map<Integer, String> getM1() {
	return m1;
}


public static void setM1(Map<Integer, String> m1) {
	VoteCandidateAction.m1 = m1;
}


	public String getCandidateSSN() {
	return candidateSSN;
}


public void setCandidateSSN(String candidateSSN) {
	this.candidateSSN = candidateSSN;
}


	public Candidate getCandidate() {
		return candidate;
	}


	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	public String execute() throws ClassNotFoundException, SQLException{
		
		System.out.println("Inside VoteCandidateAction execute method");
		System.out.println("Candidate Voted for:" +candidateSSN);
		
		Integer ssn = Integer.parseInt(candidateSSN);
		
		System.out.println("Candidate SSN: "+m1.get(ssn));
		
		CandidateService candidateService = new CandidateService();
		candidateService.updateVoteCount(m1.get(ssn));
		
		System.out.println("Voted by voter: "+displayVoter.getFirstName());
		System.out.println("Voter's UID: "+displayVoter.getUid());
		
		VoterService voterService = new VoterService();
		boolean castedVote = voterService.castVote(displayVoter.getUid(), m1.get(ssn));
		
		if(castedVote){
			return SUCCESS;
		}
		else{
			return ERROR;
		}

		
	}
}
