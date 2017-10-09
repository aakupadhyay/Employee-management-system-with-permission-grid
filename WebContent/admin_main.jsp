<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator page</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.setHeader("Cache-Control", "private,no-store,no-cache");
			response.sendRedirect("/index.jsp");
		}
	%>
	<br>
<div class="container">
	<header>
	<p> Welcome Admin </p>
	</header>
	
	<article>
	<div align="right">
	      <form action="Logout">
			<input type="submit" value="logout" align="right"/>
		</form>
	</div>
	<h3>${Fn} ${Ln}</h3>
		<div align="center">
			<form action="ListServlet" method="get">
				<input type="submit" name="active" value="View Active Employees" />
			</form>
		</div>
<br>
		<div align="center">
			<form action="ListServlet" method="get">
				<input type="submit" name="active" value="View InActive Employees" />
			</form>
		</div>
<br>	
	<div align="center">
	<form action="UserType" method="post">
	<input type="submit" value="Change User group"/>
	</form>
	</div>
<br>	
	<div align="center">
	<form action="PayrolServlet">
	<input type="submit" value="Generate Paycheck"/>
	</form>
	</div>	
</article>
<br> <br>	
 <c:if test="${not empty Message}" >
  <c:out value="${Message}"/>
 </c:if>
 <footer></footer>
</div>
</body>
</html>