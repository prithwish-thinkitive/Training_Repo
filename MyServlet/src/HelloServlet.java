import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int count;
    
    public HelloServlet() {
        super();
    }
    
    public void init() throws ServletException{
    	super.init();
    	System.out.println("Init Method...");
    	count = 0;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		count ++;
		PrintWriter out = response.getWriter();
		out.println("GET REQUEST.. -> visiter no "+count);
		
		String first = request.getParameter("txtfirstname");
		String last = request.getParameter("lastname");
		String pass = request.getParameter("password");
	
		out.println(first +" "+ last+" "+pass);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		count ++;
		PrintWriter out = response.getWriter();
		out.println("POST REQUEST.. -> visiter no "+count);
		
		String first = request.getParameter("txtfirstname");
		String last = request.getParameter("lastname");
		String pass = request.getParameter("password");
	
		out.println(first +" "+ last+" "+pass);
	}
	
	public void destroy() {
		super.destroy();
		System.out.println("Destroy method....");
	}
}
