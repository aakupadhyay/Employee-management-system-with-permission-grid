<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Applied Leaves</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("index.jsp");
		} 
	%>
	<!-- <a href="emp_main.jsp"><input type="button" value="Home Page"/></a> -->
	<br/><br/>
<table border ='1'>
				<thead>
					<tr>
						<td>Type of Leave</td>
						<td>From</td>
						<td>To</td>
						<td>Status</td>
						<td>Manager ID</td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty Leaves}">
						<c:forEach items="${Leaves}" var="record">
							<tr>
								<td>${record.leave_type}</td>
								<td>${record.startdate}</td>
								<td>${record.enddate}</td>
								<td>${record.status}</td>
								<td>${record.mgrId}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
</body>
</html>