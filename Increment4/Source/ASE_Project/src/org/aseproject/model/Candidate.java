package org.aseproject.model;

import java.io.File;
import java.sql.Blob;

public class Candidate {
	
	private String firstName;
	private String lastName;
	private String uid;
	private String dob;
	private String state;
	private String party;
	private String emailId;
	private String password1;
	private String password2;
	private String highSchoolName;
	private String schoolPassingOutWeekYear;
	private String underGradSchoolName;
	private String underGradPassingOutWeekYear;
	private String gradSchoolName;
	private String gradPassingOutWeekYear;
	private String employer1;
	private String employerYear1;
	private String employer2;
	private String employerYear2;
	private String employer3;
	private String employerYear3;
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private Blob profileImage;
	
	public Blob getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(Blob profileImage) {
		this.profileImage = profileImage;
	}
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getHighSchoolName() {
		return highSchoolName;
	}
	public void setHighSchoolName(String highSchoolName) {
		this.highSchoolName = highSchoolName;
	}
	public String getSchoolPassingOutWeekYear() {
		return schoolPassingOutWeekYear;
	}
	public void setSchoolPassingOutWeekYear(String schoolPassingOutWeekYear) {
		this.schoolPassingOutWeekYear = schoolPassingOutWeekYear;
	}
	public String getUnderGradSchoolName() {
		return underGradSchoolName;
	}
	public void setUnderGradSchoolName(String underGradSchoolName) {
		this.underGradSchoolName = underGradSchoolName;
	}
	public String getUnderGradPassingOutWeekYear() {
		return underGradPassingOutWeekYear;
	}
	public void setUnderGradPassingOutWeekYear(String underGradPassingOutWeekYear) {
		this.underGradPassingOutWeekYear = underGradPassingOutWeekYear;
	}
	public String getGradSchoolName() {
		return gradSchoolName;
	}
	public void setGradSchoolName(String gradSchoolName) {
		this.gradSchoolName = gradSchoolName;
	}
	public String getGradPassingOutWeekYear() {
		return gradPassingOutWeekYear;
	}
	public void setGradPassingOutWeekYear(String gradPassingOutWeekYear) {
		this.gradPassingOutWeekYear = gradPassingOutWeekYear;
	}
	public String getEmployer1() {
		return employer1;
	}
	public void setEmployer1(String employer1) {
		this.employer1 = employer1;
	}
	public String getEmployerYear1() {
		return employerYear1;
	}
	public void setEmployerYear1(String employerYear1) {
		this.employerYear1 = employerYear1;
	}
	public String getEmployer2() {
		return employer2;
	}
	public void setEmployer2(String employer2) {
		this.employer2 = employer2;
	}
	public String getEmployerYear2() {
		return employerYear2;
	}
	public void setEmployerYear2(String employerYear2) {
		this.employerYear2 = employerYear2;
	}
	public String getEmployer3() {
		return employer3;
	}
	public void setEmployer3(String employer3) {
		this.employer3 = employer3;
	}
	public String getEmployerYear3() {
		return employerYear3;
	}
	public void setEmployerYear3(String employerYear3) {
		this.employerYear3 = employerYear3;
	}
	
	
	

}
