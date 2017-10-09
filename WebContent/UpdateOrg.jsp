<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Organisation Profile</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("index.jsp");
		} 
	%>
	<a href="admin_main.jsp"><input type="button" value="Home Page"/></a>
	<br/> <br/>
	<form action="OrgServlet">
		<table>
			<tbody>
				<tr>
					<td>Employee ID :</td>
					<td>${ID}</td>
				</tr>
				<tr>
					<td>Employee Name :</td>
					<td>${fn}${ln}</td>
				</tr>
				<tr>
					<td>Division Name :</td>
					<td><input type="text" name="divs" value="${divi}" /></td>
				</tr>
				<tr>
					<td>Role :</td>
					<td><input type="text" name="role" value="${role}" /></td>
				</tr>
				<tr>
					<td>Bonus :</td>
					<td><input type="text" name="bon" value="0.00" /></td>
				</tr>
				<tr>
					<td>Annual Income :</td>
					<td><input type="text" name="income" value="${income}" /></td>
				</tr>
				<tr>
					<td>Leaves Available :</td>
					<td><input type="text" name="leave" value="${leave}" /></td>
				</tr>
				<tr>
					<td>Supervisor ID :</td>
					<td><select name="mgrId">
							<c:forEach items="${Map}" var="Mgr">
								<option value="${Mgr.key}">${Mgr.value}</option>
							</c:forEach>
					</select> <!-- <input type="text" name="mgrId" value="${mgr}" />  --></td>
				</tr>
				<!-- <tr>
						<td>Supervisor Name :</td>
						<td><input type="text" name="mgr_fn" value="${mgr_fn}" /></td>
						<td><input type="text" name="mgr_ln" value="${mgr_ln}" /></td>
					</tr> -->
				<tr>
					<td><input type="hidden" name="user" value="${ID}" /></td>
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
</body>
</html>