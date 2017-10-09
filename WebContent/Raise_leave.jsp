<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave request application</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("index.jsp");
		} 
	%>
	<!-- <a href="emp_main.jsp"><input type="button" value="Home Page"/></a> -->
	<br/>
<form action = "LeaveServlet">
<table>
<tbody>
<tr>
<td>Name: ${Fn} ${Ln}</td>
</tr>
<tr><td>Manager Name: ${MgrNm}</td></tr>
<tr>
<td>From:</td>
<td><input type="date" name="from" /></td>
</tr>

<tr>
<td>To:</td>
<td><input type="date" name="to" /></td>
</tr>

<tr>
<td>Type:</td>
<td>
<select name="type">
<option value="Sick">Sick Leave</option>
<option value="Vacation">Vacation Leave</option>
</select>
</td>
</tr>
<tr>
<td><input type="hidden" name="empId" value="${UserID}"/></td>
<td><input type="hidden" name="mgrId" value="${mgr}"/></td>
<td><input type="hidden" name="first" value="${Fn}"/></td>
<td><input type="hidden" name="last" value="${Ln}"/></td>
<td><input type="submit" value="Submit"/></td>
</tr>
</tbody>
</table>
</form>
<c:if test="${not empty reqMes}">
		<c:out value="${reqMes}" />
	</c:if>
</body>
</html>