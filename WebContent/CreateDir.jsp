<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Directory</title>
</head>
<body>
<%
		if (session.getAttribute("UserID") == null || session.getAttribute("UserID").equals(" ")) {
			response.sendRedirect("/index.jsp");
		}
	%>
<a href="mgr_main.jsp"><input type="button" value="Home Page"/></a>
<br/> <br/>
<div align="center">
	<form action="MkdirServlet">
		<table>
			<tbody>
				<tr>
					<td>Directory Name :</td>
					<td><input type="text" name="Dname" /></td>
				</tr>
				<tr>
					<td>Grant Permission :</td>
					<td><select name="permission">
					<option value="default">DEFAULT</option>
					<option value="private">PRIVATE</option>
					<option value="public">PUBLIC</option>
					<option value="protected">PROTECTED</option>
					</select>
					</td>
				</tr>
				<tr><td><input type="hidden" name="empId" value="${UserID}"/></td></tr>
				<tr>
				<td></td>
				<td><center><input type="submit" value="Create" /></center></td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>

<c:if test="${not empty DirMessage}">
		<c:out value="${DirMessage}" />
	</c:if>
</body>
</html>