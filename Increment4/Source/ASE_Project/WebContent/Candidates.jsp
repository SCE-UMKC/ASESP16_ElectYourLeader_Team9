<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Candidate List Page</title>
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
                        <a href="Candidates.jsp"><li>Candidates</li></a>	
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
					<h3 id="logintitle">Know the candidates contesting</h3>
				</div>
				<div id="formheader">	
					<form method="post" action="candidateSearch.action" id="searchform">
						
					        <div class="formunit">
							        <label for="state">Select the state</label>
							        <select id="state" name="state" required>
  											<option value="State1">State1</option>
  											<option value="State2">State2</option>
  											<option value="State3">State3</option>
  											<option value="State4">State4</option>
  											<option value="State5">State5</option>
  											<option value="State6">State6</option>
  											<option value="State7">State7</option>
									</select>
							        <div id="state-help"></div>
							        
							        <div class="formunit buttonunit">
							        	<input type="submit" id="submitbutton" value="Submit">
						        	</div>
						     </div>
			    	</form>	
			    	
			    	<div>
			    		<s:iterator value="candidateList">
			    			<div class="formunit">
							<label for="firstName">First Name: </label>
							<s:property value="firstName"/><br>
						    </div>
							<div class="formunit">
							<label for="lastName">Last Name: </label>
							<s:property value="lastName" /><br>
							</div>
							<div class="formunit">
							<label for="uid">UID: </label>
							<s:property value="uid" /><br>
							</div>
							<div class="formunit">
							<label for="party">Party: </label>
							<s:property value="party" /><br>
							</div>
							<hr><br>
						</s:iterator>
			    	</div>
		    	</div>
			</div>

		</div>

	</body>
</html>