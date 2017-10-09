<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Team Members</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("index.jsp");
		} 
	%>
	<a href="mgr_main.jsp"><input type="button" value="Home Page"/></a>
	<br/><br/>
<table border ='1'>
				<thead>
					<tr>
						<td>Employee ID</td>
						<td>Employee Name</td>
						<td>Bonus</td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty teamlist}">
						<c:forEach items="${teamlist}" var="record">
						<form action="AddServlet">
							<tr>
								<td>${record.empId}</td>
								<td>${record.empfirst} ${record.emplast}</td>
								<td><input type="text" name="bonus" value="${record.bonus}"/></td>
								<td><input type="hidden" name="empId" value="${record.empId}"/></td>
								<td><input type="submit" value ="Add"/></td>
							</tr>
							</form>
						</c:forEach>
					</c:if>
				</tbody>
			</table>

<c:if test="${not empty Bonus}">
		<c:out value="${Bonus}" />
	</c:if>
</body>
</html>