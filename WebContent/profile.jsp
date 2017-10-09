<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile page</title>
</head>
<body>
	<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("/index.jsp");
		}
	%>

	<!-- <form action="refresh">
		<input type="hidden" name="user" value="${UserID}" /> <input
			type="submit" value="Back" />
	</form> -->

	<div align="center">
		<form action="profile">
			<table>
				<tbody>
					<tr>
						<td>FirstName :</td>
						<td><input type="text" name="fname" value="${Fn}" /></td>
					</tr>
					<tr>
						<td>LastName :</td>
						<td><input type="text" name="lname" value="${Ln}" /></td>
					</tr>
					<tr>
						<td>Address :</td>
						<td><input type="text" name="addr" value="${ad}" /></td>
					</tr>
					<tr>
						<td>Phone Number :</td>
						<td><input type="text" name="phone" value="${ph}" /></td>
					</tr>
					<tr>
						<td>Email :</td>
						<td><input type="text" name="mail" value="${mail}" /></td>
					</tr>
					<tr>
						<td><input type="hidden" name="emp" value="${UserID}" /></td>
					</tr>
					<tr>
						<td></td>
						<td><center>
								<input type="submit" value="Update" />
							</center></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	
</body>
</html>