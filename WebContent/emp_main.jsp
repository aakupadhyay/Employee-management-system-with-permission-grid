<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Page</title>
</head>
<body>
	<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("/index.jsp");
		}
	%>
<br/> 
<div class="container">	
<header></header>
	
<nav>
<ul>
<li>
 
		<form action="NameServlet">
		<input type="hidden" name="mgr" value="${mgr}"/>
		<input type="submit" value ="Apply leave"/>
		</form>
</li>
<br/>
<li>
<form action="Status">
<input type="submit" value="Check leave Status"/>
<input type="hidden" name="emp" value="${UserID}" />
</form>
</li>
<!-- </div> -->	

<br/>	
<!-- <div align="right"> -->
<li>
<form action="DisplayServlet">
<input type="submit" value="View Directories"/>
<input type="hidden" name="emp" value="${UserID}" />
</form>
</li>
<!-- </div> --> 
</ul>
</nav>
<article>
<div align="right">  
		<form action="Logout">
			<input type="submit" value="logout">
		</form>
	</div>
	
	<table border="0" align="left">
		<thead>
			<tr>
				<td><h3>Personal Information</h3></td>
				<td></td>
				<td><!-- ${mgr} --></td>
				<!--<td><input type="hidden" name="emp" value="${UserID}" /></td>-->
				<td><a href="profile.jsp"><input type="button" value="Edit" /></a></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Name: ${Fn} ${Ln}</td>
				<td>Email: ${mail}</td>
			</tr>
			<tr>
				<td>Address: ${ad}</td>
				<td>Contact Number: ${ph}</td>
			</tr>
		</tbody>
	</table>
</article>
<br/>
	
	<c:if test="${not empty Message}">
		<c:out value="${Message}" />
	</c:if>
<footer></footer>	
</div>
</body>
</html>