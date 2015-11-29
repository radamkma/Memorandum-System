<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project114.model.Person,project114.model.Department,project114.model.Position,project114.model.Role" %>
<jsp:useBean id="persons" type="java.util.List<Person>" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Memo</title>
</head>
<body>
	<p>View Something</p>
	
	<table>
	<tr>
		<td>ID</td>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Department</td>
		<td>Position</td>
		<td>Role</td>
	</tr>
	<% for (Person p : persons) {%>
	<tr>
		<td><%=p.getPerson_id() %></td>
		<td><%=p.getFirstname() %></td>
		<td><%=p.getLastname() %></td>
		<td><%=p.getDepartment().getDepartment() %></td>
		<td><%=p.getPosition().getPosition() %></td>
		<td><%=p.getRole().getRole() %></td>
	</tr>
	<% } %>
	
	
	</table>
	
</body>
</html>