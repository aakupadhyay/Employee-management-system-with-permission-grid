<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("index.jsp");
		} 
	%>
	<a href="admin_main.jsp"><input type="button" value="Home Page"/></a>
	<br/> <br/>
	<p>Current month payment for Employee ID = ${EmpID}</p>
	<p>is ${total}.</p>
	
	<!--<c:if test="${not empty total}">
		<c:out value="${total}" />
	</c:if>-->

</body>
</html>