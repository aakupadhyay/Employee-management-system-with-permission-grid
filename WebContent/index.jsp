<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login</title>
</head>
<body>
<%
		if (session.getAttribute("UserID")!= null || session.getAttribute("pwd") != null) {
			response.setHeader("Cache-Control", "private,no-store,no-cache");
			response.sendRedirect("http://localhost:9090/ERP_model/Login?user="+session.getAttribute("usrnm")+"&pwd="+session.getAttribute("pwd"));
		} 
	%>
	<br/> <br/>
<h2>Company Name</h2><br/>
	<div align="center">
		<form action="Login">
			<table>
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="user" required/></td>
				</tr>
				<tr>
					<td>password:</td>
					<td><input type="password" name="pwd" required/></td>
				</tr>
				<tr>
					<td></td>
					<td><center><input type="submit" value="login" /></center></td>
				</tr>
			</table>
			<br/>
			<p> New User? <a href="register.jsp">Register</a> here</p>
		</form>
	</div>
	
 <c:if test="${not empty errorMessage}" >
  <c:out value="${errorMessage}"/>
 </c:if>
	
</body>
</html>