<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Permissions</title>
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
						<td>Directory Name</td>
						<td>Creator</td>
						<td>Creator ID</td>
						<td>Permission</td>
						<td>Modify Permission</td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty dirlist}">
						<c:forEach items="${dirlist}" var="record">
						  <form action="Change">
							<tr>
								<td>${record.dirName}</td>
								<td>${record.empfname} ${record.emplname}</td>
								<td>${record.empId}</td>
								<td>${record.permission}</td>
								<td><select name="permission">
					                <option value="default">DEFAULT</option>
					                <option value="private">PRIVATE</option>
					                <option value="protected">PROTECTED</option>
					                </select>
					            </td>
								<td>
								<input type="hidden" name="dir" value="${record.dirId}"/>
								<input type="hidden" name="emp" value="${UserID}"/>
								<input type="submit" value="Change"/>
								</td>
							</tr>
							</form>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			
	<c:if test="${not empty dirMsg}">
		<c:out value="${dirMsg}" />
	</c:if>
</body>
</html>