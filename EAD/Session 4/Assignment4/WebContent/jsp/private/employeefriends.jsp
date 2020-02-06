<%@page import="dto.EmployeeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friend List</title>
</head>
<body>
	<div>
		<a href = "../../LogoutServlet">LOG OUT</a>
		<h1 align=center>Your Friends</h1>
		<table align="center" border="thick">
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Show Profile</th>
			<%
				String s;
				List<EmployeeDTO> friendList = (List) session
						.getAttribute("friendList");
				for (EmployeeDTO friend : friendList) {
			%>
			<tr>
				<td><label> <%out.print(friend.getId());%></label></td>
				<td><label> <%out.print(friend.getName());%></label></td>
				<td><label> <%out.print(friend.getEmail());%></label></td>
				<td>
					<%
						s = "../../ShowFriendDetailServlet?email=" + friend.getEmail();
					%> 
					<a href="<%out.print(s);%>">Show Profile</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>