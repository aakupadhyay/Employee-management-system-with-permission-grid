<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave requests</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("index.jsp");
		} 
	%>
	<a href="mgr_main.jsp"><input type="button" value="Home Page"/></a>
	<br/> <br/>
<table border ='1'>
				<thead>
					<tr>
						<td>Employee ID</td>
						<td>Employee Name</td>
						<td>From</td>
						<td>To</td>
						<td>Type</td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty reqlist}">
						<c:forEach items="${reqlist}" var="record">
						<form action="ApproveServlet">
							<tr>
								<td>${record.empId}</td>
								<td>${record.empfirtnm} ${record.emplastnm}</td>
								<td>${record.startdate}</td>
								<td>${record.enddate}</td>
								<td>${record.leave_type}</td>
								<td><input type="hidden" name="empId" value="${record.empId}"/></td>
								<td><input type="submit" value ="Approve" name="approve"/></td>
								<td><input type="submit" value ="Decline" name="approve"/></td>
							</tr>
							</form>
						</c:forEach>
					</c:if>
				</tbody>
			</table>

<c:if test="${not empty appMessage}">
		<c:out value="${appMessage}" />
	</c:if>
</body>
</html>