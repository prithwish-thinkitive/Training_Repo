package com.Thinkitive.Assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginForm
 */
@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		
		MyDatabaseOperations login = new MyDatabaseOperations();
		boolean flag = login.isValidCredential(email, pass);
		
		if(flag) {
			out.println("<h2>Login Successfull !!</h2>");
		}
		
		else if(login.isEmailPresent(email) || login.isPasswordPresent(pass)) {
			out.println("<h2>Login Un-successfull !!</h2>");
			out.println("<h2>Check the user-email and password and re-try</h2>");
		}
		else {
			out.println("<h2>Login Un-successfull !!</h2>");
			out.println("<h2>If You are a New User then first Register before Login</h2>");
		}	
	}
}
