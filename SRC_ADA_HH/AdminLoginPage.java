package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLoginPage
 */
@WebServlet("/AdminLoginPage")
public class AdminLoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();


		out.println("<html>");
		out.println("<form action='CheckAdminLoginPage' method='post'>");
		out.println("<table><caption><b><i>Admin Login</i></b></caption><br>");
		out.println("<tr><td><b><i>admin id:</b></i></td><td><input type='text' name='adminid'></td></tr>");
		out.println("<tr><td><b><i>password:</b></i></td><td><input type='password' name='password'></td></tr>");
		out.println("</table>");
		out.println("<input type='submit'>");
		out.println("</form></html>");
		out.flush();
	}

}
