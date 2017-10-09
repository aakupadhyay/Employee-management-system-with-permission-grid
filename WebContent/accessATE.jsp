<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Allow another team member</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("index.jsp");
		} 
	%>
	<a href="mgr_main.jsp"><input type="button" value="Home Page"/></a>
	<br />
	<br />
	<table border='1'>
		<thead>
			<tr>
				<td>Directory ID</td>
				<td>Directory Name</td>
				<td>Permission</td>
				<td>Access to ATE</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty atelist}">
				<c:forEach items="${atelist}" var="record">
					<form action="Allow">
						    <tr>
								<td>${record.dirId}</td>
								<td>${record.dirName}</td>
								<td>${record.permission}</td>
								<td>
								<select name="ate">
								   <c:forEach items="${map}" var="emp">
	                                   <option value="${emp.key}">${emp.value}</option>
	                               </c:forEach>
								</select>
								</td>
								<td>
								<input type="hidden" name="dir" value="${record.dirId}" />
								<input type="submit" value="Allow" />
								</td>
							</tr>
							</form>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
<br /> <br />

<c:if test="${not empty ateMsg}">
		<c:out value="${ateMsg}" />
</c:if>
</body>
</html>