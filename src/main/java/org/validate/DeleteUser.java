package org.validate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.database.Jdbc;

@WebServlet(urlPatterns = {"/delete"})
public class DeleteUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String email=request.getParameter("email");
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			String user=(String)session.getAttribute("userName");
			Jdbc.deleteUser(user);
			response.sendRedirect("signup.html");
		}
		else
		{
			response.sendRedirect("login.html");
		}
	}

}
