<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<style>
#map {
	width: 500px;
	height: 400px;
}
</style>
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

		<div id="header" href="#">
			<img src="images/hero.jpg"> <span id="title">Elect Your
				Leader</span>
		</div>

		<div id="navigation">
			<div id="left">
				<ul>
					<a href="Home.jsp"><li>Home</li></a>
					<li>Register
						<ul class="dropdown">
							<li><a href="VoterRegistration.jsp">Voter Registration</a></li>
							<li><a href="CandidateRegistration.jsp">Candidate
									Registration</a></li>
						</ul>
					</li>
					<div class="clear"></div>
				</ul>
			</div>
			<div id="right">
				<ul>
					<li>Candidates</li>
					<li><a href="ContactUs.jsp">Contact Us</a></li>
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

		<div id="bodycontainercontact">
			<div id="bodycontentmap">
				<span><h2 align="justify"">Address:</h2> <br> <iframe
						src="https://www.google.com/maps/embed?pb=!1m23!1m12!1m3!1d397607.07226059376!2d-94.68099645993594!3d38.87125739252318!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m8!3e0!4m0!4m5!1s0x87c0efbb5cd0678b%3A0xeecb0bc21e01c0f4!2s5116+Baltimore+Avenue+%232n%2C+Kansas+City%2C+MO!3m2!1d39.03423!2d-94.588849!5e0!3m2!1sen!2sus!4v1459575222412"
						width="480" height="320" frameborder="0" style="border: 0"
						allowfullscreen></iframe><br>

					<div id="contactform">
						<br> <br> <br> <br> <br>
						<h2>Contact Submission Form</h2>




						<form method="post" name="contact"
							action="https://formspree.io/kiran.nandanamudi@gmail.com">
							<br> <label class="highlight" for="author">Name:</label> <input
								type="text" id="name" name="Name" class="required input_field" />
							<div class="cleaner h10"></div>


							<label class="highlight" for="email">Email:</label> <input
								type="text" class="validate-email required input_field"
								name="Email" id="email" />
							<div class="cleaner h10"></div>

							<label class="highlight" for="subject">Subject:</label> <input
								type="text" class="validate-subject required input_field"
								name="Subject" id="subject" />
							<div class="cleaner h10"></div>

							<label class="highlight" for="text">Message:</label>
							<textarea id="text" name="Message" rows="0" cols="20"
								class="required"></textarea>
							<div class="cleaner h10"></div>
							<input type="submit" value="Send" id="submit"
								class="submit_btn float_l" /> <input type="reset" value="Reset"
								id="reset" name="reset" class="submit_btn float_r" />

						</form></span>

			</div>




		</div>

		<div id="tooplate_sidebarcontact">
			<div id="bodycontentsidebarcontact">

				<ul>


					<li href="#"><img src="images/leadersnap.jpg"></li>

					<br>
					<br>

					<li><a>Search Engine </a>


						<div style="border: 1px solid blue;">

							<gcse:searchbox-only newWindow="true"></gcse:searchbox-only>

						</div></li>
					<br>
					<br>
					<br>

					<li><a>Calender</a> <iframe
							src="https://calendar.google.com/calendar/embed?src=kiran.nandanamudi%40gmail.com&ctz=America/Chicago"
							style="border: 0" width="325" height="305" frameborder="0"
							scrolling="no"></iframe></li>
				</ul>
			</div>


		</div>

	</div>

	</div>

	<div id="tooplate_footer_wrapper">
		<ul>
			<li><div id="bodycontainerbottom">

					<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Quick Links</h3>
					<a href="Home.jsp">Home</a> <a href="VoterRegistration.jsp">Voter
						Registration</a> <a href="Candidate Registration.jsp">Candidate
						Registration</a> <a href="VoterLogin.jsp">Voter Login</a> <a
						href="CandidateLogin.jsp">Candidate Login</a> <a
						href="ContactUs.jsp">Contact Us</a>



				</div></li>
			<li><div id="bodycontainerbottom">

					<h3>Share</h3>
					<br>
					<div class="fb-like"
						data-href="https://developers.facebook.com/docs/plugins/"
						data-layout="button_count" data-action="like"
						data-show-faces="true" data-share="true"></div>

					<br> <a href="https://twitter.com/share"
						class="twitter-share-button"
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
		</ul>
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
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;Copyright &copy;Team9 ASE
			PROJECT</li>
	</div>


</body>
</html>