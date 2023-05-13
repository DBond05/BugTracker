	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
		<div class = "container"> 
			<div>
				<H1> Welcome to ElectraTech's Bug Tracker ${name} </H1>
				<hr>
				<p> BugTracker is a simple web app built using Java 17, Spring Boot 3, Maven Framework, H2 in memory database,
				 and .jsp HTML GUI. It implements a JPA repository, HEAOTOS Restful web APIs, Spring Boot security,
				 Boot-strap CSS and other modern features. Be my guest, Try it out! </p>
				 <hr>
				
				
				<p> <a href="bugsList"> Track</a> your bugs.</p>
				

			<%@ include file="common/footer.jspf" %>