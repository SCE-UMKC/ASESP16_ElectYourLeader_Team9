package org.aseproject.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.aseproject.model.Voter;
import org.aseproject.service.VoterService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class VoterLoginAction extends ActionSupport{
	
	private Voter voter;
	private Voter displayVoter;
	private VoterService voterService;
	public byte[] profilePic = null;
	BufferedImage img;
	private Map<String, Object> session;
	
	
	public byte[] getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(byte[] profilePic) {
		this.profilePic = profilePic;
	}
	public Voter getVoter() {
		return voter;
	}
	public void setVoter(Voter voter) {
		this.voter = voter;
	}
	
	public Voter getDisplayVoter() {
		return displayVoter;
	}
	public void setDisplayVoter(Voter displayVoter) {
		this.displayVoter = displayVoter;
	}
	
	public void validate(){
		voterService = new VoterService();
		boolean loginStatus = false;
		
		try {
			try {
				displayVoter = voterService.verifyLogin(voter);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(displayVoter != null){
				System.out.println("Voter details are not null");
				loginStatus = true;
			}
			else
			{
				System.out.println("Voter details are null");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Inside validate method catch block of VoterLoginAction");
			e.printStackTrace();
		}
		
		if(loginStatus){
			System.out.println("Login successful, now execute method must be called execute");
		}
		else{
			addFieldError("password1","Username or password is incorrect");
		}
		
	}
	
	public String execute() throws SQLException, IOException{
		
		System.out.println("Inside execute method");
		CastVoteAction.setDisplayVoter(displayVoter);
		
		System.out.println("FirstName "+displayVoter.getFirstName());
		System.out.println("LastName "+displayVoter.getLastName());
		System.out.println("UID "+displayVoter.getUid());
		System.out.println("DOB "+displayVoter.getDob());
		System.out.println("State "+displayVoter.getState());
		System.out.println("EmailId "+displayVoter.getEmailId());
		System.out.println("Profile Image "+displayVoter.getProfileImage());
		
		profilePic = new byte[(int)displayVoter.getProfileImage().length()];
        profilePic = displayVoter.getProfileImage().getBytes(1,(int)displayVoter.getProfileImage().length());
        
        
        MyAction.setMyContentLength((int)displayVoter.getProfileImage().length());
        MyAction.setMyBufferSize((int)displayVoter.getProfileImage().length());
        MyAction.setMyImageInBytes(profilePic);
   
        return SUCCESS;
		
	}
	
	

}
