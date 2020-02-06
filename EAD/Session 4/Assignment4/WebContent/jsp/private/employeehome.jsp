<%@page import="dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Home</title>
</head>
<body>
    <a href = "../../LogoutServlet">LOG OUT</a>
	<%
		EmployeeDTO employee = (EmployeeDTO) session
				.getAttribute("employeeDetail");
	%>
	<h1 align = "center">Welcome <%=employee.getName()%></h1>
	<table align="center" border=thick>
		<tr>
			<td>ID</td>
			<td><label>
					<%
						out.print(employee.getId());
					%>
			</label></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><label>
					<%
						out.print(employee.getName());
					%>
			</label></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><label>
					<%
						out.print(employee.getGender());
					%>
			</label></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><label>
					<%
						out.print(employee.getEmail());
					%>
			</label></td>
		</tr>
		<tr>
			<td>Organization</td>
			<td><label>
					<%
						out.print(employee.getOrganization());
					%>
			</label></td>
		</tr>
		<tr>
			<td>Contact No</td>
			<td><label>
					<%
						out.print(employee.getPhoneNumber());
					%>
			</label></td>
		</tr>
		<tr>
			<td><a href="../../RedirectToEditPage">Edit</a></td>
			<td><a href="../../RedirectToShowFriendsPage">Show Friends</a></td>
		</tr>
	</table>
</body>
</html>