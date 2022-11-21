package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    loginDAO log = new loginDAO();

    public login() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Email = request.getParameter("UEmail").toString();
		String Passowrd = request.getParameter("UPassword").toString();
		
		try {
			log.connect();
			if(log.checkLogin(Email, Passowrd)){
				HttpSession Session = request.getSession();
				Session.setAttribute("email", Email);
				response.sendRedirect("welcome.jsp");
			}else {
				
				response.sendRedirect("Login.jsp");
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			PrintWriter out = response.getWriter();
			out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			PrintWriter out = response.getWriter();
			out.println(e.getMessage());
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
