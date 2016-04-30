<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Contesting Candidates page</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		
		<div>
			
			<div id="header">
					<span id="title">Elect Your Leader</span>
			</div>	

			<div id="logincontainer">
				<div id="loginheader">
					<h3 id="logintitle">Candidates contesting in your state</h3>
				</div>
				<div id="formheader">	
					<form method="post" action="voteCandidate.action" id="voteform">
						
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
										<div>
										<s:radio key="Vote" list="getM1()" name="candidateSSN"/>
										<input type="submit" id="submitbutton" value="Submit">
										</div>
			    					</div>
						     
			    	</form>	
			    	
			    	
		    	</div>
			</div>

		</div>

	</body>
</html>