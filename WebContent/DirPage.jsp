<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Directory Home Page</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("index.jsp");
		} 
	%>
<br/>
	<table border ='1'>
				<thead>
					<tr>
						<td>FileName</td>
						<td>Description</td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty filelist}">
						<c:forEach items="${filelist}" var="record">
						  <form action="Download">
							<tr>
								<td>${record.filenm}</td>
								<td>${record.description}</td>
								<td>
								<input type="hidden" name="file" value="${record.fileId}"/>
								<input type="submit" value="Download"/>
								</td>
							</tr>
							</form>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<br/>
			<br/>
	<div align="center">		
	<a href="Addfile.jsp"><input type="button" value="Add files" ></a>
	</div>
</body>
</html>