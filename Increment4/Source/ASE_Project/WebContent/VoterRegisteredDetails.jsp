<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="org.aseproject.model.Voter" %>
<%@ page import="java.io.OutputStream"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Voter Registered Details</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		
		<div>
			
			<div id="header">
					<span id="title">Elect Your Leader</span>
			</div>	

			<div id="bodycontainer">
				<div id="registrationheader">
					<li id="registertitle">Your Registered Details</li>
				</div>

				<div id="formdetails">
					<div id="registrationformheader">	
						<form method="post" action="castVote.action" enctype="multipart/form-data" id="registrationform">

						        <div class="formunit">
							        <label for="firstName">First Name</label>
							        <s:property value="displayVoter.firstName" />
							        <div id="firstName-help"></div>
						        </div>

						        <div class="formunit">
							        <label for="lastName">Last Name</label>
							        <s:property value="displayVoter.lastName" />
							        <div id="lastname-help"></div>
						        </div>

						        <div class="formunit">
							        <label for="uid">Unique Id</label>
							        <s:property value="displayVoter.uid" />
							        <div id="uid-help"></div>
						        </div>

						        <div class="formunit">
							        <label for="dob">Date of Birth</label>
							        <s:property value="displayVoter.dob" />
							        <div id="dob-help"></div>
						        </div>
						        
						        <div class="formunit">
							        <label for="state">Voting State</label>
							        <s:property value="displayVoter.state" />
							        <div id="state-help"></div>
						        </div>

						        <div class="formunit">
							        <label for="emailId">Email Id</label>
							        <s:property value="displayVoter.emailId" />
							        <div id="email-help"></div>
						        </div>
						     
						      <div class="booth formunit" >
						      		<label for="profileImage">Profile Image</label>
									<img src="images\regImage.gif" />
							  </div>
							  
							    <div class="formunit buttonunit">
						        	<input type="submit" id="submitbutton" value="next">
						        </div>
								
						</form>	
			    	</div>

					<div class="clear"></div>

			</div>


			</div>

		</div>
	</body>
</html>