package org.validate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.database.Jdbc;

@WebServlet(urlPatterns = {"/signup"})
public class SignupServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("uname");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		String phno=request.getParameter("phno");
		String date=request.getParameter("date");
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyy");
		Date today=null;
		try 
		{
			today = format.parse(date);
		} 
		catch (ParseException e1) 
		{
			e1.printStackTrace();
		}
		long timeinMilli=today.getTime();
		java.sql.Date todayDate= new java.sql.Date(timeinMilli);
		if(Jdbc.signup(name, pwd, email,phno, todayDate))
		{
			response.sendRedirect("login.html");
		}
		else
		{
			response.sendRedirect("signup.html");
		}
	}

}
