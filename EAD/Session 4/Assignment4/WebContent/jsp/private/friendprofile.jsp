<%@page import="dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friend Profile</title>
</head>
<body>
	<a href="../../LogoutServlet">LOG OUT</a>
	<%
		EmployeeDTO friend = (EmployeeDTO) session
				.getAttribute("friendDetail");
	%>
	<h1 align="center"><%=friend.getName()%>'s Profile
	</h1>
	<table align="center" border="thick">
		<tr>
			<td>ID</td>
			<td><label> <%
						out.print(friend.getId());
					%>
			</label></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><label> <%
						out.print(friend.getName());
					%>
			</label></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><label> <%
						out.print(friend.getGender());
					%>
			</label></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><label> <%
						out.print(friend.getEmail());
					%>
			</label></td>
		</tr>
		<tr>
			<td>Organization</td>
			<td><label> <%
						out.print(friend.getOrganization());
					%>
			</label></td>
		</tr>
		<tr>
			<td>Contact No</td>
			<td><label> <% out.print(friend.getPhoneNumber()); %>
			</label></td>
		</tr>
	</table>
</body>
</html>