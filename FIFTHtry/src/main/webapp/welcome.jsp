<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body>


<%
	response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	if(session.getAttribute("email")==null){
			response.sendRedirect("Login.jsp");
	}	
%>

<div class="top-container">
	<h1 id="welcoming">WELCOME ${email}</h1>
</div>

<div class="medium-container">
	<br><br>
		<p>- This is the first version of the library with a dynamic web page</p>
		<p>- The webapp is built with Java servlet and JSP, using eclipse IDE</p>
		<p>- This version just focus on the login and logout dynamic</p>
		<p>- it's prevented against SQL injection, and back button</p>
		<p>	you could try to press the back button after loggin out to check :) </p>
	<br><br>
</div>

<div class="bottom-container">
	<br><br>
	<form action="Logout">
		<input type="submit" name="logout" value="logout">
	</form>
	<br><br>
</div>

</body>
</html>