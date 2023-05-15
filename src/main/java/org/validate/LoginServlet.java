package org.validate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.database.Jdbc;

@WebServlet( urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		if(Jdbc.validateuser(name, pwd))
		{
			HttpSession session=request.getSession();
			session.setAttribute("userName", name);
			response.sendRedirect("Home.jsp");
		}
		else
		{
			response.sendRedirect("login.html");
		}
		
	}

}
