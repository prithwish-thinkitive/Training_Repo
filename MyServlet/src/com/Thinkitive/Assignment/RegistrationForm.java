package com.Thinkitive.Assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationForm
 */
@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegistrationForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String fn = request.getParameter("firstname");
		String mn = request.getParameter("middlename");
		String ln = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String pass = request.getParameter("password");
		
		MyDatabaseOperations mydb = new MyDatabaseOperations();
		mydb.insert(fn, mn, ln, email, phone, pass);
		mydb.displayEmp();
		
		out.println("<h2> First Name :"+fn);
		if(mn != null)
			out.println("<h2> Middle Name :"+mn);
		out.println("<h2> Last Name :"+ln);
		out.println("<h2> Email :"+email);
		out.println("<h2> Phone Number :"+phone);
		out.println("<h2> Password :"+pass);
	}

}
