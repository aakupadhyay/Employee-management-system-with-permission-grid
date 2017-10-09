<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add files</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("index.jsp");
		} 
	%>
	<br/>
	<h3>Upload Files</h3>
	<br/>
	<form action="FileServlet" enctype="multipart/form-data" method="post">
		<table border="0">
			<tbody>
			    <tr>
					<td><!-- <input type="hidden" name="user" value="${UserID}" />  -->
					<input type="hidden" name="dir" value="${dirId}" />
					</td>
				</tr>
				<tr>
					<td>Enter name of file :</td>
					<td><input type="text" name="filename" /></td>
				</tr>
				<tr>
					<td>File to upload :</td>
					<td><input type="file" name="media" /></td>
				</tr>
				<tr>
					<td>Comment :</td>
					<td><input type="text" name="comment" size="50" /></td>
				</tr>
				<%-- <tr>
					<td><!-- <input type="hidden" name="user" value="${UserID}" />  -->
					<input type="text" name="dir" value="${dirId}" />
					</td>
				</tr> --%>
				<tr>
					<td colspan="2"><input type="submit" value="Upload" /></td>
				</tr>
			</tbody>
		</table>
	</form>
<br />
	<br />
	<c:if test="${not empty fileMsg}">
		<c:out value="${fileMsg}" />
	</c:if>
</body>
</html>