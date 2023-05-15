<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
<% HttpSession session=request.getSession(false);
	if(session==null)
	{
		response.sendRedirect("login.html");
	}
%>
<a href='logout' onclick="alert('Loged Out');" >Logout</a>
</body>
</html>