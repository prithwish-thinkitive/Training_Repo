

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FactorialServlet
 */
@WebServlet("/FactorialServlet")
public class FactorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FactorialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException{
    	super.init();
    	System.out.println("Init Method...");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		//To fetch the text/number that we entered in our front-end
		int num = Integer.parseInt(request.getParameter("factorial"));
		
		Factorial fact = new Factorial();
		//To print the result in the output
		out.println(fact.fact(num));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int num = Integer.parseInt(request.getParameter("factorial"));
		
		Factorial fact = new Factorial();
		
		out.println(fact.fact(num));
	}

}
