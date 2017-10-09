<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Employee</title>
</head>
<body>
<%
		if (session.getAttribute("UserID")!= null || session.getAttribute("pwd") != null) {
			response.setHeader("Cache-Control", "private,no-store,no-cache");
			response.sendRedirect("http://localhost:9090/ERP_model/Login?user="+session.getAttribute("usrnm")+"&pwd="+session.getAttribute("pwd"));
		} 
	%>
	<br/>
<div class="container">
<header>
<h3>Registration</h3>
</header>
<br/>

<div align="center">
	<form action="register">
		<table>
			<tbody>
				<tr>
					<td>FirstName :</td>
					<td><input type="text" name="fname" /></td>
				</tr>
				<tr>
					<td>LastName :</td>
					<td><input type="text" name="lname" /></td>
				</tr>
				<tr>
					<td>Address :</td>
					<td><input type="text" name="addr" size="" /></td>
				</tr>
				<tr>
					<td>Phone Number :</td>
					<td><input type="text" name="phone" /></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="text" name="mail" /></td>
				</tr>
				<tr>
					<td>Username :</td>
					<td><input type="text" name="user" /></td>
				</tr>
				<tr>
					<td>password :</td>
					<td><input type="password" name="pwd" /></td>
				</tr>
				<tr>
					<td></td><td><center><input type="submit" value="Register" /></center></td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	
<c:if test="${not empty errorMessage}" >
 <c:out value="${errorMessage}"/>
</c:if>
<br/>
<br/>
<footer></footer>
</div>	
</body>
</html>