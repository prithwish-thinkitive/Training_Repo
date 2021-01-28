package com.Thinkitive;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JSPServlet")
public class JSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public JSPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user = request.getParameter("txtusername");
		String pass = request.getParameter("txtpassword");
		
		if(user.equals("admin") && pass.equals("admin")) {
			RequestDispatcher d = request.getRequestDispatcher("Demo.jsp");
			request.setAttribute("message", "<p class='btn-success'>SUCCESSFUL LOGIN !!</p>");
			d.forward(request, response);
		}
		else {
			RequestDispatcher d = request.getRequestDispatcher("Demo.jsp");
			request.setAttribute("message", "<p class='btn-danger'>INVALID CREDENTIALS !!</p>");
			d.forward(request, response);
		}
	}

}
