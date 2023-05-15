<%@page import="org.database.Jdbc"%>
<%@page import="org.database.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<%! List<Users> user;
	HttpSession session;
	String userName;
%>
<% HttpSession session=request.getSession(false);
	if(session==null)
	{
		response.sendRedirect("login.html");
		return;
	}
	else
	{
		userName=(String)session.getAttribute("userName");
		user=Jdbc.getUserDetails(userName);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
	table,th,tr 
	{
		border: 2px solid black;
		background-color: darkgrey;
		margin-top: 250px;
		border: 2px solid black;
		color:white;
		text-align: center;
		font-size: 20px;
	}
	#del
	{
		color: red;
		font-size: 20px;
		text-align: center;
		margin-top: 50px;
		margin-left: 700px;
	}
</style>

</head>
<body>
<div>
<a href='Profile.jsp' style="float:left">Profile Page</a>
<a href='logout' style="float:right" onclick="alert('Loged Out');">Logout</a>
</div>
<br>
<br>
<div>
<table align="center" style="width:1000px">
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>MobileNo</th>
		<th>DateOfBirth</th>
		<th>Password</th>
	</tr>
	<% for(int i=0;i<user.size();i++) 
	{%>
	<tr>
		<td>
			<%=
			user.get(i).getName()
			%>
		</td>
		<td>
			<%=
			user.get(i).getEmail()
			%>
		</td>
		<td>
			<%=
			user.get(i).getMobileNo()
			%>
		</td>
		<td>
			<%=
			user.get(i).getDateOfBirth()
			%>
		</td>
		<td>
			<%=
			user.get(i).getPassword()
			%>
		</td>
	</tr>
	<%}%>
</table>
</div>
<br><br>
<div>
<a href="delete"  >
<button id="del" onclick="alert('Account Deleted');">Delete</button>
</a>
</div>
</body>
</html>