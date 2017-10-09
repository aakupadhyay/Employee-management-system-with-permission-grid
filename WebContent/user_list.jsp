<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee groups</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("index.jsp");
		} 
	%>
	<a href="admin_main.jsp"><input type="button" value="Home Page"/></a>
	<br/> <br/>
	<table border='1'>
		<thead>
			<tr>
				<td>Employee ID</td>
				<td>FirstName</td>
				<td>LastName</td>
				<td>Contact No.</td>
				<td>Email ID</td>
				<td>Group</td>
				<td></td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty usrlist}">
				<c:forEach items="${usrlist}" var="record">
					<tr>
						<form action="refresh">
							<td>${record.empID}</td>
							<td>${record.firstname}</td>
							<td>${record.lastname}</td>
							<td>${record.phone}</td>
							<td>${record.email}</td>
							<td><select name="usrtype" value="${record.usertype}">
									<option value="Emp">Employee</option>
									<option value="Mgr">Manager</option>
									<option value="Admin">Administrator</option>
							</select> <!-- <input type="text"  name="usrtype" value="${record.usertype}"/> --></td>
							<input type="hidden" value="${record.empID}" name="user" />
							<td><input type="submit" class="btn btn-warning" value="Update" /></td>
						</form>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<c:if test="${not empty send}">
		<c:out value="${send}" />
	</c:if>
</body>
</html>