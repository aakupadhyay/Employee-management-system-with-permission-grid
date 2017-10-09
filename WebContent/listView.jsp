<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees List</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("index.jsp");
		} 
	%>
	<a href="admin_main.jsp"><input type="button" value="Home Page"/></a>
	<br/> <br/>
<table border ='1'>
				<thead>
					<tr>
						<td>Employee ID</td>
						<td>Employee Name</td>
						<td>Division Name</td>
						<td>Role</td>
						<td>Bonus</td>
						<td>Income</td>
						<td>Leaves Available</td>
						<td>Supervisor ID</td>
						<td>Supervisor Name</td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty list}">
						<c:forEach items="${list}" var="record">
						<form action="Update">
							<tr>
								<td>${record.empID}</td>
								<td>${record.firstname} ${record.lastname}</td>
								<td>${record.div_name}</td>
								<td>${record.role}</td>
								<td>${record.bonus}</td>
								<td>${record.income}</td>
								<td>${record.leaveBal}</td>
								<td>${record.superId}</td>
								<td>${record.supervisor_fname} ${record.supervisor_lname}</td>
								<td><input type="hidden" name="empId" value="${record.empID}"/></td>
								<td><input type="submit" value ="Edit" name="edit"/></td>
							</tr>
							</form>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			
<c:if test="${not empty Message}" >
  <c:out value="${Message}"/>
 </c:if>
			
</body>
</html>