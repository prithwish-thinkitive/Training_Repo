

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	int count = 0;
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException{
    	super.init();
    	System.out.println("Init Method...");
    	count = 0;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("POST REQUEST.. -> visiter no "+count);
		
		String first = request.getParameter("txtfirstname");
		String last = request.getParameter("lastname");
		String pass = request.getParameter("password");
	
		out.println(first +" "+ last+" "+pass);
	}

}
