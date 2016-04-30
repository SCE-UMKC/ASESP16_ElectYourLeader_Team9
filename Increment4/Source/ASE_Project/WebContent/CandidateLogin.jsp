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
	
	<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"
	type="text/javascript"></script>
<script src="js/jquery.nivo.slider.js" type="text/javascript"></script>

<script>
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.5&appId=2033851346839497";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>

<script>
	window.twttr = (function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0], t = window.twttr || {};
		if (d.getElementById(id))
			return t;
		js = d.createElement(s);
		js.id = id;
		js.src = "https://platform.twitter.com/widgets.js";
		fjs.parentNode.insertBefore(js, fjs);

		t._e = [];
		t.ready = function(f) {
			t._e.push(f);
		};

		return t;
	}(document, "script", "twitter-wjs"));
</script>

<script>
	window.___gcfg = {
		lang : 'en-US',
		parsetags : 'onload'
	};
</script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script>
	(function() {
		var cx = '017643444788069204610:4gvhea_mvga'; // Insert your own Custom Search Engine ID here
		var gcse = document.createElement('script');
		gcse.type = 'text/javascript';
		gcse.async = true;
		gcse.src = (document.location.protocol == 'https' ? 'https:' : 'http:')
				+ '//www.google.com/cse/cse.js?cx=' + cx;
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(gcse, s);
	})();
</script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
	
	
	
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
		
		<div id="tooplate_footer_wrapper">
			<ul>
				<li><div id="bodycontainerbottom">

						<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Quick Links</h3>
						<a href="Home.jsp">Home</a> 
						<a href="VoterRegistration.jsp">Voter Registration</a> 
						<a href="Candidate Registration.jsp">Candidate Registration</a>
						<a href="VoterLogin.jsp">Voter Login</a> 
						<a href="CandidateLogin.jsp">Candidate Login</a> 
						<a href="ContactUs.jsp">Contact Us</a>



					</div></li>
				<li><div id="bodycontainerbottom">

						<h3>Share</h3>
						<br>
						<div class="fb-like"
							data-href="https://developers.facebook.com/docs/plugins/"
							data-layout="button_count" data-action="like"
							data-show-faces="true" data-share="true"></div>

						</br> <a href="https://twitter.com/share" class="twitter-share-button"
							data-url="http://localhost:8080/umkc.edu.sparktwitteranalysis/about.html"
							data-text="Check out.....">Tweet</a> </br>
						<div>
							<g:plus action="share"></g:plus>
						</div>




						<!-- Place this tag where you want the widget to render. -->
						<div class="g-follow" data-annotation="bubble" data-height="20"
							data-href="//plus.google.com/u/0/100631431235598134170"
							data-rel="author"></div>
						<br> <br>


					</div></li>
				<li><div id="bodycontainerbottom">
						<br>
						<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;References</h3>
						<br> <a
							href="http://www.ibm.com/analytics/us/en/industry/banking/"
							target="_blank">IBM Analytics</a> <a
							href="http://www.ibmbigdatahub.com/blog/analytics-banking-services"
							target="_blank">IBM Bigdata Blog</a> <a
							href="http://www.ibmbigdatahub.com/blog/analytics-banking-services"
							target="_blank">IBM Bigdata Blog</a> <a
							href="http://www.ibmbigdatahub.com/blog/analytics-banking-services"
							target="_blank">IBM Bigdata Blog</a> <br>
					</div></li>
				<ul>
		</div>
		
		
		
		<div id="navigation">
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				&nbsp;&copy;Team9 ASE PROJECT</li>
		</div>

	</body>
</html>