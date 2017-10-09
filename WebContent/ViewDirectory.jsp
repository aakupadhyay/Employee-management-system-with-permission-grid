<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Directory Store</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("index.jsp");
		} 
	%>
<br/> <br/>
<table border ='1'>
				<thead>
					<tr>
						<td>Directory Name</td>
						<td>Creator</td>
						<!-- <td>Creator ID</td>
						<td>Permission</td>  -->
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty dirlist}">
						<c:forEach items="${dirlist}" var="record">
						  <form action="FileList">
							<tr>
								<td>${record.dirName}</td>
								<td>${record.empfname} ${record.emplname}</td>
								<!-- <td>${record.empId}</td>
								<td>${record.permission}</td>  -->
								<td>
								<input type="hidden" name="dir" value="${record.dirId}"/>
								<input type="submit" value="Open"/>
								</td>
							</tr>
							</form>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
</body>
</html>