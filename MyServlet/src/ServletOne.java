

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletOne
 */
@WebServlet("/ServletOne")
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("WE ARE IN SERVLET ONE");
		String user = request.getParameter("txtusername");
		String pass=request.getParameter("textpassword");
		out.println(user+" "+pass);
		//response.sendRedirect("ServletTwo"); // RESPONSE REDIRECTION
		RequestDispatcher d = request.getRequestDispatcher("ServletTwo"); // REQUEST DISPATCHING
		d.forward(request, response);
		
		d.include(request, response); // BY INCLUDE METHOD THE CURRENT SERVLET DATA WILL BE FORWARDED IN THE NEXT SERTVET
	}
}
