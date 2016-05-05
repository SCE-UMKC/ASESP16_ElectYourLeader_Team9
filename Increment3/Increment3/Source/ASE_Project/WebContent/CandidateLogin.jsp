<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Candidate Login Page</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		
		<div>
			
			<div id="header">
					<span id="title">Elect Your Leader</span>
			</div>	

			<div id="navigation" >
				<div id="left">
					<ul>
						<a href="Home.jsp"><li>Home</li></a>
						<li>Register
							<ul class="dropdown">
								<li><a href="VoterRegistration.jsp">Voter Registration</a></li>
								<li><a href="CandidateRegistration.jsp">Candidate Registration</a></li>
							</ul>
						</li>
						<div class="clear"></div>
					</ul>
				</div>	
				<div id="right">
					<ul>
                        <li>Candidates</li>	
						<li>Contact Us</li>	
						<li>Login
							<ul class="dropdown">
								<li><a href="VoterLogin.jsp">Voter Login</a></li>
								<li><a href="CandidateLogin.jsp">Candidate Login</a></li>
							</ul>
						</li>
						</li>
						<div class="clear"></div>		
					</ul>
				</div>	
			</div>

			<div id="logincontainer">
				<div id="loginheader">
					<h3 id="logintitle">Candidate Login</h3>
				</div>
				<div id="formheader">	
					<form method="post" action="candidateLogin.action" id="loginform">
						
					        <div class="formunit"><label for="username">Username</label></div>
					        <div class="formunit"><input type="text" id="username" name="candidate.emailId" required autofocus></div>
					        <div class="formunit"><span id="username-help"></span></div>
				    	
				    		<div class="formunit"><label for="passwd">Password</label></div>
					        <div class="formunit"><input type="password" id="password1" name="candidate.password1" required></div>
					        <div class="formunit" id="password-help"><s:fielderror fieldName="password1"></s:fielderror></div>

					        <div class="formunit"><span id="forgotpassword"><a href="ForgotPasswordCandidate.jsp">Forgot Password</a></span></div>
				    	
				    		<div class="formunit"><button id="loginbutton">Login</button></div>
			    	</form>	
		    	</div>
			</div>

		</div>

	</body>
</html>